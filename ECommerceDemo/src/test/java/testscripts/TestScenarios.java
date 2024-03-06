package testscripts;

import org.testng.annotations.Test;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtils.CommonClass;
import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderPage;

public class TestScenarios extends LoginPage  {
	   
	   HomePage homePage = new HomePage();
	   CartPage cartPage = new CartPage();
	   CheckOutPage chkoutPage = new CheckOutPage();
	   OrderPage orderPage = new OrderPage();
	   
	  @Test
	  public void placeOrderTest()
	  {
		  ITestResult result = Reporter.getCurrentTestResult();
		  test = extent.createTest("LoginTest", "Verify login functionality");
		  validLogin(result);
	
		 // test = extent.createTest("Add to cart test", "Verify add products in the cart");
		  homePage.addToCart(result);
		  //test = extent.createTest("Cart Display Test", "Verify products displayed in cart");
		  cartPage.cartDisplay(result);
		  //test = extent.createTest("Checkout Test", "Verify checkout functionality");
		  chkoutPage.checkoutTest(result);
		  //test = extent.createTest("Place Order Test", "Verify place order functionality");
		  orderPage.placeOrderTest(result);
	  }
	
	
//		@Test
//		   public void addToCartTest() 
//		   {
//			   
//			 // test = extent.createTest("Add To Cart Test", "Verify adding product to cart functionality");
//			  validLogin();
//			   String productLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//products.json";
//			   if(productDisplayed(locateElement(productLocatorPath,"homepageProduct", "xpath")))
//			   {
//				   clickElement(locateElement(productLocatorPath,"viewButton", "xpath"));
//			   }
//			   else
//			   {
//				   System.out.println("Product Not Available");
//			   }
//			   threadWait();	   
//			   clickElement(locateElement(productLocatorPath,"cartButton", "xpath"));
//			   Assert.assertEquals(getTextOfElement(locateElement(productLocatorPath,"chkHeading", "xpath")),readCredentials( "ProductData","ProductName1"));
//		   }
//		   
//		   @Test
//		   public void cartDisplayTest()
//		   {
//			   test = extent.createTest("Cart Display Test", "Verify the product displayed in the cart");
//			   String cartLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//cart.json";
//			   clickElement(locateElement(cartLocatorPath,"navigateToCart", "xpath"));
//			   Assert.assertEquals(getTextOfElement(locateElement(cartLocatorPath,"chckNameInCart", "xpath")),readCredentials( "ProductData","ProductName1"));
//
//	    
//			 }
//		   
//
//		   
//		   @Test
//		   public void checkoutTest()
//		   {
//			   
//			   test = extent.createTest("Checkout Test", "Verify the checkout functionality");
//			   String orderLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//orderLocators.json";
//			   clickElement(locateElement(orderLocatorPath,"checkoutButton", "xpath"));
//			
//			   clearField(locateElement(orderLocatorPath, "email", "xpath"));
//			   type("loginData", locateElement(orderLocatorPath, "email", "xpath"), "username");
//			   type("OrderFormData", locateElement(orderLocatorPath, "name", "xpath"), "name");
//			   clearField(locateElement(orderLocatorPath, "creditCardNo", "xpath"));
//			   type("OrderFormData", locateElement(orderLocatorPath, "creditCardNo", "xpath"), "Credit Card Number");
//			   type("OrderFormData", locateElement(orderLocatorPath, "cvv", "xpath"), "cvv");
//			
//			   clickElement(locateElement(orderLocatorPath,"countryDropdown", "xpath"));
//			   type("OrderFormData", locateElement(orderLocatorPath,"countryDropdown", "xpath"), "Country");
//			   clickElement(locateElement(orderLocatorPath,"countryName", "xpath"));
//			   clickElement(locateElement(orderLocatorPath,"placeOrder", "xpath"));
//			   
//			   Assert.assertEquals(getTextOfElement(locateElement(orderLocatorPath,"chckHeading", "xpath")),"THANKYOU FOR THE ORDER.");
//			   
//		   }
//		   @Test
//		   public void placeOrderTest()
//		   {
//			   test = extent.createTest("Place Order Test", "Verify the placeorder functionality");
//			   String orderLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//orderLocators.json";
//			   clickElement(locateElement(orderLocatorPath,"orderButton", "xpath"));
//			   String orderId = locateElement(orderLocatorPath,"OrderId1", "xpath").getText();
//			   clickElement(locateElement(orderLocatorPath,"viewSummary", "xpath"));
//			  
//			   Assert.assertEquals(orderId,getTextOfElement(locateElement(orderLocatorPath,"OrderId22", "xpath")));
//			   
//		   }
//	   
	
	   
		   
		   
		   
		   
	}


