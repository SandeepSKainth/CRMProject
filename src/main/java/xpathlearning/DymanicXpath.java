package xpathlearning;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.base.TestBase;

public class DymanicXpath extends TestBase {
	
	@FindBy (xpath = ("//a[contains(text(),'User 2')]/parent::td//preceding-sibling::td/div/input[@name=\"id\"]"))
	WebElement checkboxClick;
	

}
