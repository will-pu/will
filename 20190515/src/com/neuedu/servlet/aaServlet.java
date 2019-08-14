package com.neuedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aa")
public class aaServlet extends HttpServlet{
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
       
       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
   		response.setCharacterEncoding("utf-8");
   		
   		String lname = request.getParameter("lname");
   		String lpass = request.getParameter("lpass");
   		
   		if(lname.equals("admin") && lpass.equals("123")) {
   			request.setAttribute("xixi",lname);
   			request.getRequestDispatcher("/bb").forward(request, response);   			
   		}else{
   			response.sendRedirect("/20190515/05.aa.html");
   		}
    }
}
