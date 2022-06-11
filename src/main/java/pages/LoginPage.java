package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(name="txtUsername")
	private WebElement username;
	
	@FindBy(name="txtPassword")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement login;
	
	public LoginPage(WebDriver driver) { //assign value to global variable(WebDriver driver) 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public LoginPage enterUsername(String uName) {
            username.sendKeys(uName);
            return this;
	}
	
	public LoginPage enterPassword(String pwd) {
		   password.sendKeys(pwd);
		   return this;
			}
	
	public LoginPage clickLogin() {
		   login.click();
		   return this;
			}
}
