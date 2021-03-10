package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class base {

	public WebDriver driver;
	public String url;
	
	public WebDriver initializeDriver() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream("//Users//ashwinbidrimath//eclipse-workspace//E2EProject//src//main//java//resources//data.properties");
		
	prop.load(fis);
	String browser =prop.getProperty("browser");
	System.out.println(browser);
	
	url =prop.getProperty("url");
	System.out.println(url);
		//chrome
	
	if(browser.equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "//Users//ashwinbidrimath//Downloads//chromedriver");
		 driver=new ChromeDriver();
		
	}
		//ie
	else if(browser.equalsIgnoreCase("ie")) {
		
		System.setProperty("webdriver.edge.driver", "//Users//ashwinbidrimath//Downloads//edgedriver_mac64//msedgedriver");
		 driver=new EdgeDriver();
		
	}
	
		//firefox
	else if(browser.equalsIgnoreCase("firefox")) {
	System.setProperty("webdriver.gecko.driver", "//Users//ashwinbidrimath//Downloads//geckodriver");
	 driver=new FirefoxDriver();
	}
		//safari
	else if(browser.equalsIgnoreCase("safari")) {
		
		 driver=new SafariDriver();
		
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
	
	}
	
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destfile= System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
		FileUtils.copyFile(source,new File (destfile));
		return destfile;
		
	}
	
}
