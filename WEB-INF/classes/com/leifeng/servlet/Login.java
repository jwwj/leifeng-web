package com.leifeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leifeng.bean.MessageBean;
import com.leifeng.bean.MyInfoData;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		String num=request.getParameter("num");
		String psw=request.getParameter("psw");
		
		try {
			MessageBean msg=new MessageBean();
			if(msg.login(num,psw)){
				//request.setAttribute("message", msg.getAllMessages());
				msg.myInfo(num);
				HttpSession session=request.getSession();
				session.setAttribute("user_id", MyInfoData.getUser_id());
				session.setAttribute("user_name", MyInfoData.getUser_name());
				session.setAttribute("user_number", MyInfoData.getUser_number());
				session.setAttribute("user_school", MyInfoData.getUser_school());
				
				RequestDispatcher dispacher = request.getRequestDispatcher("Task");
				dispacher.forward(request, response);
			}else{
				//out.println("无此用户");
			}
		} catch (SQLException e) {
			//out.println("登录失败");
		} catch (ClassNotFoundException e) {
			//out.println("classnofound");
		}
	}

}
