package com.test.springBoot.application.model;

import javax.persistence.*;


@Entity
@Table(name = "basket_device")
public class BasketDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_id",referencedColumnName = "id",nullable = false)
    private Basket basket;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id", referencedColumnName = "id", nullable = false)
    private Device deviceBasket;

    public BasketDevice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Device getDeviceBasket() {
        return deviceBasket;
    }

    public void setDeviceBasket(Device deviceBasket) {
        this.deviceBasket = deviceBasket;
    }
}
