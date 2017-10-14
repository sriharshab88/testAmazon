package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import libraries.GenericMethods;

public class MyAccountPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	
	public MyAccountPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		genericMethods = new GenericMethods(driver, wait);
	}
	
	public String getPageTitle() throws Exception {
		return genericMethods.getTextByXpath("//h1[@class='page-heading']", "FAIL - My Account page is not displayed");
	}
	
	public void clickSignOut() throws Exception {
		genericMethods.clickByXpath("//a[@class='logout']", "FAIL - Sign Out Button Did not Click Successfully");
		Reporter.log("PASS - Sign Out Button Clicked Successfully", true);
	}
}
