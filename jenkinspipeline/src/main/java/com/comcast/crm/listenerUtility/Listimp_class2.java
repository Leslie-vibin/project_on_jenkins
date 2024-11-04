package com.comcast.crm.listenerUtility;

import java.util.Date;
import java.util.Random;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.Basetest.Baseclass;
import com.comcast.crm.generic.Webdriverutility.Utilityclassobject;

public class Listimp_class2 implements ITestListener {

	ExtentReports report;
     ExtentTest test;
	ITestResult result;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
		Utilityclassobject.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());

		System.out.println("======I am Listening======");
		String screenShot = WebActionUtility.takeScreenshotusingbase64(Baseclass.sdriver, result.getMethod().getMethodName());
		test.addScreenCaptureFromBase64String(screenShot);

//		String screenShot = WebActionUtility.takeScreenShot(Baseclass.sdriver, result.getMethod().getMethodName());
//		test.addScreenCaptureFromPath(screenShot);
	}

	 public void onTestSkipped1(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		Random random = new Random();
		int randNum = random.nextInt(1000);
		String currentDateTime = new Date().toString().replace(":", " ").replace(" ", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report_"+currentDateTime+".html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ExtentReport");
		spark.config().setReportName("vibin");
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows10");
		report.setSystemInfo("Executed by", "vibin");
		report.setSystemInfo("reviewed By", "Deepak");  
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
