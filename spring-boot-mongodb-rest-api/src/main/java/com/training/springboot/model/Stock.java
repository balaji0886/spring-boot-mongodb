package com.training.springboot.model;


public class Stock {
    private String name;
    private Double quantity;

    public String getName() {
        return name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
