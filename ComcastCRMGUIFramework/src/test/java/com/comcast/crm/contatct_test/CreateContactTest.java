package com.comcast.crm.contatct_test;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.file_utility.ExcelUtility;
import com.comcast.crm.generic.webdriver_utility.UtilityClassObject;
import com.comcast.crm.objectrepository_utility.ContactsInfoPage;
import com.comcast.crm.objectrepository_utility.ContactsPage;
import com.comcast.crm.objectrepository_utility.CreateContactPage;
import com.comcast.crm.objectrepository_utility.HomePage;
import com.comcast.crm.objectrepository_utility.OrganizationsPage;

/**
 * @author Nandan
 */
@Listeners(com.comcast.crm.listener_utility.ListenerImpClass.class)
public class CreateContactTest extends BaseClass {
	
	
	@Test(groups = "Smoke")
	public void createContactTest() {

		HomePage home = new HomePage(driver);
		ContactsPage contact = new ContactsPage(driver);
		CreateContactPage createContactPage = new CreateContactPage(driver);
		ContactsInfoPage contactInfo = new ContactsInfoPage(driver);
		
		// Steps to read data from Excel file
		ExcelUtility eLib = new ExcelUtility();
		String lastName = null;
		try {
			lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Throwable e) {

			e.printStackTrace(); 
		}

		// click on contacts link
		home.getContactLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on Contact Link in Home page");

		// Click on create contact image
		contact.getCreateContactImage().click();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on Create Contact image in Contact page");

		// Enter Last name
		createContactPage.getLastNameTF().sendKeys(lastName);
		UtilityClassObject.getTest().log(Status.INFO, "Entered last Name as "+ lastName);

		// Click on save button
		createContactPage.getSaveButton().click();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on Save button");

		String actualLastName = contactInfo.getLastNameInfo().getText().trim();

//		//verify the contact name
//		if(actualLastName.equals(lastName)) {
//			System.out.println("Last Name verified ====Pass====");
//		}
//		else {
//			System.out.println("last name not verified ===Fail===");
//		}

		// verify the contact name using Assertion
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actualLastName, lastName);
		UtilityClassObject.getTest().log(Status.PASS, "Info verified");
		

	}

	@Test(groups = "Regression")
	public void createContactWithOrgName() throws IOException, Throwable {
		HomePage home = new HomePage(driver);
		ContactsPage contact = new ContactsPage(driver);
		CreateContactPage createContactPage = new CreateContactPage(driver);
		ContactsInfoPage contactInfo = new ContactsInfoPage(driver);
		OrganizationsPage org = new OrganizationsPage(driver);

		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("contact", 4, 3);

		// click on contacts link
		home.getContactLink().click();

		// Click on create contact image
		contact.getCreateContactImage().click();

		// Enter last name
		createContactPage.getLastNameTF().sendKeys(lastName);

		// Enter click on add organization name image
		createContactPage.getAddOrganizationNameImage().click();

		// switch to accounts and Actions window
		wLib.switchToNewWindowByURL(driver, eLib.getDataFromExcel("contact", 4, 5));

		// Search for organization
		org.getSearchBox().sendKeys(orgName, Keys.ENTER);

		// Select organization from the table
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// Switch back to parent window
		wLib.switchToNewWindowByURL(driver, eLib.getDataFromExcel("contact", 4, 4));

		// Ckick on save button
		createContactPage.getSaveButton().click();

		// Verify the last name and organization name
		String actualLastName = contactInfo.getLastNameInfo().getText().trim();
		if (actualLastName.equals(lastName)) {
			System.out.println("Last name is verified  ==Pass==");
		}

		else {
			System.out.println("Last name is not verified  ==Fail==");
		}

		// Verify the organization name
		String actualOrgName = contactInfo.getOrgNameInfo().getText().trim();
		if (actualOrgName.equals(orgName)) {
			System.out.println("Organization name is verified ==Pass==");
		}

		else {
			System.out.println("Organization name is not verified");
		}

	}

	@Test(groups = "Regression")
	public void createContactWithSupportDate() throws IOException, Throwable {
		HomePage home = new HomePage(driver);
		ContactsPage contact = new ContactsPage(driver);
		CreateContactPage createContact = new CreateContactPage(driver);
		ContactsInfoPage contactInfo = new ContactsInfoPage(driver);

		String lastName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();

		// Click on contacts link
		home.getContactLink().click();

		// Click on create contact image
		contact.getCreateContactImage().click();

		// Enter last name
		createContact.getLastNameTF().sendKeys(lastName);

		// select support start date
		String supportStartDate = createContact.selectSupportStartDate();

		// Select support end date
		String SupportEndDate = createContact.selectSupportEndDate();

		// Click on save button
		createContact.getSaveButton().click();

		// Verify last name
		if (contactInfo.getLastNameInfo().getText().trim().equals(lastName)) {
			System.out.println("Last Name is verified ==pass== ");
		} else {
			System.out.println("Last name is not verified ==Fail==");
		}

		// Verify support start date
		if (contactInfo.getSupportStartDateInfo().getText().trim().equals(supportStartDate)) {
			System.out.println("Support start date is verified ==Pass== " + supportStartDate);
		} else {
			System.out.println("Support start date is not verified ==Fail== " + supportStartDate);
		}

		// Verify the support end date
		if (contactInfo.getSupportEndDateInfo().getText().trim().equals(SupportEndDate)) {
			System.out.println("Support end date is verified  ===Pass== " + SupportEndDate);
		}

		else {
			System.out.println("Support end date is not verified  ==Fail==" + SupportEndDate);
		}
	}

}
