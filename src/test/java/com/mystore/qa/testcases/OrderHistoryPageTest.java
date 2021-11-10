package com.mystore.qa.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.AddressPage;
import com.mystore.qa.pages.ConfirmationPage;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.LandingPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.OrderHistoryPage;
import com.mystore.qa.pages.OrderSummaryPage;
import com.mystore.qa.pages.PaymentPage;
import com.mystore.qa.pages.PrintedDressPage;
import com.mystore.qa.pages.ShippingPage;
import com.mystore.qa.pages.ShoppingCartSummaryPage;
import com.mystore.qa.pages.WomenDressPage;

public class OrderHistoryPageTest extends TestBase{
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
	ConfirmationPage confirmationPage;
	OrderHistoryPage orderHistoryPage;
	
	public OrderHistoryPageTest() {
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
		orderSummaryPage = paymentPage.proceedToCheckout();
		confirmationPage = orderSummaryPage.proceedToCheckout();
		orderHistoryPage = confirmationPage.backToOrders();
	}
	
	@Test(priority=1)
	public void OrderHistoryPageTitleTest() {
		String title = orderHistoryPage.validateOrderHistoryPageTitle();
		Assert.assertEquals(title, "Order history - My Store");
	}
	
	@Test(priority=2)
	public void OrderHistoryPageValidateTest() {
		boolean flag = orderHistoryPage.validateOrderHistoryPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void CheckTheDateOfOrderTest() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    Date date = new Date();
	    String today = formatter.format(date).toString();
	    System.out.println(today);
	    boolean flag2 = orderHistoryPage.validateDateOfPurchase(today);
	    Assert.assertTrue(flag2);
	}
	
	@Test(priority=4)
	public void DownLoadInvoiceTest() {
		orderHistoryPage.clickOnFirstOrder();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
