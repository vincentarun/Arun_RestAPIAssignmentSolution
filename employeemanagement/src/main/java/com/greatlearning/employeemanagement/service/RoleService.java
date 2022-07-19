package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.model.Role;


public interface RoleService {

    Role saveRole(Role role);
 

    List<Role> fetchRoleList();
 
    
    Role updateRole(Role role,Integer Id);
 
    
    void deleteRoleById(Integer Id);
	
}
