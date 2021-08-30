package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDao;
import lk.ijse.pos.model.Orders;

import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {


    @Override
    public boolean add(Orders orders) throws Exception {
        String sql= "INSERT INTO Orders VALUES (?,?,?)";
        return CrudUtil.executeUpdate(sql,orders.getId(),orders.getDate(),orders.getCustomerId());
    }

    @Override
    public boolean delete(String s) throws Exception {
        throw new UnsupportedOperationException("This feature not supported.");
    }

    @Override
    public boolean update(Orders orders) throws Exception {
        throw new UnsupportedOperationException("This feature not supported.");
    }

    @Override
    public Orders searchC(String s) throws Exception {
        throw new UnsupportedOperationException("This feature not supported.");
    }

    @Override
    public ArrayList<Orders> getAll() throws Exception {
        throw new UnsupportedOperationException("This feature not supported.");
    }
}
