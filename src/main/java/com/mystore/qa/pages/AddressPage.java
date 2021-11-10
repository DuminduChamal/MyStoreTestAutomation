package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class AddressPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"ordermsg\"]/textarea")
	@CacheLookup
	WebElement textBox;
	
	@FindBy(xpath="//h1[contains(text(),'Addresses')]")
	@CacheLookup
	WebElement addressTag;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button/span")
	@CacheLookup
	WebElement proceedBtn;
	
	
	//Initialization
	public AddressPage (){
		PageFactory.initElements(driver, this);
	}
	
	public String validateAddressPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateAddressPage(){
		return addressTag.isDisplayed();
	}
	
	public ShippingPage proceedToCheckout() {
		textBox.click();
		textBox.sendKeys("Please come to this address and ring 0112344678.");
		proceedBtn.click();
		return new ShippingPage();
	}
}
