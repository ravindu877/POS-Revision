package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ItemBo;
import lk.ijse.pos.dao.custom.ItemDao;
import lk.ijse.pos.dao.custom.impl.ItemDaoImpl;
import lk.ijse.pos.model.Item;

import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {

    ItemDao itemDao= new ItemDaoImpl();


    @Override
    public boolean saveItem(Item item) throws Exception {
        return itemDao.add(item);
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
        return itemDao.delete(code);
    }

    @Override
    public boolean updateItem(Item item) throws Exception {
        return itemDao.update(item);
    }

    @Override
    public Item searchItem(String code) throws Exception {
        return itemDao.searchC(code);
    }

    @Override
    public ArrayList<Item> getAllItems() throws Exception {
        return itemDao.getAll();
    }

}
