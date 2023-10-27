package com.project.Restaurant_Managementv2.models;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import jakarta.persistence.*;

@Entity
@Table(name="CheckoutCart", catalog="railway")
public class CheckoutCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    private String order_id,payment_type,delivery_address;
    @JsonIgnore
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;
    private int quantity;
    private double price;
    @Column(updatable=false, insertable=false)
    private String order_date;

    public CheckoutCart(Short id, String order_id, String payment_type, String delivery_address, User user, Product product, int quantity, double price, String order_date) {
        this.id = id;
        this.order_id = order_id;
        this.payment_type = payment_type;
        this.delivery_address = delivery_address;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.order_date = order_date;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
}
