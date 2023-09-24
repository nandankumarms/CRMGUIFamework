package com.comcast.crm.objectrepository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgImage;
	
	
	@FindBy(name="search_text")
	private WebElement searchBox;
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchDropDown;
	
	@FindBy(name = "submit")
	private WebElement searchNowButton;
	
	
	
	
	
	public WebElement getSearchBox() {
		return searchBox;
	}





	public WebElement getSearchDropDown() {
		return searchDropDown;
	}





	public WebElement getSearchNowButton() {
		return searchNowButton;
	}





	public WebElement getCreateOrgImage() {
		return createOrgImage;
	}
	
	

	

}
