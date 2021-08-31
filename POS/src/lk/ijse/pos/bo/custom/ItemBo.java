package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBo;
import lk.ijse.pos.dto.ItemDto;

import java.util.ArrayList;

public interface ItemBo extends SuperBo {

    public boolean saveItem(ItemDto item) throws Exception;

    public boolean deleteItem(String code) throws Exception;

    public boolean updateItem(ItemDto item) throws Exception;

    public ItemDto searchItem(String code) throws Exception;

    public ArrayList<ItemDto> getAllItems() throws Exception;

}
