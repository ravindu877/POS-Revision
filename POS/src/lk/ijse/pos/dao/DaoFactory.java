package lk.ijse.pos.dao;

import lk.ijse.pos.dao.custom.impl.*;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory(){
    }

    public static  DaoFactory getInstance(){
        if (daoFactory==null){
            daoFactory= new DaoFactory();
        }
        return daoFactory;
    }

    public enum DaoTypes{
        CUSTOMER,ITEM,ORDERS,ORDERDETAILS,QUERY
    }


    public SuperDao getDAO(DaoTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDERS:
                return new OrderDaoImpl();
            case ORDERDETAILS:
                return new OrderDetailsDaoImpl();
            case QUERY:
                return new QueryDaoImpl();
            default:
                return null;

        }
    }

}
