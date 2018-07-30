package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	@FindBy(id="username")
	private WebElement un;
	@FindBy(name="pwd")
	private WebElement pw;
	@FindBy(xpath="//div[.='Login']")
	private WebElement log;
	@FindBy(xpath="//span[conatins(.,'invalid')]")
	private WebElement errMsg;
	@FindBy(xpath="//nobr[conatins(.,'actiTIME')]")
	private WebElement version;
	public LoginPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver,this);
	}
	public void verifyTitle(String eTitle){
		verifyTitle(eTitle);
	}
	public void enterUsername(String un1){
		un.sendKeys(un1);
	}
	public void enterPassword(String pswd){
		pw.sendKeys(pswd);
	}
	public void clickLogin(){
		log.click();
	}
	public String verifyErrMsg() {
		verifyElement(errMsg);
		String aErrMsg=errMsg.getText();
		return aErrMsg;
	}
	public String verifyVersion() {
		verifyElement(version);
		String aVer=version.getText();
		return aVer;
	}}