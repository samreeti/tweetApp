package com.tweetapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.tweetapp.dao.UserDAO;

public class TweetUtil {
	public static void tweet(String userName) throws IOException {
		InputStreamReader r=new InputStreamReader(System.in);   
		BufferedReader br=new BufferedReader(r);
		System.out.println("Enter your choice");
		System.out.println("1.Post Tweets");
		System.out.println("2.View my tweets");
		System.out.println("3.View all tweets");
		System.out.println("4.View all users");
		System.out.println("5.View all users with tweets");
		System.out.println("6.Reset Password");
		System.out.println("7.Logout");
		int choice = Integer.parseInt(br.readLine());
		switch(choice){
		case 1: System.out.println("Post tweets");
		UserDAO.postTweet(userName);
		break;
		case 2: System.out.println("View my tweets");
		UserDAO.viewMyTweets(userName);
		break;
		case 3: System.out.println("View all tweets");
		UserDAO.viewAllTweets(userName);
		break;
		case 4: System.out.println("View all users");
		UserDAO.viewAllUsers(userName);
		break;
		case 5: System.out.println("View all users with tweets");
		UserDAO.viewAllUsersWithTweets(userName);
		break;
		case 6: System.out.println("Reset password");
		UserDAO.resetPassword(userName);
		break;
		case 7: System.out.println("Logout");
		MainMenuUtil.menu();
		break;
		default: System.out.println("Incorrect input!!! Please re-enter choice from our menu");
		tweet(userName);
		}
	}
}

