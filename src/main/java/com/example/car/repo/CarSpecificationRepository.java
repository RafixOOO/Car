package com.example.car.repo;

import com.example.car.models.CarSpecification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarSpecificationRepository extends JpaRepository<CarSpecification, Integer> {



}