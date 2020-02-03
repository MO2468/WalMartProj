package com.ap.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.pages.HomePage;
import com.ap.pages.ProductPage;
import com.ap.testbase.TestBase;
public class ProductPickUpTest extends TestBase {
	HomePage hp;
	ProductPage pp;
	
	public ProductPickUpTest(){
		super();
	}
	
	@BeforeMethod
	public void setupDriver(){
		Initialization();
		hp = new HomePage();
		
	}
	
	@Test
	public void addProductToCart(){
		hp.searchProduct(propt.getProperty("product"));
		pp.clickProduct();
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		driver=null;
	}
	
	
}
