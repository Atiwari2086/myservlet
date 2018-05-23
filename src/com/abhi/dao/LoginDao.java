package com.abhi.dao;

import java.sql.SQLException;

import com.abhi.bean.LoginUser;

public interface LoginDao {

	boolean validate(LoginUser login) throws SQLException;

	void closeConnection();

	int signup(LoginUser luser);

	int update(LoginUser luser);

}
