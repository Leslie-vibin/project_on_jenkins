package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class tc_001 {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=null;
		FileInputStream fis =new FileInputStream("./configAppdata/common.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String br=pobj.getProperty("browser").toString();
		if(br.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		if(br.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		if(br.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(pobj.getProperty("url").toString());
		driver.get("http://49.249.28.218:8888/");
		driver.findElement(By.name("user_name")).sendKeys(pobj.getProperty("username").toString());
		WebElement a = driver.findElement(By.name("user_password"));
		a.sendKeys(pobj.getProperty("password").toString());
		a.submit();
		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.xpath("//a[@name='Sales Order']")).click();
		FileInputStream fas=new FileInputStream("./testdata/test script data.xlsx");
		Workbook wb=WorkbookFactory.create(fas);
		Sheet sh=wb.getSheet("Sheet1");
		String r=sh.getRow(1).getCell(0).toString();
		driver.findElement(By.xpath("//a[@title='Sales Order' and text()='"+r+"']")).click();
		driver.findElement(By.xpath("//a[.='Create Invoice']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2500);
		driver.quit();
		
		System.out.println("Invoice Created  for "+r+"  "+"Organisation SuccessFully");

	}


}
