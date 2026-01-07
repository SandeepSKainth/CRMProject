package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.base.TestBase;

public class HomePage extends TestBase {

	// @FindBy(linkText = "/contacts")
	// WebElement contactPageLink;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/div[3]/a/span")
	WebElement contactPageLink;

	@FindBy(linkText = "/deals")
	WebElement dealsPageLink;

	@FindBy(id = "main-nav")
	WebElement mainNavigationBar;

	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	public String getHomePageTitle() {

		return driver.getTitle();

	}

	public ContactsPage clickOnContactPage() {

		Actions actions = new Actions(driver);

		actions.moveToElement(mainNavigationBar).perform();

		contactPageLink.click();
		return new ContactsPage();

	}

	public DealsPage clickOnDealsPage() {

		dealsPageLink.click();
		return new DealsPage();

	}

}
