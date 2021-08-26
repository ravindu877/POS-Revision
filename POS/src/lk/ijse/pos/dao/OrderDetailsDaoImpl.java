package lk.ijse.pos.dao;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OrderDetailsDaoImpl {

    public boolean addOrderDetails(OrderDetails orderDetails) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO OrderDetails VALUES (?,?,?,?)");
        pstm.setObject(1, orderDetails.getOrderId());
        pstm.setObject(2, orderDetails.getItemCode());
        pstm.setObject(3, orderDetails.getQty());
        pstm.setObject(4, orderDetails.getUnitPrice());
        return pstm.executeUpdate()>0;
    }

    public boolean deleteOrder(String id){
        return false;
    }

    public boolean updateOrder(OrderDetails orderDetails){
        return false;
    }

    public Orders searchOrder(String id){
        return null;
    }

    public ArrayList<OrderDetails> getAllOrders(){
        return null;
    }
}
