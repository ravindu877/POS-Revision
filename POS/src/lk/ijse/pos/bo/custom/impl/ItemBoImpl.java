package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ItemBo;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.ItemDao;
import lk.ijse.pos.dto.ItemDto;
import lk.ijse.pos.entity.Item;

import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {

    ItemDao itemDao= (ItemDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoTypes.ITEM);


    @Override
    public boolean saveItem(ItemDto item) throws Exception {
        return itemDao.add(new Item(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
        return itemDao.delete(code);
    }

    @Override
    public boolean updateItem(ItemDto item) throws Exception {
        return itemDao.update(new Item(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
    }

    @Override
    public ItemDto searchItem(String code) throws Exception {
        Item item=itemDao.searchC(code);
        return new ItemDto(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
    }

    @Override
    public ArrayList<ItemDto> getAllItems() throws Exception {
        ArrayList<Item> items= itemDao.getAll();
        ArrayList<ItemDto> itemDtos= new ArrayList<>();
        for (Item dto: items) {
            itemDtos.add(new ItemDto(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
        }
        return itemDtos;
    }

}
