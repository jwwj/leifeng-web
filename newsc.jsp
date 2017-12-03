<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*,com.leifeng.bean.MyInfoData,com.leifeng.bean.TokenGen"%>
<html>
<head>
<title>发布送餐任务</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="../css/newsc.css">
</head>
<body>
	<%
  TokenGen.getInstance().saveToken(request);
  String s = (String)session.getAttribute("token");
 %>
	<div class="header">
		<div class="title1">
			<p class="hlfont">今天，我们都是雷锋！</p>
			<p class="hrfont">
				欢迎您，<%=MyInfoData.getUser_name() %>
				&nbsp; <a href="../login.html"
					style="text-decoration: none;color:black;">退出</a>
			</p>
		</div>
		<div class="title2">
			<div class="leifeng">
				<img src="../img/logo1.png" height=55 width=58>
			</div>
			<div class="gongsi">
				<div class="leifengkeji">我是雷锋</div>
				<div class="zhongbao">校园O2O众包平台</div>
			</div>
			<!--<div class="renwudating"><a href="" ><div class="renwufont"><p class="renwu">任务大厅</p></div></a></div>
					<div class="xinxizhongxin"><a href="" ><div class="xinxifont"><p class="xinxi">信息中心</p></div></a></div>
					<div class="wodeshouye"><a href="" ><div class="shouyefont"><p class="shouye" onmouseover="change19()" onmouseout="change20()">我的首页</p></div></a></div>
					<div class="faburenwu"><a href="" ><div class="faburenwufont" onmouseover="change4()" ><p class="fubu">&nbsp;&nbsp;&nbsp;&nbsp;发布任务</p></div></a></div>-->
			<div class="renwudating">
				<a href="Task"><div class="renwufont" onmouseover="change23()"
						onmouseout="change24()" id="renwudatingyanse">
						<p class="renwu">任务大厅</p>
					</div></a>
			</div>
			<div class="xinxizhongxin">
				<a href=""><div class="xinxifont" onmouseover="change25()"
						onmouseout="change26()" id="xinxizhongxinyanse">
						<p class="xinxi">信息中心</p>
					</div></a>
			</div>
			<div class="wodeshouye">
				<a href=""><div class="shouyefont" onmouseover="change27()"
						onmouseout="change28()" id="wodeshouyeyanse">
						<p class="shouye" onmouseover="change19()" onmouseout="change20()">我的首页</p>
					</div></a>
			</div>
			<div class="faburenwu">
				<a href=""><div class="faburenwufont" onmouseover="change4()"
						onmouseout="change29()" id="faburenwuyanse"
						style="background-color: #f32f2f;color:white;">
						<p class="fubu">&nbsp;&nbsp;&nbsp;&nbsp;发布任务</p>
					</div></a>
			</div>
			<div class="xialaliebiao" id="xiala" onmouseover="change5()"
				onmouseout="change6()">
				<table class="table3">
					<tr>
						<td onmouseover="change7()" onmouseout="change8()" id="td1"><a
							href="MessageKd" style="text-decoration: none;color:black;">快递任务</a></td>
					</tr>
					<tr>
						<td onmouseover="change9()" onmouseout="change10()" id="td2"><a
							href="MessageSc" style="text-decoration: none;color:black;">送餐任务</a></td>
					</tr>
				</table>
			</div>

			<div class="xialaliebiao1" id="xiala1" onmouseover="change11()"
				onmouseout="change12()">
				<table class="table4">
					<tr>
						<td onmouseover="change13()" onmouseout="change14()" id="td3"><a
							href="../myinfo.jsp" style="text-decoration: none;color:black;">我的信息</a></td>
					</tr>
					<tr>
						<td onmouseover="change15()" onmouseout="change16()" id="td4"><a
							href="MyTaskSent" style="text-decoration: none;color:black;">发布的任务</a></td>
					</tr>
					<tr>
						<td onmouseover="change17()" onmouseout="change18()" id="td5"><a
							href="MyTaskRecived" style="text-decoration: none;color:black;">接受的任务</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>







	<div class="body">
		<div class="bodycontent">
			<div class="guanfang">官方提供担保交易，保障您的资金安全，且不会收取您任何押金。
				80%的欺诈、资金盗取均由线上交易导致，请勿线上交易。</div>
			<div class="changjianwenti">
				<pre>常见问题：

