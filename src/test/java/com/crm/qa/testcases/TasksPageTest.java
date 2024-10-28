package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

import junit.framework.Assert;

public class TasksPageTest extends TestBase {
	
	LoginPage loginPage;
	TasksPage tasksPage;
	HomePage homePage;
	

	public TasksPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		tasksPage = new TasksPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		tasksPage = homePage.ClickTasksLink();
		
	}
	
	@Test(priority=1)
	public void verifyPageName() {
		boolean flag = tasksPage.pagenamedisplay();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void verifyBoardLink() throws InterruptedException {
		Thread.sleep(2000);
		tasksPage.clickBoardButton();
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void veifyShowFilterOption() throws InterruptedException {
		Thread.sleep(3000);
		tasksPage.clickShowFilterOption();
		Thread.sleep(3000);
	}
	
	@Test(priority=4)
	public void verifyAddRowOption() throws InterruptedException {
		tasksPage.clickAddFilterRow();
		Thread.sleep(4000);
	}
	
	@Test(priority=5)
	public void verifyTasksCount() {
		String tskcount = tasksPage.checkCountOfTasks();
		Assert.assertEquals(tskcount, "1");
	}
	
	
	@AfterMethod
	   public void tearDown() throws InterruptedException {
		   Thread.sleep(1000);
		   driver.quit();
	   }
}
