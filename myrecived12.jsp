
<%@page import="com.leifeng.bean.MyInfoData"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="com.leifeng.bean.MessageData"%>

<%@ page import="java.util.*"%>


<html>

<head>

</head>

<body>
	<%
		MessageData mg = null;
		int message_count_acp = 0;

		Collection<MessageData> message1 = (Collection<MessageData>) session
				.getAttribute("message_iacp2");

		Iterator<MessageData> it = message1.iterator();
		while (it.hasNext()) {
			mg = (MessageData) it.next();
	%>
	<tr>

		<td>
			<div class="kuaiditype">订单号：<%=mg.getOrder_id()%></div>
			<div class="fabushijian"><%=mg.getKd_time1() %>-<%=mg.getKd_time2() %></div>
			<div class="fabushijian"><%=mg.getKd_place1() %>-<%=mg.getKd_place2() %></div>
			<div class="fabushijian"><%=mg.getKd_type() %>:<%=mg.getKd_id() %></div>

			<div class="fabushijian">发布时间:<%=mg.getTime()%></div>
			<div class="yongjin1">佣金:<%=mg.getKd_money() %>元</div>
			<div class="fabuzhe">发布者姓名:<%=mg.getUser_name() %></div>
			<div class="fabushijian">发布者电话:<%=mg.getTask_usernum()%></div>
			<div class="fabushijian">接受时间:<%=mg.getTime_start() %></div>
			<div class="fabushijian">完成时间:<%=mg.getTime_end() %></div>
		</td>

		<td>

			<div class="qiangdan">
				已完成
			</div>
		</td>
	</tr>
	<%
		message_count_acp++;
		}
	%>
</body>
</html>
