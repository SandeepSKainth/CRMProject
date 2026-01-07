package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {
		initialisation();
		loginPage = new LoginPage();
	}

	@Test(priority = 3)
	public void validateloginPageTitle() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM");
	}

	@Test(priority = 2)
	public void validateCRMLogo() {
		validateLogin();
		boolean flag = loginPage.crmImageValidation();
		Assert.assertTrue(flag);
	}

	@Test(priority = 1)
	public void validateLogin() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
