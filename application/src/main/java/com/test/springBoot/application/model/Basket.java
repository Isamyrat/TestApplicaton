package com.test.springBoot.application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
    private User userBasket;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "basket", cascade = CascadeType.ALL)
    @JsonManagedReference
    private BasketDevice basketDevice;

    public Basket() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserBasket() {
        return userBasket;
    }

    public void setUserBasket(User userBasket) {
        this.userBasket = userBasket;
    }

    public BasketDevice getBasketDevice() {
        return basketDevice;
    }

    public void setBasketDevice(BasketDevice basketDevice) {
        this.basketDevice = basketDevice;
    }
}
