package com.example.votingapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.votingapp.model.User;
import com.example.votingapp.model.candidate;
import com.example.votingapp.repository.UserRepository;
import com.example.votingapp.service.UserService;

@Controller
//@RequestMapping("/User")
public class UserController {

	private UserService userService;
	@Autowired(required=true)
	private UserRepository userRepo;
	

	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@GetMapping
	public List<User> getAllCandidate() {
		return userService.getAllCandidate();
	}
	@PostMapping
	public User addCandidate(@RequestBody User users) {
		return userService.addCandidate(users);
	}
	@GetMapping("/")
	public  String UserRegister(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "register";
	}
	@PostMapping("/registerUser")
	public String userRegister(@ModelAttribute("user")User user) {
		userService.registerUser(user);
		System.out.println(user);
		return "login";
	}
	@GetMapping("/login")
	public String login(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		
		return "login";
	}
	/*@PostMapping("/userLogin")
	public String userlogin(@ModelAttribute("user") User user) {
	String Username=user.getUsername();
	Optional<User> userData	=userRepo.findById(Username);
		  if (user.getPassword().equals(userData.get().getPassword()))  {
			return "home";	
		}else {
		return "Error";}
	}*/
	@PostMapping("/userLogin")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
	Optional<User> user =userRepo.findById(email);
        if (user != null && user.get().getPassword().equals(password)) {
            // Login successful, redirect to home page or dashboard
            return "home";
        } else {
            // Login failed, show error message
            return "Error";
        }
    }
}
