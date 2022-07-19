package com.greatlearning.employeemanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import com.greatlearning.employeemanagement.model.User;
import com.greatlearning.employeemanagement.service.UserService;

@Controller
@RequestMapping("/api")
public class UserManagementController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@PostMapping("/user")
	@ResponseBody
	public User roleAddSave(@Validated @RequestBody User user) {

		String enCodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(enCodedPassword);
		return userService.saveUser(user);

	}

	@GetMapping("/user")
	@ResponseBody
	public List<User> userRead() {

		return userService.fetchUserList();

	}

	@PutMapping("/user/{Id}")
	@ResponseBody
	public User updateRole(@RequestBody User user, @PathVariable("Id") Integer Id) {
		return userService.updateUser(user, Id);

	}

	@DeleteMapping("/user/{Id}")
	@ResponseBody
	public String deleteUserById(@PathVariable("Id") Integer Id) {

		userService.deleteUserById(Id);
		return "Deleted Successfully";

	}

}
