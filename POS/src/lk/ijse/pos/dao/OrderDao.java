package lk.ijse.pos.dao;

import lk.ijse.pos.model.Orders;

import java.util.ArrayList;

public interface OrderDao {

    public boolean addOrder(Orders orders) throws Exception;

    public boolean deleteOrder(String id);

    public boolean updateOrder(Orders orders);

    public Orders searchOrder(String id);

    public ArrayList<Orders> getAllOrders();

}
