package com.comcast.crm.objectrepository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "dtlview_Organization Name")
	private WebElement organizationNameInfo;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industryInfo;
	
	@FindBy(id = "dtlview_Type")
	private WebElement typeInfo;
	
	@FindBy(id = "mouseArea_Phone")
	private WebElement phoneInfo;

	public WebElement getIndustryInfo() {
		return industryInfo;
	}

	public WebElement getTypeInfo() {
		return typeInfo;
	}

	public WebElement getOrganizationNameInfo() {
		return organizationNameInfo;
	}

	public WebElement getPhoneInfo() {
		return phoneInfo;
	}

}
