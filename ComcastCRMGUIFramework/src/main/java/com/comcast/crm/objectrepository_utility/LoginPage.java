package com.comcast.crm.objectrepository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriver_utility.WebDriverUtility;
import com.mysql.jdbc.Driver;
/**
 * @author NandanKumar
 * 
 * Contains Login page elements and business methods
 */
public class LoginPage  extends WebDriverUtility{
	
	WebDriver driver;
	public  LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="user_name")
	private WebElement userNameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;

	
	/**
	 * Login to Application by using user name and password
	 * @param userName
	 * @param password
	 */
	 public void loginToApp(String userName, String password) {
		 waitForPageToLoad(driver);
		 userNameTF.sendKeys(userName);
		 passwordTF.sendKeys(password);
		 loginButton.click();
	 }
	 
	public WebElement getUserNameTF() {
		return userNameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	

}
