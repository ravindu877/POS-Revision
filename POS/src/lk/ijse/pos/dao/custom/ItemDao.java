package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDao;
import lk.ijse.pos.entity.Item;


public interface ItemDao extends CrudDao<Item, String> {

    public boolean updateItemQty(int qty, String code) throws Exception;

}
