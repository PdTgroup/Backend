package com.electricity.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
@Path("AtyTest")	
public class AuthorityTestServlet {
	
@GET
@Path("/Toupload")
public void Toupload(@Context HttpServletRequest request,@Context HttpServletResponse response) throws ServletException, IOException{
	response.sendRedirect("/ElectricityPriject/upload.html");
	

	
}

}
