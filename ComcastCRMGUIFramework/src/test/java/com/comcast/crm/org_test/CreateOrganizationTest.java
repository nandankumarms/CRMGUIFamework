package com.comcast.crm.org_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.file_utility.ExcelUtility;
import com.comcast.crm.generic.file_utility.FileUtility;
import com.comcast.crm.generic.webdriver_utility.JavaUtility;
import com.comcast.crm.objectrepository_utility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepository_utility.HomePage;
import com.comcast.crm.objectrepository_utility.LoginPage;
import com.comcast.crm.objectrepository_utility.OrganizationInfoPage;
import com.comcast.crm.objectrepository_utility.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {
	HomePage home = new HomePage(driver);
	OrganizationsPage org = new OrganizationsPage(driver);
	OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
	CreateNewOrganizationPage createOrg = new CreateNewOrganizationPage(driver);
	
	
	

	@Test(groups = "Smoke")
	public void createOrgTest() throws Throwable {

		HomePage home = new HomePage(driver);
		OrganizationsPage org = new OrganizationsPage(driver);
		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		CreateNewOrganizationPage createOrg = new CreateNewOrganizationPage(driver);

		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		// Click on organization link
		home.getOrganizationLink().click();

		// Click on create organization image
		org.getCreateOrgImage().click();

		// Enter organization name
		createOrg.getOrganizationNameTF().sendKeys(orgName);

		// Click on save button
		createOrg.getSaveButton().click();

		// Verify organization name
		String actualOrgName = orgInfo.getOrganizationNameInfo().getText().trim();

		if (actualOrgName.equals(orgName)) {
			System.out.println("Org name is verified =====Pass===== " + orgName + " " + actualOrgName);
		} else {
			System.out.println("Org name is not verified  ====Fail==== " + orgName + " " + actualOrgName);
		}

	}

	@Test(groups = "Regression")
	public void createOrgWithTypeAndIndustryTest() throws IOException, Throwable {
		HomePage home = new HomePage(driver);
		OrganizationsPage org = new OrganizationsPage(driver);
		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		CreateNewOrganizationPage createOrg = new CreateNewOrganizationPage(driver);

		// Read organization name form excel
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();

		// Read industry name from excel
		String industry = eLib.getDataFromExcel("org", 4, 3);

		// Read type from excel
		String type = eLib.getDataFromExcel("org", 4, 4);

		// Click on organization link
		home.getOrganizationLink().click();

		// Click on create new organization link
		org.getCreateOrgImage().click();

		// Enter organization name
		createOrg.getOrganizationNameTF().sendKeys(orgName);

		// Select Industry
		wLib.selectOption(createOrg.getIndustryDropdown(), industry);

		// Select Type
		wLib.selectOption(createOrg.getTypeDropdown(), type);

		// Click on save button
		createOrg.getSaveButton().click();

		// Varify the organization name
		if (orgInfo.getOrganizationNameInfo().getText().trim().equals(orgName)) {
			System.out.println("Organization name verified ==Pass==");
		} else {
			System.out.println("Organization name not verified  ==Fail==");
		}

		// varify industry
		if (orgInfo.getIndustryInfo().getText().trim().equals(industry)) {
			System.out.println("Industry is verified ==Pass==");
		} else {
			System.out.println("Industry name is not verified ==fail==");
		}

		// varify type
		if (orgInfo.getTypeInfo().getText().trim().equals(type)) {
			System.out.println("Type is verified ==Pass==");
		} else {
			System.out.println("Type  is not verified ==fail==");
		}

	}

	@Test(groups = "Smoke")
	public void createOrgWithPhoneNumberTest() throws IOException, Throwable {

		HomePage home = new HomePage(driver);
		OrganizationsPage org = new OrganizationsPage(driver);
		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		CreateNewOrganizationPage createOrg = new CreateNewOrganizationPage(driver);

		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);

		// Click on organization link
		home.getOrganizationLink().click();

		// Click on create organization image
		org.getCreateOrgImage().click();

		// Enter organization name
		createOrg.getOrganizationNameTF().sendKeys(orgName);

		// Enter phone number
		createOrg.getPhoneNumberTF().sendKeys(phoneNumber);

		// Click on save button
		createOrg.getSaveButton().click();

		// Verify organization name
		String actualOrgName = orgInfo.getOrganizationNameInfo().getText();

		if (actualOrgName.trim().equals(orgName)) {
			System.out.println("Org name is verified =====Pass===== " + orgName + " " + actualOrgName);
		} else {
			System.out.println("Org name is not verified  ====Fail==== " + orgName + " " + actualOrgName);
		}

		
		String actualPhoneNumber=orgInfo.getPhoneInfo().getText();
		System.out.println(actualPhoneNumber);
		// Verify phone number
		if (actualPhoneNumber.trim().equals(phoneNumber)) {
			System.out.println("Phone number is verified ==Pass==");
		} else {
			
			System.out.println("Phone number is not verified ==Fail==");
			
		}
	}

	@Test(groups = "Regression")
	public void deleteOrganizationTest() throws IOException, Throwable {

		HomePage home = new HomePage(driver);
		OrganizationsPage org = new OrganizationsPage(driver);
		OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
		CreateNewOrganizationPage createOrg = new CreateNewOrganizationPage(driver);

		// Click on organizations link
		home.getOrganizationLink().click();

		String orgName = eLib.getDataFromExcel("org", 10, 2) + jLib.getRandomNumber();
		String searchCriteria = eLib.getDataFromExcel("org", 10, 3);

		// Click on organization link
		home.getOrganizationLink().click();

		// Click on create organization image
		org.getCreateOrgImage().click();

		// Enter organization name
		createOrg.getOrganizationNameTF().sendKeys(orgName);

		// Click on save button
		createOrg.getSaveButton().click();

		// Verify organization name
		String actualOrgName = orgInfo.getOrganizationNameInfo().getText();

		if (actualOrgName.trim().equals(orgName)) {
			System.out.println("Org name is verified =====Pass===== " + orgName + " " + actualOrgName);
		} else {
			System.out.println("Org name is not verified  ====Fail==== " + orgName + " " + actualOrgName);
		}

		// Click on organization link
		home.getOrganizationLink().click();

		// Search for organization
		org.getSearchBox().sendKeys(orgName);

		// Select Organization Name option in Dropdown
		wLib.selectOption(org.getSearchDropDown(), searchCriteria);

		// click on search now button
		org.getSearchNowButton().click();

		try {
			// Click on the delete button of selected Organization
			driver.findElement(By.xpath("//a[text()='" + orgName + "']/../..//a[text()='del']")).click();
		} catch (NoSuchElementException e) {
			System.out.println("No such oranization found  ==Fail==");
		}

		// Accept alert
		wLib.switchToAlertAndAccept(driver);
	}
}
