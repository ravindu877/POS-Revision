package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.dao.custom.CustomerDao;
import lk.ijse.pos.dao.custom.impl.CustomerDaoImpl;
import lk.ijse.pos.model.Customer;

import java.util.ArrayList;

public class CustomerBoImpl {

    CustomerDao customerDao= new CustomerDaoImpl();


    public boolean saveCustomer(Customer customer) throws Exception {
        return customerDao.add(customer);
    }

    public boolean deleteCustomer(String id) throws Exception {
        return customerDao.delete(id);
    }

    public boolean updateCustomer(Customer customer) throws Exception {
        return customerDao.update(customer);
    }

    public Customer searchCustomer(String id) throws Exception {
        return customerDao.searchC(id);
    }

    public ArrayList<Customer> getAllCustomers() throws Exception {
        return customerDao.getAll();
    }

}
