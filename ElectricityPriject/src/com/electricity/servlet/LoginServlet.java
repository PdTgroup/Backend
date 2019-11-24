package com.electricity.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends BaseServlet {
	/*Dao dao = new Dao();

	protected void loginiDentity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		String identity = request.getParameter("identity");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String flag = request.getParameter("isLogin");
		if ("y".equals(flag)) {
			// 创建两个Cookie对象
			Cookie nameCookie = new Cookie("username", username);
			// 设置Cookie的有效期为3天
			 nameCookie.setMaxAge(60 * 60 * 24 * 3); 
			nameCookie.setMaxAge(10);
			Cookie pwdCookie = new Cookie("password", password);
			 pwdCookie.setMaxAge(60 * 60 * 24 * 3); 
			pwdCookie.setMaxAge(15);
			response.addCookie(nameCookie);
			response.addCookie(pwdCookie);
		}
		HttpSession session = request.getSession();
		if (identity.equals("SuperAdmin")) {
			SuperAdmin superAdmn = dao.superAdminLogin(username, password);
			if (superAdmn != null) {
				session.setAttribute("superAdmn", superAdmn);
				request.getRequestDispatcher("/WEB-INF/superAdmin.jsp").forward(request, response);
				// response.sendRedirect("superAdmin.jsp");
			} else {
				response.sendRedirect("error.jsp");
			}
		}
		if (identity.equals("User")) {
			User user = dao.userDecodeLogin(username, password);
			if (user != null) {
				session.setAttribute("loginUser", user);
				response.sendRedirect("userPage.jsp");
				// request.getRequestDispatcher("/jsp/testAuthority.jsp").forward(request,
				// response);
			} else {
				response.sendRedirect("error.jsp");
			}
		} else {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			//response.sendRedirect("error.jsp");
		}
	}*/
}
