package com.samples.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources/data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/mac/chromedriver");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE")) {
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;	
		
		
	}



}
