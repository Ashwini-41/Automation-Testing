package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
   
	//Object Repository
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement signUpBtn;
	
	
	@FindBy(xpath = "//link[@href='/images/logo-medium.png']")
	WebElement crmlogo;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpbtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean getlogo() {
		
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage();
	}
	
	public void signUpPage() {
		signUpbtn.click();
	}
}
