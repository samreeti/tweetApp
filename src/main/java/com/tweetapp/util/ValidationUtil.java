package com.tweetapp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.tweetapp.exception.InvalidDate;
import com.tweetapp.exception.InvalidEmailId;
import com.tweetapp.exception.InvalidPassword;

public class ValidationUtil {
	public static boolean isValidEmailId(String email) throws InvalidEmailId  { 
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
				"[a-zA-Z0-9_+&*-]+)*@" + 
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
				"A-Z]{2,7}$"; 

		Pattern pat = Pattern.compile(emailRegex); 
		if (!pat.matcher(email).matches()) 
		{
			throw new InvalidEmailId("Invalid emailID!! Please enter valid emailID");
		}
		else
			return pat.matcher(email).matches(); 
	} 

	public static boolean isValidDate(String date) throws InvalidDate { 
		String regex = "^(1[0-2]|0[1-9])/(3[01]"
				+ "|[12][0-9]|0[1-9])/[0-9]{4}$"; 
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher((CharSequence)date); 
		if(!matcher.matches())
		{
			throw new InvalidDate("Not a valid Date");
		}
		else
			return matcher.matches(); 
	} 

	public static boolean isValidPassword(String password) throws InvalidPassword {  
		String regex = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[@#$%^&+=])"
				+ "(?=\\S+$).{8,20}$"; 
		Pattern p = Pattern.compile(regex); 
		Matcher m = p.matcher(password);
		if (!m.matches()) { 
			throw new InvalidPassword("Invalid password!! Please enter valid password"); 
		} 
		else
			return m.matches(); 
	} 

}
