package com.project.Restaurant_Managementv2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Menu", catalog = "RestaurantManagementv2")
public class Product implements Serializable {
    @Column(name = "ProductId", unique = true, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "ProductName", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "ProductCountry", length = 50, nullable = false)
    private String country;

    @Column(name = "ProductImg", length = 300)
    private String img;

    @Column(name = "Price", nullable = false, precision = 10)
    private Double price;

    @Column(name = "Rate")
    private short rate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryId")
    private Category category;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<WishList> wishListList;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Cart> carts;
    public Product() {

    }

    public Product(String name, String country, String img, Double price, short rate, Category category) {
        super();
        this.name = name;
        this.country = country;
        this.img = img;
        this.price = price;
        this.rate = rate;
        this.category = category;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public short getRate() {
        return rate;
    }

    public void setRate(short rate) {
        this.rate = rate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", img='" + img + '\'' +
                ", price=" + price +
                ", rate=" + rate +
                '}';
    }
}