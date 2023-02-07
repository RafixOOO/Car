package com.example.car.repo;

import com.example.car.models.CarMake;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface CarMakeRepository extends JpaRepository<CarMake, Integer> {
    CarMake findByName(String name);

}