package com.ap.pages;



import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;



public class HomePage extends TestBase{
	@FindBy(css="button[class='f_a z_a f_c']" )
	WebElement accountButton;
	@FindBy(css="a[data-module-id='373118c9-6626-48b9-8b4d-fdb1656b1480']" )
	WebElement signinButton;
	@FindBy(css="[class='h_a a5_b header-GlobalSearch-input mweb-Typeahead-input h_b']")
	WebElement searchField;
	@FindBy(css="button[class='f_a a5_e GlobalHeaderSearchbar-submit f_c']")
	WebElement clickSearch;
	
	@FindBy(tagName="a")
	List<WebElement> links;
	
	
	
	
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public int HomePagelinks(){
		return links.size();
		
	}

	public void clickonAcctButton(){
		accountButton.click();
}
	public void clickonSignIn(){
		signinButton.click();
	}
	
	public SearchPage searchProduct(String product){
		searchField.sendKeys(product);
		clickSearch.click();
		return new SearchPage();//Have to add this line!!to create instance after searching, otherwise null pointer
	}
	
}