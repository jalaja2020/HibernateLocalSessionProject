package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.User;
import com.hcl.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/user/save")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		
		int saveUser = userService.saveUser(user);
		return new ResponseEntity<>("User is successfully save:"+ saveUser,HttpStatus.OK);
	}
	@GetMapping("/user/all")
	public ResponseEntity<List<User>> findAllUsers(){
		List<User> findAllUsers = userService.findAllUsers();
		return new ResponseEntity<List<User>>(findAllUsers,HttpStatus.OK);
	}
	
	@PutMapping("/user/update")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		 userService.updateUser(user);
		return new ResponseEntity<>("User updated successfully save:",HttpStatus.OK);
	}
	
	
	
}
