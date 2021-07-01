package com.test.springBoot.application.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "brandDevice", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Device deviceBrand;

    public Brand() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Device getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(Device deviceBrand) {
        this.deviceBrand = deviceBrand;
    }
}
