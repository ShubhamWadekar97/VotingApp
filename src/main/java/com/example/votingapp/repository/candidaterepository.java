package com.example.votingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.votingapp.model.candidate;

public interface candidaterepository extends JpaRepository<candidate,Long>{

}
