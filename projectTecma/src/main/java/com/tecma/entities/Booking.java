package com.tecma.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "booking", indexes = { @Index(columnList = "order_number") })
public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;

	// fields/properties

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// shipping address

	@Size(min = 2, max = 50, message = "{nameSizeError}")
	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(length = 20)
	private String lastName;

	@Size(min = 7, max = 255, message = "{emailSizeError}")
	@Pattern(regexp = User.EMAIL_PATTERN, message = "{emailPatternError}")
	@Column(nullable = false, length = User.EMAIL_MAX)
	private String email;

	@Column(nullable = false, length = 20)
	private long phoneNumber;

	@NotNull
	@Size(min = 10, max = 2000, message = "{addressError}")
	@Column(nullable = false, columnDefinition = "text")
	private String address;

	@Column(nullable = false, length = 20)
	private String city;

	@Column(nullable = false, length = 20)
	private String state;

	@Size(min = 2, max = 20, message = "{cityError}")
	@Column(nullable = false, length = 20)
	private String country;
	
	@Column(nullable = false, name = "order_number")
	private long orderNumber;
	
	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
