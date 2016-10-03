package org.trainings.rest.MyIMDBUtilities;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	private Properties prop = new Properties();
	private FileInputStream input = null;
	private String url,username,password;
	Connection con = null;
	public DBConnection(){
		try{
			input = new FileInputStream("D:\\Trainings\\Rest\\MyIMDBRest\\config\\config.txt");
			prop.load(input);
			url = "jdbc:"+prop.getProperty("driver")+"://"+prop.getProperty("server_ip")+":"+prop.getProperty("port")+"/"+prop.getProperty("database");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	//Close connection conn PENDING
	public Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
