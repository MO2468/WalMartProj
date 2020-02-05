package com.ap.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.pages.HomePage;
import com.ap.pages.SignInPage;
import com.ap.testbase.TestBase;

public class LoginTest extends TestBase {
	HomePage hp;
	SignInPage sip;
	public LoginTest(){
		super();
	}
	
	@BeforeMethod
		public void setupDriver(){
			Initialization();
			hp = new HomePage();
			sip = new SignInPage();
	}
	
	@Test(priority=1)
		public void validateLoginTitle(){
		hp.clickonAcctButton();
		hp.clickonSignIn();
		String title= sip.getTitle();
		Assert.assertEquals(title, "Login");
	}
	
	
	@Test(priority=2)
	public void validateLogintestNEG(){
	hp.clickonAcctButton();
	hp.clickonSignIn();
	sip.login(propt.getProperty("user"), propt.getProperty("pass"));
	String msg = sip.getError();
	Assert.assertEquals(msg, "Please enter a valid email address.", "wrong message-email");
	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		driver=null;
	}
}
