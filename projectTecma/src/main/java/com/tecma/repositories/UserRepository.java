package com.tecma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecma.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	User findByForgotPasswordCode(String forgotPasswordCode);
	
}