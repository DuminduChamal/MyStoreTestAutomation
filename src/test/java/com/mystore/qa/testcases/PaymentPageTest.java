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
import com.mystore.qa.pages.OrderSummaryPage;
import com.mystore.qa.pages.PaymentPage;
import com.mystore.qa.pages.PrintedDressPage;
import com.mystore.qa.pages.ShippingPage;
import com.mystore.qa.pages.ShoppingCartSummaryPage;
import com.mystore.qa.pages.WomenDressPage;

public class PaymentPageTest extends TestBase {
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	WomenDressPage womenDressPage;
	PrintedDressPage printedDressPage;
	ShoppingCartSummaryPage shoppingCartSmmaryPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	
	public PaymentPageTest() {
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
		paymentPage = shippingPage.proceedToCheckout();
	}
	
	@Test(priority=1)
	public void PaymentPageTitleTest() {
		String title = paymentPage.validatePaymentPageTitle();
		Assert.assertEquals(title, "Order - My Store");
	}
	
	@Test(priority=2)
	public void PaymentPageValidateTest() {
		boolean flag = paymentPage.validatePaymentPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void ProceedToCheckoutTest() {
		orderSummaryPage = paymentPage.proceedToCheckout();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
