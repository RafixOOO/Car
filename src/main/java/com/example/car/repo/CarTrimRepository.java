package com.example.car.repo;

import com.example.car.models.CarTrim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarTrimRepository extends JpaRepository<CarTrim, Integer> {
    List<CarTrim> findByIdCarSerieAndIdCarModel(Integer idCarSerie, Integer idCarModel);
    CarTrim findByNameAndIdCarSerieAndIdCarModel(String name, Integer idCarSerie, Integer idCarModel);

}