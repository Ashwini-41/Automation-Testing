package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[@class='user-display']")
	WebElement username;
	
	@FindBy(xpath="//span[@class='item-text'][text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[@class='item-text'][text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[@class='item-text'][text()='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//i[@class='grey help circle large icon']")
	WebElement supportLink;
	
	@FindBy(xpath="//button[text() = 'Create']")
	WebElement newContactLink;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePAgeTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage ClickContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	public void ClickDealsLink() {
		dealsLink.click();
	}
	
	public TasksPage ClickTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void ClickSupportLink() {
		supportLink.click();
	}
	
	public boolean VerifyUsername() {
		return username.isDisplayed();
		
	}
	
	public void ClickOnNewContact() {
       Actions action = new Actions(driver);
       action.moveToElement(contactsLink).build().perform();
       newContactLink.click();
	}
	
	
	
	
}
