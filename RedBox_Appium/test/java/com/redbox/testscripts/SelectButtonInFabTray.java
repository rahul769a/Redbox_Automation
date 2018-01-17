package com.redbox.testscripts;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.model.ApplicationLibrary;
import com.appium.model.CommonLibrary;
import com.appium.model.ConfigurationLibrary;
import com.appium.model.DataManager;
import com.appium.model.Reports;
import com.appium.pages.HomePage;
import com.appium.pages.LoginPage;
import com.appium.pages.SerachPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class SelectButtonInFabTray {
IOSDriver<MobileElement> driver;
LoginPage loginPage;
CommonLibrary comlib;
ApplicationLibrary applib;
Reports reports;
DataManager datamanager;
HomePage homePage;
String moduleName = "Select location";
String testCaseName = getClass().getSimpleName();
public void init() {
comlib = new CommonLibrary();
applib = new ApplicationLibrary();
reports = new Reports();
datamanager = new DataManager();
}

@BeforeClass
public void startUp() throws Exception {
init();
if(datamanager.executionController(testCaseName).equals("Yes")) {
reports.scriptStartTime = comlib.getCurrentTime();
reports.createFile(testCaseName);
driver = applib.launchIosdApplication(driver);
//Thread.sleep(2000);
} else {
System.out.println(testCaseName + " execution is skipped");
ConfigurationLibrary.skipCount++;
throw new SkipException(testCaseName + " execution is skipped");
}
}
@BeforeMethod
public void beforeTest(Method methodName) throws Exception {
reports.writeTestName(methodName.getName());
}
@Test
public void ManagelocationVerify() throws Exception {

try {
homePage = new HomePage(driver);
try {
Assert.assertTrue(homePage.locationIcon());
reports.writeIntoFile(driver, testCaseName,  " Verify Manage location icon ", "Manage location icon", "Manage location icon icon verified", reports.pass, "", comlib.getCurrentTime());
}
catch(Exception e)
{
reports.writeIntoFile(driver, testCaseName,  "Tap on Manage location icon ", " Manage location icon l is not displayed", " Manage location icon is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
//System.out.println("More Screen Not displayed" +e.getMessage());
Assert.fail();
} 


homePage.manageLocation();
SerachPage searchPage = new SerachPage(driver);
searchPage.sreachIconClick();
searchPage.searchIconSendText("chicago");
Thread.sleep(1000);
searchPage.scrollMaps();
try {
	Assert.assertTrue(searchPage.isDirectionButtonPresent());
reports.writeIntoFile(driver, testCaseName,  "Direction Button displayed", "Direction Button displayed", "Direction Button displayed", reports.pass, "", comlib.getCurrentTime());
}
catch(Exception e)
{
reports.writeIntoFile(driver, testCaseName,  "Direction Button is not displayed", "Direction Button is not displayed", "Direction Button is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
Assert.fail();
} 
try {
Assert.assertTrue(searchPage.isSelectButton());
reports.writeIntoFile(driver, testCaseName,  "Location Select Button is Displayed", "Location Select Button is Displayed", "Location Select Button is Displayed", reports.pass, "", comlib.getCurrentTime());
}
catch(Exception e)
{
reports.writeIntoFile(driver, testCaseName,  "Location Select Button is not Displayed", "Location Select Button is not Displayed", "Location Select Button is not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
Assert.fail();
}
searchPage.clickLocationButton();
Thread.sleep(2000);
try {
	Assert.assertTrue(searchPage.locationIconHomePageSelected());
	System.out.println("Location Get Selected is get Passed");
	Thread.sleep(1000);
reports.writeIntoFile(driver, testCaseName,  "Location Selection is Successfull", "Location Select Button is Displayed", "Location Select Button is Displayed", reports.pass, "", comlib.getCurrentTime());
}
catch(Exception e)
{
reports.writeIntoFile(driver, testCaseName,  "Location Selection is Failed", "Location is not Selected", "Location is not Selected", reports.fail, e.getMessage(), comlib.getCurrentTime());
Assert.fail();
}
} catch(Exception e) {
reports.writeIntoFile(driver, testCaseName, "Exception", "Tried performing action using iOS driver", "Exception occured", reports.fail, e.getMessage(), comlib.getCurrentTime());
Assert.fail("validation failed");
}
}
@AfterMethod
public void afterTest() throws Exception {
comlib.afterTestRun();
}

@AfterClass
public void tearDown() throws Exception {
comlib.afterScript(reports, moduleName, testCaseName);
driver.quit();
System.out.println(testCaseName + " execution completed.");

}
}