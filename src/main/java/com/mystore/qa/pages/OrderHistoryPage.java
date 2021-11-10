package com.mystore.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class OrderHistoryPage extends TestBase{
	
	@FindBy(xpath="//h1[contains(text(),'Order history')]")
	@CacheLookup
	WebElement historyTag;
	
	
	@FindBy(xpath="//*[@id=\"order-list\"]/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement date;
	
	@FindBy(xpath="//*[@id=\"order-list\"]/tbody/tr[1]/td[6]/a")
	@CacheLookup
	WebElement pdfBtn;
	
	//Initialization
	public OrderHistoryPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateOrderHistoryPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateOrderHistoryPage(){
		return historyTag.isDisplayed();
	}
	
	public boolean validateDateOfPurchase(String purchaseDate){
		if(date.getText().equals(purchaseDate))
			return true;
		else
			return false;
	}
	
	public void clickOnFirstOrder() {
		pdfBtn.click();
		return;
	}
}
