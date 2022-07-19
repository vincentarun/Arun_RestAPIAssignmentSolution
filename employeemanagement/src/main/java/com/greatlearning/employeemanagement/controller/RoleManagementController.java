package com.greatlearning.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greatlearning.employeemanagement.model.Role;
import com.greatlearning.employeemanagement.service.RoleService;

@Controller
@RequestMapping("/api")
public class RoleManagementController {

	@Autowired
	private RoleService roleService;

	@PostMapping("/role")
	@ResponseBody
	public Role roleAddSave(@Validated @RequestBody Role role) {
		return roleService.saveRole(role);

	}

	@GetMapping("/role")
	@ResponseBody
	public List<Role> roleRead() {

		return roleService.fetchRoleList();

	}

	@PutMapping("/role/{Id}")
	@ResponseBody
	public Role updateRole(@RequestBody Role role, @PathVariable("Id") Integer Id) {
		return roleService.updateRole(role, Id);

	}

	@DeleteMapping("/role/{Id}")
	@ResponseBody
	public String deleteRoleById(@PathVariable("Id") Integer role_id) {

		roleService.deleteRoleById(role_id);
		return "Deleted employee id - " + role_id;

	}

}
