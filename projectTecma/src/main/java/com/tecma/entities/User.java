package com.tecma.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name="users", indexes={ @Index(columnList="email", unique=true),
		@Index(columnList="forgotPasswordCode", unique=true) })
public class User {

	public static final int EMAIL_MAX = 250;
	public static final int NAME_MAX = 50;
	public static final String EMAIL_PATTERN = "[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
	public static final int RANDOM_CODE_LENGTH = 16;
	public static final int PASSWORD_MAX = 30;
	
	// EMPTY constructor
	public User(){
		
	}
	
	// constructor with User object
	public User(User user) {
		  super();
		  this.id = user.getId();
		  this.firstName = user.getFirstName();
		  this.lastName = user.getLastName();
		  this.email = user.getEmail();
		  this.password = user.getPassword();
		  this.verificationCode = user.getVerificationCode();
		  this.isEnabled = user.getEnabled();
		  this.isAccountNonExpired = user.getAccountNonExpired();
		  this.isAccountNonLocked = user.getAccountNonLocked();
		  this.isCredentialsNonExpired = user.getCredentialsNonExpired();
		  this.isPasswordExpired = user.getPasswordExpired();
	}

	// project roles
	public static enum Role {
		// UNVERIFIED, SUPERADMIN, ADMIN
		 UNVERIFIED, CUSTOMER, SALESENGINEER, ADMIN, SUPERADMIN
	}
	
	// fields/properties

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(nullable=false, length=EMAIL_MAX)
	private String email;
	
	@NotNull
	private String firstName;

	@NotNull
	@Column(nullable=true, length=20, name="last_name")
	private String lastName;

	// no length because it will be encrypted
	@NotNull
	@Column(nullable=false)
	private String password;

	@Column(length=16)
	private String verificationCode;

	@Column(length=RANDOM_CODE_LENGTH)
	private String forgotPasswordCode;

	// @org.hibernate.annotations.Type(type="true_false")
	@Type(type="org.hibernate.type.NumericBooleanType")
	@Column(nullable=false, columnDefinition="tinyint(1) default 1", name="is_enabled")
	private boolean isEnabled;

	// @org.hibernate.annotations.Type(type="true_false")
	@Type(type="org.hibernate.type.NumericBooleanType")
	@Column(nullable=false, columnDefinition="tinyint(1) default 1", name="is_account_non_expired")
	private boolean isAccountNonExpired;

	// @org.hibernate.annotations.Type(type="true_false")
	@Type(type="org.hibernate.type.NumericBooleanType")
	@Column(nullable=false, columnDefinition="tinyint(1) default 1", name="is_account_non_locked")
	private boolean isAccountNonLocked;

	// @org.hibernate.annotations.Type(type="true_false")
	@Type(type="org.hibernate.type.NumericBooleanType")
	@Column(nullable=false, columnDefinition="tinyint(1) default 1", name="is_credentials_non_expired")
	private boolean isCredentialsNonExpired;

	// @org.hibernate.annotations.Type(type="true_false")
	@Type(type="org.hibernate.type.NumericBooleanType")
	@Column(nullable=false, columnDefinition="tinyint(1) default 0", name="is_password_expired")
	private boolean isPasswordExpired;
	
	@ElementCollection(fetch=FetchType.EAGER)
	private Set<Role> roles = new HashSet<Role>();
	
	// getters and setters

	public String getForgotPasswordCode() {
		return forgotPasswordCode;
	}

	public void setForgotPasswordCode(String forgotPasswordCode) {
		this.forgotPasswordCode = forgotPasswordCode;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLastName() {
		return lastName;
	}

	public boolean getEnabled() {
		return isEnabled;
	}

	public boolean getAccountNonExpired() {
		return isAccountNonExpired;
	}

	public boolean getAccountNonLocked() {
		return isAccountNonLocked;
	}

	public boolean getCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	public boolean getPasswordExpired() {
		return isPasswordExpired;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public void setAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public void setPasswordExpired(boolean isPasswordExpired) {
		this.isPasswordExpired = isPasswordExpired;
	}
	
	public boolean isAdmin() {
		return roles.contains(Role.ADMIN);
	}
}