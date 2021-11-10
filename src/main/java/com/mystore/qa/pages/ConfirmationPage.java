package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class ConfirmationPage extends TestBase {
	@FindBy(xpath="//p[contains(text(),'Your order on My Store is complete.')]")
	@CacheLookup
	WebElement confirmationTag;
	
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a")
	@CacheLookup
	WebElement backBtn;
	
	//Initialization
	public ConfirmationPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateConfirmationPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateConfirmationPage(){
		return confirmationTag.isDisplayed();
	}
	
	public OrderHistoryPage backToOrders() {
		backBtn.click();
		return new OrderHistoryPage();
	}
	
}
