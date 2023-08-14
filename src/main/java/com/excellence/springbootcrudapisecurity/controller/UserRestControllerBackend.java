package com.excellence.springbootcrudapisecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//add

import com.excellence.springbootcrudapisecurity.exception.UserDataAccessException;
import com.excellence.springbootcrudapisecurity.models.User;
import com.excellence.springbootcrudapisecurity.service.UserServiceBackend;

import jakarta.validation.Valid;


@RestController
@RequestMapping(path="/users")
@Validated
public class UserRestControllerBackend {
	
	@Autowired
	private UserServiceBackend userService1;
	
	
	//CRUD
	//@RequestMapping(path = "user/create",method = RequestMethod.POST)
	@PostMapping(path = "user/create1")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		user = userService1.createUser(user);
		return ResponseEntity.ok().body(user);
	}
	
	
	@PostMapping(path = "multiUsers/create")
	public void createUsers(@RequestBody  Iterable<User> users) {
		userService1.createUsers(users);
	}
	
	
	/*
	 * @GetMapping(path = "id/{id}") public User getUserById(@PathVariable("id")
	 * Integer id) throws UserDataAccessException { return
	 * userService.findUserById(id); }
	 */
	
	@RequestMapping(path = "/id/{id}" ,produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> findUserById(@PathVariable("id") Long id) throws UserDataAccessException  {
		User user = userService1.findUserById(id).orElseThrow(()->new UserDataAccessException("User not found with ID = "+id));
		return ResponseEntity.ok().body(user);
	}
	
	
	@GetMapping(path = "/allusers")
	public Iterable<User> getAllUsers() {
		return userService1.findAllUsers();
	}
	
	@PutMapping(path = "id/{id}/username/{username}")
	public void updateUserNameById(@PathVariable("id") Long userId,@PathVariable("username") String username) {
		userService1.updateUserNameById(userId, username);
	}
	
	@DeleteMapping(path = "delete/id/{id}")
	public void deleteUserById(@PathVariable("id") Long userId) {
		userService1.deleteUserById(userId);
	}
	

}
