package com.tweetapp.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public static Connection getConnection()  
	{
		Connection con = null;
		Properties props = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace-samreeti\\tweetApp\\src\\main\\resources\\db.properties");
			props.load(fis);
			fis.close();
			String driver= props.getProperty("driver.class.name");
			if(driver!=null)
			{
				Class.forName(driver);
			}
			String url= props.getProperty("db.url");
			String username=props.getProperty("db.username");
			String password=props.getProperty("db.password");
			con = DriverManager.getConnection(url,username,password);

		}
		catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch(FileNotFoundException exception) {
			exception.printStackTrace();
		} catch(IOException exception) {
			exception.printStackTrace();
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		}
		return con;

	}

}


