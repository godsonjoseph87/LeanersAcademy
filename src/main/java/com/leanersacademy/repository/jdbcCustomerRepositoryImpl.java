package com.leanersacademy.repository;
import com.leanersacademy.model.Customer;
import com.leanersacademy.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcCustomerRepositoryImpl implements CustomerRepository {
    private ConnectionFactory connectionFactory;

    public jdbcCustomerRepositoryImpl(){
        this.connectionFactory = ConnectionFactory.getInstance();
    }

    @Override
    public void createCustom(Customer customer) throws SQLException {
        String sql = "insert into customers(firstname, lastname) values(?,?)";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.executeUpdate();
        }
    }


    @Override
    public Customer getCustomer(String customerId) throws SQLException {
        String sql = "select * from customers where id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Customer customer = new Customer(rs.getString("firstname"), rs.getString("lastname"));
                customer.setId(rs.getInt("id"));
                return customer;
            }else{
                return null;
            }
        }
    }


    @Override
    public void updateCustomer(Customer customer) throws SQLException{
        String sql = "update customer set firstname = ?, lastname where id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setInt(3, customer.getId());
            ps.executeUpdate();
        }
    }


    @Override
    public void deleteCustomer(String customer_id) throws SQLException{
        String sql = "delete from customers where id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, customer_id);
            ps.executeUpdate();
        }
    }

}
