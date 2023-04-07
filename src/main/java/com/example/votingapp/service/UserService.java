package com.example.votingapp.service;

import java.util.List;

import com.example.votingapp.model.User;
import com.example.votingapp.model.candidate;

public interface UserService {
	public List<User> getAllCandidate();
	User addCandidate(User users);
	public void registerUser(User users);
    

}
