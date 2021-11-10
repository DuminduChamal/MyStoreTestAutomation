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
import com.mystore.qa.pages.PaymentPage;
import com.mystore.qa.pages.PrintedDressPage;
import com.mystore.qa.pages.ShippingPage;
import com.mystore.qa.pages.ShoppingCartSummaryPage;
import com.mystore.qa.pages.WomenDressPage;

public class ShippingPageTest extends TestBase{
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	WomenDressPage womenDressPage;
	PrintedDressPage printedDressPage;
	ShoppingCartSummaryPage shoppingCartSmmaryPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	
	public ShippingPageTest() {
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
		addressPage = shoppingCartSmmaryPage.proceedToCheckout();
		shippingPage = addressPage.proceedToCheckout();
	}
	
	@Test(priority=1)
	public void ShippingPageTitleTest() {
		String title = shippingPage.validateShippingPageTitle();
		Assert.assertEquals(title, "Order - My Store");
	}
	
	@Test(priority=2)
	public void ShippingPageValidateTest() {
		boolean flag = shippingPage.validateShippingPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void ProceedToCheckoutTest() {
		paymentPage = shippingPage.proceedToCheckout();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
