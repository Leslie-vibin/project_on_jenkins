package com.comcast.crm.vendortest;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.ObjectRepositoryUtility.CreateNewProductpage;
import com.comcast.crm.ObjectRepositoryUtility.Documentspage;
import com.comcast.crm.ObjectRepositoryUtility.Homepage;
import com.comcast.crm.ObjectRepositoryUtility.Login;
import com.comcast.crm.ObjectRepositoryUtility.NewVendorCreation;
import com.comcast.crm.ObjectRepositoryUtility.Productinfopage;
import com.comcast.crm.ObjectRepositoryUtility.Productspage;
import com.comcast.crm.ObjectRepositoryUtility.VendorInfopage;
import com.comcast.crm.ObjectRepositoryUtility.Vendorspage;
import com.comcast.crm.ObjectRepositoryUtility.createNewDocumentpage;
import com.comcast.crm.generic.Webdriverutility.Javautility;
import com.comcast.crm.generic.Webdriverutility.Webdriverutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class tc_001 {

	public static void main(String[] args) throws Throwable {
		FileUtility flib =new FileUtility();
		Excelutility elib =new Excelutility();
		Javautility jlib=new Javautility();
		Webdriverutility wlib=new Webdriverutility();
        String browser=flib.getDatafrompropertyfile("browser");
		String url=flib.getDatafrompropertyfile("url");
		String user=flib.getDatafrompropertyfile("username");
		String pass=flib.getDatafrompropertyfile("password");
		WebDriver driver=jlib.chooseBrowser(browser);
		Login lg=new Login(driver);
	    Homepage hp=new Homepage(driver);
		driver.navigate().to(url);
		driver.get(url);
		wlib.waitforpagetoload(driver, 10);
		lg.logintoapp(url,user, pass);
		hp.navigatetoVendorsPage();
	String vendorname=	elib.getDatafromexcel("org", 2, 12);
	Vendorspage vp=new Vendorspage(driver);
	vp.getAddnewVendor().click();
	NewVendorCreation nvc=new NewVendorCreation(driver);
	nvc.getVendorNAMETXT().sendKeys(vendorname);
	nvc.getSavelnk().click();
	VendorInfopage vi=new VendorInfopage(driver);
	String header=vi.getHeadertxtlnk().getText();
	if (header.contains(vendorname)) {System.out.println("the vendor names are verified");
		
	}
	else {System.out.println("the names are not verified");}
	hp.getProductlink().click();
	Productspage pp=new Productspage(driver);
	pp.getAddnewProductlnk().click();
	CreateNewProductpage cnpp=new CreateNewProductpage(driver);
	String product=elib.getDatafromexcel("org", 1, 9);
	cnpp.getProductnametxt().sendKeys(product);

	cnpp.getStartdatelnk().sendKeys(jlib.getSystemdate());
	cnpp.getEnddatelnk().sendKeys(jlib.getrequrieddDate(15));
	cnpp.getExpirydatelnk().sendKeys(jlib.getrequrieddDate(30));
	cnpp.addVendorToproduct(vendorname);
String file=elib.getDatafromexcel("org", 1, 13);
wlib.SwitchtoWindowOnTITLE(driver, "Products&action");
	cnpp.getNewfile().sendKeys(file);
	cnpp.getSavelnk().click();
	Productinfopage pif=new Productinfopage(driver);
	String header1=pif.getHeadertxtlnk().getText();
	if (header1.contains(product)) {System.out.println("the product names are verified");
	}
	else {System.out.println("the  product names are not verified");}

hp.signout();
driver.quit();
	}


}
