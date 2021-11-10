package com.mystore.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.qa.base.TestBase;

public class PrintedDressPage extends TestBase{
	
	@FindBy(xpath="//h1[contains(text(),'Printed Summer Dress')]")
	@CacheLookup
	WebElement summerDressTag;
	
	@FindBy(xpath="//*[@id=\"color_8\"]")
	@CacheLookup
	WebElement colorChange;
	
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span")
	@CacheLookup
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	@CacheLookup
	WebElement checkOutBtn;
	
	
	Select drpSize = new Select(driver.findElement(By.name("group_1")));
	Actions actions = new Actions(driver);
	
	//Initialization
	public PrintedDressPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validatePrintedDressPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validatePrintedDressPage(){
		return summerDressTag.isDisplayed();
	}
	
	public ShoppingCartSummaryPage addItemAndProceedToCheckout() {
		drpSize.selectByVisibleText("L");
		colorChange.click();
		addToCartBtn.click();
		checkOutBtn.click();
		return new ShoppingCartSummaryPage();
	}
	
}
