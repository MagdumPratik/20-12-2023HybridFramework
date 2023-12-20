package TestCase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import PageObject.LoginPage;
import Utilities.ConfigReader;
import Utilities.XLUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	ConfigReader rd=new ConfigReader();
	XLUtils xl=new XLUtils();
	public LoginPage lp;
	public String baseurlBS = rd.getApplicationUrl();
	public String usernameBS = rd.getUsername();
	public String passwordBS = rd.getPassword();

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearUp() {
		driver.quit();
	}
}
