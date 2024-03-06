package pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

import commonUtils.CommonClass;

public class LoginPage extends CommonClass {
	  public void validLogin(ITestResult result)

	   {
		   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		   String loginLocatorPath = System.getProperty("user.dir") + "//src//test//resources//locators//login.json";
		   type("loginData",locateElement(loginLocatorPath,"emailField", "xpath"), "username");
		   type("loginData",locateElement(loginLocatorPath,"passwordField", "xpath"),"password");
		   clickElement(locateElement(loginLocatorPath,"loginButton", "xpath"));
		   Assert.assertEquals(locateElement(loginLocatorPath,"signoutButton", "xpath").getText(), "Sign Out");
		   getResult(result);
		   
	 }

}
