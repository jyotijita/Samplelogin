package Stedefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepdefinition {
	WebDriver driver;                      // Webdriver is used to control and interact with web browsers and I have declared with driver variable 

    By LoginUsername = By.id("username");  // By is a class in selenium that can be used to locate web elements on a web page.

    By LoginPassword = By.name("session_password");

    By LoginSUbmit = By.xpath("//button[@aria-label='Sign in']");
    By ErrorMessageforUsername = By.xpath("//div[@id='error-for-username']");
    By ErrorMessageforPassword = By.xpath("//div[@id='error-for-password']");

    @Before
    public void browserSetup() {
       // System.setProperty("Webdriver.chrome.driver", "C:\\Users\\sparv\\Downloads\\chromedriver_win32");
        driver  = new FirefoxDriver();                 // Initializing firefox driver using webdriver
        driver.manage().window().maximize();           // we maximizing the window
        driver.get("https://www.linkedin.com/login");  // driver.get methid is used to Navigate to the linkdIn in login page
    }

    @After
    public void ShutDown() {
        driver.quit();  						//driver.quit method is used to close the web browser window that the webdriver instance currently controlling
    }
	
	@Given("I am on the Linkedin login page")
	public void i_am_on_the_Linkedin_login_page() {
		System.out.println(driver.getTitle());                     // driver.gettitle method is used to get the title of the current web page 
       Assert.assertTrue(driver.getTitle().contains("Sign in"));  //Assert.assertTrue() will be used validate the given condition, if the condition is pass,  
       														   // then only execution of the test continues , otherewise it will stop the execution
       
	}

	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {
       driver.findElement(LoginUsername).sendKeys("testauto1326@gmail.com");    // we using findElement method to locate the web element and  using sendkeys method to pass the user credentials 
       driver.findElement(LoginPassword).sendKeys("jodan1326");
	}
	
	@When("I Click on signin button")
	public void i_click_on_signin_button() {
		 driver.findElement(LoginSUbmit).click();  				// here we are using click method to click the Signin button
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
	    String GetTitle = driver.getTitle();
	    Assert.assertTrue(GetTitle.contains("LinkedIn"));   	// here also we are assert condition to validate the Linkedin home page
	}

	@When("I enter wrong username and  correct password credentials")
	public void i_enter_wrong_username_and_correct_password_credentials() {
		 driver.findElement(LoginUsername).sendKeys("testauto");     // here we are passing wrong username and correct password
	     driver.findElement(LoginPassword).sendKeys("jodan1326");		
	}
	
	@When("I enter correct username and  wrong password credentials")
	public void i_enter_correct_username_and_wrong_password_credentials() {
		 driver.findElement(LoginUsername).sendKeys("testauto1326@gmail.com");    // here we are passing correct username and wrong password
	     driver.findElement(LoginPassword).sendKeys("password");
	}

	@Then("I should be able to see and validate the error message for the username field")
	public void i_should_be_able_to_see_and_validate_the_error_message_for_the_username_field() throws InterruptedException {
		String ActualErrormessage = driver.findElement(ErrorMessageforUsername).getText(); // 
		String ExpectedErrormessage = "Please enter a valid username";
	    Thread.sleep(3000);
	    Assert.assertTrue(ExpectedErrormessage.equals(ActualErrormessage));
	}

	@Then("I should be able to see and validate the error message for password field")
	public void i_should_be_able_to_see_and_validate_the_error_message_for_password_field() throws InterruptedException {
		String ActualErrormessage = driver.findElement(ErrorMessageforPassword).getText();
		String ExpectedErrormessage = "Wrong email or password. Try again or create an account .";
	    System.out.println(ActualErrormessage);
	    Thread.sleep(3000);
	    Assert.assertTrue(ExpectedErrormessage.equals(ActualErrormessage));
	}
	


}
