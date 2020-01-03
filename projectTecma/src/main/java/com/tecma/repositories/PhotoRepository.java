package com.tecma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecma.entities.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
