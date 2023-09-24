package com.comcast.crm.generic.webdriver_utility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

//	Method to wait until the page is loaded
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
//	Method to wait until the element is vivisible
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		
//	Method to switch to any Iframe by using index
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
//	Method to switch to iFrame identifying Iframe as a webelement
	public void switchToFrame(WebDriver driver, WebElement frame) {
		driver.switchTo().frame(frame);
	}
	
//	Method to switch to iFrame by using the iframe name or id
	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}
	
//	Method to switch to alert and accept
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
//	Method to switch to alert and dismiss
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
//	Method to select option from dropdown using index
	public void selectOption(WebElement element, int index) {
		Select select=new Select(element);
		
		select.selectByIndex(index);
	}
	
//	Method to select option from  dropdown by using visible text
	public void selectOption(WebElement element, String visibleText) {
		Select select=new Select(element);
		
		select.selectByVisibleText(visibleText);
	}
	
//	Method to select option from dropdown by using value
	public void selectOptionByValue(WebElement element, String value) {
		Select select=new Select(element);
		
		select.selectByValue(value);
	}
	
//	Method to mouse hover on webelement
	public void moveMouseOnElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	
//	Method to right click on webelement
	public void rightClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
		
	}
	
//	Method to double click on webelement
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
		
	}
	
//	Method to drag and drop the webelement
	public void dragAndDrop(WebDriver driver,WebElement from, WebElement to) {
		Actions action=new Actions(driver);
		action.dragAndDrop(from, to).perform();
		
	}

//	Method to Switch to window by using url
public void switchToNewWindowByURL(WebDriver driver, String partialUrl) {
	     Set<String> windows = driver.getWindowHandles();	
	     
	     for(String window: windows) {
	    	 driver.switchTo().window(window);
	    	 if(driver.getCurrentUrl().contains(partialUrl)) {
	    		 break;
	    	 }
	     }
	
	}

// Method to switch to window by using title
public void switchToNewWindowByTitle(WebDriver driver, String partialTitle) {
	 Set<String> windows = driver.getWindowHandles();	
     
     for(String windowId: windows) {
    	 driver.switchTo().window(windowId);
    	 if(driver.getTitle().contains(partialTitle)) {
    		 break;
    	 }
     }
}
}
