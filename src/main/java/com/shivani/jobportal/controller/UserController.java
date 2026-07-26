package com.shivani.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.jobportal.dto.LoginResponse;
import com.shivani.jobportal.entity.User;
import com.shivani.jobportal.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	 private final UserService userService;

	    public UserController(UserService userService) {
	        this.userService = userService;
	    }

	    @PostMapping("/register")
	    public String registerUser(@RequestBody User user) {

	        if (userService.emailExists(user.getEmail())) {
	            return "Email already registered";
	        }

	        userService.registerUser(user);

	        return "Registration successful";
	    }

	    @GetMapping("/all")
	    public List<User> getAllUsers() {
	        return userService.getAllUsers();
	    }
	    
	    @PostMapping("/login")
	    public LoginResponse login(@RequestBody User loginUser) {

	        User user = userService.login(
	                loginUser.getEmail(),
	                loginUser.getPassword()
	        );

	        if (user == null) {
	            return null;
	        }

	        return new LoginResponse(
	                user.getId(),
	                user.getName(),
	                user.getEmail(),
	                user.getPhone(),
	                user.getRole()
	        );
	    }
}
