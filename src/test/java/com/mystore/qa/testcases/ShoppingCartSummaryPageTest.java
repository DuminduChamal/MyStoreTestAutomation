package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.AddressPage;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.LandingPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.PrintedDressPage;
import com.mystore.qa.pages.ShoppingCartSummaryPage;
import com.mystore.qa.pages.WomenDressPage;

public class ShoppingCartSummaryPageTest extends TestBase {
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	WomenDressPage womenDressPage;
	PrintedDressPage printedDressPage;
	ShoppingCartSummaryPage shoppingCartSmmaryPage;
	AddressPage addressPage;
	
	public ShoppingCartSummaryPageTest() {
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
		shoppingCartSmmaryPage = printedDressPage.addItemAndProceedToCheckout();
	}
	
	@Test(priority=1)
	public void PrinteDressPageTitleTest() {
		String title = shoppingCartSmmaryPage.validateShoppingCartSummaryPageTitle();
		Assert.assertEquals(title, "Order - My Store");
	}
	
	@Test(priority=2)
	public void PrintedDressPageValidateTest() {
		boolean flag = shoppingCartSmmaryPage.validateShoppingCartSummaryPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void TwoProductsTest() {
		boolean flag = shoppingCartSmmaryPage.validateTwoProductsInShoppingCartSummaryPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void ExactTwoProductsTest() {
		boolean flag2 = shoppingCartSmmaryPage.validateTwoProducts();
		Assert.assertTrue(flag2);
	}
	
	@Test(priority=5)
	public void ProceedToCheckoutTest() {
		addressPage = shoppingCartSmmaryPage.proceedToCheckout();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
