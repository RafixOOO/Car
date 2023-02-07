package com.example.car.repo;

import com.example.car.models.CarGeneration;
import com.example.car.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarGenerationRepository extends JpaRepository<CarGeneration, Integer> {
    List<CarGeneration> findByIdCarModel(Integer idCarModel);

    CarGeneration findByIdCarModelAndName(Integer idCarModel, String name);


    CarGeneration findByName(String name);
}