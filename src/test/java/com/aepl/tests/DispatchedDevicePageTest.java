package com.aepl.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aepl.base.TestBase;
import com.aepl.pages.DeviceModelPage;
import com.aepl.pages.DispachedDevicePage;
import com.aepl.pages.LoginPage;
import com.aepl.util.CommonMethod;
import com.aepl.util.ConfigProperties;
import com.aepl.util.ExcelUtility;



	public class DispatchedDevicePageTest extends TestBase {
		private LoginPage loginPage;
		private DispachedDevicePage dispatchedDevice;
		private ExcelUtility excelUtility;
		private CommonMethod commonMethod;
//		private By fileUploadPage = new FileUploadPage(driver);

		@Override
		@BeforeClass
		public void setUp() {
			super.setUp();
			dispatchedDevice = new DispachedDevicePage(driver);
			loginPage = new LoginPage(driver);
			excelUtility = new ExcelUtility();
			excelUtility.initializeExcel("Dispatched Device");
		}

		@Test(priority = 1)
		public void testLogin() {
			loginPage.enterUsername(ConfigProperties.getProperty("valid.username"))
					.enterPassword(ConfigProperties.getProperty("valid.password")).clickLogin();
		}
		
		@Test(priority = 2)
		public void testClickNavBar() {
			String testCaseName = "Test Navbar Links";
			String expectedURL = ConfigProperties.getProperty("dashboard.url");
			String actualURL = "";
			String result;
			logger.info("Executing the testClickNavBar");
			try {
				logger.info("Trying to click on the nav bar links");
				dispatchedDevice.clickNavBar();
				actualURL = driver.getCurrentUrl();
				result = expectedURL.equalsIgnoreCase(actualURL) ? "PASS" : "FAIL";
				logger.info("Result is : " + result);
				excelUtility.writeTestDataToExcel(testCaseName, expectedURL, actualURL, result);
			} catch (Exception e) {
				logger.warn("Error");
				e.printStackTrace();
				actualURL = driver.getCurrentUrl();
				result = expectedURL.equalsIgnoreCase(actualURL) ? "PASS" : "FAIL";
				excelUtility.writeTestDataToExcel(testCaseName, expectedURL, actualURL, result);
			}
			logger.info("Successfully clicked on the Device Utility.");
		}

		@Test(priority = 3)
		public void testClickOnDispatchedDevice() {
			String testCaseName = "Test Dispatched Device Link";
			String expectedURL = ConfigProperties.getProperty("device.model");
			String result = "";

			logger.info("Executing test case: {}", testCaseName);

			try {
				String actualURL = dispatchedDevice.clickDispatchedDevice();
				result = expectedURL.equalsIgnoreCase(actualURL) ? "PASS" : "FAIL";
				logger.info("Test case '{}' completed successfully. Expected URL: {}, Actual URL: {}", testCaseName,
						expectedURL, actualURL);
			} catch (Exception e) {
				logger.error("Error encountered in test case '{}'.", testCaseName, e);
				result = "FAIL";
			} finally {
				excelUtility.writeTestDataToExcel(testCaseName, expectedURL,
						result.equals("PASS") ? expectedURL : "Error occurred", result);
			}
		}
		@Test(priority = 4)
		public void testClickAddDispatchedDevice() {
			String testCaseName = "Test Add Device Model Button";
			String expectedURL = ConfigProperties.getProperty("add.device.model");
			String result = "";

			logger.info("Executing test case: {}", testCaseName);

			try {
				String actualURL = dispatchedDevice.clickAddDispatchedDevice();
				result = expectedURL.equalsIgnoreCase(actualURL) ? "PASS" : "FAIL";
				logger.info("Test case '{}' completed successfully. Expected URL: {}, Actual URL: {}", testCaseName,
						expectedURL, actualURL);
			} catch (Exception e) {
				logger.error("Error encountered in test case '{}'.", testCaseName, e);
				result = "FAIL";
			} finally {
				excelUtility.writeTestDataToExcel(testCaseName, expectedURL,
						result.equals("PASS") ? expectedURL : "Error occurred", result);
			}
		}
		
		@Test
	    public void testFileUpload() {
	        String filePath = "C:\\Users\\Dhananjay Jagtap\\Downloads\\Sample_Dispatch_Sheet (3).xlsx"; // Provide actual file path
//	        String uploadedFileName = fileUploadPage.uploadFile(filePath);

	        // Printing the uploaded file name (no assertions)
//	        System.out.println("Uploaded File Name: " + uploadedFileName);
	    }
		
		
		
}
	
