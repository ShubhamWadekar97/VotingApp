package com.example.votingapp.service;

import java.util.List;

import com.example.votingapp.model.candidate;

public interface candidateservice {

	public List<candidate> getAllCandidate();
	candidate addCandidate(candidate candidates);
	
}
