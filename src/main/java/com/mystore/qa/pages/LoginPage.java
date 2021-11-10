package com.mystore.qa.pages;

import com.mystore.qa.base.TestBase;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{

	@FindBy(xpath="//input[@id='email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//input[@id='passwd']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//button[@name='SubmitLogin']")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath="//form[@id='login_form']")
	@CacheLookup
	WebElement loginForm;
	
	
	//Initialization
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateLoginPageForm(){
		return loginForm.isDisplayed();
	}
	
	public HomePage login(String name, String pd) {
		email.sendKeys(name);
		password.sendKeys(pd);
		loginBtn.click();
		
		return new HomePage();
	}
}
