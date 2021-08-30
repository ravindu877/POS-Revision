package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.OrderDao;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean addOrder(Orders orders) throws Exception {

        String sql= "INSERT INTO Orders VALUES (?,?,?)";

        return CrudUtil.executeUpdate(sql,orders.getId(),orders.getDate(),orders.getCustomerId());
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
