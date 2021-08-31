package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.PlaceOrderBo;
import lk.ijse.pos.controller.OrderFormController;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.CustomerDao;
import lk.ijse.pos.dao.custom.ItemDao;
import lk.ijse.pos.dao.custom.OrderDao;
import lk.ijse.pos.dao.custom.OrderDetailsDao;
import lk.ijse.pos.dao.custom.impl.CustomerDaoImpl;
import lk.ijse.pos.dao.custom.impl.ItemDaoImpl;
import lk.ijse.pos.dao.custom.impl.OrderDaoImpl;
import lk.ijse.pos.dao.custom.impl.OrderDetailsDaoImpl;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Customer;
import lk.ijse.pos.model.Item;
import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlaceOrderBoImpl implements PlaceOrderBo {




    private final CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoTypes.CUSTOMER);
    private final ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoTypes.ITEM);
    private final OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoTypes.ORDERS);
    private final OrderDetailsDao orderDetailsDao = (OrderDetailsDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoTypes.ORDERDETAILS);

    @Override
    public boolean placeOrder(Orders orders, ArrayList<OrderDetails> orderDetails) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);

            boolean isAdded = orderDao.add(orders);

            if (!isAdded) {
                connection.rollback();
                return false;
            }

            for (OrderDetails details : orderDetails) {
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

    @Override
    public Customer searchCustomer(String id) throws Exception {
        return customerDao.searchC(id);
    }

    @Override
    public Item searchItem(String code) throws Exception {
        return itemDao.searchC(code);
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws Exception {
        return customerDao.getAll();
    }

    @Override
    public ArrayList<Item> getAllItems() throws Exception {
        return itemDao.getAll();
    }

}
