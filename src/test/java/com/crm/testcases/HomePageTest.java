package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public HomePageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {

		initialisation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		contactsPage = new ContactsPage();

	}

	@Test
	public void verifyHomePageTitle() {

		String homePageTitle = homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, "Free CRM", "The title of the HomePage does not match");

	}

	@Test
	public void landOnContactsPage() {

		homePage.clickOnContactPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
