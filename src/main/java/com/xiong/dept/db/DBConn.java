package com.xiong.dept.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://123.56.228.198:3306/tumbleweed";
    private static String user="tumbleweed";
    private static String password="tumbleweed";
    private static Connection conn;
    private static DBConn db;
    
    private DBConn(){
    	
    }
    
    public static DBConn getInstance(){
    	synchronized(DBConn.class){
    		if(db==null){
    			db=new DBConn();
    		}
    	}
    	return db;
    }
    
    public Connection getConn(){
    	try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return conn;
    }
    
    public void connClose(){
    	try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    	
}
