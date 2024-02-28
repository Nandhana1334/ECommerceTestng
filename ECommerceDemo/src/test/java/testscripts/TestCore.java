package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;

public class TestCore {
	WebDriver driver;
	Properties prop;
	 @BeforeTest
	   public void setup() 
	   {
		   String path = System.getProperty("user.dir") + "//src//test//resources//configFiles//browserConfig.properties";
		   FileInputStream fin;
		   fin=null;
		   try {
			    fin = new FileInputStream(path);
			    prop = new Properties();
			    prop.load(fin);
			} 
		   catch (IOException e) {
			    
			    e.printStackTrace();
			}

		   String strBrowser = prop.getProperty("browser");
		   System.out.println("Browser name:.."+strBrowser);
		   if(strBrowser.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(strBrowser.equalsIgnoreCase("edge"))
			{
				
					driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("url"));
	   }

}
