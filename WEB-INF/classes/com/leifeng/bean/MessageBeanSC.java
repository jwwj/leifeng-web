package com.leifeng.bean;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import com.leifeng.bean.MessageData;


public class MessageBeanSC {

	private Connection con;

	// private static String user_number;

	public MessageBeanSC() throws ClassNotFoundException, SQLException {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String userName = "sa";
		String userPasswd = "1234";
		String conurl = "jdbc:sqlserver://localhost:1433;DatabaseName=leifeng";
		Class.forName(JDriver);
		con = DriverManager.getConnection(conurl, userName, userPasswd);
		// 连接数据库
	}

	// 查询select语句
	public ResultSet select(String sql) throws SQLException {
		ResultSet ret = con.createStatement().executeQuery(sql);
		return ret;
	}

	public PreparedStatement insert(String sql) throws SQLException {
		PreparedStatement s = con.prepareStatement(sql);
		return s;
	}

	// 返回最新插入语句的id
	public int selectLastId() throws SQLException {
		ResultSet rs = select("select @@identity AS id");
		rs.next();
		int id = rs.getInt("id");
		return id;
	}

	public void update(String sql) throws SQLException {
		con.createStatement().execute(sql);
	}


	public Collection<MessageDataSC> getAllMessages() {

		Collection<MessageDataSC> retsc = new ArrayList<MessageDataSC>();

		try {
			ResultSet rs = select("select * from scTable where scTable.sc_task_status='未接受'");
			while (rs.next()) {

				int sc_task_id = rs.getInt("sc_task_id");
				String sc_canting = rs.getString("sc_canting");
				String sc_ceng = rs.getString("sc_ceng");
				String sc_chuangkou = rs.getString("sc_chuangkou");
				String sc_place2 = rs.getString("sc_place2");
				String sc_note = rs.getString("sc_note");
				String sc_money = rs.getString("sc_money");
				String sc_task_usernum = rs.getString("sc_task_usernum");
				String sc_fbtime = rs.getString("sc_fbtime");
				String sc_sdtime = rs.getString("sc_sdtime");
				String sc_task_status = rs.getString("sc_task_status");
				
				MessageDataSC messagesc = new MessageDataSC();

				messagesc.setSc_task_id(sc_task_id);
				messagesc.setSc_canting(sc_canting);
				messagesc.setSc_ceng(sc_ceng);
				messagesc.setSc_chuangkou(sc_chuangkou);
				messagesc.setSc_place2(sc_place2);
				messagesc.setSc_note(sc_note);
				messagesc.setSc_money(sc_money);
				messagesc.setSc_task_usernum(sc_task_usernum);
				messagesc.setSc_fbtime(sc_fbtime);
				messagesc.setSc_sdtime(sc_sdtime);
				messagesc.setSc_task_status(sc_task_status);

				retsc.add(messagesc);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retsc;
	}

	
		

	public Collection<MessageDataSC> getTaskInfo(String sql) {
		Collection<MessageDataSC> ret = new ArrayList<MessageDataSC>();
		try {
			ResultSet rs = select(sql);
			while (rs.next()) {
				MessageDataSC messagesc = new MessageDataSC();

				setTask(rs, messagesc);

				ret.add(messagesc);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void setTask(ResultSet rs, MessageDataSC messagesc) throws SQLException {

		int sc_task_id = rs.getInt("sc_task_id");
		String sc_canting = rs.getString("sc_canting");
		String sc_ceng = rs.getString("sc_ceng");
		String sc_chuangkou = rs.getString("sc_chuangkou");
		String sc_place2 = rs.getString("sc_place2");
		String sc_note = rs.getString("sc_note");
		String sc_money = rs.getString("sc_money");
		String sc_task_usernum = rs.getString("sc_task_usernum");
		String sc_fbtime = rs.getString("sc_fbtime");
		String sc_sdtime = rs.getString("sc_sdtime");
		String sc_task_status = rs.getString("sc_task_status");
		

		messagesc.setSc_task_id(sc_task_id);
		messagesc.setSc_canting(sc_canting);
		messagesc.setSc_ceng(sc_ceng);
		messagesc.setSc_chuangkou(sc_chuangkou);
		messagesc.setSc_place2(sc_place2);
		messagesc.setSc_note(sc_note);
		messagesc.setSc_money(sc_money);
		messagesc.setSc_task_usernum(sc_task_usernum);
		messagesc.setSc_fbtime(sc_fbtime);
		messagesc.setSc_sdtime(sc_sdtime);
		messagesc.setSc_task_status(sc_task_status);
	}
	

	public Collection<MessageDataSC> getUserInfo(String sql) throws SQLException {

		System.out.println(sql);
		Collection<MessageDataSC> ret = new ArrayList<MessageDataSC>();
		try {
			ResultSet rs = select(sql);
			while (rs.next()) {
				
				MessageDataSC messagesc = new MessageDataSC();

				setTask(rs, messagesc);
				
				int sc_order_id=rs.getInt("sc_order_id");
				
				
				String sc_time_start = rs.getString("sc_time_start");
				String sc_time_end=rs.getString("sc_time_end");
				
				int user_id = rs.getInt("user_id");// 学号
				String user_number = rs.getString("user_number");// 电话号 主键
				String user_name = rs.getString("user_name");
				String user_school = rs.getString("user_school");

				messagesc.setSc_time_start(sc_time_start);
				messagesc.setSc_time_end(sc_time_end);
				messagesc.setSc_order_id(sc_order_id);
				
				messagesc.setUser_id(user_id);
				messagesc.setUser_name(user_name);
				messagesc.setUser_number(user_number);
				messagesc.setUser_school(user_school);

				ret.add(messagesc);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public Collection<MessageDataSC> getOrderInfo(String sql) {

		Collection<MessageDataSC> ret = new ArrayList<MessageDataSC>();

		try {
			ResultSet rs = select(sql);
			while (rs.next()) {
				int sc_order_id = rs.getInt("sc_order_id");// 订单id
				String sc_time_end = rs.getString("sc_time_end");
				String sc_time_start = rs.getString("sc_time_start");// 订单创建时间
				int sc_task_id = rs.getInt("sc_task_id");// 任务Id不显示
				String sc_fbtime = rs.getString("sc_fbtime");// 任务创建时间
				String sc_canting = rs.getString("sc_canting");
				String sc_ceng = rs.getString("sc_ceng");
				String sc_chuangkou = rs.getString("sc_chuangkou");
				String sc_place2 = rs.getString("sc_place2");
				String sc_note = rs.getString("sc_note");
				String sc_money = rs.getString("sc_money");
				String sc_sdtime = rs.getString("sc_sdtime");
				String sc_task_status = rs.getString("sc_task_status");
				String sc_task_usernum = rs.getString("sc_task_usernum");
				String user_number=rs.getString("user_number");
String user_name=rs.getString("user_name");
				MessageDataSC message = new MessageDataSC();

				message.setSc_order_id(sc_order_id);
				message.setSc_task_id(sc_task_id);
				message.setSc_canting(sc_canting);
				message.setSc_ceng(sc_ceng);
				message.setSc_chuangkou(sc_chuangkou);
				message.setSc_place2(sc_place2);
				message.setSc_note(sc_note);
				message.setSc_money(sc_money);
				message.setSc_task_usernum(sc_task_usernum);
				message.setSc_fbtime(sc_fbtime);
				message.setSc_sdtime(sc_sdtime);
				message.setSc_task_status(sc_task_status);
				message.setSc_time_start(sc_time_start);
				message.setSc_time_end(sc_time_end);
				message.setUser_name(user_name);
				message.setUser_number(user_number);
				ret.add(message);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	// 我的任务里的任务详情页(我接受的任务)
	//已接受
	public Collection<MessageDataSC> taskInfo_IAccept1() {
		String sql = "select * from scTable,scorderTable,userTable where sc_task_status='已接受' and scorderTable.sc_order_usernum='"
				+ MyInfoData.getUser_number()
				+ "' and scTable.sc_task_id=scorderTable.sc_task_id and userTable.user_number=scTable.sc_task_usernum";
		Collection<MessageDataSC> ret = new ArrayList<MessageDataSC>();
		ret = getOrderInfo(sql);

		return ret;
	}
	//已完成
	public Collection<MessageDataSC> taskInfo_IAccept2() {
		String sql = "select * from scTable,scorderTable,userTable where sc_task_status='已完成' and scorderTable.sc_order_usernum='"
				+ MyInfoData.getUser_number()
				+ "' and scTable.sc_task_id=scorderTable.sc_task_id and userTable.user_number=scTable.sc_task_usernum";
		Collection<MessageDataSC> ret = new ArrayList<MessageDataSC>();
		ret = getOrderInfo(sql);
		
		return ret;
	}

	// 我的任务里的任务详情页(我发布的任务)
	// 未接受
	public Collection<MessageDataSC> taskInfo_IPub1() {
		String sql = "select * from scTable where scTable.sc_task_usernum='"
				+ MyInfoData.getUser_number()
				+ "'and scTable.sc_task_status='未接受'";
		Collection<MessageDataSC> ret = new ArrayList<MessageDataSC>();
		ret = getTaskInfo(sql);
		return ret;
	}

	// 已接受
	public Collection<MessageDataSC> taskInfo_IPub2() throws SQLException {
		String sql = "select * from scTable,scorderTable,userTable where scTable.sc_task_id=scorderTable.sc_task_id and userTable.user_number=scorderTable.sc_order_usernum and sc_task_status='已接受' and sc_task_usernum='"
				+ MyInfoData.getUser_number() + "'";
		Collection<MessageDataSC> ret = new ArrayList<MessageDataSC>();
		ret = getUserInfo(sql);
		System.out.println(sql);
		return ret;
	}

	// 已完成
	public Collection<MessageDataSC> taskInfo_IPub3() throws SQLException {
		String sql = "select * from scTable,scorderTable,userTable where scTable.sc_task_id=scorderTable.sc_task_id and userTable.user_number=scorderTable.sc_order_usernum and sc_task_status='已完成' and sc_task_usernum='"
				+ MyInfoData.getUser_number() + "'";
		Collection<MessageDataSC> ret = new ArrayList<MessageDataSC>();
		ret = getUserInfo(sql);
		System.out.println(sql);
		return ret;
	}

	// 下单后的任务详情页
	public Collection<MessageDataSC> taskInfo(int sc_task_id) {
		String sql = "select * from scTable,scorderTable,userTable where scTable.sc_task_id='"
				+ sc_task_id + "' and scorderTable.sc_task_id='" + sc_task_id + "'and userTable.user_number=scTable.sc_task_usernum";
		Collection<MessageDataSC> ret = new ArrayList<MessageDataSC>();
		ret = getOrderInfo(sql);
		return ret;
	}
	
	//返回系统当前时间
	public String time(){
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		return time;
	}
	
	
	// 返回task_id任务id
	public int addsc(String sc_canting,String sc_ceng, String sc_chuangkou,
			String sc_place2,  String sc_note, String sc_money,
			String sc_sdtime) throws SQLException {

		System.out.println("Bean:"+sc_canting);
		
		String sql1 = "insert into scTable(sc_canting,sc_ceng,sc_chuangkou,sc_place2,sc_note,sc_money,sc_fbtime,sc_sdtime,sc_task_usernum,sc_task_status) values(?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement s1 = insert(sql1);

		String sc_fbtime=time();
	//	System.out.println(sc_canting+sc_ceng+sc_chuangkou+sc_place2+sc_note+sc_money+sc_fbtime+sc_sdtime+ MyInfoData.getUser_number()+"weijieshou");
		
		s1.setString(1, sc_canting);
		s1.setString(2, sc_ceng);
		s1.setString(3, sc_chuangkou);
		s1.setString(4, sc_place2);
		s1.setString(5, sc_note);
		s1.setString(6, sc_money);
		s1.setString(7, sc_fbtime);
		s1.setString(8, sc_sdtime);
		s1.setString(9, MyInfoData.getUser_number());
		s1.setString(10, "未接受");
		
		s1.execute();

		int sc_task_id = selectLastId();
		
		System.out.println("task_id:" + sc_task_id);
		return sc_task_id;
		
	}
	

	// 返回order_id订单号
	public int addOrder(int sc_task_id) throws SQLException {
		String sql1 = "update scTable set sc_task_status ='已接受' where sc_task_id='"
				+ sc_task_id + "'";
		update(sql1);

		String sql2 = "insert into scorderTable(sc_task_id,sc_order_usernum,sc_time_start)values(?,?,?)";
		System.out.println(sql2);
		PreparedStatement s2 = insert(sql2);

		String sc_time_start = time();

		s2.setInt(1, sc_task_id);
		s2.setString(2, MyInfoData.getUser_number());
		s2.setString(3, sc_time_start);
		// s2.setString(4, "已接受");
		s2.execute();

		int sc_order_id = selectLastId();
		System.out.println("sc_order_id" + sc_order_id);
		
		
		return sc_order_id;
	}

	public void FinishOrder(int sc_task_id) throws SQLException{
		
		String sql2 = "update scorderTable set sc_time_end ='"+time()+"' where sc_task_id='"
				+ sc_task_id + "'";
		update(sql2);
		String sql1 = "update scTable set sc_task_status ='已完成' where sc_task_id='"
				+ sc_task_id + "'";
		update(sql1);
	}
	
	


}
