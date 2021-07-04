package com.test.springBoot.application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
@Table(name = "device_information")
public class DeviceInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id",referencedColumnName = "id",nullable = false)
    @JsonBackReference
    private Device deviceInformation;

    public DeviceInformation() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Device getDeviceInformation() {
        return deviceInformation;
    }

    public void setDeviceInformation(Device deviceInformation) {
        this.deviceInformation = deviceInformation;
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
}
