package com.project.Restaurant_Managementv2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="carts", catalog="railway")
public class Cart implements Serializable {
    @Id
    @Column(name = "CartId", nullable = false)
    private short id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Created_Date")
    private LocalDateTime createdDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ProductId")
    private Product product;

    private short userId;

    private int quantity;

    private double price;

//    private double totalAmount;

    public Cart(){

    }

//    public Cart(Product product, short userId, int quantity, double price, double totalAmount) {
//        this.product = product;
//        this.userId = userId;
//        this.quantity = quantity;
//        this.price = price;
//        this.totalAmount = totalAmount;
//    }


    public Cart(LocalDateTime createdDate, Product product, short userId, int quantity, double price) {
        this.createdDate = createdDate;
        this.product = product;
        this.userId = userId;
        this.quantity = quantity;
        this.price = price;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getUser() {
        return userId;
    }

    public void setUser(short userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public double getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(double totalAmount) {
//        this.totalAmount = totalAmount;
//    }

    @PrePersist
    private void prePersist() {
        createdDate = LocalDateTime.now();
    }


}
