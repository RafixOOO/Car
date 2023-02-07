package com.example.car.model1;

import javax.persistence.*;

@Entity
@Table(name = "car_equipment")
public class CarEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_equipment", nullable = false)
    private Integer id;

    @Column(name = "id_car_trim", nullable = false)
    private Integer idCarTrim;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "year")
    private Integer year;

    @Column(name = "date_create", columnDefinition = "INT UNSIGNED not null")
    private Long dateCreate;

    @Column(name = "date_update", columnDefinition = "INT UNSIGNED not null")
    private Long dateUpdate;

    @Column(name = "id_car_type", nullable = false)
    private Integer idCarType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCarTrim() {
        return idCarTrim;
    }

    public void setIdCarTrim(Integer idCarTrim) {
        this.idCarTrim = idCarTrim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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