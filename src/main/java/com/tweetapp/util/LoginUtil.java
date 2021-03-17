package com.tweetapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.tweetapp.service.UserLoginService;

public class LoginUtil {
	public static void login() throws IOException{
		InputStreamReader r=new InputStreamReader(System.in);   
		BufferedReader br=new BufferedReader(r); 
		System.out.println("Enter User Name");
		String userName = br.readLine();
		System.out.println("Enter Password");
		String password = br.readLine();
		String result=UserLoginService.login(userName,password);
		if(result.equalsIgnoreCase("Login success!!!"))
		{
			System.out.println("Login success!!!");
			TweetUtil.tweet(userName);
		}
		else {
			System.out.println("Invalid credentials!!!");
			MainMenuUtil.menu();
		}
	}
}
