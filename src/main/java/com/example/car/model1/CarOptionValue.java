package com.example.car.model1;

import javax.persistence.*;

@Entity
@Table(name = "car_option_value")
public class CarOptionValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_option_value", nullable = false)
    private Integer id;

    @Column(name = "id_car_option", nullable = false)
    private Integer idCarOption;

    @Column(name = "id_car_equipment", nullable = false)
    private Integer idCarEquipment;

    @Column(name = "is_base", nullable = false)
    private Boolean isBase = false;

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

    public Integer getIdCarOption() {
        return idCarOption;
    }

    public void setIdCarOption(Integer idCarOption) {
        this.idCarOption = idCarOption;
    }

    public Integer getIdCarEquipment() {
        return idCarEquipment;
    }

    public void setIdCarEquipment(Integer idCarEquipment) {
        this.idCarEquipment = idCarEquipment;
    }

    public Boolean getIsBase() {
        return isBase;
    }

    public void setIsBase(Boolean isBase) {
        this.isBase = isBase;
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