package com.leanersacademy.repository;

import com.leanersacademy.model.Customer;

import java.sql.SQLException;

public interface CustomerRepository {
    void createCustom(Customer customer) throws SQLException;

    Customer getCustomer(String customerId) throws SQLException;

    void updateCustomer(Customer customer) throws SQLException;

    void deleteCustomer(String customer_id) throws SQLException;
}
