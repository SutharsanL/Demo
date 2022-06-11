package Utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class BaseClass {
public static WebDriver driver;
public LoginPage loginPage;
public static ExtentReports extent = new ExtentReports();
public static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
public static Logger log=LogManager.getLogger(BaseClass.class);

public static ExtentTest test;

	public void initBrowser(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			 driver=new ChromeDriver(options);
		}
	}

	
	@BeforeTest
	public void initilizer() {
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");	
		initBrowser("chrome");
		log.debug("*******************************Opened Browser*******************************");
	}
	@BeforeClass
	public void objectInitilizer() {
		loginPage=new LoginPage(driver);
	}
	@AfterTest
	public void endTest() {
		extent.flush();
		driver.close();
		log.debug("*******************************end Browser*********************************");
	}
}
