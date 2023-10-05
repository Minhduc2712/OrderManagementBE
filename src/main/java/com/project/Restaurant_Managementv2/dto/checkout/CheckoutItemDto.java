package com.project.Restaurant_Managementv2.dto.checkout;

public class CheckoutItemDto {
    private String productName;
    private int quantity;
    private Double price;
    private long productId;
    private int UserId;

    public CheckoutItemDto(){

    }

    public CheckoutItemDto(String productName, int quantity, Double price, long productId, int userId) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
        this.UserId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return UserId;
    }

    public void setUserId(int userId) {
        this.UserId = userId;
    }
}
