package com.crm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.utilities.TestUtil;

public class TestBase {

	protected static WebDriver driver;
	protected static Properties prop; // = new Properties();
	private static String config_file = "/Users/sandeepskainth/eclipse-workspace/ProjectCRM/src/main/java/"
			+ "com/crm/config/config.properties";
	// TestUtil testUtil = new TestUtil();

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream loadproperties = new FileInputStream(config_file);
			prop.load(loadproperties);
		} catch (IOException e) {
			throw new RuntimeException("Filed to load the config file" + config_file, e);
		}

	}

	public static void initialisation() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdrive.chrome.driver",
					"/Users/sandeepskainth/eclipse-workspace/firstPOMattempt/src/resources/drivers/chromedriver");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

			System.setProperty("driver.gecko.driver",
					"/Users/sandeepskainth/eclipse-workspace/ProjectCRM/driver/geckodriver");
			driver = new FirefoxDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get(prop.getProperty("url"));

	}

}
