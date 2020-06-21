package com.wellsfargo.common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import TestBase.BaseTestCase;

public class CommonMethods{
	
//	static WebDriver driver;
//	static WebElement tblSample= driver.findElement(By.xpath(prop.getProperty("tblSample")));
	
	public boolean validateLinksInTable(WebElement table, String expectedValue) {
		
		boolean blnFlag=false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for(WebElement row:rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for(WebElement col:cols) {
				String actualValue = col.getText();
				if(expectedValue.equalsIgnoreCase(actualValue)) {
					blnFlag=true;
					break;
				}
			}
		}
		return blnFlag;		
	   
	}
	
	public static List<String> getAllDropDownValues(WebElement drpdwn){
		
		Select lst=new Select(drpdwn);
		
		List<WebElement> options = lst.getOptions();	
		List<String> values=new ArrayList<>();
		
		for(WebElement we:options) {
				values.add(we.getText());
		}
		
		return values;
	}
	
	public static boolean verifyDropDownValues(WebElement obj,String[] arr) {
		boolean blnFlag=false;
		List<String> expectedVals=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			expectedVals.add(arr[i]);
		}
		List<String> actualVals=CommonMethods.getAllDropDownValues(obj);
		System.out.println(expectedVals);
		System.out.println(actualVals);
		
		if(actualVals.equals(expectedVals)) {
			blnFlag=true;
		}
		
		return blnFlag;
		
		
	}
	
	
	
}
