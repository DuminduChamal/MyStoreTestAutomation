package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.LandingPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.PrintedDressPage;
import com.mystore.qa.pages.ShoppingCartSummaryPage;
import com.mystore.qa.pages.WomenDressPage;

public class PrintedDressPageTest extends TestBase {
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	WomenDressPage womenDressPage;
	PrintedDressPage printedDressPage;
	ShoppingCartSummaryPage shoppingCartSummaryPage;
	
	public PrintedDressPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		loginPage = landingPage.directToLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		womenDressPage = homePage.directToWomenDressPage();
		printedDressPage = womenDressPage.addOneItemAndViewOneItem();
	}
	
	@Test(priority=1)
	public void PrinteDressPageTitleTest() {
		String title = printedDressPage.validatePrintedDressPageTitle();
		Assert.assertEquals(title, "Printed Summer Dress - My Store");
	}
	
	@Test(priority=2)
	public void PrintedDressPageValidateTest() {
		boolean flag = printedDressPage.validatePrintedDressPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void AddItemAndProceedToCheckoutTest() {
		shoppingCartSummaryPage = printedDressPage.addItemAndProceedToCheckout();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
