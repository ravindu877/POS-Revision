package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBo;
import lk.ijse.pos.dto.OrderDetailDto;
import lk.ijse.pos.dto.OrderDto;

import java.util.ArrayList;

public interface PlaceOrderBo extends SuperBo {

    public boolean placeOrder(OrderDto orders, ArrayList<OrderDetailDto> orderDetails) throws Exception;

}
