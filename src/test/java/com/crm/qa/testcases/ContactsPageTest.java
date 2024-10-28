package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    ContactsPage contactsPage;
    HomePage homePage;
    TestUtil testUtil;
    String sheetName = "Sheet1"; 
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.ClickContactsLink();
		
	}
	
	@Test
	public void verifyContactLabel() {
		Assert.assertTrue( contactsPage.verifyContactLabel());
	}
	
	@Test
	public void verifyContactName() {
		String cn = contactsPage.verifyName();
		Assert.assertEquals(cn, "Bhagyashri Garad");
	}
	
	@Test
	public void verifyFilterOption() throws InterruptedException {
		Thread.sleep(2000);
		contactsPage.verifyFilterButton();
		Thread.sleep(3000);
	}
	
	@Test
	public void verifyCreateOption() throws InterruptedException {
		Thread.sleep(3000);
		contactsPage.ClickOnCreateButton();
		Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstname,String lastname,String emailaddress) throws InterruptedException {
		homePage.ClickOnNewContact();
//		contactsPage.createNewContact("Ashwini", "Garad", "ashwinihgarad11@gmail.com");
	    contactsPage.createNewContact(firstname, lastname, emailaddress);
	}
	
	
	
	@AfterMethod
	   public void tearDown() throws InterruptedException {
		   Thread.sleep(5000);
		   driver.quit();
	   }
}
