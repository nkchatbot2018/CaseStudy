package step_Defenition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Definition {
	
	WebDriver driver;
	
	@Given("User is on Registration Page")
	public void user_is_on_registration_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NandakumarN\\Desktop\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Sign up!')]")).click();
	}


	@Given("User Enters firstname {string}")
	public void user_enters_firstname(String Fname) {
	    driver.findElement(By.id("registration_firstname")).sendKeys(Fname);
	}
	@Given("User Enters lastname {string}")
	public void user_enters_lastname(String Lname) {
		driver.findElement(By.id("registration_lastname")).sendKeys(Lname);
	}
	@Given("User Enters email {string}")
	public void user_enters_email(String email) {
		driver.findElement(By.id("registration_email")).sendKeys(email);
	}
	@Given("User Enters username {string}")
	public void user_enters_username(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	@Given("User Enters password {string}")
	public void user_enters_password(String pwd) {
		driver.findElement(By.id("pass1")).sendKeys(pwd);
	}
	@Given("Usre Enters confirmpwd {string}")
	public void usre_enters_confirmpwd(String cpwd) {
		driver.findElement(By.id("pass2")).sendKeys(cpwd);
	}
	@When("User clicks on Register button")
	public void user_clicks_on_register_button() {
		driver.findElement(By.id("registration_submit")).click();
	}
	@Then("User should see his name {string}")
	public void user_should_see_his_name(String LoginName) {
	    String Expected = LoginName;	    
	    String Actual = driver.findElement(By.xpath("//img[@class='img-circle']")).getAttribute("alt");
	    System.out.println();
	    Assert.assertEquals(Expected, Actual);
	    System.out.println("Sign in completed successfully");
	
	}
	@Then("User clicks on Compose")
	public void user_clicks_on_compose() {
		driver.findElement(By.xpath("//img[@class='img-circle']")).click();
		driver.findElement(By.xpath("//a[@title='Inbox']")).click();
		driver.findElement(By.xpath("//img[@alt='Compose message']")).click();
	}
	@Then("User enters recipient {string}")
	public void user_enters_recipient(String recipient) throws InterruptedException {
	    driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(recipient);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//ul[@class='select2-results__options']/child::li[1]")).click();
	}
	@Then("User enters subject {string}")
	public void user_enters_subject(String subject) {
	   driver.findElement(By.id("compose_message_title")).sendKeys(subject);
	}
	@Then("User enters message")
	public void user_enters_message() throws InterruptedException {	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='cke_button_icon cke_button__inserthtml_icon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@class='cke_dialog_ui_input_textarea ']")).sendKeys("Hi Candidate"+Keys.ENTER + "This is a test email"+Keys.ENTER + "Thanks"+Keys.ENTER +"ABC");
		driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
	}
	@When("User Clicks Send button")
	public void user_clicks_send_button() {
	    driver.findElement(By.id("compose_message_compose")).click();
	}
	@Then("User should see success {string}")
	public void user_should_see_success(String ExpMsg) throws InterruptedException {
	  
		String Expected = ExpMsg;
		String Actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		if(Actual.contains(Expected)) {
			System.out.println("Email sent successfully");
			Thread.sleep(5000);
		}else {
			System.out.println("Email was not sent");
		}
	
	}
	@When("Uer Clicks on Logout")
	public void uer_clicks_on_logout() {
		driver.findElement(By.xpath("//img[@class='img-circle']")).click();
		driver.findElement(By.id("logout_button")).click();
		
	}
	@Then("User should be logged out")
	public void user_should_be_logged_out() {
	    if(driver.findElement(By.xpath("//a[@title='Homepage']")).isDisplayed()) {
	    	System.out.println("User successfully logged out");
	    	driver.close();
	    	System.out.println("Test Execution completed");
	    }
	}


}
