package com.excellence.springbootcrudapisecurity.models;

import java.io.Serializable;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder  //add
@Table(name = "users")
@DynamicUpdate
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="Name can't be null")
	//add
	@Column(name="username",nullable = false)
	private String username;
	@NotNull(message="email can't be null")
	private String email;
	@NotNull(message="password can't be null")
	private String password;
	@NotNull(message="role can't be null")
	private String role; // user, admin
	
	
//
//	public User(String username, String email, String password, String role) {
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.role = role;
//	}
//	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + "role="  + role +" ,email=" + email + ", password=" + password + "]";
	}

}
