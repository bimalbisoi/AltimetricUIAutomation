package com.test.automation.components;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.basePage.BasePage;
import com.test.automation.utils.Config;

/**
 * The Class Home.
 */
public class Home extends BasePage{
	public Home()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//span[@class='tgl-btn'])[2]")
	private WebElement oneWayRadioButton;

	public WebElement getOneWayRadioButton()
	{
		return this.oneWayRadioButton;
	}
	public void clickOneWayRadioButton()
	{
		this.oneWayRadioButton.click();
	}

	@FindBy(xpath="//input[@id='from1']")
	private WebElement fromAddress;

	@FindBy(xpath="(//span[text()='Airport'])[1]")
	private WebElement fromAddresssel;

	public WebElement getFromAddress()
	{
		return this.fromAddress;
	}
	public void setFromAddress(String fromAddress)
	{
		this.fromAddress.clear();
		this.fromAddress.sendKeys(fromAddress);
		this.fromAddresssel.click();
	}
	@FindBy(xpath="//input[@id='to1']")
	private WebElement toAddress;
	@FindBy(xpath="(//span[text()='Airport'])[2]")
	private WebElement toAddressSel;
	public WebElement getToAddress()
	{
		return this.toAddress;
	}
	public void setToAddress(String toAddress)
	{
		this.toAddress.sendKeys(toAddress);
		this.toAddressSel.click();
	}
	@FindBy(xpath="//span[text()='Select Date']")
	private WebElement selectDateField;

	public WebElement getSelectDateField()
	{
		return this.selectDateField;
	}
	public void clickSelectDateField()
	{
		this.selectDateField.click();
	}
	@FindBy(xpath="//td[@data-month='8']//a[text()='3']")
	private WebElement selectDate;

	public WebElement getSelectDate()
	{
		return this.selectDate;
	}
	public void selectDate()
	{
		this.selectDate.click();
	}

	@FindBy(xpath="//button[text()='Search Flights']")
	private WebElement searchButton;

	public WebElement getSearchButton()
	{
		return this.searchButton;
	}
	public void clickSearchButton()
	{
		this.searchButton.click();
	}
	@FindBy(xpath="//span[text()='No Thanks']")
	private WebElement noThanksButton;

	public WebElement getNoThanksButton()
	{
		return this.noThanksButton;
	}
	public void clickNoThanksButton()
	{
		this.noThanksButton.click();
	}

	@FindBy(xpath="(//li[@class='fltrt-opt-fares-price flight-result-shell__fare-column ']/div)[1]")
	private WebElement price;

	public WebElement getPrice()
	{
		return this.price;
	}
	public void selectPrice()
	{
		this.price.click();
	}
	@FindBy(xpath="//span[text()='Continue']")
	private WebElement continueButton;

	public WebElement getContinueButton()
	{
		return this.continueButton;
	}
	public void clickContinueButton()
	{
		this.continueButton.click();
	}
	@FindBy(xpath="//h3[@class='trip-hdr-sub last']")
	private WebElement bookingDate;

	public WebElement getBookingDate()
	{
		return this.bookingDate;
	}
	public String getBookingDateFromTicket()
	{
		return this.bookingDate.getText();
	}

	Set<String> set=driver.getWindowHandles();
	ArrayList<String> al=new ArrayList<String>(set);
	public void switchToChildWindow() {

		driver.switchTo().window(al.get(1));
	}
	public void switchToParentWindow() {
		driver.switchTo().window(al.get(0));
	}
}
