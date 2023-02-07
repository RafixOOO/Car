package com.example.car.models;

import javax.persistence.*;

@Entity
@Table(name = "car_trim")
public class CarTrim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_trim", nullable = false)
    private Integer id;

    @Column(name = "id_car_serie", nullable = false)
    private Integer idCarSerie;

    @Column(name = "id_car_model", nullable = false)
    private Integer idCarModel;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_production_year")
    private Integer startProductionYear;

    @Column(name = "end_production_year")
    private Integer endProductionYear;

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

    public Integer getIdCarSerie() {
        return idCarSerie;
    }

    public void setIdCarSerie(Integer idCarSerie) {
        this.idCarSerie = idCarSerie;
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

    public Integer getStartProductionYear() {
        return startProductionYear;
    }

    public void setStartProductionYear(Integer startProductionYear) {
        this.startProductionYear = startProductionYear;
    }

    public Integer getEndProductionYear() {
        return endProductionYear;
    }

    public void setEndProductionYear(Integer endProductionYear) {
        this.endProductionYear = endProductionYear;
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