package testscripts;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Locator {
	String path = System.getProperty("user.dir") + "//src//test//resources//locators//login.json";
	JSONParser jsonparse = new JSONParser();
	JSONObject jsonobject = null;

	public String emailIdLocator()
	{
	
		try 
		{
			jsonobject = (JSONObject) jsonparse.parse(new FileReader(path));
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ParseException e) 
		{
		
			e.printStackTrace();
		}
		String email = (String) jsonobject.get("emailInput");
	
		return email;
	
	}
	public String pwdLocator()
	{
	
		try 
		{
			jsonobject = (JSONObject) jsonparse.parse(new FileReader(path));
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ParseException e) 
		{
			
			e.printStackTrace();
		}
		String pwd = (String) jsonobject.get("passwordInput");
	
		return pwd;
	
	}
	public String loginBtnLocator()
	{
	
		try 
		{
			jsonobject = (JSONObject) jsonparse.parse(new FileReader(path));
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ParseException e) 
		{
			
			e.printStackTrace();
		}
		String loginBtn = (String) jsonobject.get("submitButton");
	
		return loginBtn;
	
	}
	public String signoutBtnLocator()
	{
	
		try 
		{
			jsonobject = (JSONObject) jsonparse.parse(new FileReader(path));
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ParseException e) 
		{
			
			e.printStackTrace();
		}
		String signoutBtn = (String) jsonobject.get("signoutButton");
	
		return signoutBtn;
	
	}
	
	
	   
}
