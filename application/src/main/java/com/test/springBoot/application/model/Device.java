package com.test.springBoot.application.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Date year;
    private Integer count;
    private Double price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id",referencedColumnName = "id",nullable = false)
    private Brand brandDevice;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "tag_id")
    Set<Tag> tagDevice;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "deviceInformation", cascade = CascadeType.ALL)
    private DeviceInformation deviceInformationS;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "deviceBasket", cascade = CascadeType.ALL)
    private Set<BasketDevice> basketDevices;

    public Device() {
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

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Brand getBrandDevice() {
        return brandDevice;
    }

    public void setBrandDevice(Brand brandDevice) {
        this.brandDevice = brandDevice;
    }

    public Set<Tag> getTagDevice() {
        return tagDevice;
    }

    public void setTagDevice(Set<Tag> tagDevice) {
        this.tagDevice = tagDevice;
    }

    public DeviceInformation getDeviceInformationS() {
        return deviceInformationS;
    }

    public void setDeviceInformationS(DeviceInformation deviceInformationS) {
        this.deviceInformationS = deviceInformationS;
    }

    public Set<BasketDevice> getBasketDevices() {
        return basketDevices;
    }

    public void setBasketDevices(Set<BasketDevice> basketDevices) {
        this.basketDevices = basketDevices;
    }
}
