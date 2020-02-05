package com.ap.testcases;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.pages.CartSummaryPage;
import com.ap.pages.HomePage;
import com.ap.pages.ProductDetailsPage;
import com.ap.pages.SearchPage;
import com.ap.testbase.TestBase;
public class ProductPickUpTest extends TestBase {
	HomePage hp;
	SearchPage sp;
	ProductDetailsPage pdp;
	CartSummaryPage csp;
	
	public ProductPickUpTest(){
		super();
	}
	
	@BeforeMethod
	public void setupDriver(){
		Initialization();
		hp = new HomePage();
		
	}
	
	@Test(priority=2)
	public void addProductToCart(){
		//adding pp= because we changed return type to productpage
		sp =hp.searchProduct(propt.getProperty("product"));
		sp.clickProduct();
		pdp.pickColorOptions();
		csp= pdp.ClickAddToCart();
		}
	
	@Test(priority=1)
	public void validateProductAddedToCart(){
		sp =hp.searchProduct(propt.getProperty("product"));
		pdp =sp.clickProduct();
		pdp.pickColorOptions();
		csp= pdp.ClickAddToCart();
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		String msg= csp.validateAddToCartText();
		//wait.until(ExpectedConditions.textToBePresentInElement(csp.text(), "You just added 1 item "));
		Assert.assertEquals(msg, "You just added 1 item ", "item was not added");
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		driver=null;
	}
	
	
}
