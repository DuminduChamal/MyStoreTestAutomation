package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.LandingPage;
import com.mystore.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		loginPage = landingPage.directToLoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login - My Store", "Loging Page title not matched");
	}
	
	@Test(priority=2)
	public void loginPagelogoTest() {
		boolean form = loginPage.validateLoginPageForm();
		Assert.assertTrue(form);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
