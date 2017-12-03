<%@ page language="java" import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="com.leifeng.bean.MessageData"%>
<%@page import="com.leifeng.bean.MyInfoData"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


</head>

<body>
	<%
		MessageData mg = null;
		int message_count = 0;
		Collection<MessageData> message1 = (Collection<MessageData>) request
				.getAttribute("messageKd");

		Iterator<MessageData> it = message1.iterator();
		while (it.hasNext()) {
			mg = (MessageData) it.next();
	%>
	<tr>

		<td>
			<div class="kuaiditype"><%=mg.getKd_type()%></div>
			<div class="kuaidishijian"><%=mg.getKd_time1()%>-<%=mg.getKd_time2()%></div>
			<div class="kuaidididian"><%=mg.getKd_place1()%>-<%=mg.getKd_place2()%></div>
		</td>

		<td>
			<div class="yongjin">
				<span style="color:#fe0000;font-size: 25px;font-weight: bold;"><%=mg.getKd_money()%></span>元
			</div>
			<div class="qiangdan">
				<%
					if (!mg.getTask_usernum().equals(MyInfoData.getUser_number())) {
							out.print("<form method=\"post\" action=\"NewOrder?task_id="+mg.getTask_id()+"\">");
							out.print("<input type=\"submit\" value=\"抢 单\" class=\"task_button\" id="+mg.getTask_id()
									+ " onmousemove=\"change()\" onmouseout=\"change1()\">");
							out.print("</form>");
						} else {
							out.print("<td >");
							out.print("我发布的");
							out.print("</td>");
						}
				%>
			</div>
		</td>
	</tr>
	<%
		message_count++;
		}
	%>
</body>
</html>
