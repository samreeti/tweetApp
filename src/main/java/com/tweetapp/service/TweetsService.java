package com.tweetapp.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tweetapp.configuration.ConnectionFactory;

public class TweetsService {
	public static void postTweet(String emailId,String tweet){
		Statement statement;
		try {
			Connection con=ConnectionFactory.getConnection();
			statement = con.createStatement();
			String sql="INSERT INTO UserTweets(emailId,tweets) "
					+ "VALUES('"+emailId+"','"+tweet+"')";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Tweet posted successfully!!!");
	}

	public static void myTweets(String userName) {
		Statement statement;
		try {
			Connection con=ConnectionFactory.getConnection();
			statement = con.createStatement();
			String sql="SELECT * FROM UserTweets";
			ResultSet results=statement.executeQuery(sql);
			boolean match= false;
			int count=0;
			while(results.next()) {
				String user_name=results.getString("emailId");
				match=userName.equals(user_name);
				if(match)
				{
					System.out.println(results.getString("tweets"));
					count=count+1;
				}
			}
			if(count<1)
			{
				System.out.println("No tweets");
			}
			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void allTweets(){
		Statement statement;
		try {
			Connection con=ConnectionFactory.getConnection();
			statement = con.createStatement();
			String sql="SELECT * FROM UserTweets";
			int count=0;
			ResultSet results=statement.executeQuery(sql);
			while(results.next()) {
				count++;
				System.out.println(results.getString("tweets"));
			}
			if(count<1)
			{
				System.out.println("No tweets");
			}
			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void allUsers(String userName){
		Statement statement;
		try {
			Connection con=ConnectionFactory.getConnection();
			statement = con.createStatement();
			String sql="SELECT * FROM UserRegistrationDetails";
			boolean match=false;
			int count=0;
			ResultSet results=statement.executeQuery(sql);
			while(results.next()) {
				String user_name=results.getString("emailId");
				match=userName.equals(user_name);
				if(!match)
				{
					System.out.println(results.getString("emailId"));
					count=count+1;
				}
				match=false;
			}
			if(count<1)
			{
				System.out.println("NO user except you");
			}
			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void allUsersWithTweets(){
		Statement statement;
		try {
			Connection con=ConnectionFactory.getConnection();
			statement = con.createStatement();
			String sql="SELECT * FROM UserTweets";
			ResultSet results=statement.executeQuery(sql);
			while(results.next()) {
				System.out.println(results.getString("emailId")+"-"+results.getString("tweets"));
			}
			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void resetPassword(String userName,String oldPassword,String newPassword){
		Statement statement;
		try {
			Connection con=ConnectionFactory.getConnection();
			statement = con.createStatement();
			boolean match=false;
			String sql="SELECT * FROM UserRegistrationDetails";
			ResultSet results=statement.executeQuery(sql);
			while(results.next()) {
				String user_name=results.getString("emailId");
				String pass_word=results.getString("password");
				match=(userName.equals(user_name)&& oldPassword.equals(pass_word));
				if(match) {
					String sqlQuery="UPDATE UserRegistrationDetails SET password='" + newPassword+"' WHERE emailId='"+userName+"'";
					statement.executeUpdate(sqlQuery);
					System.out.println("Password Changed");
					break;
				}
			}
			if(!match)
			{
				System.out.println("Invalid Old password");
			}
			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
