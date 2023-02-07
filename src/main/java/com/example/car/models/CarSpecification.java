package com.example.car.models;

import javax.persistence.*;

@Entity
@Table(name = "car_specification")
public class CarSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_specification", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_parent")
    private Integer idParent;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdParent() {
        return idParent;
    }

    public void setIdParent(Integer idParent) {
        this.idParent = idParent;
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