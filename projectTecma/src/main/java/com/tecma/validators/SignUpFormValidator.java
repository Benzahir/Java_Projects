package com.tecma.validators;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.tecma.dto.SignUpForm;
import com.tecma.entities.User;
import com.tecma.repositories.UserRepository;

@Component
public class SignUpFormValidator extends LocalValidatorFactoryBean {
	
	private UserRepository userRepository;
	
	@Resource
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// method of LocalValidatorFactoryBean class, supports Bean Validation
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(SignUpForm.class);
	}

	// validating email and conform password in signup form (like email should be unique & password and conform password should be same)
	@Override
	public void validate(Object obj, Errors errors, final Object... validationHints) {
		super.validate(obj, errors, validationHints);
		
		if (!errors.hasErrors()) {
			SignUpForm signupForm = (SignUpForm) obj;
			User user = userRepository.findByEmail(signupForm.getEmail());
			if (user != null) {
				errors.rejectValue("email", "emailNotUnique");
			}
			if (!signupForm.getConfirmPassword().equals(signupForm.getPassword())) {
				errors.rejectValue("confirmPassword", "passwordNotMatches");
			}
		}
	}
}