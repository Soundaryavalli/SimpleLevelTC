package com.training.bean;

public class Signupbean {
	
	
	private String FirstName;
	private String LastName;
	private String email;
	private String UserName;
	private String Pass;
	private String ConfirmPass;
	private String Phone;

	
	
	public Signupbean() {
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
	
	

	public Signupbean(String FirstName , String LastName,String email,String UserName,String Pass,String ConfirmPass,String Phone)
	{
		super();
	  this.FirstName = FirstName;
	  this.LastName = LastName;
	  this.email = email;
	  this.UserName = UserName;
	  this.Pass = Pass;
	  this.ConfirmPass =ConfirmPass;
	  this.Phone = Phone;
	  
	  
	  }
     
	@Override
	public String toString() {
		return "Signupbean [FirstName=" + FirstName + ", LastName=" + LastName + ", email =" + email + ", UserName=" + UserName + ", Pass =" + Pass + ", ConfirmPass=" + ConfirmPass + ", Phone =" + Phone + "]";
	}

}
