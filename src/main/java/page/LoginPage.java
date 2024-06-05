package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver2) {
		this.driver= driver2;
	}

	//WebElement
	//By USER_NAME_FAIELD=By.xpath("//*[@id=\"user_name\"]");
	//WebElement USER_NAME_ELEMENT=driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
	@FindBy(how = How.XPATH, using= "//*[@id=\"user_name\"]") WebElement USER_NAME_ELEMENT;
	@FindBy(how =How.XPATH, using = "//*[@id=\"password\"]") WebElement PASSWORD_ELEMENT;
	@FindBy(how =How.XPATH, using = "//*[@id=\"login_submit\"]") WebElement SIGIN_ELEMENT;
	
	//actions or intractable methods
	public void insertUserName(String userName) {
		USER_NAME_ELEMENT.sendKeys(userName);
	}
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	public void clickSigninButton() {
		SIGIN_ELEMENT.click();
	}
	public void performLogin(String userName,String password) {
		USER_NAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(password);
		SIGIN_ELEMENT.click();
	}
	public void validateUserAlertMsg(String userNameAlertMsg) {
		String actualMsg = driver.switchTo().alert().getText();
		Assert.assertEquals(actualMsg, userNameAlertMsg, "alert msg not found!!");
		driver.switchTo().alert().accept();
		
	}
	public void validatePasswordAlertMsg(String passwordAlertMsg) {
		String actualMsg= driver.switchTo().alert().getText();
		Assert.assertEquals(actualMsg, passwordAlertMsg, "alert msg not found!!");
		driver.switchTo().alert().accept();
		
	}
	public String getPasswordAlertMsg() {
		String actualMsg= driver.switchTo().alert().getText();
		return actualMsg;
	}
	
}
