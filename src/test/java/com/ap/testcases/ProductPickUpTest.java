package com.ap.testcases;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.pages.CartSummaryPage;
import com.ap.pages.CheckOutPage;
import com.ap.pages.HomePage;
import com.ap.pages.ProductDetailsPage;
import com.ap.pages.SearchPage;
import com.ap.testbase.TestBase;

public class ProductPickUpTest extends TestBase {
	HomePage hp;
	SearchPage sp;
	ProductDetailsPage pdp;
	CartSummaryPage csp;
	CheckOutPage cop;
	
	public ProductPickUpTest(){
		super();
	}
	
	@BeforeMethod
	public void setupDriver(){
		Initialization();
		hp = new HomePage();
		
	}
	
	@Test(priority=1, enabled=false)
	public void addProductToCart(){
		//adding pp= because we changed return type to productpage
		sp =hp.searchProduct(propt.getProperty("product"));
		sp.clickProduct();
		pdp.pickColorOptions();
		csp= pdp.ClickAddToCart();
		}
	
	@Test(priority=2, enabled=false)
	public void validateProductAddedToCart() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		sp =hp.searchProduct(propt.getProperty("product"));
		pdp =sp.clickProduct();
		pdp.pickColorOptions();
		csp= pdp.ClickAddToCart();
		//cannot find"_ items added to cart" message due to hidden dom, so did the one next to it to validate
		wait.until(ExpectedConditions.textToBePresentInElement(csp.cartText(), "1 item in cart"));
		//had to add explicit wait, hard to find element quick based on html layout
		String msg= csp.validateAddToCartText();
		Assert.assertEquals(msg, "1 item in cart", "item was not added");
		}
	
	@Test(priority=3,enabled=true)
	public void validateLocation() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		sp =hp.searchProduct(propt.getProperty("product"));
		pdp =sp.clickProduct();
		pdp.pickColorOptions();
		csp= pdp.ClickAddToCart();
		Thread.sleep(1000);
		cop=csp.clickCheckoutButton();
		wait.until(ExpectedConditions.elementToBeClickable(cop.continueAsGuest()));
		cop.clickContinueAsGuest();
		cop.clickpickupfreeButton();
		
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		//driver=null;
		//dont null driver if running multiple test cases in order
	}
	
	
}
