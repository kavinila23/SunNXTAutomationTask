package org.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.pages.SignUpPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utilities.ExtentReport_Generation;
import org.utilities.UtilityClass;

public class TestAutomation extends UtilityClass {
	HomePage home;
	long starttime;
	long endtime;

	@BeforeClass
	private void start() {
		System.out.println("Excecution Started");
		ExtentReport_Generation.startReport();

	}

	@AfterClass
	private void end() {
		System.out.println("Excecution Completed");
		ExtentReport_Generation.endReport();

	}

	@BeforeMethod
	private void setUp() {
		starttime = System.currentTimeMillis();
		launchBrowser("chrome");
		launchUrl(getPropertValue("url"));
		implicitWait(20);

	}

	@AfterMethod
	private void tearDown(ITestResult res) throws IOException {
		ExtentReport_Generation.createLog(res);
		takeScreenShot(res.getName());
		closeBrowser();
		endtime = System.currentTimeMillis();
		System.out.println("Duration of Execurtion...." + (endtime - starttime));

	}

	@Test(enabled = true, priority = 1)
	private void testSignUp() {
		SignUpPage page = new SignUpPage();
		moveToElement(page.getSignInlogo());
		click(page.getSignInButton());
		click(page.getSignUpButton());
		sendKeys(page.getMobileNo(), "nilakavi968@gmail.com");
		sendKeys(page.getPassword(), "kavi@1234nila");
		sendKeys(page.getName(), "Kavipriya");
		selectByValue(page.getDropDownAge(), "18-25 Years");
		click(page.getGenderFemale());
		selectByText(page.getCountryDropDown(), "India");
		selectByText(page.getStateDropDown(), "Tamil Nadu");
		click(page.getTermsAndConditions());
		// click(page.getSignUpSubmit());

	}

	@Test(enabled = true, priority = 2)
	private void testLogin() throws InterruptedException {
		SignUpPage page = new SignUpPage();
		moveToElement(page.getSignInlogo());
		click(page.getSignInButton());
		LoginPage l = new LoginPage();
		sendKeys(l.getUsername(), getPropertValue("username"));
		sendKeys(l.getPassword(), getPropertValue("password"));
		click(l.getLoginButton());
		moveToElement(page.getSignInlogo());
		click(l.getProfile());
		Thread.sleep(2000);
		Assert.assertTrue(getText(l.getProfileName()).contains("Kavipriya"), "Verify the Valid Login Action");
	}

	@Test(enabled = true, priority = 3)
	private void testHomeMenuOptions() throws InterruptedException {
		home = new HomePage();

		boolean verifyMenuOption = home.verifyMenuOption();
		Assert.assertTrue(verifyMenuOption, "Verify Menu Option");

	}

	@Test(enabled = true, priority = 4)
	private void testLanguage() throws InterruptedException {
		home = new HomePage();
		boolean verifyAllLanguaeSelected = home.verifyAllLanguaeSelected();
		Assert.assertTrue(verifyAllLanguaeSelected, "Verify all languages Selected");

	}

	@Test(enabled = true, priority = 5)
	private void testChannelListEachLanguage() {
		home = new HomePage();
		home.getEachLanguageChannelList();

	}

}
