package com.leifeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leifeng.bean.MessageBean;
import com.leifeng.bean.TokenGen;

public class NewTask extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8"); 
		
		 TokenGen tokenGen=TokenGen.getInstance();
		    if (!tokenGen.isTokenValid(request))
		    {  
		    	PrintWriter pw=response.getWriter();
		    	pw.write("<script type='text/javascript'>alert('请不要重复提交表单');window.location.href='Task';</script>");
		    	
		    	pw.close();
		    	System.out.println("重复提交表单");
		    	//RequestDispatcher dispacher = request.getRequestDispatcher("Task");
				//dispacher.forward(request, response)
		    }else{
		    	
		    	tokenGen.resetToken(request);
		    	
		try {
			String kd_type = request.getParameter("kd_type");		
			String kd_id = request.getParameter("kd_id");	
			String kd_place1 = request.getParameter("kd_place1");
			String kd_place2 =request.getParameter("kd_place2");		
			String kd_startHour = request.getParameter("kd_startHour");				
			String kd_startMinute = request.getParameter("kd_startMinute");				
			String kd_endHour = request.getParameter("kd_endHour");					
			String kd_endMinute = request.getParameter("kd_endMinute");
			String kd_note = request.getParameter("kd_note");		
			String kd_money =request.getParameter("kd_money");
			
			
			String kd_time1 = kd_startHour+":"+kd_startMinute;//到达时间
			String kd_time2 = kd_endHour+":"+kd_endMinute;//离开时间
			
	
				
			
			MessageBean msg = new MessageBean();
			msg.addKd(kd_type, kd_id, kd_place1, kd_place2, kd_time1,
					kd_time2, kd_note, kd_money);
			//request.setAttribute("message", msg.getAllMessages());
		//	RequestDispatcher dispacher = request.getRequestDispatcher("Task");
		//	dispacher.forward(request, response);
			response.sendRedirect("Task");
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}

}
