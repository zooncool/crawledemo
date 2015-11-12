package com.property.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import us.codecraft.webmagic.ResultItems;


public class JdbcHelper {
	
	
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost/haowu?characterEncoding=utf8","root", "");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return conn;
	}

	public static void insertInfo(ResultItems resultItems){
		
		Connection conn = getConn();
		
		Statement st = null;
		try {
			st = conn.createStatement();
			if(null!=resultItems.get("title") && !"".equals(resultItems.get("title"))){
				String sql = "insert into gz_second_house(`property`,`area`,`section`,`address`,`layout`,`price`,`average_price`,`contact`,`identity`,`phone`,`website`) values("
						+ "'"+resultItems.get("property")+"',"
						+ "'"+resultItems.get("area")+"',"
						+ "'"+resultItems.get("section")+"',"
						+ "'"+resultItems.get("address")+"',"
						+ "'"+resultItems.get("layout")+"',"
						+ "'"+resultItems.get("price")+"',"
						+ "'"+resultItems.get("average_price")+"',"
						+ "'"+resultItems.get("contact")+"',"
						+ "'"+resultItems.get("identity")+"',"
						+ "'"+resultItems.get("phone")+"',"
						+ "'"+resultItems.get("website")+"'"
								+ ")";
				st.execute(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
