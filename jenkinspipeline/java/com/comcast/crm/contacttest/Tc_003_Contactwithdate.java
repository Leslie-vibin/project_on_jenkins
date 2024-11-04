package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tc_003_Contactwithdate {
	

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		FileInputStream fis =new FileInputStream("E:\\viteger\\commondata\\common.properties");
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
		driver.findElement(By.name("user_name")).sendKeys(pobj.getProperty("username").toString());
		WebElement a = driver.findElement(By.name("user_password"));
		a.sendKeys(pobj.getProperty("password").toString());
		a.submit();
		driver.findElement(By.xpath("(//a[contains(text(),'Contacts')])[1]")).click();	
		driver.findElement(By.xpath("(//img[@title='Create Contact...'])[1]")).click();
		Random ran=new Random();
		int number=ran.nextInt(1000);
		
		FileInputStream fas=new FileInputStream("E:\\viteger\\test script data.xlsx");
		Workbook wb=WorkbookFactory.create(fas);
		Sheet sh=wb.getSheet("Sheet1");
		String orgname=sh.getRow(2).getCell(0).toString()+number;
		String contact=sh.getRow(2).getCell(6).getStringCellValue();
		driver.findElement(By.name("lastname")).sendKeys(orgname);
		driver.findElement(By.id("mobile")).sendKeys(contact);
		//creation of date and calender
		Date date =new Date();
        System.out.println(date);
        //Tue Sep 17 11:03:06 IST 2024
        //yyyy/mm/dd
       
        
        SimpleDateFormat date1=new SimpleDateFormat("YYYY-MM-dd");
       String startdate= date1.format(date);
      // System.out.println(dateact);
      
                
       Calendar calender=date1.getCalendar();
       calender.add(calender.DAY_OF_MONTH, 30);
      String enddate= date1.format(calender.getTime());
     // System.out.println(datereq);
       
		
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(enddate);
		
		
		
		
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		

	}

}
