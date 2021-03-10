package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void startbrowser() throws IOException {
		
		driver=initializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String email, String password, String text) throws IOException {
	driver.get(url);	
	LandingPage p=new LandingPage(driver);
	p.getLogin().click();
	LoginPage l=new LoginPage(driver);
	l.getEmail().sendKeys(email);
	l.getPassword().sendKeys(password);
	l.getLogin().click();
	
	log.info("Log in successful Home Page");
		
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
	public void teardown() {
		driver.close();
	}
	
	

}
