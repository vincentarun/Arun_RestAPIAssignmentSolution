package com.greatlearning.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.greatlearning.employeemanagement.model.User;

public interface UserRepository extends CrudRepository<User, Integer>, JpaRepository<User, Integer> {

	public User getUserByUsername(String username);

}
