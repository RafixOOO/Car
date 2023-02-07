package com.example.car.repo;

import com.example.car.models.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeRepository extends JpaRepository<CarType, Integer> {
}