package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Tc_004orgcontactconnect {

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
		Random ran=new Random();
		int number=ran.nextInt(1000);
		
		FileInputStream fas=new FileInputStream("E:\\viteger\\test script data.xlsx");
		Workbook wb=WorkbookFactory.create(fas);
		Sheet sh=wb.getSheet("Sheet1");
		String orgname=sh.getRow(3).getCell(0).toString()+number;
		String contact2=sh.getRow(3).getCell(6).getStringCellValue();
		String type=sh.getRow(2).getCell(7).getStringCellValue();
		String rating=sh.getRow(2).getCell(8).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(contact2);
		
		Select sel=new Select(driver.findElement(By.xpath("//select[@name='industry']")));
	    sel.selectByVisibleText(type);
	       
	    Select sel1=new Select(driver.findElement(By.xpath("//select[@name='rating']")));
	    sel1.selectByVisibleText(rating);
	    Select sel2=new Select(driver.findElement(By.xpath("//select[@name='accounttype']")));
	    sel2.selectByVisibleText("Investor");
	    
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		String confirm=driver.findElement(By.xpath("//span[contains(text(),'"+orgname+"')]")).getText();
	    if (confirm.contains("nippon")) {System.out.println("verified");
			
		}
	    else {System.out.println("not verified");}
	    String confirmno=driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
	    if (confirmno.contains(contact2)) {System.out.println("verifiednumber");
			
		}
	    else {System.out.println("not verifiednumber");}
	    //creation of contact
	    driver.findElement(By.xpath("(//a[contains(text(),'Contacts')])[1]")).click();	
		driver.findElement(By.xpath("(//img[@title='Create Contact...'])[1]")).click();
		Random ran1=new Random();
		int numbe1r=ran1.nextInt(1000);
		
		FileInputStream fas1=new FileInputStream("E:\\viteger\\test script data.xlsx");
		Workbook wb1=WorkbookFactory.create(fas1);
		Sheet sh1=wb.getSheet("Sheet1");
		String lastname=sh.getRow(4).getCell(0).toString()+number;
		String contact1=sh.getRow(4).getCell(6).getStringCellValue();
		
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
		
		///new window
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		Set<String> children=driver.getWindowHandles();
		Iterator<String> lt= children.iterator();
		while(lt.hasNext()) {
			String url=lt.next();
			   driver.switchTo().window(url);
			  String title= driver.getTitle();
			System.out.println(title);
			if (title.contains("Accounts&action")) {
				break;
			}
		}
		
		
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		Set<String> children1=driver.getWindowHandles();
		Iterator<String> lt1= children1.iterator();
		while(lt1.hasNext()) {
			String url=lt1.next();
			driver.switchTo().window(url);
			String title=driver.getTitle();
			System.out.println(title);
			if (url.contains("Contacts&action")) {
				break;
			}
		}
		
		
		driver.findElement(By.id("mobile")).sendKeys(contact1);
		//creation of date and calender
		Date date =new Date();
       // System.out.println(date);
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
		String con=driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
String con2=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
 //System.out.println(con2);
        if (con.trim().equalsIgnoreCase(orgname)) {System.out.println("org verified");
			
		}
        if (con2.trim().contains(lastname)) {System.out.println("contact connected with org");
			
		}
       //  driver.close();
	}

}
