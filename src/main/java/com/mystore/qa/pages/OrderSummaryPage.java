package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class OrderSummaryPage extends TestBase{
	
	@FindBy(xpath="//h1[contains(text(),'Order summary')]")
	@CacheLookup
	WebElement summeryTag;
	
	@FindBy(xpath="//h3[contains(text(),'Check payment')]")
	@CacheLookup
	WebElement checkTag;
	
	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button/span")
	@CacheLookup
	WebElement confirmBtn;
	
	
	
	//Initialization
	public OrderSummaryPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateOrderSummeryPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateOrderSummeryPage(){
		return summeryTag.isDisplayed();
	}
	
	public boolean validateCheckOrderSummeryPage(){
		return checkTag.isDisplayed();
	}
	
	public ConfirmationPage proceedToCheckout() {
		confirmBtn.click();
		return new ConfirmationPage();
	}
}
