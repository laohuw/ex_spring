package com.algo.dao.mapper;


import com.algo.model.Customer;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hd on 8/5/18.
 */
public class CustomerMapper implements RowMapper {

    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
        Customer customer=new Customer();
        customer.setId(resultSet.getInt("id"));
        customer.setFirstName(resultSet.getString("first_name"));
        customer.setLastName(resultSet.getString("last_name"));
        return customer;
    }
}
