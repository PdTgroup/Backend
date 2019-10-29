package com.electricity.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.electricity.service.Jsonservice;


@WebServlet("/JsonLineChart")
public class LineChartJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Jsonservice jsonservice=new Jsonservice();
		Integer indexid= Integer.parseInt(request.getParameter("indexid"));
		String LineChart = jsonservice.getLineChart(indexid);
		System.out.println(LineChart);
		response.setContentType("text/javascript;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/javascript");
		response.getWriter().print(LineChart);
	}

}
