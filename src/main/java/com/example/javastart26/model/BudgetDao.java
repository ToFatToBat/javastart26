package com.example.javastart26.model;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

public class BudgetDao {
    private static final String URL = "jdbc:mysql://localhost:3306/budget";
    private static final String USER = "root";
    private static final String PASS = "hockiklockikotfilemon";
    private Connection connection;


    public BudgetDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
