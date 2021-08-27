package lk.ijse.pos.dao;

import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;

import java.util.ArrayList;

public interface OrderDetailsDao {

    public boolean addOrderDetails(OrderDetails orderDetails) throws Exception;

    public boolean deleteOrder(String id);

    public boolean updateOrder(OrderDetails orderDetails);

    public Orders searchOrder(String id);

    public ArrayList<OrderDetails> getAllOrders();

}
