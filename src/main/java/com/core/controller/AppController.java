package com.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.model.User;
import com.core.service.UserDao;

@Controller
@RequestMapping("/app")
public class AppController {
	@Autowired
	UserDao userDao;

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Helloji";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	@PostMapping("/login")
	@ResponseBody
	public String checkLogin(@RequestParam("user") String user, @RequestParam("pass") String pass) {
		if (userDao.checkLogin(user, pass)) {
			return "Login succes";
		}
		return "Login failure";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	@ResponseBody
	public String doRegister(User user) {
		if (userDao.doRegister(user)) {
			return "Registration success";
		}
		return "Registration failed";
	}

	@GetMapping("/users")
	@ResponseBody
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@GetMapping("/users/{username}")
	@ResponseBody
	public User getUser(@PathVariable("username") String userName) {
		return userDao.getUser(userName);
	}
	
	@PutMapping("/users")
	@ResponseBody
	public boolean getUser(@RequestBody User user) {
		return userDao.updateUser(user);
	}

	@DeleteMapping("/users/{username}")
	@ResponseBody
	public String deleteUser(@PathVariable("username") String userName) {
		if (userDao.deleteUser(userName)) {
			return "Delete success";
		}
		return "Delete failed";
	}

}
