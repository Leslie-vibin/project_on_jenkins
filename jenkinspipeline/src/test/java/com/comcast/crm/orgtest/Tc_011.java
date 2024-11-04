package com.comcast.crm.orgtest;

import org.testng.annotations.Test;

import com.comcast.crm.Basetest.Baseclass;
import com.comcast.crm.ObjectRepositoryUtility.Contactsinfopage;
import com.comcast.crm.ObjectRepositoryUtility.Homepage;

public class Tc_011 extends Baseclass {
	@Test
	public void Accessorgfromcontact() throws Exception {
		Homepage hp= new Homepage(driver);
		hp.getContactlink().click();
		Contactsinfopage cif=new Contactsinfopage(driver);
		cif.getFindorglnk().click();
		Thread.sleep(5000);
		 
		
	}

}
