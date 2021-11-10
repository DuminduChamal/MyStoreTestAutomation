package com.mystore.qa.pages;

import com.mystore.qa.base.TestBase;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends TestBase {

	@FindBy(xpath="//a[@class='login']")
	@CacheLookup
	WebElement signinBtn;
	
	//Initialization
	public LandingPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public LoginPage directToLoginPage() {
		signinBtn.click();
		return new LoginPage();
	}
}
