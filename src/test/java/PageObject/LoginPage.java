package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement username;
	
	public void setUsername(String user)
	{
		username.sendKeys(user);
	}
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	public void setPassword(String user)
	{
		password.sendKeys(user);
	}
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement clkLogin;
	
	public void clickLogin()
	{
		clkLogin.click();
	}
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement clkLogout;
	
	public void clickLogout()
	{
		clkLogout.click();
	}
	
	@FindBy(xpath="//marquee[@class='heading3']")
	WebElement getsmg;
	
	public String getSuccessMsg()
	{
		return getsmg.getText();
	}
	
	
}
