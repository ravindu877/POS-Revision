package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.dao.custom.ItemDao;
import lk.ijse.pos.dao.custom.impl.ItemDaoImpl;
import lk.ijse.pos.model.Item;

import java.util.ArrayList;

public class ItemBoImpl {

    ItemDao itemDao= new ItemDaoImpl();


    public boolean saveItem(Item item) throws Exception {
        return itemDao.add(item);
    }

    public boolean deleteItem(String code) throws Exception {
        return itemDao.delete(code);
    }

    public boolean updateItem(Item item) throws Exception {
        return itemDao.update(item);
    }

    public Item searchItem(String code) throws Exception {
        return itemDao.searchC(code);
    }

    public ArrayList<Item> getAllItems() throws Exception {
        return itemDao.getAll();
    }

}
