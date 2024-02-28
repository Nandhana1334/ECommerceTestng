package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginTest {
	 WebDriver driver;
	 Properties prop;
	  
	   @BeforeTest
	   public void setup() throws IOException
	   {
		   String path = System.getProperty("user.dir") + "//src//test//resources//configFiles//browserConfig.properties";
		   FileInputStream fin = new FileInputStream(path);
		   prop = new Properties();
		   prop.load(fin);
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
	   

//	   @DataProvider(name="loginData")
//		public String readCredentials(String data )
//		{
//			String credentials="";
//			String dataPath = System.getProperty("user.dir") + "//src//test//resources//testData//Data.xlsx";
//			FileInputStream fin;
//			XSSFWorkbook workbook=null;
//			try {
//				fin=new FileInputStream(dataPath);
//				workbook=new XSSFWorkbook(fin);
//			}catch(FileNotFoundException e)
//			{
//				e.printStackTrace();
//			}
//			catch(IOException e)
//			{
//				e.printStackTrace();
//			}
//			XSSFSheet loginSheet=workbook.getSheet("loginData");
//			int numRows=loginSheet.getLastRowNum();
//			int numCol = loginSheet.getRow(0).getLastCellNum();
//			for(int i=1;i<=numRows;i++)
//			{
//				for(int j=0;j<numCol;j++)
//				{
//					
//				
//					XSSFRow row=loginSheet.getRow(i);
//				
//					credentials=row.getCell(j).getStringCellValue();
//				}
////				XSSFRow row=loginSheet.getRow(i);
////				Cell cell = row.getCell(1);
////				credentials = cell.getStringCellValue();
//				
//			}
//			
//			return credentials;
//		}
	   
//	   @DataProvider(name = "loginData")
//	   public Object[][] readCredentials() {
//	       String[][] credentials = null;
//	       String dataPath = System.getProperty("user.dir") + "//src//test//resources//testData//Data.xlsx";
//	       FileInputStream fin;
//	       XSSFWorkbook workbook = null;
//	       try {
//	           fin = new FileInputStream(dataPath);
//	           workbook = new XSSFWorkbook(fin);
//	       } catch (FileNotFoundException e) {
//	           e.printStackTrace();
//	       } catch (IOException e) {
//	           e.printStackTrace();
//	       }
//	       XSSFSheet loginSheet = workbook.getSheet("loginData");
//	       int numRows = loginSheet.getLastRowNum();
//	       credentials = new String[numRows][2];
//
//	       for (int i = 0; i <numRows-1; i++) {
//	           XSSFRow row = loginSheet.getRow(i+1);
//	           credentials[i][0] = row.getCell(1).getStringCellValue(); // assuming username is in column 1
//	           credentials[i][1] = row.getCell(1).getStringCellValue(); // assuming password is in column 2
//	       }
//
//	       return credentials;
//	   }
	   
	   
//	   @DataProvider(name = "loginData")
//	   public Object[][] readCredentials() {
//	       String[][] credentials = null;
//	       String dataPath = System.getProperty("user.dir") + "//src//test//resources//testData//Data.xlsx";
//	       FileInputStream fin;
//	       XSSFWorkbook workbook = null;
//	       try {
//	           fin = new FileInputStream(dataPath);
//	           workbook = new XSSFWorkbook(fin);
//	       } catch (FileNotFoundException e) {
//	           e.printStackTrace();
//	       } catch (IOException e) {
//	           e.printStackTrace();
//	       }
//	       XSSFSheet loginSheet = workbook.getSheet("loginData");
//	       int numRows = loginSheet.getLastRowNum();
//	       credentials = new String[numRows][2];
//	       XSSFRow row = loginSheet.getRow(1);
//	       credentials[1][0]= row.getCell(1).getStringCellValue();
//	       credentials[1][1]=row.getCell(1).getStringCellValue();
////	       for (int i = 0; i < numRows; i++) {
////	           XSSFRow row = loginSheet.getRow(i + 1); // Adjusted the row index
////	           credentials[i][0] = row.getCell(1).getStringCellValue(); // assuming username is in column 0
////	           credentials[i][1] = row.getCell(1).getStringCellValue(); // assuming password is in column 1
////	       }
//
//	       return credentials;
//	   }


			
	   @Test
		public void validLogin() throws FileNotFoundException, IOException, ParseException, InterruptedException
		{
		   String path = System.getProperty("user.dir") + "//src//test//resources//locators//login.json";
		   String dataPath = System.getProperty("user.dir") + "//src//test//resources//testData//Data1.xlsx";
		   
		   JSONParser jsonparse = new JSONParser();
		   JSONObject jsonobject = (JSONObject) jsonparse.parse(new FileReader(path));
		   
		   FileInputStream inputData = new FileInputStream(dataPath);
		   XSSFWorkbook workbook = new XSSFWorkbook(inputData);
		   XSSFSheet sheet = workbook.getSheetAt(0);
		   
		   Row mailRow = sheet.getRow(0);
		   Cell mailCell = mailRow.getCell(0);
		   String emailId = mailCell.getStringCellValue();
		   Row pwdRow = sheet.getRow(0);
		   Cell pwdCell= pwdRow.getCell(1);
		   String pwd = pwdCell.getStringCellValue();
		   
		   //System.out.println(pwdRow.getCell(0));
		   
		  

		   
		   String email = (String) jsonobject.get("emailInput");
		   String passwd = (String) jsonobject.get("passwordInput");
		   String loginBtn = (String)jsonobject.get("submitButton");
		   
		   driver.findElement(By.xpath(email)).clear();
		   
		   driver.findElement(By.xpath(email)).sendKeys(emailId);
		   driver.findElement(By.xpath(passwd)).clear();
		    driver.findElement(By.xpath(passwd)).sendKeys(pwd);
	        driver.findElement(By.xpath(loginBtn)).click();
	        Thread.sleep(3000);
	       boolean chk= driver.findElement(By.xpath("//button[contains(text(),'Sign Out')]")).isDisplayed();
	       Assert.assertTrue(chk);

		}
//	   
	   
//	   @DataProvider(name="loginData")
//		public String[][] getData() throws IOException
//		{
//			String path=System.getProperty("user.dir")+"//src//test//resources//testData//Data.xlsx";
//			FileInputStream fin=new FileInputStream(path);	
//			XSSFWorkbook workbook=new XSSFWorkbook(fin);
//			XSSFSheet sheet=workbook.getSheet("loginSheet");
//			int noOfRows=sheet.getLastRowNum();
//			System.out.println(noOfRows);
//			int noOfColumns=sheet.getRow(0).getLastCellNum();
//	 
//			String[][] data=new String[noOfRows][noOfColumns];
//			for(int i=0;i<noOfRows;i++) {
//				for(int j=0;j<noOfColumns;j++)
//				{
//					DataFormatter df=new DataFormatter();
//					data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
//					System.out.println(data[i][j]);
//				}
//			}
//			workbook.close();
//			fin.close();
//			return data;
//		}
//	   
//	   
//	   
//	   
//	   
//	 
//	   @Test(dataProvider = "loginData")
//	   public void validLogin(String username, String password) throws FileNotFoundException, IOException, ParseException {
//	      
//		   
//		   String path = System.getProperty("user.dir") + "//src//test//resources//locators//login.json";
//		  
//		   
//		   JSONParser jsonparse = new JSONParser();
//		   JSONObject jsonobject = (JSONObject) jsonparse.parse(new FileReader(path));
//	   
//
//	       System.out.println(username);
//	       System.out.println(password);
//	       String email = (String) jsonobject.get("emailInput");
//		   String passwd = (String) jsonobject.get("passwordInput");
//		   String loginBtn = (String)jsonobject.get("submitButton");
//		   
//		   
//		   driver.findElement(By.xpath(email)).sendKeys(username);
//		   
//		    driver.findElement(By.xpath(passwd)).sendKeys(password);
//	        driver.findElement(By.xpath(loginBtn)).click();
//	      
//	   }

	  
}

