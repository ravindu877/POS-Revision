package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.CustomerBo;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.CustomerDao;
import lk.ijse.pos.dao.custom.impl.CustomerDaoImpl;
import lk.ijse.pos.model.Customer;

import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao= (CustomerDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoTypes.CUSTOMER);


    @Override
    public boolean saveCustomer(Customer customer) throws Exception {
        return customerDao.add(customer);
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDao.delete(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws Exception {
        return customerDao.update(customer);
    }

    @Override
    public Customer searchCustomer(String id) throws Exception {
        return customerDao.searchC(id);
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws Exception {
        return customerDao.getAll();
    }

}
