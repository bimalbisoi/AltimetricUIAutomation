package com.test.automation.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionUtil {

	/**
	 * Take screen shot.
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void takeScreenShot( WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile= ts.getScreenshotAs(OutputType.FILE);
		String currentDirectory=System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDirectory + "/Screenshots/" + System.currentTimeMillis() + ".png"));
	}

	/**
	 * Wait until element is visible.
	 *
	 * @param driver the driver
	 * @param element the element
	 * @param timeduration the timeduration
	 */
	public static void waitUntilElementIsVisible(WebDriver driver,WebElement element,int timeduration) {
		WebDriverWait wait = new WebDriverWait(driver, timeduration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
