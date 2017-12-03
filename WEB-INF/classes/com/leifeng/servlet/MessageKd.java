package com.leifeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leifeng.bean.TokenGen;

public class MessageKd extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session= request.getSession();
		
		TokenGen.getInstance().saveToken(request);
		String s = (String)session.getAttribute("token");
		
		RequestDispatcher dispacher = request.getRequestDispatcher("../newkd.jsp");
		dispacher.forward(request, response);
		
	}

}
