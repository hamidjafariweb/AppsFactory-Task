package com.appsfactory.carpolicy.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class CarManufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @Column(length = 100)
    private String name;
    @OneToMany(mappedBy="carManufacturer", orphanRemoval=true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<CarClass> carClasses;

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

    public List<CarClass> getCarClasses() {
        return carClasses;
    }

    public void setCarClasses(List<CarClass> carClasses) {
        this.carClasses = carClasses;
    }
}
