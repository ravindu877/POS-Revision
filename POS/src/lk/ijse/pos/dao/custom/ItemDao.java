package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.SuperDao;
import lk.ijse.pos.model.Item;


public interface ItemDao extends SuperDao<Item, String> {

    public boolean updateItemQty(int qty, String code) throws Exception;

}
