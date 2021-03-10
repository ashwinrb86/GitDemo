package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By signin=By.className("login-btn");
	By text=By.className("text-center");
	By contact=By.xpath("//a[contains(text(),'Contact')]");
	
	public  WebElement getLogin() {
		
		return driver.findElement(signin);
	}
	
	public  WebElement getTitleheading() {
		
		return driver.findElement(text);
	}
	public  WebElement getContact() {
		
		return driver.findElement(contact);
	}
	

}
