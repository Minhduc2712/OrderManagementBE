package com.project.Restaurant_Managementv2.form.Cart;

import com.project.Restaurant_Managementv2.models.Cart;
import com.project.Restaurant_Managementv2.models.Product;

public class CartItem {
    private Short id;
    private Integer quantity;
    private Product product;

    public CartItem(){

    }

//    public CartItem(Integer id, Integer quantity, Product product) {
//        this.id = id;
//        this.quantity = quantity;
//        this.product = product;
//    }

    public CartItem(Cart cart) {
        this.setId(cart.getId());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItemDto{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
