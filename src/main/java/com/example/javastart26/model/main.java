package com.example.javastart26.model;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        BudgetDao budgetDao = new BudgetDao();
        budgetDao.save(new Budget("in", "koks", 25000));
        budgetDao.save(new Budget("in", "wegiel", 11000));
        budgetDao.save(new Budget("in", "piasek", 9000));
        budgetDao.save(new Budget("out", "koks", 15000));
        budgetDao.save(new Budget("out", "piasek", 4000));

        System.out.println(budgetDao.get(1));





    }
}
