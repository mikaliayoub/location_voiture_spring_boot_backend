package com.cars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cars.entity.Reservation;
import com.cars.entity.User;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	Reservation findById(int id);
	List<Reservation> findByUser(User user);
}
