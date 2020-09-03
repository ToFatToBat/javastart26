package com.example.javastart26.model;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public void add(Budget budget) {
        final String sql = "insert into home_budget (iotype, description, amount) values(???)";
        try{
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(2, budget.getiOType() );
            prepStmt.setString(3, budget.getDescription() );
            prepStmt.setDouble(4, budget.getAmount() );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
