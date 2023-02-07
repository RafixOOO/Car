package com.example.car.models;

import javax.persistence.*;

@Entity
@Table(name = "car_generation")
public class CarGeneration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_generation", nullable = false)
    private Integer id;

    @Column(name = "id_car_model", nullable = false)
    private Integer idCarModel;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "year_begin")
    private String yearBegin;

    @Column(name = "year_end")
    private String yearEnd;

    @Column(name = "date_create", columnDefinition = "INT UNSIGNED not null")
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

    public Integer getIdCarModel() {
        return idCarModel;
    }

    public void setIdCarModel(Integer idCarModel) {
        this.idCarModel = idCarModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearBegin() {
        return yearBegin;
    }

    public void setYearBegin(String yearBegin) {
        this.yearBegin = yearBegin;
    }

    public String getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(String yearEnd) {
        this.yearEnd = yearEnd;
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