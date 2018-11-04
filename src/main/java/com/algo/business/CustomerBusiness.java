package com.algo.business;

import com.algo.dao.CustomerDao;
import com.algo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hd on 8/5/18.
 */
@Component
public class CustomerBusiness {
    @Autowired
    CustomerDao customerDao;

    public List<Customer> getAllCustomer(){
        return customerDao.getAllCustomers();
    }

    public void setupDb(){
        customerDao.setup();
    }

    public Customer getCustomer(Integer id){
        return customerDao.getCustomer(id);
    }

    public Customer getCustomerById(Integer id){
        return customerDao.getCustomerById(id);
    }
}
