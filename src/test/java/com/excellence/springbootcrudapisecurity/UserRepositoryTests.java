package com.excellence.springbootcrudapisecurity;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.excellence.springbootcrudapisecurity.models.User;
import com.excellence.springbootcrudapisecurity.repository.UserRepository;

//addtest

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	//junit test for saveuser
	@Test
	@Order(1)
	@Rollback(value=false)
	public void saveUserTest()
	{
		User user=User.builder()
				.username("manish")
				.email("mku@gmail.com")
				.password("mku123")
				.role("User")
				.build();
		userRepository.save(user);
		

		Assertions.assertThat(user.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	@Rollback(value=false)
	public void getUserTest()
	{
		User user=userRepository.findById(1L).get();
		Assertions.assertThat(user.getId()).isEqualTo(1L);
	}
	
	
	@Test
	@Order(3)
	@Rollback(value=false)
	public void getListOfEmployeesTest()
	{
		List<User> user=userRepository.findAll();
		Assertions.assertThat(user.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value=false)
	public void updateUserTest()
	{
		User user=userRepository.findById(1L).get();
		user.setEmail("mku@gmail.com");
		
		User userupdated=userRepository.save(user);
		
		Assertions.assertThat(userupdated.getEmail()).isEqualTo("mku@gmail.com");
	}

	@Test
	@Order(5)
	@Rollback(value=false)
	public void deleteUserTest()
	{
		User user=userRepository.findById(1L).get();
		
		userRepository.delete(user);
		
		User user2=null;
		
		Optional<User> optionalUser= userRepository.findByEmail("mku@gmail.com");
		if(optionalUser.isPresent())
		{
			user2=optionalUser.get();
		}
		Assertions.assertThat(user2).isNull();
	}

}
