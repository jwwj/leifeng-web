package com.leifeng.bean;

public class MyInfoData {
private static int user_id;
private static String user_name,user_number,user_school;
public static int getUser_id() {
	return user_id;
}
public static void setUser_id(int user_id) {
	MyInfoData.user_id = user_id;
}
public static String getUser_name() {
	return user_name;
}
public static void setUser_name(String user_name) {
	MyInfoData.user_name = user_name;
}
public static String getUser_number() {
	return user_number;
}
public static void setUser_number(String user_number) {
	MyInfoData.user_number = user_number;
}
public static String getUser_school() {
	return user_school;
}
public static void setUser_school(String user_school) {
	MyInfoData.user_school = user_school;
}

}
