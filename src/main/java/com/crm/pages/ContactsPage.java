package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]/span")
	WebElement contactPanelHeader;
//
//	@FindBy(xpath = ("//a[contains(text(),'User 2')]/parent::td//preceding-sibling::td/div/input[@name=\"id\"]"))
//	WebElement checkboxClick;

	@FindBy(xpath = ("//a[contains(text(), 'User 2')]/ancestor::tr//div[contains(@class, 'fitted checkbox')]"))
	WebElement checkboxClick;

	@FindBy(xpath = ("//a[contains(text(),'SAM Smith')]"))
	WebElement SAMSmithClick;

	@FindBy(xpath = ("//div[contains(@class,'visible menu transition')]"))
	WebElement dropdownClick;

	@FindBy(xpath = ("//a[@href='/contacts/new']"))
	WebElement createContact;

	@FindBy(xpath = ("//input[@name=\"first_name\"]"))
	WebElement firstNameField;

	@FindBy(xpath = ("//input[@name=\"last_name\"]"))
	WebElement lastNameField;

	@FindBy(xpath = ("//div[@class=\"ui selection dropdown\" and @name=\"status\"]"))
	WebElement statusField;

	@FindBy(xpath = ("\"//div[@role='option']//span[normalize-space(text())='\" + enteredStatus + \"']/parent::div\""))
	WebElement selectStatusOption;

	@FindBy(xpath = "//button[@class=\"ui linkedin button\"]")
	WebElement saveButton;

	public ContactsPage() {

		PageFactory.initElements(driver, this);

	}

	public boolean getContactPanelHeader() {

		return contactPanelHeader.isDisplayed();
	}

	public void Contactcheckbox() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(checkboxClick));
		// checkboxClick.click();
		// checkboxClick.isEnabled();
		SAMSmithClick.click();
		driver.navigate().back();
		Thread.sleep(1000);
		checkboxClick.click();
		// dropdownClick.click();

	}

	public void selectContactsByName(String contactinfo) {
		driver.findElement(By.xpath(
				"//a[contains(text(), '" + contactinfo + "')]/ancestor::tr//div[contains(@class, 'fitted checkbox')]"))
				.click();

	}

	public void createNewContact() {
		createContact.click();

	}

	public void createNewForm(String firstName, String lastName, String enteredStatus) throws InterruptedException {

		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		statusField.click();

		String optionXPath = "//div[@role='option']//span[normalize-space(text())='" + enteredStatus + "']/parent::div";

		By statusOptionLocator = By.xpath(optionXPath);

		// Wait for the option to be clickable and click it
		WebElement desiredOption = driver.findElement(statusOptionLocator);
		Thread.sleep(5000);
		desiredOption.click();
		Thread.sleep(5000);
		// selectStatusOption.
		// Select status = new Select(statusField);
		// status.deselectByValue(entereredStatus);
		saveButton.click();
		Thread.sleep(5000);

	}

}
