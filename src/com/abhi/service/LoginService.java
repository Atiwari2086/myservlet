package com.abhi.service;

import com.abhi.bean.LoginUser;

public interface LoginService {

	
	boolean validate(LoginUser luser);

	void closeConnection();

	int signup(LoginUser luser);

	int update(LoginUser luser);

}
