package com.ap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.testbase.TestBase;

public class CheckOutPage extends TestBase {
		@FindBy(css="button[class='button m-margin-top width-full button--primary']")
		WebElement continueGuest;
		@FindBy(xpath="//div[@class='CXO_panel_button selected CXO-FulfillmentCategory--button']")
		WebElement pickupfreeButton;
		
		public CheckOutPage() {
		PageFactory.initElements(driver, this);
		}
		
		public void clickContinueAsGuest(){
			continueGuest.click();
		}
		public WebElement continueAsGuest(){
			return continueGuest;
		}
		public void clickpickupfreeButton(){
			pickupfreeButton.click();
		}
		
		
		
}
