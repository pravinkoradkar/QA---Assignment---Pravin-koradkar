package com.Test;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Pages.Login_Class;
import com.Utility.BaseClass;

public class Login_Class_Test extends BaseClass {
	
	public Login_Class_Test() throws IOException {
		super();
		
	}

	Login_Class login;
	
	@BeforeMethod 
	public void setup() throws IOException
	{  
		initalization();  
		login=new Login_Class();  
	}
	
	@Test(priority=1)
	public void Validate_Successful_login_Test() throws InterruptedException
	{
		String value=login.Validate_Successful_login();
		Reporter.log("Message display="+value);
	}
	
	@Test(priority=2)
	public void Validate_Invalid_credentials_Test() throws InterruptedException
	{
		String value=login.Validate_Invalid_credentials();
		Reporter.log("Message display="+value);
	}
	
	@Test(priority=3)
	public void Validate_Retain_values_after_failed_login_Test() throws InterruptedException
	{
		String value=login.Validate_Retain_values_after_failed_login();
		Reporter.log("Message display="+value);
	}
	
	@Test(priority=4)
	public void Validate_Disabled_Login_button_with_empty_fields_Test() throws InterruptedException
	{
		String value=login.Validate_Disabled_Login_button_with_empty_fields();
		
	}
	
	@Test(priority=5)
	public void Validate_Enabled_Login_button_with_valid_input_Test() throws InterruptedException
	{
		String value=login.Validate_Enabled_Login_button_with_valid_input();
	

	}
	@Test(priority=6)
	public void Validate_Redirect_to_Password_Recovery_Page_Test() throws InterruptedException
	{
		String value=login.Validate_Redirect_to_Password_Recovery_Page();
		Reporter.log("Message display="+value);
	}
	
	@Test(priority=7)
	public void Validate_Password_Recovery_Functionality_Test() throws InterruptedException
	{
		String value=login.Validate_Password_Recovery_Functionality();
		Reporter.log("Message display="+value);
	}

}
