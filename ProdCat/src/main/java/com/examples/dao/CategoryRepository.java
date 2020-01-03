package com.examples.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.examples.entities.Category;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, String> {

}
