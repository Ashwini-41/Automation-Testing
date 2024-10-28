package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

import junit.framework.Assert;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	TasksPage tasksPage;
	ContactsPage contactsPage;
	HomePage homePage;
	
   public HomePageTest() {
	   super();
   }
   
  
   @BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
   
   @Test(priority=1)
   public void verifyHomePageTitle() {
	  String hometitle = homePage.verifyHomePAgeTitle();
	  Assert.assertEquals(hometitle, "Cogmento CRM");
   }
   
   @Test(priority=2 )
   public void verifyUsername() {
	   boolean un = homePage.VerifyUsername();
	   Assert.assertTrue(un);
   }
   
   @Test(priority = 3)
   public void verifyContactsLink() {
	   contactsPage = homePage.ClickContactsLink();
	   
	   
   }
   
   @Test(priority=4)
   public void verifyDealsLink() {
	   homePage.ClickDealsLink();
	   
   }
   
   @Test(priority=5)
   public void verifyTasksLink() {
	   homePage.ClickTasksLink();
   }
   
   
   @AfterMethod
   public void tearDown() throws InterruptedException {
	   Thread.sleep(5000);
	   driver.quit();
   }
   
   
   
}
