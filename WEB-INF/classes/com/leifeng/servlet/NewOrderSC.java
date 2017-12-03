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

public class NewOrderSC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sc_task_id = Integer.parseInt(request.getParameter("sc_task_id"));
		try {
			MessageBeanSC msc = new MessageBeanSC();
			msc.addOrder(sc_task_id);

			request.setAttribute("message", msc.taskInfo(sc_task_id));
			RequestDispatcher dispacher = request.getRequestDispatcher("../detailsc.jsp");
			dispacher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
