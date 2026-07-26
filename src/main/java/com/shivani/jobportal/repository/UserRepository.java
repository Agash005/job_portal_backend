package com.shivani.jobportal.repository;

import com.shivani.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
	long countByRole(String role);

}
