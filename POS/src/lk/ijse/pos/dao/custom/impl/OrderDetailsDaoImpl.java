package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDetailsDao;
import lk.ijse.pos.entity.OrderDetails;

import java.util.ArrayList;

public class OrderDetailsDaoImpl implements OrderDetailsDao {


    @Override
    public boolean add(OrderDetails orderDetails) throws Exception {
        String sql= "INSERT INTO OrderDetails VALUES (?,?,?,?)";
        return CrudUtil.executeUpdate(sql,orderDetails.getOrderId(),orderDetails.getItemCode(),orderDetails.getQty(),orderDetails.getUnitPrice());
    }

    @Override
    public boolean delete(String s) throws Exception {
        throw new UnsupportedOperationException("This feature not supported.");
    }

    @Override
    public boolean update(OrderDetails orderDetails) throws Exception {
        throw new UnsupportedOperationException("This feature not supported.");
    }

    @Override
    public OrderDetails searchC(String s) throws Exception {
        throw new UnsupportedOperationException("This feature not supported.");
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws Exception {
        throw new UnsupportedOperationException("This feature not supported.");
    }
}
