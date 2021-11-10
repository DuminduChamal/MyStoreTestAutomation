package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class ShoppingCartSummaryPage extends TestBase {
	
	@FindBy(xpath="//h1[contains(text(),'Shopping-cart summary')]")
	@CacheLookup
	WebElement shoppingCartSummaryTag;
	
	@FindBy(xpath="//h1[contains(text(),'Shopping-cart summary')]")
	@CacheLookup
	WebElement twoProductsTag;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]/span")
	@CacheLookup
	WebElement checkOutBtn;
	
	@FindBy(xpath="//*[@id=\"product_1_1_0_592083\"]/td[2]/p/a")
	@CacheLookup
	WebElement itemOne;
	
	@FindBy(xpath="//*[@id=\"product_6_42_0_592083\"]/td[2]/p/a")
	@CacheLookup
	WebElement itemTwo;
	
	
	//Initialization
	public ShoppingCartSummaryPage (){
		PageFactory.initElements(driver, this);
	}
	
	public String validateShoppingCartSummaryPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateShoppingCartSummaryPage(){
		return shoppingCartSummaryTag.isDisplayed();
	}
	
	public boolean validateTwoProductsInShoppingCartSummaryPage(){
		return twoProductsTag.isDisplayed();
	}
	
	public boolean validateTwoProducts(){
		if(itemOne.getText().equals("Faded Short Sleeve T-shirts") && itemTwo.getText().equals("Printed Summer Dress"))
			return true;
		else
			return false;
	}
	
	public AddressPage proceedToCheckout() {
		checkOutBtn.click();
		return new AddressPage();
	}
}
	
