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

        budgetDao.update(new Budget(1, "in", "ziemia", 41000));

        System.out.println(budgetDao.get(1));

        budgetDao.delete(7);
        budgetDao.delete(8);
        budgetDao.delete(9);
        budgetDao.delete(10);
        budgetDao.delete(11);

        System.out.println(budgetDao.findAll("in"));





    }
}
