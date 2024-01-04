package com.cars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cars.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findAll();
    User findByEmail(String email);
	User findById(int id);
	boolean existsByEmail(String email);
}

