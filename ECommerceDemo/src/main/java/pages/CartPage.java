package pages;

import org.testng.Assert;
import org.testng.ITestResult;

import commonUtils.CommonClass;

public class CartPage  extends CommonClass{
	public void cartDisplay(ITestResult result)
	   {
		   
		   String cartLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//cart.json";
		   clickElement(locateElement(cartLocatorPath,"navigateToCart", "xpath"));
		   Assert.assertEquals(getTextOfElement(locateElement(cartLocatorPath,"chckNameInCart", "xpath")),readCredentials( "ProductData","ProductName1"));
		   getResult(result);
 
		 }

}
