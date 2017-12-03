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

public class MyTaskSent extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session=request.getSession();
			MessageBean msg = new MessageBean();
			MessageBeanSC msgsc = new MessageBeanSC();
			
			session.setAttribute("message_iacp1", msg.taskInfo_IAccept1());
			session.setAttribute("message_iacp2", msg.taskInfo_IAccept2());
			session.setAttribute("message_ipub1", msg.taskInfo_IPub1());
			session.setAttribute("message_ipub2", msg.taskInfo_IPub2());
			session.setAttribute("message_ipub3", msg.taskInfo_IPub3());
			
			session.setAttribute("messagesc_iacp1", msgsc.taskInfo_IAccept1());
			session.setAttribute("messagesc_iacp2", msgsc.taskInfo_IAccept2());
			session.setAttribute("messagesc_ipub1", msgsc.taskInfo_IPub1());
			session.setAttribute("messagesc_ipub2", msgsc.taskInfo_IPub2());
			session.setAttribute("messagesc_ipub3", msgsc.taskInfo_IPub3());
			
			RequestDispatcher dispacher = request.getRequestDispatcher("../mysent.jsp");
			dispacher.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
