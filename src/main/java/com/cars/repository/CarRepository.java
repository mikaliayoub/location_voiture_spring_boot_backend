package com.cars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cars.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{
	Car findById(int id);
	List<Car> findByBrand(String brand);
	
	@Query("SELECT c FROM Car c WHERE c.price BETWEEN :minPrice AND :maxPrice")
    List<Car> findCarsInPriceRange(@Param("minPrice") float minPrice, @Param("maxPrice") float maxPrice);
}
