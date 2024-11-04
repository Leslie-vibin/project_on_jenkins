package com.comcast.crm.product;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.Webdriverutility.Javautility;
import com.comcast.crm.generic.Webdriverutility.Webdriverutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class Trial_multiplerow {

	public static void main(String[] args) throws Throwable {
		FileUtility flib = new FileUtility();
		Excelutility elib = new Excelutility();
		Javautility jlib = new Javautility();
		Webdriverutility wlib = new Webdriverutility();
		String browser = flib.getDatafrompropertyfile("browser");
		String url = flib.getDatafrompropertyfile("url");
		String user = flib.getDatafrompropertyfile("username");
		String pass = flib.getDatafrompropertyfile("password");
		// WebDriver driver= null;
		WebDriver driver = jlib.chooseBrowser(browser);
		driver.navigate().to(url);
		driver.get(url);
		wlib.waitforpagetoload(driver, 10);
		driver.findElement(By.name("user_name")).sendKeys(user);
		driver.findElement(By.name("user_password")).sendKeys(pass);

		driver.findElement(By.id("submitButton")).click();
//		//ArrayList<String> data = elib.getMultipledata("org", 1, 0);
//		Iterator<String> single = data.iterator();
//		while (single.hasNext()) {
//			String s = single.next();
//			System.out.println(s);
//		}
//		System.out.println(data);
//	}

}}
