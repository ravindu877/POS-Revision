package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.CustomerDao;
import lk.ijse.pos.entity.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {


    @Override
    public boolean add(Customer customer) throws Exception {
        String sql= "INSERT INTO Customer VALUES (?,?,?)";
        return CrudUtil.executeUpdate(sql,customer.getcID(),customer.getName(),customer.getAddress());
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql= "DELETE FROM Customer WHERE cid=?";
        return  CrudUtil.executeUpdate(sql,id);
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        String sql= "UPDATE Customer SET name=?, address=? WHERE cID=?";
        return CrudUtil.executeUpdate(sql,customer.getName(),customer.getAddress(),customer.getcID());
    }

    @Override
    public Customer searchC(String id) throws Exception {
        String sql= "SELECT * FROM Customer where cID=?";
        ResultSet rst = CrudUtil.executeQuery(sql,id);
        if (rst.next()){
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        String sql= "SELECT * FROM Customer";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Customer> allCustomers = new ArrayList<>();
        while (rst.next()){
            allCustomers.add(
                    new Customer(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3)
                    )
            );
        }
        return allCustomers;
    }
}
