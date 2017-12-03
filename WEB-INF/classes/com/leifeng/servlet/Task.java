package com.leifeng.servlet;

import java.io.IOException;
import java.sql.SQLException;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leifeng.bean.MessageBean;
import com.leifeng.bean.MessageBeanSC;

public class Task extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MessageBean msg = new MessageBean();
			MessageBeanSC msc =new MessageBeanSC(); 
					
			request.setAttribute("messageKd", msg.getAllMessages());
			request.setAttribute("messageSc", msc.getAllMessages());
			RequestDispatcher dispacher = request.getRequestDispatcher("../task.jsp");
			dispacher.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
