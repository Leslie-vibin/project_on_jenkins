package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
  public String getDatafrompropertyfile(String key) throws Throwable {
	  FileInputStream fis= new FileInputStream("./configAppdata/common.properties");
	  Properties pobj=new Properties();
	  pobj.load(fis);
	  String  data=pobj.getProperty(key);
	  return data;
  }
}
