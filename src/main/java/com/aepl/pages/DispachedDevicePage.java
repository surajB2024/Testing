package com.aepl.pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aepl.util.CommonMethod;

public class DispachedDevicePage {

	// Global variables
		private final WebDriver driver;
		private final WebDriverWait wait;
		private CommonMethod commonMethod;
		private final Logger logger = LogManager.getLogger(DispachedDevicePage.class);
	
		
		private final By dropDown = By.xpath("//span[@class='headers_custom color_3D5772']");
		private final By DispatchedDevice = By.xpath("//a[@routerlink='dispatch-device-page']");
		private final By AddDispatchedDevice= By.xpath("//button[contains(.,'Add Dispatched Device')]");
		private final By ChooseFile= By.xpath("//button[contains(.,'Choose File')]");
		private CommonMethod uploadFileAndGetFileName;
		
		
	
	public DispachedDevicePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.commonMethod = new CommonMethod(driver);
		this.uploadFileAndGetFileName = new CommonMethod(driver);
	}
	
	

	// Methods Goes here
	public void clickNavBar() {
		List<WebElement> navBarLinks = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropDown));

		boolean isClicked = false;
		for (WebElement link : navBarLinks) {
			if (link.getText().equalsIgnoreCase("Device Utility")) {
				link.click();
				isClicked = true;
				break;
			}
		}
		if (!isClicked) {
			throw new RuntimeException("Failed to find and click on 'Device Utility' in the navigation bar.");
		}
	}

	public String clickDispatchedDevice() {
		// Click on the element 'Device Model' and return the current URL
		try {
			WebElement DispatchedDeviceLink = wait.until(ExpectedConditions.visibilityOfElementLocated(DispatchedDevice));
			DispatchedDeviceLink.click();
			return driver.getCurrentUrl();
		} catch (Exception e) {
			logger.error("Error while clicking on Device Model option.", e);
			throw new RuntimeException("Failed to click on Device Model option", e);
		}
	}
	
	public String clickAddDispatchedDevice() {
		// Click on the element 'Add Device Model' and return the current URL
		try {
			WebElement AddDispatchedDeviceBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AddDispatchedDevice));
			AddDispatchedDeviceBtn.click();
			return driver.getCurrentUrl();
		} catch (Exception e) {
			logger.error("Error while clicking on Add Device Model button.", e);
			throw new RuntimeException("Failed to click on Add Device Model button", e);
		}
	}
	
	public String clickChooseFile() {
		// Click on the element 'Add Device Model' and return the current URL
		try {
//			WebElement ChooseFileBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(commonMethod.uploadFileAndGetFileName()));
//			ChooseFileBtn.click();
			return driver.getCurrentUrl();
		} catch (Exception e) {
			logger.error("Error while clicking on Add Device Model button.", e);
			throw new RuntimeException("Failed to click on Add Device Model button", e);
		}
	}
	
	public String uploadFile(String filePath) {
//        return CommonMethod.uploadAndFetchFileName(filePath);
		return "";
    }
	
	
}
