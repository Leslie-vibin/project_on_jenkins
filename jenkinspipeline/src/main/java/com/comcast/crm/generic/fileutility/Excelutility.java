package com.comcast.crm.generic.fileutility;
/**
 * @author leslie vibin y
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.math3.analysis.function.Add;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	public String getDatafromexcel(String sheetname, int rownum, int celnum) throws Throwable {

		FileInputStream fis = new FileInputStream("./testdata/test script data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		Row r = s.getRow(rownum);
		Cell c = r.getCell(celnum);
		String str = c.getStringCellValue();
		wb.close();
		return str;
	}

	public int getRowcount(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/test script data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rownumber = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rownumber;

	}

	public void setDataintoexcel(String sheetname, int rownum, int celnum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/test script data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
		Row r = s.getRow(rownum);
		r.createCell(celnum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./testdata/test script data.xlsx");
		wb.write(fos);
		wb.close();

	}

	public Object[][] getMultipledata(String sheetname, int rownum, int celnum) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/test script data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetname);
         int row=getRowcount(sheetname);
		Object[][] obj=new Object[row][2];
	for (int i = 0; i<row ; i++) {
		obj[i][0]=getDatafromexcel(sheetname, i+1, 0);
		obj[i][1]=getDatafromexcel(sheetname, i+1, 1);
	}
			
			return obj;

	}
}
