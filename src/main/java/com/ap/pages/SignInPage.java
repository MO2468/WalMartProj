package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class SignInPage extends TestBase{
	@FindBy(css="[id='email']" )
	WebElement email;
	@FindBy(css="[id='password']" )
	WebElement pwd;
	@FindBy(css="button[type='submit']")
	WebElement submitbtn;
	@FindBy(css="[class='error-message']")
	WebElement errormsg;
	
	
	public SignInPage(){
		PageFactory.initElements(driver, this);
	}
	public String getTitle(){
		return driver.getTitle();
	}
	
	public void login(String user, String pass){
		email.sendKeys(user);
		pwd.sendKeys(pass);
		submitbtn.click();
	}
	public String getError(){
		return errormsg.getText();
	}
}

