package com.comcast.crm.objectrepository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	public ContactsInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameInfo;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgNameInfo;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement supportStartDateInfo;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement supportEndDateInfo;

	public WebElement getLastNameInfo() {
		return lastNameInfo;
	}

	public WebElement getOrgNameInfo() {
		return orgNameInfo;
	}

	public WebElement getSupportStartDateInfo() {
		return supportStartDateInfo;
	}

	public WebElement getSupportEndDateInfo() {
		return supportEndDateInfo;
	}

}
