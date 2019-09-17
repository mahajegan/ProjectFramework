package com.training.bean;

/**
 * 
 * @author Naveen
 * @see this class shall get the bean data 
 */

//Setter Getter methods - it will pick the db details from db.properties and it will passed to connect the database
public class DBBean {
	private String url; 
	private String driver; 
	private String city; 
	private String name;
	private String email;
	private String subject;
	private String message;
	private String username;
	private String password;
	
	public DBBean(){}
	
	public DBBean(String url, String driver, String city, String name, String email, String subject,String message) {
		super();
		this.url = url;
		this.driver = driver;
		this.city = city;
		this.name = name;
		this.email = email;
		this.subject=subject;
		this.message=message;
		this.username=username;
		this.password=password;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
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
}
