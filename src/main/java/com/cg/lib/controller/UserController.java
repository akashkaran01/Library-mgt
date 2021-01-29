package com.cg.lib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lib.dto.UserDTO;
import com.cg.lib.entity.User;
import com.cg.lib.service.UserServiceImpl;
import com.cg.lib.util.Util;

@RestController
@RequestMapping("/login")
public class UserController {
	
	@Autowired
	private UserServiceImpl service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody UserDTO dto)
	{
		User newUser = Util.DtoToUser(dto);
		String result = service.registration(newUser);
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/validate/{username}/{password}")
	public ResponseEntity<String> validation(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		String result = service.validation(username, password);
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		return response;
	}
	
	

}
