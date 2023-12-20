package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import PageObject.LoginPage;

public class TC_02_DATTestCase extends BaseClass{

	@Test(dataProvider="LoginData")
	public void DATLoginTest(String user, String pass)
	{
		driver.get(baseurlBS);
		lp=new LoginPage(driver);
		lp.setUsername(user);
		lp.setPassword(pass);
		lp.clickLogin();
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
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String ExcelFile = ".//DATData//LoginData.xlsx";
		int row = xl.getRowCount(ExcelFile, "Sheet1");
		int cell = xl.getCellCount(ExcelFile, "Sheet1", 1);

		String[][] loginData = new String[row][cell];
		for (int i = 1; i <= row; i++) {
			for (int c = 0; c < cell; c++) {
				loginData[i - 1][c] = xl.getCellData(ExcelFile, "Sheet1", i, c);
			}
		}
		return loginData;
	}
}
