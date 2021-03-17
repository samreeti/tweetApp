package com.tweetapp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tweetapp.configuration.ConnectionFactory;
import com.tweetapp.util.MainMenuUtil;

public class UserRegistrationService {
	public static void getUser(String firstName,String lastName,String gender,String dob,String emailId,String password) throws IOException{
		Statement statement;
		try {
			Connection con=ConnectionFactory.getConnection();
			statement = con.createStatement();
			String sql="INSERT INTO UserRegistrationDetails(firstName,lastName,gender,dob,emailId,password) "
					+ "VALUES('"+firstName+"','"+lastName+"','"+gender+"','"+dob+"','"+emailId+"','"+password+"')";
			statement.executeUpdate(sql);
			System.out.println("Registration success!!");
		} catch (SQLException e) {
			System.out.println("Duplicate entry for "+ emailId +" key 'PRIMARY'");
		}

		MainMenuUtil.menu();
	}

	public static void forgotPassword(String userName,String dateOfBirth) throws IOException {
		Statement statement;
		try {
			boolean match= false;
			int count=0;
			InputStreamReader r=new InputStreamReader(System.in);   
			BufferedReader br=new BufferedReader(r); 
			Connection con=ConnectionFactory.getConnection();
			statement = con.createStatement();
			String sql="SELECT emailId,dob FROM UserRegistrationDetails";
			ResultSet results=statement.executeQuery(sql);
			while(results.next()) {
				String user_name=results.getString("emailId");
				String dob=results.getString("dob");
				match=(userName.equals(user_name))&&(dateOfBirth.equals(dob));
				if(match)
				{
					System.out.println("Enter new password");
					String password = br.readLine();
					String sqlQuery="UPDATE UserRegistrationDetails SET password='" + password+"' WHERE emailId='"+userName+"'";
					statement.executeUpdate(sqlQuery);
					System.out.println("Password Changed");
					count++;
					break;
				}
			}
			if(count<1)
			{
				System.out.println("No match");
			}
			results.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MainMenuUtil.menu();
	}
}
