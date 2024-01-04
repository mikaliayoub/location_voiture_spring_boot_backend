package com.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.entity.Car;
import com.cars.entity.Reservation;
import com.cars.entity.ReservationRequest;
import com.cars.entity.User;
import com.cars.repository.CarRepository;
import com.cars.repository.ReservationRepository;
import com.cars.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private CarRepository carRepository;
	

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userRepository.findAll();

		if (!users.isEmpty()) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}/reservations")
	public List<Reservation> getAllReservationByIdUser(@PathVariable int id) {
		User user = userRepository.findById(id);
		return reservationRepository.findByUser(user);
	}
	
	@PostMapping("/{userId}/createReservation")
	public Reservation createUserReservation(@RequestBody ReservationRequest reservationRequest, @PathVariable int userId) {
	    if(carRepository.findById(reservationRequest.getCarId())!=null) {
	    	Reservation reservation = new Reservation();
		    reservation.setStartDate(reservationRequest.getStartDate());
		    reservation.setEndDate(reservationRequest.getEndDate());
		    
		    User user = userRepository.findById(userId);
		    reservation.setUser(user);
		    
		    Car car = carRepository.findById(reservationRequest.getCarId());
		    reservation.setCar(car);
		    car.setAvailable(false);
		    
		    return reservationRepository.save(reservation);
	    }
	    else {
	    	return null;
	    }
		
	}
	
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userRepository.findById(id);
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody User user) {
		User userTest= userRepository.findByEmail(user.getEmail());
		if(userTest.getPassword().equals(user.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	@PutMapping("/{id}/updatePassword")
	public User updatePassword(@PathVariable int id, @RequestBody String newPassword) {
		User user = userRepository.findById(id);
		user.setPassword(newPassword);
		return userRepository.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
}
