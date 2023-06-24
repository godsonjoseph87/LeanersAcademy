package com.leanersacademy.repository;

import com.leanersacademy.model.Accounts;

import java.sql.SQLException;

public interface AccountRepository {
    void createAccount(Accounts account) throws SQLException;

    Accounts getAccount(String accountid) throws SQLException;

    void updateAccount(Accounts account) throws SQLException;

    void deleteAccount(String id) throws SQLException;
}
