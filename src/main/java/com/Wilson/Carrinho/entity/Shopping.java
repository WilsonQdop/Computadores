package com.Wilson.Carrinho.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Shopping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_shopping;

    private String name;
    private Double price;

    public Long getId_shopping() {
        return id_shopping;
    }

    public void setId_shopping(Long id_shopping) {
        this.id_shopping = id_shopping;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
