<%@ page contentType="text/html;charset=UTF-8"
	import="com.leifeng.bean.MessageDataSC"%>

<%@ page import="java.util.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>

<body>
	<%
		MessageDataSC mgsc = null;
		int scmessage_count = 0;
		Collection<MessageDataSC> messagesc = (Collection<MessageDataSC>) session
				.getAttribute("messagesc_ipub3");

		Iterator<MessageDataSC> itsc = messagesc.iterator();
		while (itsc.hasNext()) {
			mgsc = (MessageDataSC) itsc.next();
	%>
	<tr>
		<td>
			<div class="cantingtype">
				订单号：<%=mgsc.getSc_order_id()%></div>
			<div class="songdashijian"><%=mgsc.getSc_sdtime()%>送达
			</div>
			<div class="songcanshijian"><%=mgsc.getSc_canting()%>-<%=mgsc.getSc_ceng()%>层-<%=mgsc.getSc_chuangkou()%>窗口
			</div>
			<div class="songcanshijian">
				送至：<%=mgsc.getSc_place2()%></div>
			<div class="songcandidian">
				菜品：<%=mgsc.getSc_note()%></div>

			<div class="fabushijian1">
				发布时间:<%=mgsc.getSc_fbtime()%></div>
			<div class="yongjin2">
				佣金:<%=mgsc.getSc_money()%>元
			</div>

			<div class="fabushijian1">
				接受者姓名:<%=mgsc.getUser_name()%></div>
			<div class="fabushijian1">
				接受者电话:<%=mgsc.getUser_number()%></div>
			<div class="fabushijian1">
				接受时间:<%=mgsc.getSc_time_start()%></div>
			<div class="fabushijian1">
				完成时间:<%=mgsc.getSc_time_end()%></div>
		</td>
		<td>

			<div class="qiangdan">已完成</div>
		</td>
	</tr>

	<%
		scmessage_count++;
		}
	%>



</body>
</html>
