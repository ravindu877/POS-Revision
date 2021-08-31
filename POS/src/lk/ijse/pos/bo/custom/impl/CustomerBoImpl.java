package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.CustomerBo;
import lk.ijse.pos.dao.DaoFactory;
import lk.ijse.pos.dao.custom.CustomerDao;
import lk.ijse.pos.dto.CustomerDto;
import lk.ijse.pos.entity.Customer;

import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao= (CustomerDao) DaoFactory.getInstance().getDAO(DaoFactory.DaoTypes.CUSTOMER);


    @Override
    public boolean saveCustomer(CustomerDto customer) throws Exception {
        return customerDao.add(new Customer(customer.getcID(),customer.getName(),customer.getAddress()));
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDao.delete(id);
    }

    @Override
    public boolean updateCustomer(CustomerDto customer) throws Exception {
        return customerDao.update(new Customer(customer.getcID(),customer.getName(),customer.getAddress()));
    }

    @Override
    public CustomerDto searchCustomer(String id) throws Exception {
        Customer customer= customerDao.searchC(id);
        return new CustomerDto(customer.getcID(),customer.getName(),customer.getAddress());
    }

    @Override
    public ArrayList<CustomerDto> getAllCustomers() throws Exception {
        ArrayList<Customer> customers= customerDao.getAll();
        ArrayList<CustomerDto> customerDtos= new ArrayList<>();
        for (Customer customer: customers) {
            customerDtos.add(new CustomerDto(customer.getcID(),customer.getName(),customer.getAddress()));
        }
        return customerDtos;
    }

}
