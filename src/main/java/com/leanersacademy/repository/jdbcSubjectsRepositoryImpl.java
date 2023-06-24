package com.leanersacademy.repository;

import com.leanersacademy.model.Subjects;
import com.leanersacademy.model.CurrentAccount;
import com.leanersacademy.model.SavingsAccount;
import com.leanersacademy.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcSubjectsRepositoryImpl{
    private ConnectionFactory connectionFactory;

    public jdbcSubjectsRepositoryImpl(){
        this.connectionFactory = ConnectionFactory.getInstance();
    }


    public void addSubject(Subjects subject) throws SQLException{
        System.out.println("Ayyo just Reached here");
        System.out.println(subject.getSubjectName());
        String sql = "insert into subjects(name)" +
                " values(?)";
        try (Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ){
            ps.setString(1, subject.getSubjectName());
            ps.executeUpdate();
        }
    }

}
