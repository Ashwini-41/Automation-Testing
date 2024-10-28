package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TasksPage extends TestBase{
	

	@FindBy(xpath="//span[@class='selectable ']")
	WebElement pageType;
	
	@FindBy(xpath="//button[text()='Board']")
	WebElement boardButton;
	
	@FindBy(xpath="//button[text()='Show Filters']")
	WebElement filterButton;
	
	@FindBy(xpath="//button[text()='Add Filter Row']")
	WebElement addRowButton;
	
	@FindBy(xpath="//a[@class='item active'][text()='1']")
	WebElement getCountOfTask;
	
	
	
	public TasksPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public boolean pagenamedisplay() {
		return pageType.isDisplayed();
	}
	
	public void clickBoardButton() {
		boardButton.click();
	}
	
	public void clickShowFilterOption() {
		filterButton.click();
	}
	
	public void clickAddFilterRow() throws InterruptedException {
		clickShowFilterOption();
		Thread.sleep(3000);
		addRowButton.click();
		
	}
	
	public String checkCountOfTasks() {
		String count = getCountOfTask.getText();
		return count;
	}
}
