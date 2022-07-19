package com.greatlearning.employeemanagement.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.model.Role;
import com.greatlearning.employeemanagement.repository.RolesRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RolesRepository roleRepository;

	@Override
	public Role saveRole(Role role) {

		return roleRepository.save(role);
	}

	@Override
	public List<Role> fetchRoleList() {

		return (List<Role>) roleRepository.findAll();
	}

	@Override
	public Role updateRole(Role role, Integer Id) {

		Role roleDB = roleRepository.findById(Id).get();

		if (Objects.nonNull(role.getName()) && !"".equalsIgnoreCase(role.getName())) {
			roleDB.setName(role.getName());
		}

		return roleRepository.save(roleDB);
	}

	@Override
	public void deleteRoleById(Integer Id) {

		roleRepository.deleteById(Id);

	}

}
