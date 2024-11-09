package com.crm.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	private static final Logger Log = Logger.getLogger(LoginPage.class);
   
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
		Log.info("Attempting to log in with username : " + un);
		Log.info("Attempting to log in with password : " + pwd);
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		Log.info("Login Successful");
		
		return new HomePage();
	}
	
	public void signUpPage() {
		signUpbtn.click();
	}
}
