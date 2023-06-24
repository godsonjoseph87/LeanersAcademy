package com.leanersacademy.model;
import java.sql.*;
import java.util.*;
import com.leanersacademy.model.Accounts;
import com.leanersacademy.model.CurrentAccount;
import com.leanersacademy.model.SavingsAccount;
import com.leanersacademy.repository.jdbcSubjectsRepositoryImpl;
import com.leanersacademy.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Subjects {

    private String subjectName;

    public void addSubject(Subjects subjects) throws SQLException {
        System.out.println("I am in herer");
        jdbcSubjectsRepositoryImpl jdbcsubject = new jdbcSubjectsRepositoryImpl();
        jdbcsubject.addSubject(subjects);
    }

    public String getSubjectName(){
        return this.subjectName;
    }
    public void setSubjectName(String subjectName){
        this.subjectName = subjectName;
    }

}
