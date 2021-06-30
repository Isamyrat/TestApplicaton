package com.test.springBoot.application.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;
    private String password;

    @NotNull
    @JoinColumn(name = "ROLE")
    private String role;

    private LocalDate create_at;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "userBasket", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Basket basketUser;


    public User() {
    }

    public User(String name, String email, String password, String role, LocalDate create_at) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.create_at = create_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
    }

    public Basket getBasketUser() {
        return basketUser;
    }

    public void setBasketUser(Basket basketUser) {
        this.basketUser = basketUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
