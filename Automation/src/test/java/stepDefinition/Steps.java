package stepDefinition;


import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

 

public class Steps {
	WebDriver driver;
	@Before
	public void beforetest()
	{
		WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	}
	
	@Given("I am able to navigate onto login page")
	public void i_am_able_to_navigate_onto_login_page() {
		
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("I enter the username as {string}")
	public void i_enter_the_username_as(String string) {
	   driver.findElement(By.id("txtUsername")).sendKeys(string);
	}

	@When("I enter the password as {string}")
	public void i_ebter_the_password_as(String string) {
		driver.findElement(By.id("txtPassword")).sendKeys(string);
	}

	@And("I click on the login button")
	public void i_click_on_the_login_button() throws InterruptedException {
	    driver.findElement(By.name("Submit")).click();
	    Thread.sleep(2000);
	}

	@SuppressWarnings("deprecation")
	@Then("I should see the username as {string}")
	public void i_should_see_the_username_as(String string) throws InterruptedException {
	    String expected= driver.findElement(By.id("welcome")).getText();
	    Assert.assertEquals(expected, string);
	    driver.findElement(By.id("welcome")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
	    Thread.sleep(5000);
	    driver.close();
	}
	@Then("I should see a Error message as {string}")
	public void i_should_see_a_error_message_as(String string) throws InterruptedException
	{
		String getErrorText=driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
		Assert.assertEquals("Valid login", getErrorText, "Invalid credentials");
		driver.close();
		Thread.sleep(5000);
	}
	    
	
}
