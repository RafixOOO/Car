package com.example.car.repo;

import com.example.car.models.CarSpecificationValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface CarSpecificationValueRepository extends JpaRepository<CarSpecificationValue, Integer> {
    List<CarSpecificationValue> findByIdCarTrim(Integer idCarTrim);

}