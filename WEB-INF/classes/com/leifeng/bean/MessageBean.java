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


public class MessageBean {

	private Connection con;

	// private static String user_number;

	public MessageBean() throws ClassNotFoundException, SQLException {
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

	public boolean login(String num, String psw) throws SQLException {
		String sql = "select * from userTable where user_number='" + num
				+ "' and user_password='" + psw + "'";
		ResultSet rs = select(sql);
		boolean isRight = rs.next();
		rs.close();
		return isRight;
	}

	public Collection<MessageData> getAllMessages() {

		Collection<MessageData> ret = new ArrayList<MessageData>();

		try {
			ResultSet rs = select("select * from kdTable where kdTable.task_status='未接受'");
			while (rs.next()) {

				int task_id = rs.getInt("task_id");// 任务Id不显示
				// int order_id=rs.getInt("order_id");//订单id不显示

				String kd_type = rs.getString("kd_type");
				// String kd_id = rs.getString("kd_id");
				String kd_place1 = rs.getString("kd_place1");
				String kd_place2 = rs.getString("kd_place2");
				String kd_time1 = rs.getString("kd_time1");// 快递到达时间
				String kd_time2 = rs.getString("kd_time2");// 快递离开时间
				// String kd_note = rs.getString("kd_note");
				String kd_money = rs.getString("kd_money");
				String time = rs.getString("time");// 订单创建时间
				String task_status = rs.getString("task_status");
				String task_usernum = rs.getString("task_usernum");

				MessageData message = new MessageData();

				message.setTask_id(task_id);
				// message.setOrder_id(order_id);

				message.setKd_type(kd_type);
				// message.setKd_id(kd_id);
				message.setKd_place1(kd_place1);
				message.setKd_place2(kd_place2);
				message.setKd_time1(kd_time1);
				message.setKd_time2(kd_time2);
				// message.setKd_note(kd_note);
				message.setKd_money(kd_money);
				message.setTime(time);
				message.setTask_status(task_status);
				message.setTask_usernum(task_usernum);

				ret.add(message);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	// 获取订单详情
	public Collection<MessageData> getOrderInfo(String sql) {

		Collection<MessageData> ret = new ArrayList<MessageData>();

		try {
			ResultSet rs = select(sql);
			while (rs.next()) {

				int order_id = rs.getInt("order_id");// 订单id
				String time_start = rs.getString("time_start");// 订单创建时间
				String time_end = rs.getString("time_end");
				
				int task_id = rs.getInt("task_id");// 任务Id不显示
				String time = rs.getString("time");// 任务创建时间
				String kd_type = rs.getString("kd_type");
				String kd_id = rs.getString("kd_id");
				String kd_place1 = rs.getString("kd_place1");
				String kd_place2 = rs.getString("kd_place2");
				String kd_time1 = rs.getString("kd_time1");// 快递到达时间
				String kd_time2 = rs.getString("kd_time2");// 快递离开时间
				String kd_note = rs.getString("kd_note");
				String kd_money = rs.getString("kd_money");
String user_name=rs.getString("user_name");
				String task_status = rs.getString("task_status");
				String task_usernum = rs.getString("task_usernum");

				MessageData message = new MessageData();

				message.setTask_id(task_id);
				message.setTime(time);
				message.setOrder_id(order_id);
				message.setKd_type(kd_type);
				message.setKd_id(kd_id);
				message.setKd_place1(kd_place1);
				message.setKd_place2(kd_place2);
				message.setKd_time1(kd_time1);
				message.setKd_time2(kd_time2);
				message.setKd_note(kd_note);
				message.setKd_money(kd_money);
				message.setTime_start(time_start);
				message.setTime_end(time_end);
				message.setTask_status(task_status);
				message.setTask_usernum(task_usernum);
message.setUser_name(user_name);
				ret.add(message);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public Collection<MessageData> getTaskInfo(String sql) {
		Collection<MessageData> ret = new ArrayList<MessageData>();
		try {
			ResultSet rs = select(sql);
			while (rs.next()) {
				MessageData message = new MessageData();

				setTask(rs, message);

				ret.add(message);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void setTask(ResultSet rs, MessageData message) throws SQLException {
		int task_id = rs.getInt("task_id");// 任务Id
		String time = rs.getString("time");// 任务创建时间
		String kd_type = rs.getString("kd_type");
		String kd_id = rs.getString("kd_id");
		String kd_place1 = rs.getString("kd_place1");
		String kd_place2 = rs.getString("kd_place2");
		String kd_time1 = rs.getString("kd_time1");// 快递到达时间
		String kd_time2 = rs.getString("kd_time2");// 快递离开时间
		String kd_note = rs.getString("kd_note");
		String kd_money = rs.getString("kd_money");
		String task_usernum = rs.getString("task_usernum");
		String task_status = rs.getString("task_status");

		message.setTask_id(task_id);
		message.setTime(time);
		message.setKd_type(kd_type);
		message.setKd_id(kd_id);
		message.setKd_place1(kd_place1);
		message.setKd_place2(kd_place2);
		message.setKd_time1(kd_time1);
		message.setKd_time2(kd_time2);
		message.setKd_note(kd_note);
		message.setKd_money(kd_money);
		message.setTask_status(task_status);
		message.setTask_usernum(task_usernum);
	}

	public Collection<MessageData> getUserInfo(String sql) throws SQLException {

		System.out.println(sql);
		Collection<MessageData> ret = new ArrayList<MessageData>();
		try {
			ResultSet rs = select(sql);
			while (rs.next()) {
				
				MessageData message = new MessageData();

				setTask(rs, message);
				
				int order_id=rs.getInt("order_id");
				String time_start = rs.getString("time_start");
				String time_end=rs.getString("time_end");
				
				int user_id = rs.getInt("user_id");// 学号
				String user_number = rs.getString("user_number");// 电话号 主键
				String user_name = rs.getString("user_name");
				String user_school = rs.getString("user_school");

				message.setTime_start(time_start);
				message.setTime_end(time_end);
				message.setOrder_id(order_id);
				
				message.setUser_id(user_id);
				message.setUser_name(user_name);
				message.setUser_number(user_number);
				message.setUser_school(user_school);

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
	public Collection<MessageData> taskInfo_IAccept1() {
		String sql = "select * from kdTable,orderTable,userTable where kdTable.task_status='已接受' and orderTable.order_usernum='"
				+ MyInfoData.getUser_number()
				+ "' and kdTable.task_id=orderTable.task_id and userTable.user_number=kdTable.task_usernum";
		Collection<MessageData> ret = new ArrayList<MessageData>();
		ret = getOrderInfo(sql);
		return ret;
	}
	//已完成
	public Collection<MessageData> taskInfo_IAccept2() {
		String sql = "select * from kdTable,orderTable,userTable where kdTable.task_status='已完成' and orderTable.order_usernum='"
				+ MyInfoData.getUser_number()
				+ "' and kdTable.task_id=orderTable.task_id and userTable.user_number=kdTable.task_usernum";
		Collection<MessageData> ret = new ArrayList<MessageData>();
		ret = getOrderInfo(sql);
		return ret;
	}

	// 我的任务里的任务详情页(我发布的任务)
	// 未接受
	public Collection<MessageData> taskInfo_IPub1() {
		String sql = "select * from kdTable where kdTable.task_usernum='"
				+ MyInfoData.getUser_number()
				+ "'and kdTable.task_status='未接受'";
		Collection<MessageData> ret = new ArrayList<MessageData>();
		ret = getTaskInfo(sql);
		return ret;
	}

	// 已接受
	public Collection<MessageData> taskInfo_IPub2() throws SQLException {
		String sql = "select * from kdTable,orderTable,userTable where kdTable.task_id=orderTable.task_id and userTable.user_number=orderTable.order_usernum and task_status='已接受' and task_usernum='"
				+ MyInfoData.getUser_number() + "'";
		Collection<MessageData> ret = new ArrayList<MessageData>();
		ret = getUserInfo(sql);
		System.out.println(sql);
		return ret;
	}

	// 已完成
	public Collection<MessageData> taskInfo_IPub3() throws SQLException {
		String sql = "select * from kdTable,orderTable,userTable where kdTable.task_id=orderTable.task_id and userTable.user_number=orderTable.order_usernum and task_status='已完成' and task_usernum='"
				+ MyInfoData.getUser_number() + "'";
		Collection<MessageData> ret = new ArrayList<MessageData>();
		ret = getUserInfo(sql);
		System.out.println(sql);
		return ret;
	}

	// 下单后的任务详情页
	public Collection<MessageData> taskInfo(int task_id) {
		String sql = "select * from kdTable,orderTable,userTable where kdTable.task_id='"
				+ task_id + "' and orderTable.task_id='" + task_id + "'and userTable.user_number=kdTable.task_usernum";
		Collection<MessageData> ret = new ArrayList<MessageData>();
		ret = getOrderInfo(sql);
		return ret;
	}
	

	// 返回task_id任务id
	public String time(){
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		return time;
	}
	
	public int addKd(String kd_type, String kd_id, String kd_place1,
			String kd_place2, String kd_time1, String kd_time2, String kd_note,
			String kd_money) throws SQLException {

		String sql1 = "insert into kdTable(kd_type,kd_id,kd_place1,kd_place2,kd_time1,kd_time2,kd_note,kd_money,task_usernum,time,task_status) values(?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement s1 = insert(sql1);

		String time=time();

		s1.setString(1, kd_type);
		s1.setString(2, kd_id);
		s1.setString(3, kd_place1);
		s1.setString(4, kd_place2);
		s1.setString(5, kd_time1);
		s1.setString(6, kd_time2);
		s1.setString(7, kd_note);
		s1.setString(8, kd_money);
		s1.setString(9, MyInfoData.getUser_number());
		s1.setString(10, time);
		s1.setString(11, "未接受");
		s1.execute();

		int task_id = selectLastId();
		// System.out.println("insert" + UserData.getUser_number());
		System.out.println("task_id:" + task_id);
		return task_id;
		/*
		 * String sql2=
		 * "insert into orderTable(task_id,order_usernum,time_start,order_status)values(?,?,?,?)"
		 * ; System.out.println(sql2); PreparedStatement s2=insert(sql2);
		 * 
		 * s2.setInt(1, task_id); s2.setInt(2, user_id); s2.setString(3,
		 * time_start); s2.setString(4,"false"); s2.execute();
		 */
	}
	

	// 返回order_id订单号
	public int addOrder(int task_id) throws SQLException {
		String sql1 = "update kdTable set task_status ='已接受' where task_id='"
				+ task_id + "'";
		update(sql1);

		String sql2 = "insert into orderTable(task_id,order_usernum,time_start)values(?,?,?)";
		System.out.println(sql2);
		PreparedStatement s2 = insert(sql2);

		String time_start = time();

		s2.setInt(1, task_id);
		s2.setString(2, MyInfoData.getUser_number());
		s2.setString(3, time_start);
		// s2.setString(4, "已接受");
		s2.execute();

		int order_id = selectLastId();
		System.out.println("order_id" + order_id);
		return order_id;
	}

	public void FinishOrder(int task_id) throws SQLException{
		String sql1 = "update kdTable set task_status ='已完成' where task_id='"
				+ task_id + "'";
		update(sql1);
		String sql2 = "update orderTable set time_end ='"+time()+"' where task_id='"
				+ task_id + "'";
		update(sql2);
	}
	
	
	public void myInfo(String num) throws SQLException {

		String sql = "select * from userTable where user_number='" + num + "'";
		ResultSet rs = select(sql);
		rs.next();
		int user_id = rs.getInt("user_id");// 学号
		String user_number = rs.getString("user_number");// 电话号 主键
		String user_name = rs.getString("user_name");
		String user_school = rs.getString("user_school");

		MyInfoData.setUser_id(user_id);
		MyInfoData.setUser_name(user_name);
		MyInfoData.setUser_number(user_number);
		MyInfoData.setUser_school(user_school);

		rs.close();
	}

}
