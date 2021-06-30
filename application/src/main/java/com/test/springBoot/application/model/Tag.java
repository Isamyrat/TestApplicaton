package com.test.springBoot.application.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tagDevice",cascade = CascadeType.ALL)
    private Set<Device> deviceTag;

    public Tag() {
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Device> getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(Set<Device> deviceTag) {
        this.deviceTag = deviceTag;
    }
}
