package com.example.car.repo;

import com.example.car.models.CarMake;
import com.example.car.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel, Integer> {
    List<CarModel> findByIdCarMake(Integer idCarMake);
    CarModel findByName(String name);
}