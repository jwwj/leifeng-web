<%@ page language="java" import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="com.leifeng.bean.MessageDataSC"%>
<%@page import="com.leifeng.bean.MyInfoData"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


</head>

<body>

	<%
		MessageDataSC mgsc = null;
		int scmessage_count = 0;
		Collection<MessageDataSC> messagesc = (Collection<MessageDataSC>) request
				.getAttribute("messageSc");

		Iterator<MessageDataSC> itsc = messagesc.iterator();
		while (itsc.hasNext()) {
			mgsc = (MessageDataSC) itsc.next();
	%>
	<tr>
		<td>
			<div class="cantingtype"><%=mgsc.getSc_canting()%></div>
			<div class="songcanshijian"><%=mgsc.getSc_sdtime()%></div>
			<div class="songcandidian"><%=mgsc.getSc_canting()%>-<%=mgsc.getSc_place2()%></div>
		</td>
		<td>
			<div class="yongjin0">
				<span style="color:#fe0000;font-size: 25px;font-weight: bold;"><%=mgsc.getSc_money()%></span>元
			</div>
			<div class="qiangdan0">
				<%
					if (!mgsc.getSc_task_usernum().equals(
								MyInfoData.getUser_number())) {
							out.print("<form method=\"post\" action=\"NewOrderSC?sc_task_id="
									+ mgsc.getSc_task_id() + "\">");
							out.print("<input type=\"submit\" value=\"抢 单\" class=\"task_button\" id="
									+ mgsc.getSc_task_id()
									+ " onmouseover=\"change2()\" onmouseout=\"change3()\">");
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
		scmessage_count++;
		}
	%>
</body>
</html>
