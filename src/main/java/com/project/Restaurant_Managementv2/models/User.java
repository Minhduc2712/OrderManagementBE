package com.project.Restaurant_Managementv2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.Restaurant_Managementv2.enums.Role;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="users", catalog = "RestaurantManagementv2")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId", unique = true)
    private Short id;
    @Column(name="LastName", length=50)
    private String lastName;
    @Column(name="FirstName", length=50)
    private String firstName;
    @Column(name="UserName",unique = true, length=50)
    private String username;
    @Column(name="PassWord",length=500)
    private String password;

    @Column(name="Email", length = 50)
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;

    @Enumerated(EnumType.STRING)
    @Column(name ="Role")
    private Role role;

    public User(){

    }

    public User(String lastName, String firstName, String username, String password, Role role, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.password = password;
        this.role= role;
        this.email=email;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
