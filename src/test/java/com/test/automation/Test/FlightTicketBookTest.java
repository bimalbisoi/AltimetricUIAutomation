package com.test.automation.Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.automation.basePage.BasePage;
import com.test.automation.pageObjects.HomePage;
import com.test.automation.utils.ActionUtil;
import com.test.automation.utils.Config;

public class FlightTicketBookTest {

	/**
	 * Book ticket.
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws IOException 
	 */
	@Test
	public void bookTicket() throws InterruptedException, IOException {
		SoftAssert sa=new SoftAssert();
		WebDriver driver=BasePage.getDriver();
		BasePage.open(Config.getConfigProperty("BASE_URL"));
		HomePage.getHome().clickOneWayRadioButton();
		ActionUtil.waitUntilElementIsVisible(driver, HomePage.getHome().getFromAddress(), 5);
		HomePage.getHome().setFromAddress(Config.getConfigProperty("FROM_CITY_ADDRESS"));
		HomePage.getHome().setToAddress(Config.getConfigProperty("TO_CITY_ADDRESS"));
		HomePage.getHome().clickSelectDateField();
		HomePage.getHome().selectDate();
		HomePage.getHome().clickSearchButton();
		HomePage.getHome().switchToChildWindow();
		ActionUtil.waitUntilElementIsVisible(driver, HomePage.getHome().getNoThanksButton(), 5);
		HomePage.getHome().clickNoThanksButton();
		HomePage.getHome().selectPrice();
		ActionUtil.waitUntilElementIsVisible(driver, HomePage.getHome().getContinueButton(), 10);
		HomePage.getHome().clickContinueButton();
		ActionUtil.waitUntilElementIsVisible(driver, HomePage.getHome().getBookingDate(), 10);
		String date=HomePage.getHome().getBookingDateFromTicket();
		sa.assertEquals(date, Config.getConfigProperty("EXPECTED_DATE"));
	    ActionUtil.takeScreenShot(driver);
		driver.close();
		HomePage.getHome().switchToParentWindow();
		driver.quit();
		sa.assertAll();
	}
}
