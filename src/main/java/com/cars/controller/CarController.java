package com.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.entity.Car;
import com.cars.repository.CarRepository;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarRepository carRepository;

	@GetMapping("/all")
	public List<Car> getAllCar() {
		return carRepository.findAll();
	}

	@GetMapping("/+{id}")
	public Car getCarById(@PathVariable int id) {
		return carRepository.findById(id);
	}

	@GetMapping("/{brand}")
	public List<Car> getCarByBrand(@PathVariable String brand) {
		return carRepository.findByBrand(brand);
	}

	@GetMapping("/byPrice/{min}/{max}")
	public List<Car> getCarsByPriceRange(@PathVariable float min, @PathVariable float max) {
		return carRepository.findCarsInPriceRange(min, max);
	}

	@PostMapping
	public Car createCar(@RequestBody Car car) {
		car.setAvailable(true);
		return carRepository.save(car);
	}

	@PutMapping("{id}")
	public Car updateCar(@PathVariable int id, @RequestBody Car car) {
		car.setId(id);
		return carRepository.save(car);
	}

	@DeleteMapping("/{id}")
	public void deleteCar(@PathVariable int id) {
		carRepository.deleteById(id);
	}

}
