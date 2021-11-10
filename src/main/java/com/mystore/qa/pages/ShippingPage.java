package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class ShippingPage extends TestBase {
	
	@FindBy(xpath="//h1[contains(text(),'Shipping')]")
	@CacheLookup
	WebElement shippingTag;
	
	@FindBy(xpath="//*[@id=\"cgv\"]")
	@CacheLookup
	WebElement checkBox;
	
	@FindBy(xpath="//*[@id=\"form\"]/p/button/span")
	@CacheLookup
	WebElement proceedBtn;
	
	
	//Initialization
	public ShippingPage (){
		PageFactory.initElements(driver, this);
	}
	
	public String validateShippingPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateShippingPage(){
		return shippingTag.isDisplayed();
	}
	
	public PaymentPage proceedToCheckout() {
		checkBox.click();
		proceedBtn.click();
		return new PaymentPage();
	}
}
