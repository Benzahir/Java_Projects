package com.tecma.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.tecma.entities.User;

public class SignUpForm {
	
	@NotNull
	@Size(min=1, max=255, message="{emailSizeError}")
	@Pattern(regexp=User.EMAIL_PATTERN, message="{emailPatternError}")
	private String email;
	
	@NotNull
	@Size(min=3, max=50)
	private String firstName;

	@NotNull
	@Size(min=3, max=20)
	private String lastName;

	@NotNull
	@Size(min=6, max=50, message="{passwordSizeError}")
	private String password;

	// no length because it will be encrypted
	@Transient
	@Size(min=6, max=50, message="{passwordSizeError}")
	private String confirmPassword;
	
	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}