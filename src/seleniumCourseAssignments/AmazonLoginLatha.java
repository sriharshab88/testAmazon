package seleniumCourseAssignments;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AmazonLoginLatha {

	@Test
	public static void amazonLoginLatha() {
		
		if(System.getProperty("os.name").contains("Windows")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+File.separator+"geckodriver.exe");
			}
			else{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+File.separator+"geckodriver");	
			}
		WebDriver driver = new FirefoxDriver();    //Lunches Firefox browser
		Reporter.log("Firefox browser launched successfully", true);
		driver.get("https://www.amazon.in/");
		
		String title = driver.getTitle();//Get the window title
		Reporter.log("window title"+ title, true);
		
		String Url = driver.getCurrentUrl();
		Reporter.log("Window URL is "+ Url, true);
		
		WebElement signin = driver.findElement(By.xpath("//span[@class='nav-line-4'][contains(text(),'Your Orders')]"));
		String text = signin.getText();
		Reporter.log("signin button text is "+ text, true);
		signin.click();
		String signinTitle = driver.getTitle();
		
		Assert.assertEquals(signinTitle, "Amazon Sign In", "FAIL-- if Login text not displayed");
		
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("9740811277");
		Reporter.log("PASS email entered successfully"+ email, true);
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("Test@123");
		Reporter.log("PASS password entered successfully" + password, true);
		
		WebElement Loginbutton = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		Loginbutton.click();
		//Thread.sleep(5000);
		Reporter.log("PASS login to the application successfully"+ Loginbutton, true);
		
		WebElement Clickyourorder = driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']"));
		Clickyourorder.click();
		
		String youraccounttext = driver.findElement(By.xpath("//h1[contains(text(),'Your Account')]")).getText();
		
		Assert.assertEquals(youraccounttext, "Your Account", "FAIL -- if your account text not displyed");
		
		WebElement account = driver.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Your Orders')]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(account).build().perform();
		WebElement signOut = driver.findElement(By.xpath("//a[@id='nav-item-signout']"));
		action.moveToElement(signOut).click().build().perform();

		
		
		driver.close();
		
		


	}

}
