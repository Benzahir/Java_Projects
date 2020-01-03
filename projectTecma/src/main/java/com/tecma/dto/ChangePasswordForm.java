package com.tecma.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tecma.entities.User;


public class ChangePasswordForm {
	
	@NotNull
	@Size(min=6, max=User.PASSWORD_MAX, message="{passwordSizeError}")
	private String password = "";
	
	@NotNull
	@Size(min=6, max=User.PASSWORD_MAX, message="{passwordSizeError}")
	private String newPassword = "";
	
	@NotNull
	@Size(min=6, max=User.PASSWORD_MAX, message="{passwordSizeError}")
	private String confirmPassword = "";

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
