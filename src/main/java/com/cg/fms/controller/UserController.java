package com.cg.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.User;
import com.cg.fms.service.SchedulerService;
import com.cg.fms.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService ser;

	@GetMapping("/login/{userName}/{password}")
	public String userLogin(@PathVariable("userName") String username, @PathVariable("password") String password) {
		if (ser.login(username, password))
			return "Login Successful";
		else
			return "Login Failed";

	}

	@PutMapping("/logout/{userName}")
	public String userLogout(@PathVariable("userName") String userName, String password, String role) {

		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setRole(role);

		return ser.logout(user);
	}

	@PostMapping("/addUser/{userName}/{password}/{role}")
	public String addUser(@PathVariable("userName") String userName, @PathVariable("password") String password,
			@PathVariable("role") String role) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setRole(role);

		if (ser.addUser(user))
			return "User added successfully";
		else
			return "User exists";
	}

	@DeleteMapping
	public String removeUser(User user) {
		ser.removeUser(user);
		return "User with name " + user.getUserName() + " deleted successfully";
	}
}