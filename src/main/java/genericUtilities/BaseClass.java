package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of Basic configuration Annotations of TestNg
 * @author Sandeep Anand
 */
public class BaseClass { // Base class develop by framework developers
	
	/*
	 * public because all script running from base class
	 * so no need to create object for/in every child class
	 */
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public WebDriver driver;
	
	//For Listeners
	public static WebDriver sdriver;
			/*In BaseClass driver is same, sdriver is only for Listeners, sdriver holds driver
			  so it is satic so that we can directly access it from BaseClass*/
		
	
	/*
	 * any time we add annotation than we have to give method
	 */
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("===== DB Connection successful =====");
	}
	
//	@Parameters("browser")
//	@BeforeTest(groups = {"SmokeSuite","RegressionSuite"})
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		
		driver = new EdgeDriver();
		
//		if(BROWSER.equalsIgnoreCase("Edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		
//		else if (BROWSER.equalsIgnoreCase("Firefox")) 
//		{
//			driver = new FirefoxDriver();
//		}
//		
//		else
//		{
//			driver = new EdgeDriver();
//		}
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitelyWait(driver);
		driver.get(URL);
		
		//For Listeners
		sdriver = driver;
		
		System.out.println("===== Browser Launch successful =====");
	}
	
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("===== Login To App successful =====");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutApp(driver);
		
		System.out.println("===== Logout Of App successful =====");
	}
	
//	@AfterTest(alwaysRun = true)
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("===== Browser Closure successful =====");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("===== DB Closure successful =====");
	}
}
