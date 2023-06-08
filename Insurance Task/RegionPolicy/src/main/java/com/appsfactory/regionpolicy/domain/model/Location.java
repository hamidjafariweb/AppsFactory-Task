package com.appsfactory.regionpolicy.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(length = 100)
    private String Name;
    @Column
    private Long postalCode;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private com.appsfactory.regionpolicy.domain.model.City city;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public com.appsfactory.regionpolicy.domain.model.City getCity() {
        return city;
    }

    public void setCity(com.appsfactory.regionpolicy.domain.model.City city) {
        this.city = city;
    }
}
