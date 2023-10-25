package com.project.Restaurant_Managementv2.dto.cart;

import java.time.LocalDateTime;

public class AddtoCartDto {
    private short id;

    private LocalDateTime createdDate;

    private double price;

    private Integer quantity;

    private short userId;
    private short productId;

    public AddtoCartDto(){

    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public short getUserId() {
        return userId;
    }

    public void setUserId(short userId) {
        this.userId = userId;
    }

    public short getProductId() {
        return productId;
    }

    public void setProductId(short productId) {
        this.productId = productId;
    }
}
