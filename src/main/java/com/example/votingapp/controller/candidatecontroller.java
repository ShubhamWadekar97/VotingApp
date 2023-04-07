package com.example.votingapp.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.votingapp.model.User;
import com.example.votingapp.model.candidate;
import com.example.votingapp.service.candidateservice;
@RestController
@RequestMapping("/candidates")
public class candidatecontroller {

	private candidateservice candidateService;

	public candidatecontroller(candidateservice candidateService) {
		super();
		this.candidateService = candidateService;
	}
	@GetMapping
	public List<candidate> getAllCandidate() {
		return candidateService.getAllCandidate();
	}
	@PostMapping
	public candidate addCandidate(@RequestBody candidate candidates) {
		
		return candidateService.addCandidate(candidates);
	}
	
	@GetMapping("/candidates")
	public String listOfStudents(Model model)
	{
		model.addAttribute("candidates",candidateService.getAllCandidate());
		return "students";
	}	
}
