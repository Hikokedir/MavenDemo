package com.actitime.tests;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class VerifyVersionTest extends BaseTest {
	@Test(priority=3)
	public void testVerifyVersion()
	{
		String logTitle=ExcelData.getData(filepath, "TC01", 1, 2);
		String eVersion=ExcelData.getData(filepath, "TC03", 1, 0);
		LoginPage lp=new LoginPage(driver);
		lp.verifyTitle(logTitle);
		String aVersion=lp.verifyVersion();
		Reporter.log("Actual :"+aVersion,true);
		Reporter.log("Expected :"+eVersion,true);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(aVersion,eVersion);
		sa.assertAll();
	}
}
