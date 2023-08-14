package com.excellence.springbootcrudapisecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellence.springbootcrudapisecurity.models.User;
import com.excellence.springbootcrudapisecurity.repository.UserRepository;

//add
@Service
public class UserServiceBackend {

	@Autowired
	private UserRepository userRepository1;

	public void deleteUserById(Long userId) {

		System.out.println("Deleting User whose Id =" + userId);
		userRepository1.deleteById(userId);
	}
	
	//update
	public void updateUserNameById(Long userId,String username) {

		System.out.println("Finding Enitity by Id = "+userId);
		Optional<User> findById = userRepository1.findById(userId);
		User user = findById.get();
		user.setUsername(username);
		userRepository1.save(user);
	}
	//find all users
	public Iterable<User> findAllUsers() {
		 return	userRepository1.findAll();
		}

	public Optional<User> findUserById(Long userId)  {
		return userRepository1.findById(userId);
		
	}
	
	//create user
	public void createUsers(Iterable<User> userList) {
		Iterable<User> dbSavedUsers = userRepository1.saveAll(userList);
		System.out.println("Following users info saved in database:");
		dbSavedUsers.forEach(System.out::println);
	}

	public User createUser(User user) {
		User dbUser = userRepository1.save(user);
		return dbUser;
	}

}
