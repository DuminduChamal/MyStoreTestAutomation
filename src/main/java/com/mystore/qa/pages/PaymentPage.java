package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class PaymentPage extends TestBase {

	@FindBy(xpath="//h1[contains(text(),'Please choose your payment method')]")
	@CacheLookup
	WebElement paymentTag;
	
	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
	@CacheLookup
	WebElement paymentMethod;
	
	
	
	//Initialization
	public PaymentPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validatePaymentPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validatePaymentPage(){
		return paymentTag.isDisplayed();
	}
	
	public OrderSummaryPage proceedToCheckout() {
		paymentMethod.click();
		return new OrderSummaryPage();
	}
}
