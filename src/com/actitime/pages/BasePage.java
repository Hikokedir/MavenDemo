package com.actitime.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	public WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	public void verifyTitle(String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try {
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title Matching"+eTitle,true);
		}
		catch(Exception e) {
			Reporter.log("Title is not matching, Expected Title is : "+eTitle,true);
			Reporter.log("Actual Title : "+driver.getTitle(),true);
			Assert.fail();
		} }
	public void verifyElement(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element Present",true);
		}
		catch(Exception e)
		{
			Reporter.log("Element Not Present",true);
			Assert.fail();
		} } }