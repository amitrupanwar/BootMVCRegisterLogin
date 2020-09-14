package com.core.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.dao.UserRepo;
import com.core.model.User;

@Service
public class UserDao {

	// private List<User> userList = new ArrayList<User>();
	@Autowired
	UserRepo userRepo;

	public boolean checkLogin(String userName, String pass) {
		User u = userRepo.findById(userName).get();

		if (userName.equals(u.getName())) {
			if (pass.equals(u.getPass())) {
				return true;
			}
			return false;
		}

		return false;
	}

	public boolean doRegister(User user) {
		// TODO Auto-generated method stub
		if (this.validateUser(user)) {
			userRepo.save(user);
			return true;
		}
		return false;
	}

	public boolean validateUser(User user) {
		if (user.getName() != null && user.getCity() != null && user.getPass() != null && user.getEmail() != null
				&& !user.getName().isEmpty() && !user.getCity().isEmpty() && !user.getPass().isEmpty()
				&& !user.getEmail().isEmpty()) {
			return true;
		}
		return false;
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub

		/*
		 * List<User> list = new ArrayList<User>(); Iterator<User> iter =
		 * userRepo.findAll().iterator(); while (iter.hasNext()) {
		 * list.add(iter.next()); }
		 * 
		 * return list;
		 */
		
		return (List<User>)userRepo.findAll();
	}

	public User getUser(String userName) {
		return userRepo.findById(userName).get();
	}
	
	public boolean updateUser(User user) {
		System.out.println(user);
		if(userRepo.existsById(user.getName())) {
			userRepo.save(user);
			
			return true;
		}
		return false;
	}

	public boolean deleteUser(String userName) {

		userRepo.deleteById(userName);
		return true;
	}
}
