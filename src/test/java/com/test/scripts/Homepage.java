package com.test.scripts;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.samples.base.BaseClass;
import com.samples.pageobjects.LandingPage;
import com.samples.pageobjects.LoginPage;


public class Homepage extends BaseClass {
	
	@Test(dataProvider="getData")
	public void basePageNevigation(String Username, String Password) throws IOException {
		driver = initializeDriver();
		driver.get("http://qaclickacademy.com");
		
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		LoginPage lpg = new LoginPage(driver);
		lpg.getEmail().sendKeys(Username);
		lpg.getPass().sendKeys(Password);
		//System.out.println(Text);
		lpg.getLogin().click();
	}
	@DataProvider
	public Object[][] getData() {
		//rows stand for how many different data types test should run
		//coloumn stands for how many values per each test
		Object [][] data = new Object[2][2];
		//0 th row
		data[0][0]="faysalsf@gmail.com";
		data[0][1]="123456";
		//data[0][2]="restricted";
		
		data[1][0]="nonfaysalsf@gmail.com";
		data[1][1]="123456789AAAA";
		//data[1][2]="nonrestricted";
		
		return data;
		
	}
}
