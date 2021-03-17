package com.tweetapp.dao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.tweetapp.exception.InvalidPassword;
import com.tweetapp.service.TweetsService;
import com.tweetapp.util.TweetUtil;
import com.tweetapp.util.ValidationUtil;

public class UserDAO {
	static String tweet;
	public static void postTweet(String userName) throws IOException{
		InputStreamReader r=new InputStreamReader(System.in);   
		BufferedReader br=new BufferedReader(r);
		System.out.println("Enter you Tweet");
		tweet = br.readLine();
		TweetsService.postTweet(userName,tweet);
		TweetUtil.tweet(userName);
	}

	public static void viewMyTweets(String userName) throws IOException{
		TweetsService.myTweets(userName);
		TweetUtil.tweet(userName);
	}

	public static void viewAllTweets(String userName) throws IOException{
		TweetsService.allTweets();
		TweetUtil.tweet(userName);
	}

	public static void viewAllUsers(String userName) throws IOException{
		TweetsService.allUsers(userName);
		TweetUtil.tweet(userName);
	}

	public static void viewAllUsersWithTweets(String userName) throws IOException{
		TweetsService.allUsersWithTweets();
		TweetUtil.tweet(userName);
	}

	public static void resetPassword(String userName) throws IOException{
		InputStreamReader r=new InputStreamReader(System.in);   
		BufferedReader br=new BufferedReader(r);
		System.out.println("Enter your old password");
		String oldPassword = br.readLine();
		System.out.println("Enter your new password");
		String newPassword = br.readLine();
		try {
			ValidationUtil.isValidPassword(newPassword);
		}
		catch(InvalidPassword ex)
		{
			System.out.println("Enter password(It contains at least 8 characters and at most 20 characters.\r\n" + 
					"It contains at least one digit.\r\n" + 
					"It contains at least one upper case alphabet.\r\n" + 
					"It contains at least one lower case alphabet.\r\n" + 
					"It contains at least one special character which includes !@#$%&*()-+=^.\r\n" + 
					"It doesn’t contain any white space.)");
			newPassword = br.readLine();
		}

		TweetsService.resetPassword(userName,oldPassword,newPassword);
		TweetUtil.tweet(userName);
	}


}
