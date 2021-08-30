package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CrudUtil;
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

        String sql= "INSERT INTO Item VALUES (?,?,?,?)";

        return CrudUtil.executeUpdate(sql,item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
    }

    @Override
    public boolean deleteItem(String code) throws Exception {

        String sql= "DELETE FROM Item WHERE code=?";

        return CrudUtil.executeUpdate(sql,code);
    }

    @Override
    public boolean updateItem(Item item) throws Exception {

        String sql= "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
        Connection connection = DBConnection.getInstance().getConnection();

        return CrudUtil.executeUpdate(sql,item.getDescription(),item.getUnitPrice(),item.getQtyOnHand(),item.getCode());
    }

    @Override
    public Item searchItem(String code) throws Exception {

        String sql= "SELECT * FROM Item where code=?";

        ResultSet rst = CrudUtil.executeQuery(sql,code);
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

        String sql= "SELECT * FROM Item";

        ResultSet rst = CrudUtil.executeQuery(sql);

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

        String sql= "UPDATE Item SET qtyOnHand=? WHERE code=?";

        return CrudUtil.executeUpdate(sql,qty,code);
    }


}
