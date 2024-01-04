package com.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.entity.Reservation;
import com.cars.repository.ReservationRepository;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@GetMapping("/all")
	public List<Reservation> getAllReservation(){
		return reservationRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Reservation getReservationById(@PathVariable int id){
		return reservationRepository.findById(id);
	}
	
	@PutMapping("/{id}")
	public Reservation updateReservation(@PathVariable int id, @RequestBody Reservation reservation) {
		reservation.setId(id);
		return reservationRepository.save(reservation);
	}
	
	@DeleteMapping("/{id}")
	public void deleteReservation(@PathVariable int id) {
		reservationRepository.deleteById(id);
	}
}
	