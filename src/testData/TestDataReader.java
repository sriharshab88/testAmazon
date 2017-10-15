package testData;

import libraries.PropertiesReader;

public class TestDataReader {
	
	private static PropertiesReader propertiesReader = new PropertiesReader();
	
	public static String email = propertiesReader.getUserName();
	public static String password = propertiesReader.getPassword();
	public static String signInAssertion = propertiesReader.getsignInAssertion();
	public static String signInAssertionFailMessage = propertiesReader.getsignInAssertionFailMessage();
	public static String myAccountAssertion = propertiesReader.getmyAccountAssertion();
	public static String myAccountAssertionFailMessage = propertiesReader.getmyAccountAssertionFailMessage();

}
