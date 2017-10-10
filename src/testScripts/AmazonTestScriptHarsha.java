package testScripts;

import java.io.File;

import org.eclipse.jetty.util.Loader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LoggingHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libraries.Utilities;

/**
 * This class file contains Test scripts
 * @author Sri harsha
 */
public class AmazonTestScriptHarsha{
	
	public static int i =0;
	WebDriver driver;
	Utilities utilities = new Utilities();

	@BeforeTest
	public void startBrowser() {
		driver = utilities.launchBrowser();
	}
	
	
	@Test(groups= {"Sanity", "Smoke"},enabled = true)
	public void webdriverCommands() {
				
		WebElement signIn = driver.findElement(By.xpath("//a[@class='login']")); //Find element using xpath
		String text = signIn.getText();  //Get the text of the webelement
		Reporter.log("Sign In button text is "+ text, true);  
		
		signIn.click();  //Clicks the web element
		String signInTitle = driver.getTitle();  //Gets the window title
		
		/**
		 * Verifies the Sign in Window Title with expected value using if..else statements
		 */
		if(signInTitle.equalsIgnoreCase("LOGIN - My Store")) {
			Reporter.log("PASS - Sign in page displayed successfully", true);
		}else {
			Reporter.log("FAIL - Sign in page did not display successfully", true);
		}
		
		/**
		 * Verifies the Sign in Window Title with expected value using TestNG assertions
		 */
		Assert.assertEquals(signInTitle, "Login - My Store", "FAIL - Sign in page did not display successfully");
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));  //Identify Email field
		email.sendKeys("testautomation88@test.com");  //Enter Email into the email field
		Reporter.log("PASS - Email entered Successfully", true);
		
		WebElement password = driver.findElement(By.id("passwd"));  //Identify Password field
		password.sendKeys("123456");   //Enter Password into the email field
		Reporter.log("PASS - Password entered Successfully", true);
		
		WebElement signInButton = driver.findElement(By.xpath("//button[@id='SubmitLogin']")); //Identify Sign In Button
		signInButton.click();  //Click the Sign In button
		Reporter.log("PASS - Sign in Button Clicked Successfully", true);
		
		String myAccountText = driver.findElement(By.xpath("//h1[@class='page-heading']")).
				getText();   //Identify My account text and fetch it
		
		/**
		 * Verifies the My Account text with the expected value using Test NG assertions
		 */
		Assert.assertEquals(myAccountText, "MY ACCOUNT", "FAIL - My Account page is not displayed");
		
		WebElement signOut = driver.findElement(By.xpath("//a[@class='logout']")); //Identify Sign Out Button
		signOut.click();  //Clicks Signout button
		Reporter.log("PASS - Sign Out Button Clicked Successfully", true);
	
	}
	
	@Test(groups = {"Regression"}, enabled = true)
	public void signInValidations() throws InterruptedException {
	
		
		String pageSource = driver.getPageSource();   //Get the Page source
		//Reporter.log("Page Source is"+ pageSource, true);
		
		WebElement signIn = driver.findElement(By.xpath("//a[@class='login']")); //Find element using xpath
		String text = signIn.getText();  //Get the text of the webelement
		Reporter.log("Sign In button text is "+ text, true);  
		
		signIn.click();  //Clicks the web element
		String signInTitle = driver.getTitle();  //Gets the window title
		
		WebElement signUp = driver.findElement(By.xpath("//input[@id='email_create']"));
		signUp.sendKeys("test.com");
		
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		Thread.sleep(3000);
		
		String errorMessage = driver.findElement(By.
				xpath("//div[@id='create_account_error']/ol")).getText();
		
		Assert.assertEquals(errorMessage, "Invalid email address.", "FAIL - Error message not displayed");
		
		driver.close();
	}
	
	@Test(groups = {"Sanity"}, invocationCount = 10)
	public static void testMethod()
	{
		
		Reporter.log("Test has run "+i+" times", true);
		i++;
	}
	
	@Test(groups = {"Regression"})
	public void webDriverCommandsContinue() {
		
		driver.manage().window().maximize(); //To maximize the browser window
		WebElement signIn = driver.findElement(By.xpath("//a[@class='login']")); //Find element using xpath
		String text = signIn.getText();  //Get the text of the webelement
		Reporter.log("Sign In button text is "+ text, true);  
		
		signIn.click();  //Clicks the web element
		
		driver.navigate().back(); //Navigates back to the previous page
		driver.navigate().forward(); //Navigates forward to next page
		driver.navigate().refresh(); //Refreshes the current page
		driver.navigate().
		to("http://automationpractice.com/index.php?id_category=3&controller=category");  //Navigates to specific page using the URL

		driver.close();
	}
	
	@Test
	public void timeOutCommands() {
	
		driver.manage().window().maximize(); //To maximize the browser window
		WebElement signIn = driver.findElement(By.xpath("//a[@class='login']")); //Find element using xpath
		String text = signIn.getText();  //Get the text of the webelement
		Reporter.log("Sign In button text is "+ text, true);  
		
		signIn.click();  //Clicks the web element
		
		WebElement signInForm = driver.findElement(By.xpath("//form[@id='login_form']"));   //Identifies the sign in Form in login page
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(signInForm));
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));  //Identify Email field
		email.sendKeys("testautomation88@test.com");  //Enter Email into the email field
		Reporter.log("PASS - Email entered Successfully", true);
		
		WebElement password = driver.findElement(By.id("passwd"));  //Identify Password field
		password.sendKeys("123456");   //Enter Password into the email field
		Reporter.log("PASS - Password entered Successfully", true);
		
		WebElement signInButton = driver.findElement(By.xpath("//button[@id='SubmitLogin']")); //Identify Sign In Button
		signInButton.click();  //Click the Sign In button
		Reporter.log("PASS - Sign in Button Clicked Successfully", true);
		
		driver.close();
		
	}
	
	@AfterTest
	public void endBrowser() {
		
	}
	
	

}
