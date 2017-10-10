package testScripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AmazonLoginMadhukar {

	@Test
	public void Amazon(){
		// TODO Auto-generated method stub

		//Checking the OS and geckodriver 
		if(System.getProperty("os.name").contains("Windows")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+File.separator+"geckodriver.exe");
			}
			else{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+File.separator+"geckodriver");	
			}
		WebDriver driver = new FirefoxDriver();    //Lunches Firefox browser
		Reporter.log("Firefox browser launched successfully", true);
		
		driver.get("https://www.amazon.in/"); //Launch the Amazon URL in the browser
		String title = driver.getTitle();    //Get the Window title
		Reporter.log("Window title is : "+ title, true);
		String url = driver.getCurrentUrl();   //Get the Window URL
		Reporter.log("Window URL is : "+ url, true);
		
		//Verifies the Sign in Window Title with expected value using TestNG assertions
		Assert.assertEquals(title, "Online Shopping: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", 
				"FAIL - Window Tittle  page did not display successfully");
		
		WebElement signIn = driver.findElement(By.id("nav-link-yourAccount")); //Find Sign In web element
		String text = signIn.getText();  //Get the text of the web element
		Reporter.log("Sign In button text is : "+ text, true);  
		
		signIn.click();  //Clicks the web element
		String signInTitle = driver.getTitle();  //Gets the window title
		
		// Verifies the Sign in Window Title using if..else statements
		if(signInTitle.equalsIgnoreCase("Amazon Sign In")) {
			Reporter.log("PASS - Sign in page displayed successfully", true);
		}else {
			Reporter.log("FAIL - Sign in page did not display successfully", true);
		}
		
		WebElement login = driver.findElement(By.xpath("//h1[@class='a-spacing-small']"));
		String logInTitle = driver.getTitle();
		// Verifies the Login text using TestNG assertions
		Assert.assertEquals(logInTitle, "Amazon Sign In", "FAIL - Login Text did not display successfully");
		
		WebElement email = driver.findElement(By.id("ap_email"));  //Identify Email field
		email.sendKeys("8147808493");  //Enter Email into the email field
		Reporter.log("PASS - Email entered Successfully", true);
		
		WebElement password = driver.findElement(By.id("ap_password"));  //Identify Password field
		password.sendKeys("Madhu@87");   //Enter Password into the email field
		Reporter.log("PASS - Password entered Successfully", true);
		
		WebElement signInButton = driver.findElement(By.id("signInSubmit")); //Identify LogIn Button
		signInButton.click();  //Click the Sign In button
		Reporter.log("PASS - Sign in Button Clicked Successfully", true);
		
		String usernameText = driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']/span[1]")).
				getText();   //Identify My account text and fetch it
		
		// Verifies the My Account text with the expected value using Test NG assertions
		Assert.assertEquals(usernameText, "Hello, Madhukara", "FAIL - My Account page is not displayed");
		
			
		WebElement myAcc = driver.findElement(By.id("nav-link-yourAccount")); //Navigate to Your account page
		myAcc.click();  //Click the Sign In button
		Reporter.log("PASS - Your Account page displayed Successfully", true);
		
		WebElement signOut = driver.findElement(By.xpath("//a[@id='nav-item-signout']/span[@class='nav-text']")); //Identify Sign Out Button
		signOut.click();  //Clicks Signout button
		Reporter.log("PASS - Sign Out Button Clicked Successfully", true);
		
		driver.close();  //Closes the active Firefox browser
		Reporter.log("PASS - Firefox Browser Closed Successfully", true);
	}

}
