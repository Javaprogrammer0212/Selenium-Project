package com.wellsfargo.TestCases;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.wellsfargo.common.CommonMethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TestBase.BaseTestCase;

//@Listeners(utility.ListenerTest.class)
public class Module1 extends BaseTestCase{	
	
//	@FindBy(id="abc")
//	WebElement uid;
//	public WebElement txtGoogleSearch = driver.findElement(By.xpath(prop.getProperty("txtGoogleSearch")));
	/*
	 * @FindBy(xpath = "//input[@title='Search']") public WebElement
	 * txtGoogleSearch;
	 */

	
//	public WebElement getTxtGoogleSearch() {
//		return txtGoogleSearch;
//	}
//	public static WebElement tblSample= driver.findElement(By.xpath(prop.getProperty("tblSample")));

	@Test
	public void testCase1M1() {
//		try {
//			Module1 m1 = new Module1();
//			Thread.sleep(3000);
//			txtGoogleSearch.sendKeys("testcase1");
			logger=reports.createTest("testcase1M1");
			WebElement searchBox=driver.findElement(By.xpath(prop.getProperty("txtGoogleSearch")));
			searchBox.sendKeys("testcase1");
//			Thread.sleep(2000);
			driver.navigate().refresh();
//			Thread.sleep(5000);
			try {
				searchBox.sendKeys("testcase1");
			}catch(StaleElementReferenceException e) {
				searchBox=driver.findElement(By.xpath(prop.getProperty("txtGoogleSearch")));
				searchBox.sendKeys("testcase1");
			}
			logger.log(Status.PASS,"Entered text in search field");
			System.out.println("testCase1M1");
			
//			File f=new File("c:\\Balaji.txt");
//			FileReader fr=new FileReader(f);//shows compilation error when throws exception is not declared
//		}catch(Exception e) {
//			logger.log(Status.FAIL, e.getMessage());
//			throw e;
//		}
		
	}
	
	@Test
	public void testCase2M1() throws Exception {
//		txtGoogleSearch.sendKeys("testcase2");
		try {
			logger=reports.createTest("testcase2M1");
			driver.findElement(By.xpath(prop.getProperty("txtGoogleSearch"))).sendKeys("testcase2");
			Thread.sleep(2000);
			logger.log(Status.PASS,"Entered text in search field");
			System.out.println("testCase2M1");
			
		}catch(Exception e) {
			logger.log(Status.FAIL, e.getMessage());
			throw e;
		}
		
	}
	
	@Test
	public void testCase3M1() throws Exception {
//		txtGoogleSearch.sendKeys("testcase3");
//		try {
			logger=reports.createTest("testcase3M1");
			WebElement search=driver.findElement(By.xpath(prop.getProperty("txtGoogle")));
			search.sendKeys("testcase3");
			Thread.sleep(2000);
			logger.log(Status.PASS,"Text is entered");
			System.out.println("testCase3M1");
//		}catch(Exception e) {
//			logger.log(Status.FAIL, e.getMessage());
//			System.out.println(e.getMessage());
//			throw e;
//		}
		
	}
	
	@Test
	public static void sampleTable() throws Exception{
		logger=reports.createTest("SampleTable");
		CommonMethods cm = new CommonMethods();
		boolean blnVal = cm.validateLinksInTable(driver.findElement(By.xpath(prop.getProperty("tblSample"))),"UAE");
		if(blnVal==true) {
			logger.log(Status.PASS, "UAE is present in the table");
			System.out.println("UAE is present in the table");
		}else {
			logger.log(Status.PASS, "UAE is not present in the table");
		}
		
	}
	
	@Test
	public void verifyDays() {
		logger=reports.createTest("verifyDays");
		WebElement drpdown = driver.findElement(By.xpath(prop.getProperty("drpdownDemo")));
		boolean status=CommonMethods.verifyDropDownValues(drpdown,new String[] {"Please select", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"});
		if(status==true) {
			logger.log(Status.PASS, "Expected days are present in the list");
		}else {
			logger.log(Status.FAIL, "Expected days are present in the list");
		}
	}
	
	@Test(enabled=false)
	public void testCaseEnabling(){
			System.out.println("I'm Not Ready, please don't execute me");
		}
	@Test
	public void testCaseSkipException(){
			System.out.println("Im in skip exception");
			throw new SkipException("Skipping this exception");
		}

	@Test
	public void testCaseConditionalSkipException(){
		int DataAvailable=0;
		System.out.println("Im in Conditional Skip");
		if(DataAvailable==0)
		throw new SkipException("Skipping this exception");
		System.out.println("Executed Successfully");
	}

}
