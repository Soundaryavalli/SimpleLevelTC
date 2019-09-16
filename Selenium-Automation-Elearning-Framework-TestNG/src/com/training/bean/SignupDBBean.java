package com.training.bean;

public class SignupDBBean {


	private String url; 
	private String driver; 
	private String FirstName;
	

	private String LastName;
	private String email;
	private String UserName;
	private String Pass;
	private String ConfirmPass;
	private String Phone;
	
	public SignupDBBean(){}
	
	public SignupDBBean(String url, String driver, String fname, String lname,String mail, String userName, String password,String confirm, String phone) {
		super();
		this.url = url;
		this.driver = driver;
		this.FirstName =fname;
		this.LastName =lname;
		this.email =mail;
		this.UserName = userName;
		this.Pass = password;
		this.ConfirmPass=confirm;
		this.Phone=phone;
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

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getConfirmPass() {
		return ConfirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		ConfirmPass = confirmPass;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	
}
