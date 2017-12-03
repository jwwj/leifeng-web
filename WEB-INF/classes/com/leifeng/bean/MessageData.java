package com.leifeng.bean;

public class MessageData {
	private String kd_type,kd_id,kd_place1,kd_place2,kd_time1,kd_time2,kd_note,kd_money,time_start,time_end,task_status,task_usernum,time;
	private int task_id,order_id;
	
	private  int user_id;
	private  String user_name,user_number,user_school;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_number() {
		return user_number;
	}
	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}
	public String getUser_school() {
		return user_school;
	}
	public void setUser_school(String user_school) {
		this.user_school = user_school;
	}
	
	public String getKd_type() {
		return kd_type;
	}

	public void setKd_type(String kd_type) {
		this.kd_type = kd_type;
	}

	public String getKd_id() {
		return kd_id;
	}

	public void setKd_id(String kd_id) {
		this.kd_id = kd_id;
	}

	public String getKd_place1() {
		return kd_place1;
	}

	public void setKd_place1(String kd_place1) {
		this.kd_place1 = kd_place1;
	}

	public String getKd_place2() {
		return kd_place2;
	}

	public void setKd_place2(String kd_place2) {
		this.kd_place2 = kd_place2;
	}

	public String getKd_time1() {
		return kd_time1;
	}

	public void setKd_time1(String kd_time1) {
		this.kd_time1 = kd_time1;
	}

	public String getKd_time2() {
		return kd_time2;
	}

	public void setKd_time2(String kd_time2) {
		this.kd_time2 = kd_time2;
	}

	public String getKd_note() {
		return kd_note;
	}

	public void setKd_note(String kd_note) {
		this.kd_note = kd_note;
	}

	public String getKd_money() {
		return kd_money;
	}

	public void setKd_money(String kd_money) {
		this.kd_money = kd_money;
	}


	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTask_usernum() {
		return task_usernum;
	}

	public void setTask_usernum(String task_usernum) {
		this.task_usernum = task_usernum;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

}
