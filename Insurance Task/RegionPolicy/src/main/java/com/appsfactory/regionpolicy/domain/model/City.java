package com.appsfactory.regionpolicy.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "city", orphanRemoval = true, cascade = CascadeType.ALL)
    List<Location> locations;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "county_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private County county;

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

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }
}
