package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class SearchPage extends TestBase {
	@FindBy(xpath="//li[@class='Grid-col u-size-6-12 u-size-1-4-m u-size-1-5-xl search-gridview-first-col-item search-gridview-first-grid-row-item']//div[@class='search-result-gridview-item-wrapper']//div[@class='search-result-gridview-item clearfix arrange-fill']//div//a[@class='search-result-productimage gridview display-block']//div//img")
	WebElement product1;
	
	
	public SearchPage(){
		PageFactory.initElements(driver, this);
	}
	
	public ProductDetailsPage clickProduct(){
		product1.click();
		return new ProductDetailsPage();
	}


	
}
