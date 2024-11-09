package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class CalendarPageTest extends TestBase{
      
	LoginPage loginPage;
	HomePage homePage;
	CalendarPage calendarPage;
	
	public CalendarPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		calendarPage = homePage.clickOnCalenderLink();
		
	}
	
	@Test(priority=1)
	public void verifyEventOption() throws InterruptedException {
		Thread.sleep(2000);
		calendarPage.viewEvents();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=2)
	public void getBackToCalendar() throws InterruptedException {
		Thread.sleep(1000);
		calendarPage.viewEvents();
		Thread.sleep(2000);
		calendarPage.clickOnBackInEvent();
	}
	
	@Test(priority=3)
	public void VerifyOnCreate() throws InterruptedException {
		Thread.sleep(2000);
		calendarPage.clickOnCreate();
		Thread.sleep(2000);
		
	}
	
	@Test(priority=4)
	public void addTaskInCalendar() {
		calendarPage.clickOnCreate();
		calendarPage.createNewTask("Automation Testing", "Automation testing of web application");
		
	}
	
	@AfterMethod
	   public void tearDown() throws InterruptedException {
		   Thread.sleep(2000);
		   driver.quit();
	   }
}
