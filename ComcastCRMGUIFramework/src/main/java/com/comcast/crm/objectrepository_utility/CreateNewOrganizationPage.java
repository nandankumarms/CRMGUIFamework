package com.comcast.crm.objectrepository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {

	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement organizationNameTF;
	
	@FindBy(name = "button")
	private WebElement saveButton;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropdown;
	
	@FindBy(id = "phone")
	private WebElement phoneNumberTF;
	
	
	public WebElement getPhoneNumberTF() {
		return phoneNumberTF;
	}

	public WebElement getOrganizationNameTF() {
		return organizationNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}
}
