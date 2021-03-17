package com.tweetapp.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tweetapp.configuration.ConnectionFactory;

public class UserLoginService {
	public static String login(String username,String password){
		Statement statement;
		String result=null;
		try {
			Connection con=ConnectionFactory.getConnection();
			statement = con.createStatement();
			String sql="SELECT emailId,password FROM UserRegistrationDetails";
			ResultSet results=statement.executeQuery(sql);
			while(results.next()) {
				String user_name=results.getString("emailId");
				String pass_word=results.getString("password");
				if((username.equals(user_name))&&(password.equals(pass_word)))
				{
					result="Login success!!!";
					break;
				}
				else
				{
					result="Invalid credentials!!!";
				}
			}
			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
