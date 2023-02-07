package com.example.car.repo1;

import com.example.car.model1.CarOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOptionRepository extends JpaRepository<CarOption, Integer> {
}