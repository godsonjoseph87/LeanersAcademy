package com.leanersacademy.repository;

import com.leanersacademy.model.Accounts;
import com.leanersacademy.model.CurrentAccount;
import com.leanersacademy.model.SavingsAccount;
import com.leanersacademy.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcAccountRepositoryImpl implements AccountRepository {
    private ConnectionFactory connectionFactory;

    public jdbcAccountRepositoryImpl(){
        this.connectionFactory = ConnectionFactory.getInstance();
    }

    @Override
    public void createAccount(Accounts account) throws SQLException{
        String sql = "insert into accounts(id, balance, type, interest_rate, overdraft_amount, fk_customer_id)" +
                " values(?,?,?,?,?,?)";
        try (Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, account.getId());
            ps.setDouble(2, account.getBalance());
            ps.setString(3, account.gettype());
            ps.setDouble(4, account.getInterestRate());
            ps.setDouble(5, account.getOverdraftAmount());
            ps.setDouble(6, account.getCustomerId());
            ps.executeUpdate();
        }
    }

    @Override
    public Accounts getAccount(String accountid) throws SQLException {
        String sql = "select * from accounts where id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, accountid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                double balance = rs.getDouble("balance");
                String accountType = rs.getString("type");
                if("savings".equalsIgnoreCase(accountType)) {
                    double interestRate = rs.getDouble("interest_rate");
                    Accounts account = new SavingsAccount(balance, interestRate);
                    account.setId(accountid);
                    return account;
                }else if("current".equalsIgnoreCase(accountType)) {
                    double overdraftAmount = rs.getDouble("overdraft_amount");
                    Accounts account = new CurrentAccount(balance, overdraftAmount);
                    account.setId(accountid);
                    return account;
                }else{
                    return null;
                }
            }else{
                return null;
            }
        }
    }

    @Override
    public void updateAccount(Accounts account) throws SQLException{
        String sql = "update accounts set balance = ? where id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setDouble(1, account.getBalance());
            ps.setString(2, account.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteAccount(String id) throws SQLException{
        String sql = "delete from accounts where id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, id);
            ps.executeUpdate();
        }
    }

}
