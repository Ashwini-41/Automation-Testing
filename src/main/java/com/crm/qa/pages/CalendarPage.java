package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CalendarPage extends TestBase{

	@FindBy(xpath="//span[text()='Calendar']")
	WebElement calendarButton;
	
	@FindBy(xpath="//button[text()='Events']")
	WebElement viewEventBtn;
	
	@FindBy(xpath="//button[text()='Create']")
	WebElement createBtn;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath="//input[@name=\"title\"][@type=\"text\"]")
	WebElement title;
	
	@FindBy(xpath="//textarea[@name=\"description\"]")
	WebElement description;
	
	@FindBy(xpath="//button[text()='Save'] ")
	WebElement saveButton;
	
	@FindBy(xpath="//button[text()='Calendar'] ")
	WebElement eventCalendar;
	
	public CalendarPage(){
		PageFactory.initElements(driver, this);

	}
	
	public void verifyCalendarButton() {
		calendarButton.click();
	}
	
	public void viewEvents() {
		viewEventBtn.click();
	}
	
	public void clickOnBackInEvent() {
		eventCalendar.click();
	}
	
	public void clickOnCreate() {
		createBtn.click();
	}
	
	public void createNewTask(String titleK,String descrip) {
		title.sendKeys(titleK);
		description.sendKeys(descrip);
		saveButton.click();
		
	}
	
	
}
