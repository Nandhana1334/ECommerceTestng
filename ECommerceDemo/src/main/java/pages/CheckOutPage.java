package pages;

import org.testng.Assert;
import org.testng.ITestResult;

import commonUtils.CommonClass;

public class CheckOutPage extends CommonClass {
	public void checkoutTest(ITestResult result)
	   {
		   
		   //test = extent.createTest("Checkout Test", "Verify the checkout functionality");
		   String orderLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//orderLocators.json";
		   clickElement(locateElement(orderLocatorPath,"checkoutButton", "xpath"));
		
		   clearField(locateElement(orderLocatorPath, "email", "xpath"));
		   type("loginData", locateElement(orderLocatorPath, "email", "xpath"), "username");
		   type("OrderFormData", locateElement(orderLocatorPath, "name", "xpath"), "name");
		   clearField(locateElement(orderLocatorPath, "creditCardNo", "xpath"));
		   type("OrderFormData", locateElement(orderLocatorPath, "creditCardNo", "xpath"), "Credit Card Number");
		   type("OrderFormData", locateElement(orderLocatorPath, "cvv", "xpath"), "cvv");
		
		   clickElement(locateElement(orderLocatorPath,"countryDropdown", "xpath"));
		   type("OrderFormData", locateElement(orderLocatorPath,"countryDropdown", "xpath"), "Country");
		   clickElement(locateElement(orderLocatorPath,"countryName", "xpath"));
		   clickElement(locateElement(orderLocatorPath,"placeOrder", "xpath"));
		   
		   Assert.assertEquals(getTextOfElement(locateElement(orderLocatorPath,"chckHeading", "xpath")),"THANKYOU FOR THE ORDER.");
		   getResult(result);
		   
	   }

}
