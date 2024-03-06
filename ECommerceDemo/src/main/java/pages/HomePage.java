package pages;

import org.testng.Assert;
import org.testng.ITestResult;

import commonUtils.CommonClass;

public class HomePage  extends CommonClass{
	
	 public  void addToCart(ITestResult result) 
	   {
		   
		 
		   String productLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//products.json";
		   if(productDisplayed(locateElement(productLocatorPath,"homepageProduct", "xpath")))
		   {
			   clickElement(locateElement(productLocatorPath,"viewButton", "xpath"));
		   }
		   else
		   {
			   System.out.println("Product Not Available");
		   }
		   threadWait();	   
		   clickElement(locateElement(productLocatorPath,"cartButton", "xpath"));
		   Assert.assertEquals(getTextOfElement(locateElement(productLocatorPath,"chkHeading", "xpath")),readCredentials( "ProductData","ProductName1"));
		   getResult(result);
	   }

}
