package com.example.car.repo1;


import com.example.car.model1.CarEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface CarEquipmentRepository extends JpaRepository<CarEquipment, Integer> {

    List<CarEquipment> findByIdCarTrim(Integer idCarTrim);
}