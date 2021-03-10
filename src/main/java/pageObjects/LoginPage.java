package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By email=By.name("email");
	By password=By.id("user_password");
	By login=By.name("commit");
	
	
	
	public  WebElement getEmail() {
		
		return driver.findElement(email);
	}
	
	public  WebElement getPassword() {
		
		return driver.findElement(password);
	}
	
	public  WebElement getLogin() {
		
		return driver.findElement(login);
	}
	

}
