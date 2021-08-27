package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.ItemDao;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Customer;
import lk.ijse.pos.model.Item;
import lk.ijse.pos.view.tblmodel.ItemTM;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean adItem(Item item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?,?)");

        pstm.setObject(1, item.getCode());
        pstm.setObject(2, item.getDescription());
        pstm.setObject(3, item.getUnitPrice());
        pstm.setObject(4, item.getQtyOnHand());

        return pstm.executeUpdate()> 0;
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");

        pstm.setObject(1, code);

        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean updateItem(Item item) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");

        pstm.setObject(1, item.getDescription());
        pstm.setObject(2, item.getUnitPrice());
        pstm.setObject(3, item.getQtyOnHand());
        pstm.setObject(4, item.getCode());

        return pstm.executeUpdate()>0;
    }

    @Override
    public Item searchItem(String code) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm= connection.prepareStatement("SELECT * FROM Item where code=?");
        pstm.setObject(1,code);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(3)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Item> getAllItems() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        Statement stm = connection.createStatement();

        ResultSet rst = stm.executeQuery("SELECT * FROM Item");

        ArrayList<Item> alItems = new ArrayList<>();

        while (rst.next()) {

            Item item = new Item(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4));

            alItems.add(item);
        }
        return alItems;
    }


    @Override
    public boolean updateItemQty(int qty, String code) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm2 = connection.prepareStatement("UPDATE Item SET qtyOnHand=? WHERE code=?");
        pstm2.setObject(1, qty);
        pstm2.setObject(2, code);
        return pstm2.executeUpdate()>0;
    }


}
