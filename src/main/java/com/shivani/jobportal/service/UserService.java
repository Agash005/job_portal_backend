package com.shivani.jobportal.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.shivani.jobportal.entity.User;
import com.shivani.jobportal.repository.UserRepository;

@Service
public class UserService {

	 private final UserRepository userRepository;

	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    public User registerUser(User user) {
	        return userRepository.save(user);
	    }

	    public User findByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }

	    public boolean emailExists(String email) {

	        User user = userRepository.findByEmail(email);

	        return user != null;
	    }

	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
	    
	    
	    public User login(String email, String password) {

	        User user = userRepository.findByEmail(email);

	        if (user != null && user.getPassword().equals(password)) {
	            return user;
	        }

	        return null;
	    }
	    
}
