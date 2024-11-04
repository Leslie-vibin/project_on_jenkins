package com.comcast.crm.generic.Webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class Utilityclassobject {
	//using static in test cannot be used for parallel execution and cross browser execution
 public static ThreadLocal<ExtentTest> test =new ThreadLocal<ExtentTest>();
 public static ThreadLocal<WebDriver> driver =new ThreadLocal<WebDriver>();
public static ExtentTest getTest() {
	return test.get();
}
public static WebDriver getdriver() {
	return driver.get();

}
public static void setTest(ExtentTest acttest) {
	test.set(acttest);
}
public static void setdriver(WebDriver actdriver) {
	driver.set(actdriver);
}
}
