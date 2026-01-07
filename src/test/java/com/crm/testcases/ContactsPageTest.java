package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utilities.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName = "CRMSheet";

	public ContactsPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialisation();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		contactsPage = homePage.clickOnContactPage();
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();

	}

	@Ignore
	@Test(priority = 1)
	public void verifyContactPanelHeader() {
		homePage.clickOnContactPage();

		Assert.assertTrue(contactsPage.getContactPanelHeader(), "The Panel Header is not dispaled");

	}

	@Ignore
	@Test
	public void clickOnContactCheckbox() throws InterruptedException {

		homePage.clickOnContactPage();

		Assert.assertTrue(contactsPage.getContactPanelHeader());
		homePage.clickOnContactPage();
		contactsPage.Contactcheckbox();

	}

//	@Test(priority = 2)
//	public void clickOnTheContact() {
//		contactsPage.selectContactsByName("User 1");
//
//	}

	@Ignore
	@Test(priority = 2)
	public void clickOnTheContact() {
		contactsPage.selectContactsByName(prop.getProperty("contactname"));
		contactsPage.createNewContact();
	}

	@DataProvider
	public Object[][] getDatafromCRMSheet() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 3, dataProvider="getDatafromCRMSheet")
	public void creatingNewContact(String firstName, String lastName, String enteredStatus) throws InterruptedException {

		contactsPage.createNewContact();
		contactsPage.createNewForm(firstName, lastName, enteredStatus);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
