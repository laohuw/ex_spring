package com.algo.dao;

import com.algo.dao.mapper.CustomerMapper;
import com.algo.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by hd on 8/5/18.
 */
@Repository
public class CustomerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final Logger log = LoggerFactory.getLogger(CustomerDao.class);

    public void setup(){
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
        jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> log.info(customer.toString()));
    }

    public Customer getCustomer(Integer id){
        Customer customer=(Customer)jdbcTemplate.queryForObject("select id, first_name, last_name from customers where id=?", new Object[]{id}, new CustomerMapper());
        return customer;
    }

    public List<Customer> getAllCustomers(){
        List<Map<String, Object>> rows=jdbcTemplate.queryForList("select id, first_name, last_name from customers");
        List<Customer> customers=new ArrayList<>(rows.size());
        for(Map row: rows){
            Customer customer=new Customer();
            customer.setId((Integer)row.get("id"));
            customer.setFirstName((String)row.get("first_name"));
            customer.setLastName((String)row.get("last_name"));
            customers.add(customer);
        }
        return customers;
    }


    public Customer getCustomerById(Integer id){
        Customer customer=(Customer)jdbcTemplate.queryForObject("select id, first_name, last_name from customers where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Customer.class));
        return customer;
    }

}
