package com.project.Restaurant_Managementv2.models;

import jakarta.persistence.*;
//import org.apache.catalina.User;


import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="tokens",catalog="RestaurantManagementv2" )
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TokenId")
    private short id;

    private String token;

    @Column(name = "Created_Date")
    private Date createdDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name="UserId")
    private User user;

    public AuthenticationToken(User user) {
        this.user = user;
        this.createdDate=new Date();
        this.token= UUID.randomUUID().toString();
    }

    public AuthenticationToken(){

    }

    public AuthenticationToken(short id, String token, Date createdDate, User user) {
        this.id = id;
        this.token = token;
        this.createdDate = createdDate;
        this.user = user;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
