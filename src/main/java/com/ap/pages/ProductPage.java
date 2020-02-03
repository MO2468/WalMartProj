package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class ProductPage extends TestBase {
	@FindBy(css="[data-tl-id='ProductTileGridView-0']")
	WebElement product1;
	
	
	public ProductPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickProduct(){
		product1.click();
	}
	
}
