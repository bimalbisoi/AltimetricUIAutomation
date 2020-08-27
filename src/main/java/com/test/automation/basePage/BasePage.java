package com.test.automation.basePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.test.automation.utils.Config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static WebDriver driver;


	/**
	 * 
	 * This method initialise the driver and return the driver instance.
	 *
	 * @return the driver
	 */
	public static WebDriver getDriver(){

		String browserName = Config.getConfigProperty("BROWSER_NAME");
		if (browserName.equalsIgnoreCase("chrome")) {		                                                                                    
			WebDriverManager.chromedriver().setup();      
			driver = new ChromeDriver();                 
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver();
		} 

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public static void open(String url) {
		driver.get(url);
	}

}
