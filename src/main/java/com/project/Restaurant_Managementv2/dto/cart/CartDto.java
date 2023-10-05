package com.project.Restaurant_Managementv2.dto.cart;

import java.math.BigDecimal;
import java.util.List;

public class CartDto {
    private List<CartItemDto> cartItems;
    private Double totalCost;

    public CartDto(List<CartItemDto> cartItems, Double totalCost) {
        this.cartItems = cartItems;
        this.totalCost = totalCost;
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}


