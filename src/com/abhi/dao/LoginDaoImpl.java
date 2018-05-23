package com.abhi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abhi.bean.LoginUser;
import com.abhi.util.JdbcUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean validate(LoginUser user) {
		Connection con = JdbcUtil.getConnection();
		String sql = "select password ,emailid from userinfo where Login=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = null;
			String login = user.getLogin();
			String password = user.getPassword();
			
			System.out.println(login);
			ps.setString(1, login);
			rs = ps.executeQuery();
			if (rs.next()) {

				String pswd = rs.getString(1);
				if (pswd.equals(password)) {
					user.setEmailid(rs.getString(2));
					return true;

				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public int signup(LoginUser user) {
		int rows = 0;
		Connection con = JdbcUtil.getConnection();
		String sql = "insert into userinfo(login,password,emailid)values(?,?,?)";
		// String sql = "update userinfo set emailid =? where login = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			String login = user.getLogin();
			String password = user.getPassword();
			String emailid = user.getEmailid();
			ps.setString(1, login);
			ps.setString(2, password);
			ps.setString(3, emailid);

			rows = ps.executeUpdate();// it will return no of rows affected in db
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows;
	}
	public int update(LoginUser user) {
		System.out.println("update: "+user);
		int rows = 0;
		Connection con = JdbcUtil.getConnection();
		String sql = "UPDATE userinfo SET emailid=?,password=? where login=?";

		// UPDATE emp9 set salary=salary+100 where id=1212
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			// ResultSet rs = null;
			String emailid = user.getEmailid();
			ps.setString(1, emailid);
			String password = user.getPassword();
			ps.setString(2, password);
			String login = user.getLogin();
			ps.setString(3, login);
			System.out.println(login + password + emailid);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public void closeConnection() {
		JdbcUtil.closeConnection();

	}

}
