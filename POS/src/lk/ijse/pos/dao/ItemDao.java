package lk.ijse.pos.dao;

import lk.ijse.pos.model.Item;

import java.util.ArrayList;

public interface ItemDao {

    public boolean adItem(Item item) throws Exception;

    public boolean deleteItem(String code) throws Exception;

    public boolean updateItem(Item item) throws Exception;

    public Item searchItem(String code) throws Exception;

    public ArrayList<Item> getAllItems() throws Exception;

    public boolean updateItemQty(int qty, String code) throws Exception;

}
