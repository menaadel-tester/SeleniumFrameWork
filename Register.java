package ecoomerceproject;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register {
	
	ChromeDriver driver;
	
	@BeforeTest
	
	public void openurl() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");	
		

}
	
	@Test
	
	public void user_register() {
		
		WebElement register = driver.findElement(By.linkText("Register"));
		register.click();
		
		WebElement m = driver.findElement(By.id("gender-male"));
		m.click();
		WebElement fn = driver.findElement(By.id("FirstName"));
		fn.sendKeys("Mena");
		WebElement ln = driver.findElement(By.id("LastName"));
		ln.sendKeys("Adel");
		WebElement DOB = driver.findElement(By.name("DateOfBirthDay"));
		Select dob = new Select(DOB);
		dob.selectByValue("25");
		WebElement DOM = driver.findElement(By.name("DateOfBirthMonth"));
		Select dom = new Select(DOM);
		dom.selectByVisibleText("May");
		WebElement DOY = driver.findElement(By.name("DateOfBirthYear"));
		Select doy = new Select(DOY);
		doy.selectByValue("1987");
		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("menadl285@gmail.com");
		WebElement company = driver.findElement(By.id("Company"));
		company.sendKeys("EVAPharma");
		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys("M@m0102273135");
		WebElement confirm_pass = driver.findElement(By.id("ConfirmPassword"));
		confirm_pass.sendKeys("M@m0102273135");
		WebElement regbtn = driver.findElement(By.id("register-button"));
		regbtn.click();
		
		WebElement title = driver.findElement(By.tagName("h1"));
		
		boolean TITLE = title.isDisplayed();
		
		assertEquals(true, TITLE);
	}
	
	
	@Test(dependsOnMethods= {"user_register"})
	
	public void login_user() {
		
		WebElement login_button = driver.findElement(By.linkText("Log in"));
		login_button.click();
		WebElement e_mail = driver.findElement(By.id("Email"));
		e_mail.sendKeys("menadl285@gmail.com");
		WebElement pass_word = driver.findElement(By.id("Password"));
		pass_word.sendKeys("M@m0102273135");
		WebElement remember_me = driver.findElement(By.id("RememberMe"));
		remember_me.click();
		WebElement login = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
		login.click();
		
		WebElement message = driver.findElement(By.tagName("h2"));
		
		boolean Message = message.isDisplayed();
		assertEquals(true, Message);
	}
	
	
	
@Test(dependsOnMethods= {"login_user"})

public void user_select_item() {
	
	WebElement computer_link = driver.findElement(By.linkText("Computers"));
	
	Actions actions = new Actions(driver);
	actions.moveToElement(computer_link).perform();
	WebElement desk_top = driver.findElement(By.linkText("Desktops"));
	desk_top.click();
	WebElement add_desk_top_to_cart = driver.findElement(By.xpath("(//button[text()='Add to cart'])[3]"));
	add_desk_top_to_cart.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement Confirm_Message = driver.findElement(By.xpath("//p[text()='The product has been added to your ']"));
	
	boolean valid_Addition_Message = Confirm_Message.isDisplayed();
	assertEquals(valid_Addition_Message, true);
		
}

@Test(dependsOnMethods= {"user_select_item"})

public void continue_shopping() {
	
	WebElement close_btn = driver.findElement(By.xpath("//span[@title='Close']"));
	close_btn.click();
	WebElement shopping_cart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
	Actions actions = new Actions(driver);
	actions.moveToElement(shopping_cart).perform();
	WebElement Go_to_cart = driver.findElement(By.xpath("//button[text()='Go to cart']"));
	Go_to_cart.click();
	WebElement radio_term_btn = driver.findElement(By.id("termsofservice"));
	radio_term_btn.click();
	WebElement check_out = driver.findElement(By.id("checkout"));
	check_out.click();
	WebElement check_out_title = driver.findElement(By.tagName("h1"));
	
	String title = check_out_title.getTagName();
	
	assertEquals(title, "h1");	
}

@Test(dependsOnMethods= {"continue_shopping"})


public void billing_address() {
	
	// WebElement fn_billing = driver.findElement(By.id("BillingNewAddress_FirstName"));
	//fn_billing.clear();
	//fn_billing.sendKeys("Mena");
	//WebElement ln_billing = driver.findElement(By.name("BillingNewAddress.LastName"));
	//ln_billing.clear();
	//ln_billing.sendKeys("Beshay");
	//WebElement email_billing = driver.findElement(By.id("BillingNewAddress_Email"));
	//email_billing.clear();
	//email_billing.sendKeys("menadl285@gmail.com");
	//WebElement Company_billing = driver.findElement(By.id("BillingNewAddress_Company"));
	//Company_billing.sendKeys("EVA Pharma");
	//WebElement Country_billing = driver.findElement(By.id("BillingNewAddress_CountryId"));
	
	//Select country = new Select(Country_billing);
	//country.selectByVisibleText("Egypt");
	//WebElement state = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
	//Select state_billing = new Select(state);
	//state_billing.selectByVisibleText("Other");
	//WebElement city_billing = driver.findElement(By.id("BillingNewAddress_City"));
	//city_billing.sendKeys("AinShams");
	//WebElement address_billing = driver.findElement(By.id("BillingNewAddress_Address1"));
	//address_billing.sendKeys("17 abdelhakeemReda street");
	//WebElement zip = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
	//zip.sendKeys("71111");
	//WebElement phone_number = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
	//phone_number.sendKeys("01200088785");
	WebElement continue_btn = driver.findElement(By.xpath("//button[@onclick='Billing.save()']"));
	continue_btn.click();
	WebElement shipping_option = driver.findElement(By.id("shippingoption_2"));
	shipping_option.click();
	WebElement continue_shipping = driver.findElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));
	continue_shipping.click();
	WebElement payment_option = driver.findElement(By.id("paymentmethod_1"));
	payment_option.click();
	WebElement payment_continue_btn = driver.findElement(By.xpath("//button[@onclick='PaymentMethod.save()']"));
	payment_continue_btn.click();
	WebElement credit_card = driver.findElement(By.id("CreditCardType"));
	Select Master_Card = new Select(credit_card);
	Master_Card.selectByVisibleText("Master card");
	WebElement cardholder = driver.findElement(By.id("CardholderName"));
	cardholder.sendKeys("Mina Adel Makeen");
	WebElement cardnumber = driver.findElement(By.id("CardNumber"));
	cardnumber.sendKeys("4242424242424242");
	WebElement exp_month = driver.findElement(By.id("ExpireMonth"));
	Select Expiration_Date = new Select(exp_month);
	Expiration_Date.selectByVisibleText("09");
	WebElement exp_year = driver.findElement(By.id("ExpireYear"));
	Select Expiration_Year = new Select(exp_year);
	Expiration_Year.selectByVisibleText("2024");
	WebElement card_code = driver.findElement(By.id("CardCode"));
	card_code.sendKeys("971");
	WebElement continue_payment_option_btn = driver.findElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));
	continue_payment_option_btn.click();
	WebElement confirm_btn = driver.findElement(By.xpath("//button[@onclick='ConfirmOrder.save()']"));
	confirm_btn.click();
	WebElement submit_message = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
	 String Confirm_order_Message = submit_message.getText();
	 assertEquals(Confirm_order_Message, "Your order has been successfully processed!");
	
}
	
	
	@AfterTest
	
	public void close_url() {
		
		driver.quit();
		
		
	}
	
	
	
	
}
