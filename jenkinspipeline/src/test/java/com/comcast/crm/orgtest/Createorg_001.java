package com.comcast.crm.orgtest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class Createorg_001 {

	public static void main(String[] args) throws Throwable {
		////practising with utility
		FileUtility f=new FileUtility();
         String br= f.getDatafrompropertyfile("browser");
         String url=f.getDatafrompropertyfile("url");
         String username=f.getDatafrompropertyfile("username");
         String pass=f.getDatafrompropertyfile("password");
         WebDriver driver=null;
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
 		driver.get(url);
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		WebElement a = driver.findElement(By.name("user_password"));
		a.sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		Random ran=new Random();
		int number=ran.nextInt(1000);
		
		Excelutility ex=new Excelutility();
		int rownum=ex.getRowcount("sheet1");
		System.out.println(rownum);
		String st=ex.getDatafromexcel("sheet1", 1, 0);
		System.out.println(st);
		ex.setDataintoexcel("sheet1", 4, 7,"Energy5");
		
 		
	}
}
