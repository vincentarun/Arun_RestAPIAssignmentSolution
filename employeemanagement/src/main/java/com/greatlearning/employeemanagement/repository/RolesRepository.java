package com.greatlearning.employeemanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.greatlearning.employeemanagement.model.Role;

public interface RolesRepository extends CrudRepository<Role, Integer> {

}
