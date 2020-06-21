package com.wellsfargo.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestBase.BaseTestCase;

public class Module2 extends BaseTestCase{
	
	/*
	 * private WebElement lnkGoogleApps =
	 * driver.findElement(By.xpath(prop.getProperty("lnkGoogleApps")));
	 * 
	 * public WebElement getLnkGoogleApps() { return lnkGoogleApps; }
	 */
	
	@Test
	public void testCase1M2() {
		try {
			driver.findElement(By.xpath(prop.getProperty("lnkGoogleApps"))).click();
			Thread.sleep(2000);
			System.out.println("testCase1M2");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	@Test
	public void testCase2M2() throws Exception{
		driver.findElement(By.xpath(prop.getProperty("lnkGoogleApps"))).click();
		Thread.sleep(2000);
		System.out.println("testCase2M2");
	}
	
	@Test
	public void testCase3M2() throws Exception {
		driver.findElement(By.xpath(prop.getProperty("lnkGoogleApps"))).click();
		Thread.sleep(2000);
		System.out.println("testCase3M2");
	}
	

}
