package com.ap.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class CartSummaryPage extends TestBase{
	@FindBy(css="a.PACModal-total-items-count")
	WebElement txt;
	@FindBy(xpath="//button[@class='button ios-primary-btn-touch-fix hide-content-max-m checkoutBtn button--primary']")
	WebElement checkoutButton;
	
	
	public CartSummaryPage(){
		PageFactory.initElements(driver, this);
	}
	public String validateAddToCartText(){
		return txt.getText();
	}
	public WebElement cartText(){
		return txt;
	}
	public CheckOutPage clickCheckoutButton(){
		checkoutButton.click();
		return new CheckOutPage();
	}
	public WebElement checkOutButton(){
		return checkoutButton;
	}
	

	
}
