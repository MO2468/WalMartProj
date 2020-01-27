package com.ap.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.utilities.TestUtil;
import com.ap.utilities.WebEventListener;



public class TestBase {
	public static WebDriver driver;
	public static Properties propt;
	public static EventFiringWebDriver en_driver;//initiate the webdriver
	public static WebEventListener eventListener;
	
	public TestBase(){
		try{
		propt = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/ap/config/config.properties");
		propt.load(fis);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		System.out.println("No file found");
	} catch (IOException e) {
		e.printStackTrace();
	}		
}
	public static void Initialization(){
		String browserName = propt.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe"));
			driver  = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver.exe"));
			driver  = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/src/main/resources/drivers/.exe"));
			driver  = new InternetExplorerDriver();
		}
		
		/**deals with all the events instead of calling the driver, we call object
		 * this object is holding my events - pass,fail,skip/assert & verify
		 * CREATING AN OBJECT FOR ACTION THAT'S OCCURING AND SHARING WITH DRIVER*/
		en_driver = new EventFiringWebDriver(driver);		
		//to catch the events		
		//////CREATE OBJECT OF WEBLISTENER TO REGISTER WITH EventFiringWebDriver
		eventListener = new WebEventListener();
		/////EVENTS CAN BE CAPTURED 
		// object holding information, events(the passed, or failed).
				//event can be captured based on the method we create webeventlistener class
		en_driver.register(eventListener);
		////since we driver object is for browser en_driver is for event. we declaring with equal to each when they are exchanging the information.
		driver = en_driver;
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//testUtil class needs to have this data for this class to access
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load, TimeUnit.SECONDS);
		driver.get(propt.getProperty("url"));		
		
	}
	
}
