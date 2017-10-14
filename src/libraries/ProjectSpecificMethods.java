package libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.SignInPageObject;

public class ProjectSpecificMethods {
	
	WebDriver driver;
	WebDriverWait wait;
	SignInPageObject signIn;
	
	public ProjectSpecificMethods(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		signIn = new SignInPageObject(driver, wait);
	}

	public void Login(String email, String password) throws Exception {		
		signIn.enterEmail(email);
		signIn.enterPassword(password);
		signIn.clickSignInButton();
		
	}
	
}
