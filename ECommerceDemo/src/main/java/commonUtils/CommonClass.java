package commonUtils;

import java.io.File;

import java.io.FileInputStream;


import java.io.FileNotFoundException;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import org.json.JSONObject;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.*;

import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.reporter.*;

import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



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

	    protected ExtentReports extent;
	    protected ExtentTest test;

	    @BeforeTest
	    public void setupExtentReport() {
	        
	    	//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
	    	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
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
		//System.out.println(numRows);
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
		element.sendKeys(readCredentials( excelSheet,credentials));
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
	public static void clearField(WebElement element)
	{
		element.clear();
	}
	public boolean productDisplayed(WebElement element)
	{
		boolean value = element.isDisplayed();
		return value;
	}
   
    public void threadWait()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	 public static String getLocatorFromJson(String path,String locator,String locatorType) {
	
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
	                } 
	                else if (locatorType.equalsIgnoreCase("name")) {
		                   value= emailField.getString("name");
		                } 
	                else {
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
	public static String getScreenshotPath(WebDriver driver)
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		String srcFile=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File dest=new File(srcFile);
	    try
		{
			FileUtils.copyFile(src, dest);		
		}catch(IOException e)
	    {
			e.printStackTrace();
	    }
	
	return srcFile;
	}
	 
	    public void getResult(ITestResult result) {
	        
	        if (result.getStatus() == ITestResult.FAILURE) {
	            test.fail("Test Case Failed is " + result.getName());
	            test.fail("Test Case Failed is " + result.getThrowable());
	            String strPath=getScreenshotPath(driver);
	    	    test.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
	        } else if (result.getStatus() == ITestResult.SUCCESS) {
	            test.pass("Test Case Passed is " + result.getName());
	        } else if (result.getStatus() == ITestResult.SKIP) {
	            test.skip("Test Case Skipped is " + result.getName());
	        }
	    }

	    @AfterTest
	    public void tearDown() {
	      
	        extent.flush();
	    }
	@AfterTest
	public static void terminate()
	{
		driver.close();
	}

		
		
	}
	
	

	


