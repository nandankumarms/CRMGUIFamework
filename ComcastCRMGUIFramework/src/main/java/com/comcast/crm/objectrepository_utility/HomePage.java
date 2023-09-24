package com.comcast.crm.objectrepository_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Nandan
 */
public class HomePage {  //Rule 1
	
WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "Organization")
	private WebElement organizationLink;
	
	@FindBy(partialLinkText = "Contact")
	private WebElement ContactLink;
	
	@FindBy(partialLinkText = "Compaigns")
	private WebElement compaignsLink;
	
	@FindBy(partialLinkText = "More")
	private WebElement moreLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImage;
	
	@FindBy(partialLinkText = "Sign Out")
	private WebElement signOutLink;

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getAdminImage() {
		return adminImage;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCompaignsLink() {
		return compaignsLink;
	}

	public WebElement getMoreink() {
		return moreLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}
	
	
	public void navigateToCampaignPage() {
		Actions action=new Actions(driver);
		action.moveToElement(moreLink).perform();
		
	}
	
	/**
	 * Log out method to log out from the application
	 */
	public void logOut() {
		Actions action=new Actions(driver);
		action.moveToElement(adminImage).perform();
		signOutLink.click();
	}

}
