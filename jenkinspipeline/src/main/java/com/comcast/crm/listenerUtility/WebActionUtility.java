package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WebActionUtility {
	@Test
	
	public static String takeScreenShot(WebDriver driver, String screenShotName) { 
	TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
	File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
	LocalDateTime dateTime = LocalDateTime.now();
	 
	File dst = new File("./Screenshort/" + screenShotName +"+"+dateTime+".png");
	try {
	FileUtils.copyFile(src, dst);}
	catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();}
	return screenShotName;}
	@Test
	public static String takeScreenshotusingbase64(WebDriver driver, String screenShotName) {
		TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
		String  src = takesSceenShot.getScreenshotAs(OutputType.BASE64);
		return src;
		
	}
}
