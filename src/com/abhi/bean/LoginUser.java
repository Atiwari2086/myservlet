package com.abhi.bean;

public class LoginUser {
	private String login;
	private String password;
	private String emailid;

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public LoginUser(String login, String password, String emailid) {
		super();
		this.login = login;
		this.password = password;
		this.emailid = emailid;
	}

	public LoginUser(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "LoginUser [login=" + login + ", password=" + password + ", emailid=" + emailid + "]";
	}

	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}
}
