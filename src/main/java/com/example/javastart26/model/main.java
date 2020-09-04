package com.example.javastart26.model;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        BudgetDao budgetDao = new BudgetDao();
        budgetDao.add(new Budget("in", "koks", 25000));
    }
}
