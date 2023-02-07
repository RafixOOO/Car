package com.example.car.repo;

import com.example.car.models.CarSerie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarSerieRepository extends JpaRepository<CarSerie, Integer> {
    List<CarSerie> findByIdCarModelAndIdCarGeneration(Integer idCarModel, Integer idCarGeneration);
    CarSerie findByNameAndIdCarModelAndIdCarGeneration(String name, Integer idCarModel, Integer idCarGeneration);


}