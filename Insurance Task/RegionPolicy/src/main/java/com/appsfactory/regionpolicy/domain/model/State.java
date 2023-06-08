package com.appsfactory.regionpolicy.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class State {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(length = 100, unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "state", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<County> counties;
    @Column
    private Float factor;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<County> getCounties() {
        return counties;
    }

    public void setCounties(List<County> counties) {
        this.counties = counties;
    }

    public Float getFactor() {
        return factor;
    }

    public void setFactor(Float factor) {
        this.factor = factor;
    }
}
