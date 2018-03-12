/**
 * 
 */
package com.cg.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author aruravic
 *
 */
@Entity
@Table(name = "login")
public class Login {

	// @Pattern(regexp = "^[a-zA-Z]{10}$", message =
	// "Username must contain only alphabets")
	@Id
	@NotEmpty(message = "Please Enter Username ")
	private String username;

	// @Pattern(regexp = "^[a-zA-Z0-9]{8,20}$", message =
	// "Password must contain only combination of alphabets and numbers")
	@NotEmpty(message = "Please Enter Password ")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}

}