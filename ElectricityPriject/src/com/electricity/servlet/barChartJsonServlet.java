package com.electricity.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.electricity.service.Jsonservice;


@WebServlet("/JsonbarChart")
public class barChartJsonServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Jsonservice jsonservice=new Jsonservice();
		Integer timeid= Integer.parseInt(request.getParameter("timeid"));
		Integer indexid= Integer.parseInt(request.getParameter("indexid"));
		String barChart = jsonservice.getBarChart(timeid, indexid);
		
		response.setContentType("text/javascript;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/javascript");
		response.getWriter().print(barChart);
	}
}
