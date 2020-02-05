package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class ProductDetailsPage extends TestBase {
	@FindBy(xpath="//label[3]//div[1]")
	WebElement color;
	@FindBy(xpath="//span[@class='spin-button-children']")
	WebElement addtocart;
	
	public ProductDetailsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void pickColorOptions(){
		color.click();
	}
	
	public CartSummaryPage ClickAddToCart(){
		addtocart.click();
		return new CartSummaryPage();
	}
}
