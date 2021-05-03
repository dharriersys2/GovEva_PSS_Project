package com.govevapss.qa.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.goveva.qa.utilities.ReadConfig;
import com.govevapss.qa.testPageObjects.DashboardPage;
import com.govevapss.qa.testPageObjects.LoginPage;




public class BaseTest {


	ReadConfig readconfig = new ReadConfig();

	public static WebDriver driver;
	public String appURL = readconfig.applicationURL();
	public String appUsername = readconfig.applicationUsername();
	public String appPassword = readconfig.applicationPassword();
	public String appCompanyName = readconfig.applicationComapnyName();


	public static Logger logger;


	@Parameters("browser")

	@BeforeMethod
	public void setUp(String br) throws InterruptedException {

		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver = new ChromeDriver();
		}

		else if(br.equals("firefox")){

			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}

		else if(br.equals("edge")){

			System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
			driver = new EdgeDriver();
		}

		logger = Logger.getLogger("Goveva_PSS");

		PropertyConfigurator.configure("log4j.properties");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(appURL);

		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);


		//Thread.sleep(5000);
		lp.setUsername(appUsername);

		//Thread.sleep(5000);
		lp.setCompanyName(appCompanyName);

		lp.setPassword(appPassword);

		//Thread.sleep(5000);


		lp.clickLoginBtn();

		logger.info("Login Successfull");
		
		//String CompanyNameOnDashboard = driver.findElement(By.xpath("//span[@class='company-name-label']")).getText();

		// Assert.assertEquals(CompanyNameOnDashboard, "HARRIER INFORMATION SYSTEMS PRIVATE LIMITED");
		
	}



	@AfterMethod
	public void tearDown() throws InterruptedException
	{

		DashboardPage dp = new DashboardPage(driver);

		//Thread.sleep(5000);
		dp.clickOnProfile();
		//Thread.sleep(5000);
		dp.clickOnLogout();
		logger.info("Logout Successfull");
		//Thread.sleep(5000);
		//driver.close();

	}

	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	
	  public static String randomestring() {
			String generatedString1 = RandomStringUtils.randomAlphabetic(5);
			return (generatedString1);
		}
		
		
		public static String randomeNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(4);
			return (generatedString2);
		}
	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
