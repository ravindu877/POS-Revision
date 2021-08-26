package lk.ijse.pos.dao;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OrderDaoImpl {

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

    public boolean deleteOrder(String id){
        return false;
    }

    public boolean updateOrder(Orders orders){
        return false;
    }

    public Orders searchOrder(String id){
        return null;
    }

    public ArrayList<Orders> getAllOrders(){
        return null;
    }

    public boolean updateItemQty(int qty, String code) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm2 = connection.prepareStatement("UPDATE Item SET qtyOnHand=? WHERE code=?");
        pstm2.setObject(1, qty);
        pstm2.setObject(2, code);
        return pstm2.executeUpdate()>0;
    }

}
