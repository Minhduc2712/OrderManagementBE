package com.project.Restaurant_Managementv2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Order_Item", catalog="RestaurantManagementv2")
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="OrderItemId",unique = true,nullable = false)
    private short id;

    @Column(name="Quantity")
    private int quantity;

    @Column(name="Price")
    private Double price;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Created_Date")
    private Date createdDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="OrderId")
    private Order order;

    @OneToOne
    @JoinColumn(name="ProductId")
    private Product product;

    public OrderItem(){

    }

    public OrderItem(int quantity, Double price, Order order, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.product = product;

    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
