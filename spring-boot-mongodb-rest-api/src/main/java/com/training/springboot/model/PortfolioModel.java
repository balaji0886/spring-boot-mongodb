package com.training.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "portfolio")
public class PortfolioModel {

    public static final String SEQUENCE_NAME = "portfolio_sequence";

    @Id
    private Long id;

    private String name;

    private Gold gold;

    private Stock stock;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gold getGold() {
        return gold;
    }

    public Stock getStock() {
        return stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
