package com.Utility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BaseClass {
	public static WebDriver driver;
	public static void initalization()  
	{
	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo-PC\\eclipse-workspace\\Arrivnow\\chromedriver.exe");
			  driver=new ChromeDriver();
			driver.manage().window().maximize();
		    driver.get("http://arrivnow-web.s3-website.ap-south-1.amazonaws.com/login");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 

	}
}
