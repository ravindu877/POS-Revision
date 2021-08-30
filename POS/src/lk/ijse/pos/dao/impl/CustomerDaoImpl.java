package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.CustomerDao;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Customer;
import lk.ijse.pos.view.tblmodel.CustomerTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean addCustomer(Customer customer) throws Exception {

        String sql= "INSERT INTO Customer VALUES (?,?,?)";

        return CrudUtil.executeUpdate(sql,customer.getcID(),customer.getName(),customer.getAddress());

    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {


        String sql= "DELETE FROM Customer WHERE id=?";

        return  CrudUtil.executeUpdate(sql,id);

    }

    @Override
    public boolean updateCustomer(Customer customer) throws Exception {

        String sql= "UPDATE Customer SET name=?, address=? WHERE cID=?";

        return CrudUtil.executeUpdate(sql,customer.getName(),customer.getAddress(),customer.getcID());

    }

    @Override
    public Customer searchCustomer(String id) throws Exception {

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
    public ArrayList<Customer> getAllCustomers() throws Exception {

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
