package com.example.votingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.votingapp.model.User;
import com.example.votingapp.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
private UserRepository userRepo;
	
public UserServiceImpl(UserRepository userRepo) {
	super();
	this.userRepo = userRepo;
}

@Override
public List<User> getAllCandidate() {
	// TODO Auto-generated method stub
	return userRepo.findAll();
}

@Override
public User addCandidate(User users) {
	// TODO Auto-generated method stub
	return userRepo.save(users);
}

@Override
public void registerUser(User users) {
	// TODO Auto-generated method stub
	userRepo.save(users);
}
public Optional<User> getUserByEmail(String email) {
    return userRepo.findById(email);
}

}
