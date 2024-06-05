package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import unit.BrowserFactory;

public class LoginTest {
	
	
	WebDriver driver;
	
	String userName = "demo@codefios.com";
	String password = "abc123";
	String dashboardHearderText="Dashboard";
	String userNameAlertMsg="Please enter your user name";
	String passwordAlertMsg = "Please enter your password";
	
	
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		//create object
		//by the name of the class
	
		
		driver= BrowserFactory.init();
		//LoginPage1 loginPage1=new LoginPage(driver);
		
		LoginPage loginPage=  PageFactory.initElements(driver,LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		
		
		DashboardPage dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
		//String actualDashboardHeaderText=dashboardPage.validateDashboardPageText();
		//Assert.assertEquals(actualDashboardHeaderText, "Dashboard", "Dashboard page not found!)";
		Assert.assertEquals(dashboardPage.validateDashboardPageTest(), dashboardHearderText, "Dashboard page not found!!");
		
		//LoginPage page =new LoginPage(driver);
		
		 
	
	
	}
	@Test
	public void validateAlertMessages() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickSigninButton();
		loginPage.validateUserAlertMsg(userNameAlertMsg);
		
		
		loginPage.insertUserName(userName);
		loginPage.clickSigninButton();
		loginPage.validatePasswordAlertMsg(passwordAlertMsg);
//		String actualMsg= loginPage.getPasswordAlertMsg();
//		Assert.assertEquals(actualMsg, passwordAlertMsg,"password alert Msg not found!!");
		BrowserFactory.tearDown();
		
	}
	

}
