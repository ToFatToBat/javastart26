package com.example.javastart26.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BudgetDao<connection> {
    private static final String URL = "jdbc:mysql://localhost:3306/budget?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "root";
    Connection connection;

    public BudgetDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }

    public void save(Budget budget) {
        final String sql = "insert into home_budget (iotype, description, amount) values(?,?,?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, budget.getiOType());
            prepStmt.setString(2, budget.getDescription());
            prepStmt.setDouble(3, budget.getAmount());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }
    }

    public Budget get(long id) {
        final String sql = "select id, iotype, description, amount from home_budget where id = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setLong(1, id);
            ResultSet resultSet = prepStmt.executeQuery();
            if (resultSet.next()) {
                Budget budget = new Budget();
                budget.setId(resultSet.getLong("id"));
                budget.setiOType(resultSet.getString("iotype"));
                budget.setDescription(resultSet.getString("description"));
                budget.setAmount(resultSet.getDouble("amount"));
                return budget;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Budget budget) {
        final String sql = "update home_budget set iotype=?, description=?, amount=? where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, budget.getiOType());
            prepStmt.setString(2, budget.getDescription());
            prepStmt.setDouble(3, budget.getAmount());
            prepStmt.setLong(4, budget.getId());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not update record");
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        final String sql = "delete from home_budget where id = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setLong(1, id);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not delete row");
            e.printStackTrace();
        }
    }

    public List<Budget> findAll(String IOType) {
        final String sql = "select * from home_budget where iotype=?";
        try {
            List<Budget> budgetList = new ArrayList<>();
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, IOType);
            ResultSet resultSet = prepStmt.executeQuery();
            while (resultSet.next()) {
                Budget budget = new Budget();
                budget.setId(resultSet.getLong(1));
                budget.setiOType(resultSet.getString(2));
                budget.setDescription(resultSet.getString(3));
                budget.setAmount(resultSet.getDouble(4));
                budgetList.add(budget);
            }   return budgetList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
