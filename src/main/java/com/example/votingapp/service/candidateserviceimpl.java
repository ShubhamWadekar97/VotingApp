package com.example.votingapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.votingapp.model.candidate;
import com.example.votingapp.repository.candidaterepository;
@Service
public class candidateserviceimpl implements candidateservice{

	private candidaterepository candidateRepo;
	
	
	public candidateserviceimpl(candidaterepository candidateRepo) {
		super();
		this.candidateRepo = candidateRepo;
	}

	@Override
	public List<candidate> getAllCandidate() {
		// TODO Auto-generated method stub
		return candidateRepo.findAll();
	}

	@Override
	public candidate addCandidate(candidate candidates) {
		// TODO Auto-generated method stub
		return candidateRepo.save(candidates);
	}
	
	

}
