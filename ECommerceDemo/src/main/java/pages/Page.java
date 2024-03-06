package pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commonUtils.CommonClass;

public class Page {
	public class LoginPage extends CommonClass {
		  public void validLogin()

		   {
			   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			   String loginLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//login.json";
			   type("loginData",locateElement(loginLocatorPath,"emailField", "xpath"), "username");
			   type("loginData",locateElement(loginLocatorPath,"passwordField", "xpath"),"password");
			   clickElement(locateElement(loginLocatorPath,"loginButton", "xpath"));
			   Assert.assertEquals(locateElement(loginLocatorPath,"signoutButton", "xpath").getText(), "Sign Out");
			  
		 }
		  public class HomePage  extends CommonClass{
				
				 public void addToCart() 
				   {
					   
					  //test = extent.createTest("Add To Cart Test", "Verify adding product to cart functionality");
					 
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
				   }

		  

}
		  public class CartPage  extends CommonClass{
				public void cartDisplay()
				   {
					   //test = extent.createTest("Cart Display Test", "Verify the product displayed in the cart");
					   String cartLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//cart.json";
					   clickElement(locateElement(cartLocatorPath,"navigateToCart", "xpath"));
					   Assert.assertEquals(getTextOfElement(locateElement(cartLocatorPath,"chckNameInCart", "xpath")),readCredentials( "ProductData","ProductName1"));

			 
					 }

			}
		  public class CheckOutPage extends CommonClass {
				public void checkoutTest()
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
					   
				   }

			}
		  public class OrderPage extends CommonClass{
				 public void placeOrderTest()
				   {
					   //test = extent.createTest("Place Order Test", "Verify the placeorder functionality");
					   String orderLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//orderLocators.json";
					   clickElement(locateElement(orderLocatorPath,"orderButton", "xpath"));
					   String orderId = locateElement(orderLocatorPath,"OrderId1", "xpath").getText();
					   clickElement(locateElement(orderLocatorPath,"viewSummary", "xpath"));
					  
					   Assert.assertEquals(orderId,getTextOfElement(locateElement(orderLocatorPath,"OrderId22", "xpath")));
					   
				   }

			}
		  
		  
		  
}
}