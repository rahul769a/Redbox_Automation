package com.redbox.testscripts;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.model.ConfigurationLibrary;

public class Sample {
static IOSDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigurationLibrary.deviceName);
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("udid",ConfigurationLibrary.UD_ID);
		capabilities.setCapability("platformVersion", ConfigurationLibrary.platform_version);
		capabilities.setCapability("bundleId", ConfigurationLibrary.Bundle_Id);
	    capabilities.setCapability("noReset","true");
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
		driver.findElement(By.name("Manage Location")).click();
		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name='Redbox']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name='Redbox']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")).sendKeys("Newyork");
		driver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Search");
		//List<MobileElement> test=   driver.findElements(By.xpath("//XCUIElementTypeTable"));
		System.out.println(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='LocationCell']")).getSize());
		//XCUIElementTypeButton[@name="Map Handle"]

	}

}
