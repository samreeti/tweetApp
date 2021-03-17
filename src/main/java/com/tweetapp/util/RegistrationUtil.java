package com.tweetapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.tweetapp.exception.InvalidDate;
import com.tweetapp.exception.InvalidEmailId;
import com.tweetapp.exception.InvalidPassword;
import com.tweetapp.service.UserRegistrationService;

public class RegistrationUtil {
	public static void registration() throws IOException {
		InputStreamReader r=new InputStreamReader(System.in);   
		BufferedReader br=new BufferedReader(r);  
		System.out.println("Enter First Name");
		String firstName = br.readLine();
		System.out.println("Enter Last Name");
		String lastName = br.readLine();
		System.out.println("Enter Gender");
		String gender = br.readLine();
		System.out.println("Enter DOB(DD/MM/YYY)");
		String dob = br.readLine();
		try {
			ValidationUtil.isValidDate(dob);
		}
		catch (InvalidDate ex)
        {
			System.out.println(ex.getMessage());
            System.out.println("Enter DOB(DD/MM/YYYY)");
			dob = br.readLine();
        }
		System.out.println("Enter EmailID");
		String emailID = br.readLine();
		try {
			ValidationUtil.isValidEmailId(emailID);
		}
		catch(InvalidEmailId ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Enter EmailID");
			emailID = br.readLine();
		}
		System.out.println("Enter password(It contains at least 8 characters and at most 20 characters.\r\n" + 
				"It contains at least one digit.\r\n" + 
				"It contains at least one upper case alphabet.\r\n" + 
				"It contains at least one lower case alphabet.\r\n" + 
				"It contains at least one special character which includes !@#$%&*()-+=^.\r\n" + 
				"It doesn’t contain any white space.)");
		String password = br.readLine();
		try {
			ValidationUtil.isValidPassword(password);
		}
		catch(InvalidPassword ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Enter password(It contains at least 8 characters and at most 20 characters.\r\n" + 
					"It contains at least one digit.\r\n" + 
					"It contains at least one upper case alphabet.\r\n" + 
					"It contains at least one lower case alphabet.\r\n" + 
					"It contains at least one special character which includes !@#$%&*()-+=^.\r\n" + 
					"It doesn’t contain any white space.)");
			password = br.readLine();
		}
		UserRegistrationService.getUser(firstName,lastName,gender,dob,emailID,password);
	}

	public static void forgotPassword() throws IOException {
		InputStreamReader r=new InputStreamReader(System.in);   
		BufferedReader br=new BufferedReader(r);
		System.out.println("Enter Username");
		String userName = br.readLine();
		System.out.println("Enter DateOfBirth");
		String dob = br.readLine();
		UserRegistrationService.forgotPassword(userName,dob);
		
	}
}
