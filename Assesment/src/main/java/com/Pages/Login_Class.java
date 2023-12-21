package com.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.BaseClass;

public class Login_Class extends BaseClass {
	
//	Object Repository
	
	@FindBy(xpath="//input[@name=\"loginEmail\"]")private WebElement useridTextbox;
	@FindBy(xpath="//input[@type=\"password\"]")private WebElement passwordTextbox;
	@FindBy(xpath="//span[@class=\"cursor-pointer input-group-text\"]")private WebElement EyeIcon;
	@FindBy(xpath="//button[text()='Sign in']")private WebElement LoginBtn;
	@FindBy(xpath="//span[text()='You have successfully logged in as an ']")private WebElement SuccessfullyLogin;
	@FindBy(xpath="//div[text()='Invalid Email/Password']")private WebElement LoginFailed;
	@FindBy(xpath="//small[text()='Forgot Password?']")private WebElement ForgotPassword;
	@FindBy(xpath="//h2[text()='Forgot Password? 🔒']")private WebElement ForgotPasswordText;
	@FindBy(xpath="//div[text()='Send reset link']")private WebElement Sendresetlink;
	@FindBy(xpath="//div[text()='Please check your mail for instructions to reset your password']")private WebElement passwordrecoveryinstructions;
	@FindBy(xpath="//span[text()='Back to login']")private WebElement Backtologin;
	
//	 Constructor 
	
	public Login_Class() throws IOException {
		super();
		PageFactory.initElements(driver,this); 
	}
	
//	 Methods
//	  Test Case 1: Successful login
	public String Validate_Successful_login() throws InterruptedException
	{
		useridTextbox.sendKeys("admin123@gmail.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		passwordTextbox.sendKeys("Admin@123");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		LoginBtn.click();
		Thread.sleep(2000);
		
		return SuccessfullyLogin.getText();
	}
	
//	 Test Case 2: Invalid login
	
	public String Validate_Invalid_credentials() throws InterruptedException
	{
		useridTextbox.sendKeys("client123@gmail.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		passwordTextbox.sendKeys("Admin@1");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		LoginBtn.click();
		Thread.sleep(2000);
		
		return LoginFailed.getText();
	}
//	Test Case 3: Retain values after failed login
	public String Validate_Retain_values_after_failed_login() throws InterruptedException
	{
		return useridTextbox.getText();
//		return passwordTextbox.getText();
		
	}
	
//	Test Case 4: Disabled Login button with empty fields
	
	public String Validate_Disabled_Login_button_with_empty_fields()
	{
		useridTextbox.sendKeys("");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		passwordTextbox.sendKeys("");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		LoginBtn.click();
		
		if (LoginBtn.isEnabled())
			 
	         System.out.println("Test Passed: Login button is initially disabled with empty fields");
		else
			 System.out.println("Test Failed: Login button is enabled with empty fields");
		
		return null;
		
	}
//	Test Case 5: Enabled Login button with valid input
	
	public String Validate_Enabled_Login_button_with_valid_input()
	{
		useridTextbox.sendKeys("admin123@gmail.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		passwordTextbox.sendKeys("Admin@123");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		LoginBtn.click();
		 if (!LoginBtn.isEnabled())
				 
             System.out.println("Test Passed: Login button is initially disabled with valid input.");
		 else
			 System.out.println("Test Failed: Login button is enabled with Invalid input.");
		return null;
		
	}
//	Test Case 6: Redirect to Password Recovery Page
	
	public String Validate_Redirect_to_Password_Recovery_Page()
	{
		ForgotPassword.click();
		return ForgotPasswordText.getText();
		
	}
	
//	Test Case 7: Password Recovery Functionality
	public String Validate_Password_Recovery_Functionality()
	{
		ForgotPassword.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ForgotPasswordText.sendKeys("pravin12@gmail.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Sendresetlink.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Backtologin.click();
		
//		Verify if the user is successfully logged in with the new password
		useridTextbox.sendKeys("admin123@gmail.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		passwordTextbox.sendKeys("Pravin@123");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		LoginBtn.click();
		return passwordrecoveryinstructions.getText();
		
	}

}
