package libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
	
	public static String Url = "http://automationpractice.com/index.php";
	public static String testDataUrl = System.getProperty("user.dir")+File.separator+"src"+
										File.separator+"testData"+File.separator+"TestData";
}
