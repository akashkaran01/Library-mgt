package com.cg.lib.service;

import java.time.LocalDate;

import com.cg.lib.dto.UserDTO;
import com.cg.lib.entity.User;

public interface IUserService {
	
	String validation(String username, String password);
	
	String registration(User user);
	
}
