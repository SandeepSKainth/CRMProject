package com.crm.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.base.TestBase;

public class TestUtil extends TestBase {

	public static final long IMPLICIT_WAIT = 10;
	public static long PAGE_LOAD_TIMEOUT = 10;
	private static String TESTDATA_SHEET_PATH = "/Users/sandeepskainth/eclipse-workspace/ProjectCRM/src/main/java/crm/main/testdata/CRMTestData.xlsx";

	public void switchToFrame() {
		driver.switchTo().frame(""); // enter the name of the panel/frame by viewing it on page source info
	}
	// 1. Locate the element you want to hover over
	// WebElement menu = driver.findElement(By.id());

	// @FindBy(id = "main-nav")
	// WebElement mainNavigationBar;

	// 2. Initialize the Actions class
	// Actions actions = new Actions(driver);

	// 3. Move to the element and execute
	// actions.moveToElement(menu).perform();

	public static Object[][] getTestData(String CRMSheet) {

		FileInputStream file = null;
		XSSFWorkbook workbook = null;

		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheet(CRMSheet);

			int totalRows = sheet.getLastRowNum();
			int totalColm = sheet.getRow(0).getLastCellNum();

			Object[][] data = new Object[totalRows][totalColm];

			// run the row loop and get the data inside the XSSFCell

			for (int row = 1; row <= totalRows; row++) {
				XSSFRow currentRow = sheet.getRow(row);

				for (int col = 0; col < totalColm; col++) {

					XSSFCell cell = currentRow.getCell(col);

					if (cell == null) {

						data[row - 1][col] = "";

					} else {

						data[row - 1][col] = cell.toString();
					}
				}

			}
			return data;

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if (file != null)
					file.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return null;

	}

}

// same is for the column

// Collect the data from the cells
