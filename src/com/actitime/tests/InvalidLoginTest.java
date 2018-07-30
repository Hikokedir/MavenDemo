package com.actitime.tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

class InvalidLoginTest extends BaseTest {
	@Test(priority=2)
	public void testInvalidLogin() throws InterruptedException
	{
		String filepath = null;
		String loginTitle=ExcelData.getData(filepath, "TC01", 1, 2);
		String expectedErrMsg=ExcelData.getData(filepath, "TC02", 1, 2);
		WebDriver driver = null;
		LoginPage lp=new LoginPage(driver);
		lp.verifyTitle(loginTitle);
		int rc=ExcelData.getRowCount(filepath, "TC02");
		for(int i=1;i<=rc;i++) {
			String user=ExcelData.getData(filepath, "TC02", i, 0);
			String pswd=ExcelData.getData(filepath, "TC02", i, 1);
		Reporter.log("Username"+user,true);
		lp.enterUsername(user);
		Reporter.log("Password"+pswd,true);
		lp.enterPassword(pswd);
		lp.clickLogin();
		Thread.sleep(1000);
		String actualErrMsg=lp.verifyErrMsg();
		Reporter.log("Actual"+actualErrMsg,true);
		Reporter.log("Expected"+expectedErrMsg,true);
		Assert.assertEquals(expectedErrMsg, actualErrMsg);
		Reporter.log("Matching",true);
	}}}
