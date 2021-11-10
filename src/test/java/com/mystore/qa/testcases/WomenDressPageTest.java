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

public class WomenDressPageTest extends TestBase{
	
	String sheetName = "Items";
	
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	WomenDressPage womenDressPage;
	PrintedDressPage printedDressPage;
	ShoppingCartSummaryPage shoppingCartSummaryPage;
	
	public WomenDressPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		loginPage = landingPage.directToLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		womenDressPage = homePage.directToWomenDressPage();
	}
	
	@Test(priority=1)
	public void WomenDressPageTitleTest() {
		String title = womenDressPage.validateWomenDressPageTitle();
		Assert.assertEquals(title, "Women - My Store", "Women Dress Page title not matched");
	}
	
	@Test(priority=2)
	public void WomenDressPageValidateTest() {
		boolean flag = womenDressPage.validateWomenDressPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void addOneItemAndViewOneItemTest() {
		String initialCount = womenDressPage.getInitialCountInCart();
		if (initialCount.equals("(empty)")) {
			System.out.println("Test Passed! No items initially!");
		}
		else
		{
			System.out.println("Already something in the cart");
		}
		printedDressPage = womenDressPage.addOneItemAndViewOneItem();
		String count = womenDressPage.getTheCountInCart();
		if (count.equals("1")) {
			System.out.println("One item added to the cart");
		}
		else
		{
			System.out.println("Item did not added to the cart");
		}
	}
	
//	@DataProvider
//	public Object[][] getTestItemData(){
//		Object data[][] = TestUtil.getTestData(sheetName);
//		return data;
//	}	
//	
//	
//	@Test(priority=4, dataProvider ="getTestItemData")
//	public void AddToProductsAndCheckOut(String itm1, String itm2) {
//		shoppingCartSummaryPage = womenDressPage.addTwoItems(itm1, itm2);
//	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
