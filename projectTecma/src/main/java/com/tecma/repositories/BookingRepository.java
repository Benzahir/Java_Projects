package com.tecma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecma.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	

}
