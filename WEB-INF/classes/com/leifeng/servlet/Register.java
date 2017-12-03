package com.leifeng.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leifeng.bean.RegisterBean;

public class Register extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8"); 
		
		int user_id=Integer.parseInt(request.getParameter("fnu"));//ѧ��
		
		String user_name=new String(request.getParameter("fname").getBytes("ISO8859_1"), "UTF-8");//����
		String user_school=new String(request.getParameter("fmail").getBytes("ISO8859_1"), "UTF-8");//ѧУ
		
		String user_number=request.getParameter("tel");//�绰
		String user_password=request.getParameter("fpassword");//����
		
		try {
			RegisterBean rb=new RegisterBean();
			
			rb.addUser(user_id, user_name, user_number, user_school, user_password);
			
			response.sendRedirect("../login.html");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
