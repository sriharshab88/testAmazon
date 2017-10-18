package libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	Properties prop;
	public PropertiesReader() {
		
		File file = new File(Configurations.testDataPath);
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}

//***********************AmazonTestScriptHarsha*********************
	public String getUserName() {
		return prop.getProperty("email");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public String getsignInAssertion() {
		return prop.getProperty("signInAssertion");
	}
	
	public String getsignInAssertionFailMessage() {
		return prop.getProperty("signInAssertionMessage");
	}
	
	public String getmyAccountAssertion() {
		return prop.getProperty("myAccountAssertion");
	}
	
	public String getmyAccountAssertionFailMessage() {
		return prop.getProperty("myAccountAssertionMessage");
	}
//*************************************************************************	
	
}
