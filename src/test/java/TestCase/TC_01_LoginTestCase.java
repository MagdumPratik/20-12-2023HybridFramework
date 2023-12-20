package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;

public class TC_01_LoginTestCase extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException
	{
		driver.get(baseurlBS);
		lp=new LoginPage(driver);
		lp.setUsername(usernameBS);
		lp.setPassword(passwordBS);
		lp.clickLogin();
		Thread.sleep(2000);
		if(alertIsPresent()==true)
		{
			driver.switchTo().alert().accept();
			System.out.println("Test Case Failed");
			Assert.assertTrue(false);
		}
		else
		{
			System.out.println("TEst CAse PAssed");
			lp.clickLogout();
			alertIsPresent();
			System.out.println("Successfully logged off");
		}
	}
	public boolean alertIsPresent()
	{
		try
		{
			driver.switchTo().alert();
			System.out.println("ALert handled");
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("ALert not present");
			return false;
		}
		
	}
	
}
