package com.mystore.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.LandingPage;
import com.mystore.qa.pages.LoginPage;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class LandingPageTest extends TestBase {
	LoginPage loginPage;
	LandingPage landingPage;
	Logger log = Logger.getLogger(LandingPageTest.class);
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = landingPage.validateLoginPageTitle();
		log.info("Validating Landing Page!");
		log.info("Landing Page Title - "+title);
		Assert.assertEquals(title, "My Store", "Landing Page title not matched");
		log.info("This is a info log");
		log.warn("This is a warn log");
		log.fatal("This is a fata log");
		log.debug("This is a debug log");
	}
	
	@Test(priority=2)
	public void directToLoginPageTest() {
		loginPage = landingPage.directToLoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
