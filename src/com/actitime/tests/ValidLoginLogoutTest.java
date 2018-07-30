package com.actitime.tests;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class ValidLoginLogoutTest extends BaseTest {
	@Test(priority=1)
	public void testValidLoginLogout()
	{
		String loginTitle=ExcelData.getData(filepath, "TC01", 1, 2);
		String username=ExcelData.getData(filepath, "TC01", 1, 0);
		String password=ExcelData.getData(filepath, "TC01", 1, 1);
		String enterTitle=ExcelData.getData(filepath, "TC01", 1, 3);
		LoginPage lp=new LoginPage(driver);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		lp.verifyTitle(loginTitle);
		Reporter.log("Username"+username,true);
		lp.enterUsername(username);
		Reporter.log("Password"+password,true);
		lp.enterPassword(password);
		lp.clickLogin();
		lp.verifyTitle(enterTitle);
		ep.clickLogout();
		lp.verifyTitle(loginTitle);
	}
}
