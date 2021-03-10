package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest 
	
	public void startbrowser() throws IOException {
		
		driver=initializeDriver();
		log.info("driver initialised");
		
	}
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String email, String password, String text) throws IOException {
		
	driver.get(url);
	log.info("Arrived at Landing Page");
	LandingPage l=new LandingPage(driver);
	System.out.println(l.getTitleheading().getText());
	Assert.assertEquals(l.getTitleheading().getText(), "FEATURED COURSES");
	log.info("FEATURED COURSES title is visible on Landing Page");
	
	Assert.assertTrue(l.getContact().isDisplayed());
	
		
	}
	
	@DataProvider
	
	public Object[][] getData() {
		
		Object[][] data=new Object[2][3];
		
		
		data[0][0]="ashiwn.bidrimath@gmail.com";
		data[0][1]="Rahul@123";
		data[0][2]="Non-ristricted user";
				
		data[1][0]="abc@gmail.com";
		data[1][1]="abc@123";
		data[1][2]="Ristricted user";
		
		return data;
		
	}
	
	@AfterTest 
	public void teardown1() {
		driver.close();
		log.info("Browser closed");
	}
	
	

}