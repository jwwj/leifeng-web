<%@ page contentType="text/html;charset=UTF-8"
	import="com.leifeng.bean.MessageData"%>

<%@ page import="java.util.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>

<body>
	<%
			MessageData mg = null;
			int message_count_pub1 = 0;
			
			Collection<MessageData> message = (Collection<MessageData>) session.getAttribute("message_ipub1");

			Iterator<MessageData> it = message.iterator();
			while (it.hasNext()) {
				mg = (MessageData) it.next();
		%>
	<tr>

		<td>
			<div class="kuaiditype">订单号：无</div>
			<div class="kuaidishijian"><%=mg.getKd_time1() %>-<%=mg.getKd_time2() %></div>
			<div class="kuaidididian"><%=mg.getKd_place1() %>-<%=mg.getKd_place2() %></div>
			<div class="kuaidihao"><%=mg.getKd_type() %>:<%=mg.getKd_id() %></div>

			<div class="fabushijian">发布时间:<%=mg.getTime() %></div>
			<div class="yongjin1">佣金:<%=mg.getKd_money() %>元</div>
		</td>
		
		<td>

			<div class="qiangdan" >
						未接受
			</div>
		</td>
		
		<%
			
			message_count_pub1++;
			}
			//request.removeAttribute("message");
		%>
		

	</tr>
</body>
</html>
