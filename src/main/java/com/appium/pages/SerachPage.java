package com.appium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.model.ExtLogger;

public class SerachPage {
	private ExtLogger log = new ExtLogger(SerachPage.class.toString());
	WebDriverWait wait;
	IOSDriver<MobileElement> driver;
	MorePage more;

	public SerachPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = (IOSDriver<MobileElement>) driver;
		wait = new WebDriverWait(driver, 100);		
	}	
	/*Elements in Login screen*/
	
	@iOSFindBy(xpath="//XCUIElementTypeApplication[@name='Redbox']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")
	public WebElement serachBar;
	
	
}
