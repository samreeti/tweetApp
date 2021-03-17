package com.tweetapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenuUtil {
	public static void menu() throws IOException{
		System.out.println("Enter your choice");
		System.out.println("1.Registration");
		System.out.println("2.Login");
		System.out.println("3.Forgot Password");
		System.out.println("4.Exit");
		InputStreamReader r=new InputStreamReader(System.in);   
		BufferedReader br=new BufferedReader(r);    
		int choice=Integer.parseInt(br.readLine()); 
		switch(choice){
		case 1: System.out.println("Registration Form");
		RegistrationUtil.registration();
		break;
		case 2: System.out.println("Login Form");
		LoginUtil.login();
		break;
		case 3: System.out.println("Forgot Password");
		RegistrationUtil.forgotPassword();
		break;
		case 4: System.out.println("Exit");
		System.exit(0);
		default: System.out.println("Incorrect input!!! Please re-enter choice from menu");
		menu();
		}
	}
}
