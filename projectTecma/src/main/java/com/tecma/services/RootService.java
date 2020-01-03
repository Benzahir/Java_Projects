package com.tecma.services;

import javax.mail.MessagingException;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.validation.BindingResult;

import com.tecma.dto.ForgotPasswordForm;
import com.tecma.dto.ResetPasswordForm;
import com.tecma.dto.SignUpForm;
import com.tecma.entities.User;
import com.tecma.entities.User.Role;
import com.tecma.mail.SmtpMailSender;
import com.tecma.repositories.UserRepository;
import com.tecma.util.MyUtil;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class RootService {
	
	private static final Logger logger = LoggerFactory.getLogger(RootService.class);
	
	private PasswordEncoder passwordEncoder;
	private UserRepository userRepository;
	private SmtpMailSender smtpMailSender;
	
	@Autowired
	public RootService(PasswordEncoder passwordEncoder,
			UserRepository userRepository, SmtpMailSender smtpMailSender) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.smtpMailSender = smtpMailSender;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void signUp(SignUpForm signupForm){		
		
		User u = new User();
		u.setFirstName(signupForm.getFirstName());
		u.setLastName(signupForm.getLastName());
		u.setEmail(signupForm.getEmail());
		u.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		u.getRoles().add(Role.UNVERIFIED);
		u.setVerificationCode(RandomStringUtils.randomAlphanumeric(16));
		u.setAccountNonExpired(true);
		u.setAccountNonLocked(true);
		u.setCredentialsNonExpired(true);
		u.setEnabled(true);
		u.setPasswordExpired(false);
		userRepository.save(u);
		
		TransactionSynchronizationManager.registerSynchronization(
			    new TransactionSynchronizationAdapter() {
			        @Override
			        public void afterCommit() {
			    		try {
			    			String verifyLink = MyUtil.hostUrl() + "/admin/users/" + u.getVerificationCode() + "/verify";
			    			smtpMailSender.send(u.getEmail(), MyUtil.getMessage("verifySubject"), MyUtil.getMessage("verifyEmail", verifyLink));
			    			logger.info("Verification mail to " + u.getEmail() + " queued.");
						} catch (MessagingException e) {
							System.out.println(e);
						}
			        }
		    });
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public boolean verify(String verificationCode) {
		try {
			long loggedInUserId = MyUtil.getSessionUser().getId();
			User user = userRepository.findOne(loggedInUserId);
			
			// if verification code in the URL didn't match the verification code in the DB
			//  incorrect message(messages.properties) is called 
			// which takes "Verification code" as a parameter 
			MyUtil.validate(!user.getVerificationCode().isEmpty(), "alreadyVerified");
			MyUtil.validate(user.getVerificationCode().equals(verificationCode),
					"incorrect", "verification code");
			user.getRoles().remove(Role.UNVERIFIED);
			if(user.getId() != 0) {
				user.getRoles().add(Role.CUSTOMER);
			}else {
				user.getRoles().add(Role.UNVERIFIED);
			}
			
			// Setting verifcationCode to null
			user.setVerificationCode(null);			
			userRepository.save(user);
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/*
	 * Forgot password, In case any user forgets their password
	 *  
	 * */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void forgotPassword(ForgotPasswordForm form) {
		// Finding user record by email on the forgot password form
		final User user = userRepository.findByEmail(form.getEmail());
		// Generating forgotPasswordCode
		final String forgotPasswordCode = RandomStringUtils.randomAlphanumeric(User.RANDOM_CODE_LENGTH);
		// Setting the ForgotPasswordCode
		user.setForgotPasswordCode(forgotPasswordCode);
		// Saving the user
		final User savedUser = userRepository.save(user);
		
		TransactionSynchronizationManager.registerSynchronization(
			    new TransactionSynchronizationAdapter() {
			        @Override
			        public void afterCommit() {
			        	try {
							mailForgotPasswordLink(savedUser);
						} catch (MessagingException e) {
							System.out.println(e);
						}
			        }

		    });				

	}
	
	/*
	 * Sending mail for the ForgotPasswordLink to the entered email
	 *  
	 * */
	private void mailForgotPasswordLink(User user) throws MessagingException {
		// Generating forgotPasswordLink to be send on the user's email
		String forgotPasswordLink = MyUtil.hostUrl() + "/resetpassword/"
				+ user.getForgotPasswordCode();
		smtpMailSender.send(user.getEmail(),
				MyUtil.getMessage("forgotPasswordSubject"),
				MyUtil.getMessage("forgotPasswordEmail", forgotPasswordLink));

	}

	/*
	 * Resetting the password after user successfully verified
	 * With the forgotPasswordLink
	 *  
	 * */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void resetPassword(String forgotPasswordCode,
			ResetPasswordForm resetPasswordForm,
			BindingResult result) {
		// Getting user record by ForgotPasswordCode
		User user = userRepository.findByForgotPasswordCode(forgotPasswordCode);
		// If null sending error message
		if (user == null)
			result.reject("invalidForgotPassword");
		
		if (result.hasErrors())
			return;
		
		// setting ForgotPasswordCode to null, when forgotPasswordLink verified 
		user.setForgotPasswordCode(null);
		// encrypting the password
		user.setPassword(passwordEncoder.encode(resetPasswordForm.getPassword().trim()));
		userRepository.save(user);
	}
	
	public User findOne(long userId){
		
		User loggedIn = MyUtil.getSessionUser();
		User user = userRepository.findOne(userId);
		
		if((loggedIn == null) || loggedIn.getId() != user.getId() && !loggedIn.isAdmin()){
			user.setEmail("Confidential");
			
		}
		return userRepository.findOne(userId);
	}
		
}