package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.PlaceOrderBo;
import lk.ijse.pos.controller.OrderFormController;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.CustomerDao;
import lk.ijse.pos.dao.custom.ItemDao;
import lk.ijse.pos.dao.custom.OrderDao;
import lk.ijse.pos.dao.custom.OrderDetailsDao;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.dto.OrderDetailDto;
import lk.ijse.pos.dto.OrderDto;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.OrderDetails;
import lk.ijse.pos.entity.Orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlaceOrderBoImpl implements PlaceOrderBo {

    private final ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoTypes.ITEM);
    private final OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoTypes.ORDERS);
    private final OrderDetailsDao orderDetailsDao = (OrderDetailsDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoTypes.ORDERDETAILS);

    @Override
    public boolean placeOrder(OrderDto orders, ArrayList<OrderDetailDto> orderDetails) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);

            boolean isAdded = orderDao.add(new Orders(orders.getId(),orders.getDate(),orders.getCustomerId()));

            if (!isAdded) {
                connection.rollback();
                return false;
            }

            for (OrderDetailDto details : orderDetails) {
                boolean isAdded1 = orderDetailsDao.add(new OrderDetails(details.getOrderId(), details.getItemCode(), details.getQty(), details.getUnitPrice()));

                if (!isAdded1) {
                    connection.rollback();
                    return false;
                }

                int qtyOnHand = 0;

                Item item = itemDao.searchC(details.getItemCode());

                if (item != null) {
                    qtyOnHand = item.getQtyOnHand();
                }

                int newQry = qtyOnHand - details.getQty();

                boolean issAdded2 = itemDao.updateItemQty(newQry, details.getItemCode());

                if (!issAdded2) {
                    connection.rollback();
                    return false;
                }
            }

            connection.commit();
            return true;

        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception(ex1);
            }
            Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e);
        } finally {
            try {
                connection.setAutoCommit(true);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception(ex);
            }

        }

    }


}
