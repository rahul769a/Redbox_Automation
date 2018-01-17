package com.appium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.model.ExtLogger;
public class HomePage {
	private ExtLogger log = new ExtLogger(HomePage.class.toString());
	WebDriverWait wait;
	IOSDriver<MobileElement> driver;

	public HomePage(IOSDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = (IOSDriver<MobileElement>) driver;
		wait = new WebDriverWait(driver, 40);
	}
	
	/*Element Present in Home screen and Splash Screen*/	
	@iOSFindBy(name="logo_large")
	public WebElement splashLogo;
	
	@iOSFindBy(name="In progress")
	public WebElement inProgress;
	
	
	/*Tabs in Home screen*/
	@iOSFindBy(accessibility="MORE")
	public WebElement moreTab;
	
	@iOSFindBy(name="BROWSE")
	public WebElement browseTab;
	
	@iOSFindBy(name="UPCOMING")
	public WebElement upcomingTab;
	
	@iOSFindBy(name="MY REDBOX")
	public WebElement myRedboxTab;
	
	@iOSFindBy(name="NEW")
	public WebElement newTab;
	
	/*New Release Tab*/
	@iOSFindBy(name="MOVIES")
	public WebElement moviesTab;
	
	@iOSFindBy(name="TV")
	public WebElement tvTab;
	
	@iOSFindBy(name="GAMES")
	public WebElement gamesTab;
	
	@iOSFindBy(name="Manage Location")
	public WebElement manageLocation;
	
	
	/*Display of Elements*/	
	public boolean splashLogo() throws InterruptedException
	{		
		wait.until(ExpectedConditions.visibilityOf(splashLogo));
		log.stepLog("Splash screen Dispalyed");;
		return splashLogo.isDisplayed();			
	}

	public boolean inProgress()	
	{
		wait.until(ExpectedConditions.visibilityOf(inProgress));
		log.stepLog("In Progress screen Dispalyed");;
		return inProgress.isDisplayed();		
	}
	public boolean moreTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(moreTab));
		log.stepLog("More Tab is Displayed");;
		return moreTab.isDisplayed();	
	}
	public boolean browseTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(browseTab));
		log.stepLog("Browse Tab is Displayed");;
		return browseTab.isDisplayed();	
	}
	public boolean myRedboxTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(myRedboxTab));
		log.stepLog("My Redbox Tab is Displayed");;
		return myRedboxTab.isDisplayed();	
	}
	public boolean upcomingTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(upcomingTab));
		log.stepLog("Upcoming Tab is Displayed");;
		return upcomingTab.isDisplayed();	
	}
	public boolean newTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(newTab));
		log.stepLog("New Tab is Displayed");;
		return newTab.isDisplayed();	
	}
	public boolean moviesTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(moviesTab));
		log.stepLog("Movies Tab is Displayed");;
		return moviesTab.isDisplayed();	
	}
	public boolean tvTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(tvTab));
		log.stepLog("TV Tab is Displayed");;
		return tvTab.isDisplayed();	
	}
	public boolean gamesTabDisplay()
	{
		wait.until(ExpectedConditions.visibilityOf(gamesTab));
		log.stepLog("Games Tab is Displayed");;
		return gamesTab.isDisplayed();	
	}
	
	/*Methods for Elements*/
	public void moreTab()
	{
		wait.until(ExpectedConditions.visibilityOf(moreTab));
		log.stepLog("Displayed");
		moreTab.click();
	}
	public void browseTab()
	{
		wait.until(ExpectedConditions.visibilityOf(browseTab));
		browseTab.click();
	}
	public void myRedboxTab()
	{
		wait.until(ExpectedConditions.visibilityOf(myRedboxTab));
		myRedboxTab.click();
	}
	public void upcomingTab()
	{
		wait.until(ExpectedConditions.visibilityOf(upcomingTab));
		upcomingTab.click();
	}
	public void newTab()
	{
		wait.until(ExpectedConditions.visibilityOf(newTab));
		newTab.click();
	}
	public void moviesTab()
	{
		wait.until(ExpectedConditions.visibilityOf(moviesTab));
		moviesTab.click();
	}
	public void tvTab()
	{
		wait.until(ExpectedConditions.visibilityOf(tvTab));
		tvTab.click();
	}
	public void gamesTab()
	{
		wait.until(ExpectedConditions.visibilityOf(gamesTab));
		gamesTab.click();
	}
	public void manageLocation()
	{
		wait.until(ExpectedConditions.visibilityOf(manageLocation));
		manageLocation.click();
	}
	
	
	}

