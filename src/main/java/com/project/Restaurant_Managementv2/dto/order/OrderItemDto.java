package com.project.Restaurant_Managementv2.dto.order;

public class OrderItemDto {
    private Double price;
    private Integer quantity;
    private Integer orderId;
    private Integer productId;

    public OrderItemDto(){}

    public OrderItemDto(Double price, Integer quantity, Integer orderId, Integer productId) {
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