我在我是雷锋网上交易有安全保障吗？
答：
1）我们采用的是线下付款方式，您对服务工作满意后，再与服务人员当面进行交易，充分保障您的财产安全；
2）此外，所有服务人员实名认证，若交易中服务商发生违约或不诚信行为，雇主可获得双倍赔付。
我该怎么填写我的需求？
答：
您可以：
1）参考雷锋科技网的已有需求，看看人家的需求是怎样描述的。
2）尽量用简单、明了的语言来表述自己的需求。
3）实在难以表述清楚的，雷锋科技网的客服人员协助您处理。</pre>
			</div>

			<div class="kuaidiyuan">
				<img src="../img/waimai.png" width="60px;">
			</div>
			<div class="kuaidirenwufabu">送餐任务发布</div>
			<div class="jiahengxian"></div>
			<img src="../img/banner.jpg">
			<!--<div class="contentimg"><img src="../img/2.jpg" width="950px;"></div>-->
			<div class="kuaidiform">
				<form methd="post" action="NewTaskSC" class="form1">
					<input type="hidden" name="token" value="<%=s%>" />
					<!-- <div class="kuaidigongsiti">
          <span>
            <span class="xinhao">*</span>餐厅类型
          </span>
          </div>
          <div class="kuaidigongsi">
            <div class="kuaidigongsisr">
              <input type="text" name="sc-type" class="kuaidigongsis" onClick="jingao1()" onBlur="jingao2()">
            </div>
          </div>

          <div class="kuaidibianhaoti">
          <span>
            <span class="xinhao">*</span>餐厅窗口
          </span>
          </div>
          <div class="kuaidibianhao">
            <div class="kuaidibianhaosr">
              <input type="text" name="kd-id" class="kuaidibianhaos" onClick="jingao3()" onBlur="jingao4()">
            </div>
          </div>-->

					<div class="qujianshijianti">
						<span> <span class="xinhao">*</span>餐厅
						</span>
					</div>
					<div class="qujianshijian">
						<div class="qujianshijian1">
							<input type="text" name="sc_ceng" class="qujianshijian0"
								onClick="jingao7()" onBlur="jingao8()">
						</div>
					</div>



					<div class="qujiandidianti" style="width: 30px;">
						<span> <span class="xinhao">*</span>层
						</span>
					</div>
					<div class="qujiandidian">
						<div class="qujiandidiansr">
							<input type="text" name="sc_canting" class="qujiandidians"
								onClick="jingao5()" onBlur="jingao6()">
						</div>
					</div>


					<div class="qujianyongjinti">
						<span> <span class="xinhao">*</span>窗口
						</span>
					</div>
					<div class="qujianyongjin">
						<div class="qujianyongjinsr">
							<input type="text" name="sc_chuangkou" class="yongjins"
								onClick="jingao9()" onBlur="jingao10()">
						</div>
					</div>

					<div class="songjiandidianti">
						<span> <span class="xinhao">*</span>送餐地点
						</span>
					</div>
					<div class="songjiandidian">
						<div class="songjiandidiansr">
							<input type="text" name="sc_place2" class="songjiandidians"
								onClick="jingao11()" onBlur="jingao12()">
						</div>
					</div>

					<div class="lianxirenti">
						<span> <span class="xinhao">*</span>送达时间
						</span>
					</div>
					<div class="lianxiren">
						<div class="lianxirensr">
							<input type="text" name="sc_sdtime" class="lianxirens"
								onClick="jingao13()" onBlur="jingao14()">
						</div>
					</div>

					<div class="sjhmti">
						<span> <span class="xinhao">*</span>佣金
						</span>
					</div>
					<div class="sjhm">
						<div class="sjhmsr">
							<input type="text" name="sc_money" class="sjhms"
								onClick="jingao15()" onBlur="jingao16()">
						</div>
					</div>

					<div class="beizhuti">
						<span> <span class="xinhao">*</span>备注（饭菜）
						</span>
					</div>
					<div class="beizhu">
						<div class="beizhusr">
							<input type="text" name="sc_note" class="beizhus"
								onClick="jingao17()" onBlur="jingao18()">
						</div>
					</div>

					<div class="fabuti">
						<div>
							<input type="submit" value="确认信息并发布任务" class="button1">
						</div>
					</div>
					<!--<div class="fabuti1">
            <div><input type="submit" value="返回主页" class="button2"></div>
          </div>-->
				</form>
				<form method="post" action="task.jsp">
					<div class="fabuti1">
						<div>
							<input type="submit" value="返回主页" class="button2">
						</div>
					</div>
				</form>
				<div class="typetishi" id="tishi1">
					<img src="../img/jingao.png" width="18px"><span
						style="color:#cccccc;font-size:15px;">0-40个字，不允许填写特殊字符！</span>
				</div>
				<div class="bianhaotishi" id="tishi2">
					<img src="../img/jingao.png" width="18px"><span
						style="color:#cccccc;font-size:15px;">0-40个数字，不允许填写电话号码或邮箱！</span>
				</div>
				<div class="qujiandidiantishi" id="tishi3">
					<img src="../img/jingao.png" width="18px"><span
						style="color:#cccccc;font-size:15px;">0-40个字符，不允许填写特殊字符！</span>
				</div>
				<div class="qujianshijiantishi" id="tishi4">
					<img src="../img/jingao.png" width="18px"><span
						style="color:#cccccc;font-size:15px;">0-40个字，不允许填写特殊字符！</span>
				</div>
				<div class="yongjintishi" id="tishi5">
					<img src="../img/jingao.png" width="18px"><span
						style="color:#cccccc;font-size:15px;">0-40个字，不允许填写特殊字符！！</span>
				</div>
				<div class="songjiandidiantishi" id="tishi6">
					<img src="../img/jingao.png" width="18px"><span
						style="color:#cccccc;font-size:15px;">0-40个字符，不允许填写特殊字符！</span>
				</div>
				<div class="lianxirentishi" id="tishi7">
					<img src="../img/jingao.png" width="18px"><span
						style="color:#cccccc;font-size:15px;">请按格式填写，例如18:00!</span>
				</div>
				<div class="sjhmtishi" id="tishi8">
					<img src="../img/jingao.png" width="18px"><span
						style="color:#cccccc;font-size:15px;">请输入数字，不允许不填或填0！</span>
				</div>
				<div class="beizhutishi" id="tishi9">
					<img src="../img/jingao.png" width="18px"><span
						style="color:#cccccc;font-size:15px;">允许填写0-15个字，请在范围内填写！</span>
				</div>
			</div>
			<div class="leftcontent">
				<div class="guanggao">
					<img src="../img/guanggao.png" width="60px;">
				</div>
				<div class="qitabangzhu">其他帮助</div>
				<div class="leftdiv"></div>
				<div class="lianxikefu">联系客服帮您发需求</div>
				<div class="kefudianhua">客服电话</div>
				<div class="kefuphone">0591-22887859</div>
				<div class="zhouyidaozhouliu">工作时间：周一到周六</div>
				<div class="button3">
					<input type="submit" value="联系在线客服" class="button4" id="kefu1"
						onmouseover="change21()" onmouseout="change22()">
				</div>
				<div class="zaixiankefu">周一至周五:9:00-18:00</div>
				<div class="jiaerhengxian"></div>
				<div class="erweima1">
					<img src="../img/1.jpg" width="185px">
				</div>
			</div>
		</div>
	</div>













	<div class="footer">
		<div class="footcontent">
			<div class="diyilie">
				<div class="tu">
					<img src="../img/logo2.png" height=55 width=58>
				</div>
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
				<div class="erweima">
					<img src="../img/1.jpg" width=150>
				</div>
				<div class="hailiangzanzhu">海量赞助，就加关注</div>
			</div>
		</div>
		<div class="footend">
			<div class="footendcontent">Copyright © 2016 雷锋科技有限公司版权所有
				晋ICP备16008255号-1</div>
		</div>
	</div>
	<script src="../js/newsc.js"></script>
</body>
</html>