package com.crm.qa.testcases;

import org.apache.log4j.Logger;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.listener.Listeneres;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

@Listeners(Listeneres.class)

public class LoginPageTest extends TestBase {
	private static final Logger Log = Logger.getLogger(LoginPageTest.class);

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Log.debug("Launch the browser");
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void titleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void loginTest() {
		Log.info("Logging method is running");
		Log.debug("this ia a Debug message");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			
	}
	
	
	
	@Test(priority=3)
	public void crmlogoTest() {
		boolean flag = loginPage.getlogo();
		Assert.assertFalse(flag);
	}
	
	@Test
	public void signUpbtnTest() {
		loginPage.signUpPage();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
}
