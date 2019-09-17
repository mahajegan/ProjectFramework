package com.training.bean;

public class LoginBean {
	private String city;
	private String name;
	private String email;
	private String subject;
	private String message;
	private String username;
	private String password;

	public LoginBean() {
	}

	public LoginBean(String city, String name, String email,String subject,String message,String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.city = city;
		this.name = name;
		this.email=email;
		this.subject=subject;
		this.message=message;
	}
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
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		//return "LoginBean [username" + username + ",password" + password + ",city" + city +  "," + name + "name ]";
		return "LoginBean [ city" + city +  "," + name + "name " +email +"email]";
	}

}
