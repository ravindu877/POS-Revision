package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBo;
import lk.ijse.pos.dto.CustomerDto;

import java.util.ArrayList;

public interface CustomerBo extends SuperBo {

    public boolean saveCustomer(CustomerDto customer) throws Exception;

    public boolean deleteCustomer(String id) throws Exception;

    public boolean updateCustomer(CustomerDto customer) throws Exception;

    public CustomerDto searchCustomer(String id) throws Exception;

    public ArrayList<CustomerDto> getAllCustomers() throws Exception;
}
