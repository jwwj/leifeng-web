<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,com.leifeng.bean.MyInfoData"%>
<html>
	<head>
		<title>接受的任务</title>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="../css/myrecived.css">
	</head>
	<body>
		<div class="header">
			<div class="title1">
				    <p class="hlfont">今天，我们都是雷锋！</p><p class="hrfont">欢迎您，<%=MyInfoData.getUser_name() %> &nbsp; <a href="../login.html" style="text-decoration: none;color:black;">退出</a></p> 
			</div>	
			<div class="title2">
					<div class="leifeng"><img src="../img/logo1.png" height=55 width=58></div>
					<div class="gongsi">
					    <div class="leifengkeji">我是雷锋</div>
					    <div class="zhongbao">校园O2O众包平台</div>
					</div>
					<div class="renwudating" ><a href="Task" ><div class="renwufont" id="renwudatingyanse" onmouseout="change26()" onmouseover="change27()"><p class="renwu">任务大厅</p></div></a></div>
					<div class="xinxizhongxin"><a href="" ><div class="xinxifont" onmouseover="change23()" onmouseout="change24()" id="xinxizhongxinyanse"><p class="xinxi">信息中心</p></div></a></div>
					<div class="wodeshouye"><a href="" ><div class="shouyefont" onmouseover="change19()" onmouseout="change20()" id="wodeshouyeyanse" style="background-color:#f32f2f;color:white;" ><p class="shouye" >我的首页</p></div></a></div>
					<div class="faburenwu"><a href="" ><div class="faburenwufont" onmouseover="change4()" onmouseout="change25()"id="faburenwuyanse"><p class="fubu">&nbsp;&nbsp;&nbsp;&nbsp;发布任务</p></div></a></div>
					<div class="xialaliebiao" id="xiala" onmouseover="change5()" onmouseout="change6()">
						<table class="table3">
							<tr ><td onmouseover="change7()" onmouseout="change8()" id="td1"><a href="MessageKd" style="text-decoration: none;color:black;">快递任务</a></td></tr>
							<tr><td  onmouseover="change9()" onmouseout="change10()" id="td2"><a href="MessageSc" style="text-decoration: none;color:black;">送餐任务</a></td></tr>
						</table>
					</div>

					<div class="xialaliebiao1" id="xiala1" onmouseover="change11()" onmouseout="change12()">
						<table class="table4">
							<tr ><td onmouseover="change13()" onmouseout="change14()" id="td3"><a href="../myinfo.jsp" style="text-decoration: none;color:black;">我的信息</a></td></tr>
							<tr><td  onmouseover="change15()" onmouseout="change16()" id="td4"><a href="MyTaskSent" style="text-decoration: none;color:black;">发布的任务</a></td></tr>
							<tr><td  onmouseover="change17()" onmouseout="change18()" id="td5"><a href="MyTaskRecived" style="text-decoration: none;color:black;">接受的任务</a></td></tr>
						</table>
					</div>
			</div>
		</div>

		<div class="body">
			<div class="bodycontent">
			<img src="../img/banner.jpg">
			    <div class="left">
			    	<div class="leftcontent">
			    		<table class="table1">
			    			<tr>
			    				<td colspan="2">
			    				<div class="kuaidiyuanimg"><img src="../img/kuaidiyuan.png" width="60px;"></div>
			    				<div class="kuaidirenwu">快递任务</div>
			    				</td>			    				
			    			</tr>
			    			
			    			<jsp:include page="myrecived11.jsp"/>
			    			<jsp:include page="myrecived12.jsp"/>
			    				
			    		</table>
			    	</div>
			    	<div class="rightcontent">
			    		<table class="table2">
			    			<tr>
			    				<td colspan="2">
			    				<div class="waimaiimg"><img src="../img/waimai.png" width="60px;"></div>
			    				<div class="songcanrenwu">送餐任务</div>
			    				</td>			    				
			    			</tr>
			    			
			    			<jsp:include page="myrecived21.jsp"/>
			    			<jsp:include page="myrecived22.jsp"/>
			    			
			    		</table>
			    	</div>
			    </div>
				<div class="contentimg"><img src="../img/2.jpg" width="950px;"></div>
			</div>
		</div>

		<div class="footer">
			<div class="footcontent">
				<div class="diyilie">
					<div class="tu"><img src="../img/logo2.png" height=55 width=58></div>
					<div class="tel">免费服务热线</div>
					<div class="num">0591-22887859</div>
					<div class="shangwu">商务合作:15534008171</div>
					<div class="gongzuoshijian">周一到周六:8:00-12:00</div>
					<div class="mail">邮箱:357243759@qq.com</div>
				</div>
				<div class="dierlie">
					<div class="guidingtiaokuan">规定条款</div>
					<div class="renzheng">会员身份实名认证</div>
					<div class="chufa">举报投诉违规处罚</div>
				</div>
				<div class="disanlie">
					<div class="xinshouzhidao">新手指导</div>
					<div class="zanzhu">免费发布赞助信息</div>
					<div class="jieda">常见问题解答</div>
				</div>
				<div class="disilie">
					<div class="leifengfuwu">雷锋服务</div>
					<div class="leifengbao">雷锋宝</div>
					<div class="leifengxueyuan">雷锋学院</div>
					<div class="dingzhi">客户定制</div>
				</div>
				<div class="diwulie">
					<div class="guanyu">关于我们</div>
					<div class="jieshao">雷锋介绍</div>
					<div class="lianxiwomen">联系我们</div>
					<div class="gonggao">网站公告</div>
					<div class="yinsitiaokuan">隐私条款</div>
					<div class="ditu">网站地图</div>
				</div>
				<div class="diliulie">
					<div class="dingyue">微信订阅</div>
					<div class="erweima"><img src="../img/1.jpg" width=150></div>
					<div class="hailiangzanzhu">海量赞助，就加关注</div>
				</div>
			</div>
			<div class="footend"><div class="footendcontent">Copyright © 2016 雷锋科技有限公司版权所有 晋ICP备16008255号-1</div></div>
		</div>
		<script src="../js/myrecived.js"></script>
	</body>
</html>