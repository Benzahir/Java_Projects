package com.tecma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tecma.dto.ChangePasswordForm;
import com.tecma.entities.User;
import com.tecma.entities.User.Role;
import com.tecma.repositories.UserRepository;
import com.tecma.util.MyUtil;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User save(User u, int roleId) {
		User user = new User();
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		user.setEmail(u.getEmail());
		user.setPassword(passwordEncoder.encode(u.getPassword()));
		if (roleId == 1) {
			user.getRoles().add(Role.CUSTOMER);
		} else if (roleId == 2) {
			user.getRoles().add(Role.SALESENGINEER);
		} else if (roleId == 3) {
			user.getRoles().add(Role.ADMIN);
		} else {
			user.getRoles().add(Role.UNVERIFIED);
		}
		user.setVerificationCode(null);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setPasswordExpired(false);
		userRepository.save(user);
		return user;
	}

	public boolean update(Long id, User u, int roleId) {
		User user = userRepository.findOne(id);
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		user.setEmail(u.getEmail());
		// u.setPassword(passwordEncoder.encode(u.getPassword()));

		if (roleId == 1) {
			user.getRoles().remove(Role.CUSTOMER);
			user.getRoles().add(Role.CUSTOMER);
		} else if (roleId == 2) {
			user.getRoles().remove(Role.SALESENGINEER);
			user.getRoles().add(Role.SALESENGINEER);
		} else if (roleId == 3) {
			user.getRoles().remove(Role.ADMIN);
			user.getRoles().add(Role.ADMIN);
		} else {
			user.getRoles().remove(Role.UNVERIFIED);
			user.getRoles().add(Role.UNVERIFIED);
		}
		user.setVerificationCode(null);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setPasswordExpired(false);
		userRepository.save(user);
		return true;
	}

	/*
	 * Updating user password
	 * 
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean updatePassword(ChangePasswordForm changePasswordForm) {

		// Getting user record by its session id
		User user = userRepository.findOne(MyUtil.getSessionUser().getId());
		// encrypting new password and setting it to the password field
		user.setPassword(passwordEncoder.encode(changePasswordForm.getNewPassword()));
		userRepository.save(user);

		return false;
	}

}
