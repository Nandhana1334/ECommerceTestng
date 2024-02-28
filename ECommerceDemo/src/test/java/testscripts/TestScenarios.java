package testscripts;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtils.CommonClass;

public class TestScenarios extends CommonClass {
	
		

		  
		  
		  
		   @Test
		   public void validLogin()

		   {
			   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			   //locateElement("email", "xpath").sendKeys(null);
			   String loginLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//login.json";
			   
			   type("loginData",locateElement(loginLocatorPath,"emailField", "xpath"), "username");
			   type("loginData",locateElement(loginLocatorPath,"passwordField", "xpath"),"password");
			   clickElement(locateElement(loginLocatorPath,"loginButton", "xpath"));
			   Assert.assertEquals(locateElement(loginLocatorPath,"signoutButton", "xpath").getText(), "Sign Out");
			   

		   }
		   @Test
		   public void addToCart() throws InterruptedException
		   {
		  
			   String productLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//products.json";
			   Thread.sleep(2000);
			   locateElement(productLocatorPath,"search", "xpath").click();
			   type("ProductData", locateElement(productLocatorPath,"search", "xpath"), "ProductName");
			   			   
			   clickElement(locateElement(productLocatorPath,"viewButton", "xpath"));
			   clickElement(locateElement(productLocatorPath,"cartButtonA", "xpath"));
			   clickElement(locateElement(productLocatorPath,"navigateToCart", "xpath"));
			  // clickElement(locateElement(productLocatorPath,"cartButton", "xpath"));
			  // Assert.assertEquals(locateElement(productLocatorPath,"chkHeading", "xpath").getText(),"ZARA COAT 3");
			   Assert.assertEquals(locateElement(productLocatorPath,"chckCart", "xpath"),"ZARA COAT 3");

		   }
//
//		   
//		   @Test
//		   public void checkout()
//		   {
//			   String orderLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//orderLocators.json";
//
//			   clickElement(locateElement(orderLocatorPath,"checkoutButton", "xpath"));
//			   type("OrderData", locateElement(orderLocatorPath,"countryDropdown", "xpath"), "Country");
//			   clickElement(locateElement(orderLocatorPath,"countryName", "xpath"));
//			   Assert.assertEquals(locateElement(orderLocatorPath,"chckHeading", "xpath"),"Thankyou for the order.");
//			   
//		   }
//		   @Test
//		   public void placeOrder()
//		   {
//			   String orderLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//orderLocators.json";
//			   clickElement(locateElement(orderLocatorPath,"placeOrder", "xpath"));
//			   clickElement(locateElement(orderLocatorPath,"orderButton", "xpath"));
//			   clickElement(locateElement(orderLocatorPath,"viewSummary", "xpath"));
//			   Assert.assertEquals(readCredentials("OrderData", "OrderId"), "65dec204a86f8f74dc8a1c16");
//			   
//		   }
		   
		   
		   
		   
		   
		   
		   
		   
		   
	}


