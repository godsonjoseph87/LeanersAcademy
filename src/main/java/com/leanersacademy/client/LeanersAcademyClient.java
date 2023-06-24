package com.leanersacademy.client;
import com.leanersacademy.model.Subjects;
import com.leanersacademy.repository.jdbcAccountRepositoryImpl;
import com.leanersacademy.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class LeanersAcademyClient {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        System.out.println("Connected to Database !! MYSQL");

        Subjects subjects = new Subjects();
        subjects.setSubjectName("mathematics");
        subjects.addSubject(subjects);

        System.out.println("Creating the account");
        jdbcAccountRepositoryImpl accountRepo = new jdbcAccountRepositoryImpl();
    }
}