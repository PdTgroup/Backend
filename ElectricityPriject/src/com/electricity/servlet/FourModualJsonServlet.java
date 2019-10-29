package com.electricity.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electricity.service.Jsonservice;

/**
 * Servlet implementation class FourModualJsonServlet
 */
@WebServlet("/JsonFourModual")
public class FourModualJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Jsonservice jsonservice=new Jsonservice();
		Integer timeid= Integer.parseInt(request.getParameter("timeid"));
		String FourModual = jsonservice.getFourModual(timeid);
		System.out.println(FourModual);
		response.setContentType("text/javascript;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/javascript");
		response.getWriter().print(FourModual);
	}

}
