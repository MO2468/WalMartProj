package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class CartSummaryPage extends TestBase{
	@FindBy(xpath="//h3[@class='Cart-PACModal-Heading']//span[1]//span[1]")
	WebElement text;
	
	
	public CartSummaryPage(){
		PageFactory.initElements(driver, this);
	}
	public String validateAddToCartText(){
		return text.getText();
	}
	public WebElement text(){
		return text;
	}
	
}
