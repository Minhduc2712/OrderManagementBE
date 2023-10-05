package com.project.Restaurant_Managementv2.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Wish_List",catalog = "RestaurantManagementv2")
public class WishList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WishListId", unique = true, nullable = false)
    private short id;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="CustomerId")
    private User user;

    @Column(name="Created_Date")
    private Date createdDate;

    @ManyToOne()
    @JoinColumn(name="ProductId")
    private Product product;

    public WishList(){

    }

    public WishList(User user, Product product) {
        this.user = user;
        this.product = product;
        this.createdDate = new Date();
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setCustomer(User customer) {
        this.user = user;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
