package com.example.javastart26.model;

public class Budget {
    private long id;
    private String iOType;
    private String description;
    private double amount;

    public Budget() {}

    public Budget(String iOType, String description, double amount) {
        this.iOType = iOType;
        this.description = description;
        this.amount = amount;
    }

    public Budget(long id, String iOType, String description, double amount) {
        this.id = id;
        this.iOType = iOType;
        this.description = description;
        this.amount = amount;
    }

    public void setId(long id) { this.id = id; }

    public long getId() {
        return id;
    }

    public String getiOType() {
        return iOType;
    }

    public void setiOType(String iOType) {
        this.iOType = iOType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", type='" + iOType + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
