package com.app.services;

import java.util.List;

import com.app.model.User;

public interface UserService {

	public Integer saveUser(User user);
	public void deleteUser(Integer userId);
	public User getuserById(Integer userId);
	public List<User> getAllUsers();
}
