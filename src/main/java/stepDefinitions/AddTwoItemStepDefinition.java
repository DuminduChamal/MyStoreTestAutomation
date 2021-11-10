package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AddTwoItemStepDefinition {
	
	WebDriver driver;
	
	@Given("^user is already on Landing Page$")
	public void user_is_already_on_Landing_Page() {
		 System.setProperty("webdriver.chrome.driver","F:\\SQA\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://automationpractice.com/index.php?");
	}

	@When("^title of landing page is My Store$")
	public void title_of_landing_page_is_My_Store() {
		String title1 = driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals("My Store", title1);
	}
	
	@Then("^user clicks on sign in button$")
	public void user_clicks_on_sign_in_button() {
		WebElement signinBtn =
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", signinBtn);
	}
	
	@When("^title of login page is My Store Login$")
	public void title_of_login_page_is_My_Store_Login() {
		String title2 = driver.getTitle();
		System.out.println(title2);
		Assert.assertEquals("Login - My Store", title2);
	}
	
	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	 public void user_enters_username_and_password(String username, String password){
	 driver.findElement(By.name("email")).sendKeys(username);
	 driver.findElement(By.name("passwd")).sendKeys(password);
	 }
	
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		WebElement loginBtn =
		driver.findElement(By.xpath("//button[@name='SubmitLogin']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}

	@Then("^user is on home page$")
	 public void user_is_on_home_page(){
	 String title3 = driver.getTitle();
	 System.out.println(title3);
	 Assert.assertEquals("My account - My Store", title3);
	 }
	 
	@Then("^user clicks on WOMEN button$")
	public void user_clicks_on_WOMEN_button() {
		WebElement womenBtn =
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", womenBtn);
	}
	
	@When("^title of women page is Women My Store$")
	public void title_of_women_page_is_Women_My_Store() {
		String title4 = driver.getTitle();
		System.out.println(title4);
		Assert.assertEquals("Women - My Store", title4);
	}
	
	@Then("^user clicks on faded tshirt button$")
	public void user_clicks_on_faded_tshirt_button() {
		WebElement item1 =
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", item1);
	}
	
	@Then("^user clicks on add to cart$")
	public void user_clicks_on_add_to_cart() {
		WebElement addToCart1 =
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", addToCart1);
	}
	
	@Then("^user clicks on continue shopping$")
	public void user_clicks_on_continue_shopping() {
		WebElement ctnBtn =
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ctnBtn);
	}
	
	@Then("^user clicks on printed dress$")
	public void user_clicks_on_printed_dress() {
		WebElement dressBtn =
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[7]/div/div[2]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", dressBtn);
	}
	
	@Then("^user clicks on more button$")
	public void user_clicks_on_more_button() {
		WebElement moreBtn =
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[7]/div/div[2]/div[2]/a[2]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", moreBtn);
	}
	
	@When("^title of printed dress page is Printed Chiffon Dress My Store$")
	public void title_of_printed_dress_page_is_Printed_Chiffon_Dress_My_Store() {
		String title5 = driver.getTitle();
		System.out.println(title5);
		Assert.assertEquals("Printed Chiffon Dress - My Store", title5);
	}
	
	@Then("^user clicks on add to cart button$")
	public void user_clicks_on_add_to_cart_button() {
		WebElement addToCart2 =
		driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", addToCart2);
	}
	
	@Then("^user clicks on proceed to checkout button$")
	public void user_clicks_proceed_to_checkout_button() {
		WebElement proceedBtn =
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", proceedBtn);
	}
	
	@When("^title of order page is Order My Store$")
	public void title_of_order_page_is_Order_My_Store() {
		String title6 = driver.getTitle();
		System.out.println(title6);
		Assert.assertEquals("Order - My Store", title6);
	}
	
	@Then("^user clicks on proceed to checkout button on order page$")
	public void user_clicks_proceed_to_checkout_button_on_order_page() {
		WebElement proceedBtn2 =
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", proceedBtn2);
	}
	
	@When("^title of address page is Order My Store$")
	public void title_of_address_page_is_Order_My_Store() {
		String title7 = driver.getTitle();
		System.out.println(title7);
		Assert.assertEquals("Order - My Store", title7);
	}
	
	@Then("^user clicks on proceed to checkout button on address page$")
	public void user_clicks_proceed_to_checkout_button_on_address_page() {
		WebElement proceedBtn3 =
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", proceedBtn3);
	}
	
	@When("^title of shipping page is Order My Store$")
	public void title_of_shipping_page_is_Order_My_Store() {
		String title8 = driver.getTitle();
		System.out.println(title8);
		Assert.assertEquals("Order - My Store", title8);
	}
	
	@Then("^user clicks on check box$")
	public void user_clicks_check_box() {
		driver.findElement(By.xpath("//*[@id=\"uniform-cgv\"]/span")).click();
	}
	
	@Then("^user clicks on proceed to checkout button on shipping page$")
	public void user_clicks_proceed_to_checkout_button_on_shipping_page() {
		WebElement proceedBtn4 =
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", proceedBtn4);
	}
	
	@When("^title of payment page is Order My Store$")
	public void title_of_payment_page_is_Order_My_Store() {
		String title9 = driver.getTitle();
		System.out.println(title9);
		Assert.assertEquals("Order - My Store", title9);
	}
	
	@Then("^user clicks on pay by check button$")
	public void user_clicks_pay_by_check_button() {
		WebElement payBtn =
		driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", payBtn);
	}
	
	@When("^title of order summary page is My Store$")
	public void title_of_order_summary_page_is_My_Store() {
		String title10 = driver.getTitle();
		System.out.println(title10);
		Assert.assertEquals("My Store", title10);
	}
	
	@Then("^user clicks on confirm button$")
	public void user_clicks_on_confirm_button() {
		WebElement confrimBtn =
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", confrimBtn);
	}
	
	@When("^title of order confirmation page is Order confirmation My Store$")
	public void title_of_order_confirmation_page_is_Order_confirmation_My_Store() {
		String title11 = driver.getTitle();
		System.out.println(title11);
		Assert.assertEquals("Order confirmation - My Store", title11);
	}
	
	@Then("^user clicks on back button$")
	public void user_clicks_on_back_button() {
		WebElement backBtn =
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", backBtn);
	}
	
	@When("^title of order history page is Order history My Store$")
	public void title_of_order_history_page_is_Order_history_My_Store() {
		String title12 = driver.getTitle();
		System.out.println(title12);
		Assert.assertEquals("Order history - My Store", title12);
	}
	
	@Then("^user clicks on pdf button$")
	public void user_clicks_on_pdf_button() {
		WebElement pdfBtn =
		driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[6]/a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", pdfBtn);
	}
	
	@Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
	 }
}
