package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.Reporting;


public class BaseTestCase{
	
	public static WebDriver driver;
	public static String url;
	public static Properties prop;
	public static FileInputStream fis;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports reports;
	public static ExtentTest logger ;
	public static XSSFWorkbook wb;
	
	@BeforeSuite
	public void beforeSuite(ITestContext context) {
		
		
		htmlreporter = new ExtentHtmlReporter(new File(".\\Reports\\HtmlReport.html"));
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		
		
	}
	
	
	@BeforeMethod
	public void beforeMethod(ITestContext context) throws Exception {
//		int count=0;
//		context.setAttribute("Number of test cases executed", count=count+1);
		File f=new File(".\\resources\\selenium.properties"); 
		fis =new FileInputStream(f); 
		prop=new Properties();
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver83.exe");
		
//		System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");
		
//		DesiredCapabilities cap=new DesiredCapabilities();
//		
//		cap.setAcceptInsecureCerts(true);
//		
//		ChromeOptions options=new ChromeOptions();	
//		
//		options.merge(cap);
//		
//		options.addArguments("--disable-infobars");
	
//		cap.setCapability("applicationCacheEnabled", false);
				
		driver=new ChromeDriver();	
//		driver=new InternetExplorerDriver();
		
//		driver.manage().deleteAllCookies();		
			
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		if(result.getStatus()==ITestResult.FAILURE) {
			Reporting.takeScreenshot(driver,result.getName());
			logger.log(Status.FAIL, "Test case failed is "+result.getName());
		}
		
		driver.close();
		reports.flush();
	}
	
	@AfterSuite
	public void afterSuite(ITestContext context) {
		IResultMap passedTests = context.getPassedTests();
		IResultMap failedTests = context.getFailedTests();
		int testsPassed = passedTests.size();
		int testsFailed = failedTests.size();
		Collection<ITestNGMethod> failedTestNames = failedTests.getAllMethods();	

		System.out.println("Number of tests passed "+testsPassed);
		System.out.println("Number of tests failed "+testsFailed);
		System.out.println("Failed test cases are "+failedTestNames);

	}
	
	public void readExcel(String sheetname) throws IOException {
		
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\Balaji Krishnan\\Desktop"));
		
		wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet(sheetname);	
		int rowCount = sheet.getLastRowNum();
		sheet.getRow(0).getPhysicalNumberOfCells();//this returns used column range
	}
	
	

}
