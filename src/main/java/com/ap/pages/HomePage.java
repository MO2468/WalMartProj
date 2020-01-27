package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class HomePage extends TestBase{
	@FindBy(css="button[class='f_a z_a f_c']" )
	WebElement accountButton;
	@FindBy(css="a[data-module-id='373118c9-6626-48b9-8b4d-fdb1656b1480']" )
	WebElement signinButton;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickonAcctButton(){
		accountButton.click();
}
	public void clickonSignIn(){
		signinButton.click();
	}
	
	
}