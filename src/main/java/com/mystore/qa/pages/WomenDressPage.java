package com.mystore.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.utils.TestUtil;

public class WomenDressPage extends TestBase{

	@FindBy(xpath="//strong[contains(text(),'You will find here all woman fashion collections.')]")
	@CacheLookup
	WebElement womenTag;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[2]")
	@CacheLookup
	WebElement selectCard1;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[6]/div/div[2]")
	@CacheLookup
	WebElement selectCard2;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
	@CacheLookup
	WebElement addToCartBtn1;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
	@CacheLookup
	WebElement continueShoppingBtn;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[6]/div/div[2]/div[2]/a[2]/span")
	@CacheLookup
	WebElement moreBtn;
	
	@FindBy(xpath="//a/span[contains(@class,'ajax_cart_quantity')]")
	@CacheLookup
	WebElement oneProductTag;
	
	@FindBy(xpath="//a/span[contains(@class,'ajax_cart_no_product')]")
	@CacheLookup
	WebElement initialCount;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	@CacheLookup
	WebElement addToCartBtn;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	@CacheLookup
	WebElement proceedToCheckOutBtn;
	
	Actions actions = new Actions(driver);
	
	//Initialization
	public WomenDressPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateWomenDressPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateWomenDressPage(){
		return womenTag.isDisplayed();
	}
	
	public PrintedDressPage addOneItemAndViewOneItem() {
	    actions.moveToElement(selectCard1).perform();
		addToCartBtn1.click();
		continueShoppingBtn.click();
		actions.moveToElement(selectCard2).perform();
		moreBtn.click();
		return new PrintedDressPage();
	}
	
	public String getInitialCountInCart() {
		String count = initialCount.getText();
		System.out.println(count);
		return count;
	}
	
	public String getTheCountInCart() {
		String count = oneProductTag.getText();
		System.out.println(count);
		return count;
	}
	
	public ShoppingCartSummaryPage addTwoItems(String item1, String item2) {
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+item1+"') and @class='product-name']"))).perform();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		addToCartBtn.click();
//		driver.findElement(By.xpath("//a[@title='Add to cart']//span[contains(text(),'Add to cart')]")).click();
		System.out.println("Here1");
		continueShoppingBtn.click();
		System.out.println("Here2");
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+item1+"') and @class='product-name']"))).perform();
		System.out.println("Here3");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("Hereee");
		addToCartBtn.click();
//		driver.findElement(By.xpath("//a[@title='Add to cart']//span[contains(text(),'Add to cart')]")).click();
		System.out.println("Here4");
		proceedToCheckOutBtn.click();
		return new ShoppingCartSummaryPage();	
	}

}
	
	
