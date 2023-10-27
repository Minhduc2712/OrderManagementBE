package com.project.Restaurant_Managementv2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.Restaurant_Managementv2.enums.Roles;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users", catalog = "railway")
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


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_roles",
            joinColumns = @JoinColumn(name = "UserId"),
            inverseJoinColumns = @JoinColumn(name = "RodeId"))
    private Set<Role> roles = new HashSet<>();

    public User(){}

    public User(String firstName, String lastName, String username, String encryptedPassword, Roles user, String email){

    }

    public User( String firstName,String lastName, String username, String password, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.password = password;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
