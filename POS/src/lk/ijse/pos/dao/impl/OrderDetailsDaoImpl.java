package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.OrderDetailsDao;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OrderDetailsDaoImpl implements OrderDetailsDao {

    @Override
    public boolean addOrderDetails(OrderDetails orderDetails) throws Exception {

        String sql= "INSERT INTO OrderDetails VALUES (?,?,?,?)";

        return CrudUtil.executeUpdate(sql,orderDetails.getOrderId(),orderDetails.getItemCode(),orderDetails.getOrderId(),orderDetails.getUnitPrice());
    }

    @Override
    public boolean deleteOrder(String id){
        throw new UnsupportedOperationException("This feature not supported.");
    }

    @Override
    public boolean updateOrder(OrderDetails orderDetails){ throw new UnsupportedOperationException("This feature not supported."); }

    @Override
    public Orders searchOrder(String id){
        throw new UnsupportedOperationException("This feature not supported.");
    }

    @Override
    public ArrayList<OrderDetails> getAllOrders(){ throw new UnsupportedOperationException("This feature not supported."); }

}
