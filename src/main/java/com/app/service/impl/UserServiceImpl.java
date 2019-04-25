package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.model.User;
import com.app.rpository.UserRepository;
import com.app.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Integer saveUser(User user) {
		user=userRepository.save(user);
		Integer userId=user.getUserid();
		return userId;
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public User getuserById(Integer userId) {
		Optional<User> p=userRepository.findById(userId);
		if(p.isPresent()) {
			return p.get();
		}else {
			return new User();
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users=userRepository.findAll();
		return users;
	}
}
