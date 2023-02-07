package com.example.car.models;

import javax.persistence.*;

@Entity
@Table(name = "car_model")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_model", nullable = false)
    private Integer id;

    @Column(name = "id_car_make", nullable = false)
    private Integer idCarMake;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date_create", columnDefinition = "INT UNSIGNED")
    private Long dateCreate;

    @Column(name = "date_update", columnDefinition = "INT UNSIGNED")
    private Long dateUpdate;

    @Column(name = "id_car_type", nullable = false)
    private Integer idCarType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCarMake() {
        return idCarMake;
    }

    public void setIdCarMake(Integer idCarMake) {
        this.idCarMake = idCarMake;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Long dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Long getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Long dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Integer getIdCarType() {
        return idCarType;
    }

    public void setIdCarType(Integer idCarType) {
        this.idCarType = idCarType;
    }

}