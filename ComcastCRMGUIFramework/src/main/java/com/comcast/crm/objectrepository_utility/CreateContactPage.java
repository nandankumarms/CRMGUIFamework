package com.comcast.crm.objectrepository_utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	public CreateContactPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastNameTF;
	
	@FindBy(xpath = "//input[@name='account_id']//following-sibling::img")
	private WebElement addOrganizationNameImage;
	
	@FindBy(name = "support_end_date")
	private WebElement supportEndDateTF;
	
	@FindBy(id = "jscal_trigger_support_end_date")
	private WebElement supportEndDateCalendarImg;
	
	@FindBy(name = "support_start_date")
	private WebElement supportStartDateTF;
	
	@FindBy(id = "jscal_trigger_support_start_date")
	private WebElement supportStartDateCalendarImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getAddOrganizationNameImage() {
		return addOrganizationNameImage;
	}

	public WebElement getSupportEndDateTF() {
		return supportEndDateTF;
	}

	public WebElement getSupportEndDateCalendarImg() {
		return supportEndDateCalendarImg;
	}

	public WebElement getSupportStartDateTF() {
		return supportStartDateTF;
	}

	public WebElement getSupportStartDateCalendarImg() {
		return supportStartDateCalendarImg;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	public String selectSupportStartDate() {
		//Get the calendar
		Calendar date=Calendar.getInstance();
		
		//create the required date format
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		//Convert the system date into required format
		String startDate=dateFormat.format(date.getTime());
		
		//Enter the date in the support start date text field
		supportStartDateTF.clear();
		supportStartDateTF.sendKeys(startDate);
		return startDate;
	}
	
	public  String selectSupportEndDate() {
		//Get the calendar
		Calendar date=Calendar.getInstance();
		
		//create the required date format
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		date.add(Calendar.DAY_OF_MONTH, 30);
		String endDate=dateFormat.format(date.getTime());
		
		//Enter the date in the support end date text field
		supportEndDateTF.clear();
		supportEndDateTF.sendKeys(endDate);
		return  endDate;
	}
	
	
}
