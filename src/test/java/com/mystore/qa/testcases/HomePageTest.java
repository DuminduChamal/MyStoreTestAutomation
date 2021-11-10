package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.LandingPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.WomenDressPage;

public class HomePageTest extends TestBase {
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	WomenDressPage womenDressPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		loginPage = landingPage.directToLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void HomePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "My account - My Store", "Home Page title not matched");
	}
	
	@Test(priority=2)
	public void HomePageUserNameTest() {
		boolean flag = homePage.validateHomePage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void directToWomenDressPageTest() {
		womenDressPage = homePage.directToWomenDressPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
