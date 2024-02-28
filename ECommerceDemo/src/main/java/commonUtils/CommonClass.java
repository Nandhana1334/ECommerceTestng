package commonUtils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import org.json.JSONObject;
import java.nio.file.Files;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

//import com.google.common.io.Files;

public class CommonClass {
	
	protected static WebDriver driver;
	 static Properties prop;
	 @BeforeTest
	   public static void setup() 
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

	

	 
	
	public  static String readCredentials(String excelSheet,String credentials)
	{
		String name="";
		String dataPath = System.getProperty("user.dir") + "//src//test//resources//testData//Data.xlsx";
		
		FileInputStream fin;
		XSSFWorkbook workbook=null;
		try {
		    fin = new FileInputStream(dataPath);
		    workbook = new XSSFWorkbook(fin);
		} catch (IOException e) {
		    e.printStackTrace();
		}

		XSSFSheet loginSheet=workbook.getSheet(excelSheet);
		int numRows=loginSheet.getLastRowNum();
		
		for(int i=0;i<numRows+1;)
		{
	
			XSSFRow row=loginSheet.getRow(i);
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(credentials))
			{
				name=row.getCell(1).getStringCellValue();
			}
			i=i+1;
		}
		
		return name;
		
		
	}
	
	
	public static void type(String excelSheet,WebElement element,String credentials)
	{
		element.sendKeys(CommonClass.readCredentials( excelSheet,credentials));
	}
	public static void clickElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		//element.click();
	}
	public static String getTextOfElement(WebElement element)
	{
		return element.getText();
		
	}
   

	
	 public static String getLocatorFromJson(String path,String locator,String locatorType) {
	        //String path = System.getProperty("user.dir") + "//src//test//resources//locators//login.json";
	        String jsonData = null;
	        String value = null;

	        try {
	            jsonData = new String(Files.readAllBytes(Paths.get(path)));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        if (jsonData != null) {
	            try {
	                JSONObject jsonObject = new JSONObject(jsonData);
	                JSONObject emailField = jsonObject.getJSONObject(locator);

	                if (locatorType.equalsIgnoreCase("id")) {
	                   value= emailField.getString("id");
	                } else if (locatorType.equalsIgnoreCase("cssSelector")) {
	                    value= emailField.getString("cssSelector");
	                } else if (locatorType.equalsIgnoreCase("xpath")) {
	                   value= emailField.getString("xpath");
	                } else {
	                   value= null; 
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	                 
	            }
	        } else {
	            
	           System.out.println("JSON file is empty");
	          
	        }
	        return value;
	    }

//	 public static String pwdLocator(String locatorType) {
//	        String path = System.getProperty("user.dir") + "//src//test//resources//locators//login.json";
//
//	        try {
//	            
//	            String jsonString = new String(Files.readAllBytes(Paths.get(path)));
//	            
//	            
//	            JSONObject jsonObject = new JSONObject(jsonString);
//	            
//	            
//	            JSONObject pwdField = jsonObject.getJSONObject("passwordField");
//
//	            
//	            if (locatorType.equalsIgnoreCase("id")) {
//	                return pwdField.getString("id");
//	            } else if (locatorType.equalsIgnoreCase("xpath")) {
//	                return pwdField.getString("xpath");
//	            } else {
//	                return null;
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            return null;
//	        }
//	    }
//	 
//	 public static String loginBtnLocator(String locatorType) {
//	        String path = System.getProperty("user.dir") + "//src//test//resources//locators//login.json";
//
//	        try {
//	            String jsonString = new String(Files.readAllBytes(Paths.get(path)));
//	            JSONObject jsonObject = new JSONObject(jsonString);
//	            JSONObject loginBtn = jsonObject.getJSONObject("loginButton");
//
//	            switch (locatorType.toLowerCase()) {
//	                case "id":
//	                    return loginBtn.getString("id");
//	                case "cssselector":
//	                    return loginBtn.getString("cssSelector");
//	                case "xpath":
//	                    return loginBtn.getString("xpath");
//	                case "name":
//	                    return loginBtn.getString("name");
//	                default:
//	                    return null;
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            return null;
//	        }
//	    }
//	 public static String loginBtnLocator(String locatorType) {
//	        String path = System.getProperty("user.dir") + "//src//test//resources//locators//login.json";
//
//	        try {
//	            String jsonString = new String(Files.readAllBytes(Paths.get(path)));
//	            JSONObject jsonObject = new JSONObject(jsonString);
//	            JSONObject loginBtn = jsonObject.getJSONObject("loginButton");
//
//	            if (locatorType.equalsIgnoreCase("id")) {
//	                return loginBtn.getString("id");
//	            } else if (locatorType.equalsIgnoreCase("cssSelector")) {
//	                return loginBtn.getString("cssSelector");
//	            } else if (locatorType.equalsIgnoreCase("xpath")) {
//	                return loginBtn.getString("xpath");
//	            } else if (locatorType.equalsIgnoreCase("name")) {
//	                return loginBtn.getString("name");
//	            } else {
//	                return null;
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            return null;
//	        }
//	    }
//
//	    public static String signoutBtnLocator(String locatorType) {
//	        String path = System.getProperty("user.dir") + "//src//test//resources//locators//login.json";
//
//	        try {
//	            String jsonString = new String(Files.readAllBytes(Paths.get(path)));
//	            JSONObject jsonObject = new JSONObject(jsonString);
//	            JSONObject signoutBtn = jsonObject.getJSONObject("signoutButton");
//
//	            if (locatorType.equalsIgnoreCase("xpath")) {
//	                return signoutBtn.getString("xpath");
//	            } else {
//	                return null;
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            return null;
//	        }
//	    }

	public static WebElement locateElement(String path,String element,String locatorType)
	{
		
		String locator =getLocatorFromJson(path,element, locatorType);
		WebElement element1 =null;
		switch(locatorType)
		{
		case "xpath":
			element1=driver.findElement(By.xpath(locator));
			break;
				
		case "id":
			element1=driver.findElement(By.id(locator));
			break;
		case "name":
			element1=driver.findElement(By.name(locator));
			break;
		case "cssSelector":
			element1=driver.findElement(By.cssSelector(locator));
//			driver.findElement(By.cssSelector(locatorType));
			break;
		default:
			System.out.println("No locator found");
			break;
			
			
		}
		return element1;
	}
	
//	public static void actions(WebElement element ,String input,String credentials)
//	{
//		
//		switch(input)
//		{
//		case "click":
//			element.click();
//		case "getText":
//			element.getText();
//		case "sendkeys":
//			element.sendKeys(CommonClass.readCredentials(credentials));
//		
//			
//		}
		
		
		
		
	}
	
	

	


