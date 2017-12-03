package com.leifeng.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leifeng.bean.MessageBean;
import com.leifeng.bean.MessageBeanSC;

public class FinishOrderSC extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sc_task_id=Integer.parseInt(request.getParameter("sc_task_id"));
		//int order_id=Integer.parseInt(request.getParameter("order_id"));
		try {
			MessageBeanSC msgsc = new MessageBeanSC();
			msgsc.FinishOrder(sc_task_id);
			
			RequestDispatcher dispacher = request.getRequestDispatcher("MyTaskSent");
			dispacher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
