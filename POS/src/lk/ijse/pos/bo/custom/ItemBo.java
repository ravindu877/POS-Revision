package lk.ijse.pos.bo.custom;

import lk.ijse.pos.model.Item;

import java.util.ArrayList;

public interface ItemBo extends SuperBo{

    public boolean saveItem(Item item) throws Exception;

    public boolean deleteItem(String code) throws Exception;

    public boolean updateItem(Item item) throws Exception;

    public Item searchItem(String code) throws Exception;

    public ArrayList<Item> getAllItems() throws Exception;

}
