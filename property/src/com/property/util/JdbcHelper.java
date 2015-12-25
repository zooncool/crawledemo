package com.property.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.property.samples.GzHouse;

import us.codecraft.webmagic.ResultItems;


public class JdbcHelper {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
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
				String sql = "insert into gz_second_house(`property`,`area`,`section`,`address`,`layout`,`price`,`average_price`,`contact`,`identity`,`phone`,`website`,`atime`) values("
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
						+ "'"+resultItems.get("website")+"',"
						+ "'"+resultItems.get("atime")+"'"
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

	
public static void insertBean(GzHouse resultItems){
		
		Connection conn = getConn();
		
		Statement st = null;
		try {
			st = conn.createStatement();
			if(null!=resultItems.getTitle() && !"".equals(resultItems.getTitle())){
				String sql = "insert into gz_second_house(`property`,`area`,`section`,`address`,`layout`,`price`,`average_price`,`contact`,`identity`,`phone`,`website`,`atime`) values("
						+ "'"+resultItems.getProperty()+"',"
						+ "'"+resultItems.getArea()+"',"
						+ "'"+""+"',"
						+ "'"+""+"',"
						+ "'"+""+"',"
						+ "'"+""+"',"
						+ "'"+""+"',"
						+ "'"+""+"',"
						+ "'"+""+"',"
						+ "'"+""+"',"
						+ "'"+resultItems.getWebsite()+"',"
						+ "'"+sdf.format(new Date())+"'"
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
