package com.abhi.service;

import java.sql.SQLException;

import com.abhi.bean.LoginUser;
import com.abhi.dao.LoginDao;
import com.abhi.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
private LoginDao ldao;

	public LoginServiceImpl() {
	super();
	ldao = new LoginDaoImpl();
	// TODO Auto-generated constructor stub
}

	@Override
	public boolean validate(LoginUser login) {
		// TODO Auto-generated method stub
		try {
			return ldao.validate(login);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void closeConnection() {
		ldao.closeConnection();
		
	}

	@Override
	public int signup(LoginUser luser) {
		// TODO Auto-generated method stub
		return ldao.signup(luser);
	}

	@Override
	public int update(LoginUser luser) {
		// TODO Auto-generated method stub
		return ldao.update(luser);
	}

}
