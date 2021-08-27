package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.OrderDao;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean addOrder(Orders orders) throws Exception {
        System.out.println(orders.getId());
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Orders VALUES (?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orders.getId());
        pstm.setObject(2, orders.getDate());
        pstm.setObject(3, orders.getCustomerId());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean deleteOrder(String id){
        throw new UnsupportedOperationException("This feature not supported.");
    }

    @Override
    public boolean updateOrder(Orders orders){ throw new UnsupportedOperationException("This feature not supported."); }

    @Override
    public Orders searchOrder(String id){
        throw new UnsupportedOperationException("This feature not supported.");
    }

    @Override
    public ArrayList<Orders> getAllOrders(){
        throw new UnsupportedOperationException("This feature not supported.");
    }


}
