package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//span[contains(text(),'UCSC SQA')]")
	@CacheLookup
	WebElement nameTag;
	
	@FindBy(xpath="//a[@title='Women']")
	@CacheLookup
	WebElement womenBtn;
	
	
	
	//Initialization
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateHomePage(){
		return nameTag.isDisplayed();
	}
	
	public WomenDressPage directToWomenDressPage() {
		womenBtn.click();
		
		return new WomenDressPage();
	}
}
