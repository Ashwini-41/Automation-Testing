package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastname;
  
	@FindBy(xpath="//input[@name=\"value\"][@placeholder=\"Email address\"]")
	WebElement emailadd;
	
	@FindBy(xpath="//span[@class='selectable ']")
	WebElement contactslabel;
	
	@FindBy(xpath="//a[text()='Bhagyashri Garad']")
	WebElement nameOfcontacts;
	
	@FindBy(xpath="//button[text() = 'Show Filters']")
	WebElement filterbutton;
	
	@FindBy(xpath="//button[text() = 'Create']")
	WebElement createbutton;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement savebutton;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel() {
		return contactslabel.isDisplayed();
	}
	
	public String verifyName() {
		String name =nameOfcontacts.getText();
		return name;
	}
	
	public void verifyFilterButton() {
		filterbutton.click();
	}
	
	public void ClickOnCreateButton() {
		createbutton.click();
	}
	
	public void createNewContact(String ftname,String ltname,String emailaddress) throws InterruptedException {
		Thread.sleep(3000);
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		emailadd.sendKeys(emailaddress);
		Thread.sleep(3000);
		savebutton.click();
	}
	

}
