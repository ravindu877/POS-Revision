package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.custom.impl.CustomerBoImpl;
import lk.ijse.pos.bo.custom.impl.ItemBoImpl;
import lk.ijse.pos.bo.custom.impl.PlaceOrderBoImpl;

public class BoFactory {

    private static BoFactory boFactory;

    private BoFactory(){
    }

    public static BoFactory getInstance(){
        if (boFactory==null){
            boFactory=new BoFactory();
        }
        return boFactory;
    }

    public enum BOTypes {
        CUSTOMER,ITEM,PLASEORDER
    }

    public SuperBo getBO(BOTypes types) {
        switch (types){
            case CUSTOMER:
                return new CustomerBoImpl();
            case ITEM:
                return new ItemBoImpl();
            case PLASEORDER:
                return new PlaceOrderBoImpl();
            default:
                return null;
        }
    }

}
