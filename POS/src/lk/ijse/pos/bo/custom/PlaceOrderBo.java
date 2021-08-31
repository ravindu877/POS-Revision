package lk.ijse.pos.bo.custom;

import lk.ijse.pos.model.Customer;
import lk.ijse.pos.model.Item;
import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;

import java.util.ArrayList;

public interface PlaceOrderBo {

    public boolean placeOrder(Orders orders, ArrayList<OrderDetails> orderDetails) throws Exception;

    public Customer searchCustomer(String id) throws Exception;

    public Item searchItem(String code) throws Exception;

    public ArrayList<Customer> getAllCustomers() throws Exception;

    public ArrayList<Item> getAllItems() throws Exception;
}
