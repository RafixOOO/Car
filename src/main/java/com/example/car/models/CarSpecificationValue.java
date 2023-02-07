package com.example.car.models;

import javax.persistence.*;

@Entity
@Table(name = "car_specification_value")
public class CarSpecificationValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_specification_value", nullable = false)
    private Integer id;

    @Column(name = "id_car_trim", nullable = false)
    private Integer idCarTrim;

    @Column(name = "id_car_specification", nullable = false)
    private Integer idCarSpecification;

    @Column(name = "value")
    private String value;

    @Column(name = "unit")
    private String unit;

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

    public Integer getIdCarTrim() {
        return idCarTrim;
    }

    public void setIdCarTrim(Integer idCarTrim) {
        this.idCarTrim = idCarTrim;
    }

    public Integer getIdCarSpecification() {
        return idCarSpecification;
    }

    public void setIdCarSpecification(Integer idCarSpecification) {
        this.idCarSpecification = idCarSpecification;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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