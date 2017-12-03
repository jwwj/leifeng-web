package com.leifeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leifeng.bean.MessageBeanSC;
import com.leifeng.bean.TokenGen;

public class NewTaskSC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

		    }else{
		    	
		    	tokenGen.resetToken(request);
		try {
			String sc_canting =  request.getParameter("sc_canting");	
			System.out.println("NewTaskSc:"+sc_canting);
			String sc_ceng =  request.getParameter("sc_ceng");
			String sc_chuangkou =  request.getParameter("sc_chuangkou");				 
			String sc_place2 =  request.getParameter("sc_place2");				 
			String sc_note =  request.getParameter("sc_note");			 
			String sc_money =  request.getParameter("sc_money");			 
			String sc_sdtime =  request.getParameter("sc_sdtime");
					 
			MessageBeanSC msgsc = new MessageBeanSC();
			msgsc.addsc(sc_canting,sc_ceng, sc_chuangkou,
					sc_place2,  sc_note, sc_money,
					sc_sdtime);

			response.sendRedirect("Task");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
}
