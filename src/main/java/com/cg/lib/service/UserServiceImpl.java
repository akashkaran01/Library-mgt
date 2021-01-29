package com.cg.lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lib.dao.IUserDAO;
import com.cg.lib.entity.User;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDAO dao;
	
	@Override
	public String registration(User user) {
		if(dao.existsById(user.getUsername()))
		{
			return "User already exists.";
		}
		dao.save(user);
		return "User registered successfully";
	}
	
	@Override
	public String validation(String username, String password) {
		boolean userPresence = dao.existsById(username);
		if(!userPresence) 
		{
			return "No such user present";
		}else {
			List<User> allUsers = dao.findAll();
			for (User user : allUsers) 
			{ 
				if (user.getPassword().equals(password)) 
				{
					return "Login Successful";
				}
			}
		}
		return "Wrong password";
	}
	
	
	
	/**
	public UserDTO validate(String username, String password) 
	{
		User user1 = null;
		boolean userPresence = dao.existsById(username);
		if(userPresence) 
		{
			List<User> allUsers = dao.findAll();
			for (User user : allUsers) 
			{ 
				if (user.getPassword().equals(password)) 
				{
					user1 = user;
					break;
				}
			}
		}else {
			return null;
		}
		UserDTO user = Util.userToDto(user1);
		return user;
	}
	**/
}
