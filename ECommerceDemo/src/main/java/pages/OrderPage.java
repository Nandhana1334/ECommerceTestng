package pages;

import org.testng.Assert;
import org.testng.ITestResult;

import commonUtils.CommonClass;

public class OrderPage extends CommonClass{
	 public void placeOrderTest(ITestResult result)
	   {
		   //test = extent.createTest("Place Order Test", "Verify the placeorder functionality");
		   String orderLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//orderLocators.json";
		   clickElement(locateElement(orderLocatorPath,"orderButton", "xpath"));
		   String orderId = locateElement(orderLocatorPath,"OrderId1", "xpath").getText();
		   clickElement(locateElement(orderLocatorPath,"viewSummary", "xpath"));
		  
		   Assert.assertEquals(orderId,getTextOfElement(locateElement(orderLocatorPath,"OrderId22", "xpath")));
		   getResult(result);
		   
	   }

}
