package com.example.votingapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.votingapp.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findById(String email);
	// User findByEmail(String email);
	//User findByEmail(String email);
	 
}
