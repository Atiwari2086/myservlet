package com.abhi;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abhi.bean.LoginUser;
import com.abhi.service.LoginService;
import com.abhi.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login", "/signup", "/displayupdate","/update" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService lservice;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		lservice = new LoginServiceImpl();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		lservice.closeConnection();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println("path = " + path);
		String login = "";
		switch (path) {
		case "/login":
			LoginUser luser = new LoginUser();
			HttpSession session = request.getSession();
			 login = request.getParameter("login");
			String password = request.getParameter("password");
			luser.setLogin(login);
			luser.setPassword(password);
			boolean valid = lservice.validate(luser);
			// if password is wrong go to error.jsp ,if login is wrong go to signup.jsp else
			// go to first.jsp
			if (valid) {
				session.setAttribute("user", luser);

				request.getRequestDispatcher("first.jsp").forward(request, response);
			} else {

				request.getRequestDispatcher("signup.jsp").forward(request, response);

			}

			break;
		case "/signup":
			// System.out.println("Signup");
			luser = new LoginUser();
			session = request.getSession();
			login = request.getParameter("login");
			password = request.getParameter("password");
			String emailid = request.getParameter("emailid");
			luser.setLogin(login);
			luser.setPassword(password);
			luser.setEmailid(emailid);
			int row = lservice.signup(luser);
			if (row > 0) {
				session.setAttribute("user", luser);
				request.getRequestDispatcher("first.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			break;
		case "/displayupdate":
			System.out.println("diverting to update.jsp");
			request.getRequestDispatcher("update.jsp").forward(request, response);
			
			break;
		
		case "/update":
			System.out.println("upadting profile");
			luser = new LoginUser();
			session = request.getSession();
			//login = request.getParameter("login");
			LoginUser usertemp =(LoginUser) session.getAttribute("user");
			if(usertemp!=null) {
				login = usertemp.getLogin();	
			}
					
			password = request.getParameter("password");
			emailid = request.getParameter("emailid");
			luser.setLogin(login);
			luser.setEmailid(emailid);
			luser.setPassword(password);

			row = lservice.update(luser);
			if (row > 0) {
				session.setAttribute("user", luser);
				request.getRequestDispatcher("first.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}

			//System.out.println("update");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
