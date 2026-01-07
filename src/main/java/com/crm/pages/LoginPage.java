package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "email")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(css = ("div.ui.blue.button"))
	WebElement loginBtn;

	@FindBy(css = ("div.header.item"))
	WebElement crmLogo;

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	public String validateLoginPageTitle() {

		return driver.getTitle();

	}

	public boolean crmImageValidation() {

		return crmLogo.isDisplayed();
	}

	public HomePage login(String usrname, String pwd) {
		userName.sendKeys(usrname);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}

}
