package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.FileUtil;

public class Reporting {
	
	static ExtentHtmlReporter htmlreporter;
	static ExtentReports reports;
	static ExtentTest logger ;
	static WebDriver driver;
	
	public static void Log() {
		
		htmlreporter = new ExtentHtmlReporter(new File(".\\Reports\\HtmlReport.html"));
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		logger = reports.createTest("testcase1");
		
		logger.log(Status.PASS, "TestCase1 Started");
		
		logger.log(Status.INFO, "TestCase1 Executed");
		
	
	}
	
	public static void reportingTerminate() {
		
		reports.flush();
	}
	
	public static void takeScreenshot(WebDriver driver,String screenshotname) throws Exception {
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
//			File des = new File(".\\Screenshots\\+screenshotname+".png");
			
			FileHandler.copy(src,new File("./Screenshots/"+screenshotname+".png"));
			System.out.println("Screenshot taken");
		}catch(Exception e) {
			System.out.println("Exception while taking screenshot"+e.getMessage());
		}
		
	}
}
