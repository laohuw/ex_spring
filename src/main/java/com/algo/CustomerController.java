package com.algo;

import com.algo.business.CustomerBusiness;
import com.algo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hd on 8/5/18.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerBusiness customerBusiness;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id){
        if(id==null)
            return null;
        return customerBusiness.getCustomer(id);
    }

    @GetMapping("id/{id}")
    public Customer getCustomerById(@PathVariable("id") Integer id){
        if(id==null)
            return null;
        return customerBusiness.getCustomerById(id);
    }

    @PostMapping("/create")
    public List<Customer> createDb()
    {
        customerBusiness.setupDb();
        return customerBusiness.getAllCustomer();
    }

    @GetMapping("/all")
    public List<Customer> getAll(){
        return customerBusiness.getAllCustomer();
    }
}
