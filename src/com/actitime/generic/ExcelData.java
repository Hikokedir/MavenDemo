package com.actitime.generic;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
	public static String getData(String filepath, String sheetName, int rowNumb, int cellNum) {
		try {
			FileInputStream fis=new FileInputStream(new File(filepath));
			Workbook wb=WorkbookFactory.create(fis);
			Cell c=wb.getSheet(sheetName).getRow(rowNumb).getCell(cellNum);
			String data=c.toString();
			return data; }
		catch(Exception e) {
			return "";
		} }
	public static int getRowCount(String filepath, String sheetN) {
		try {
			FileInputStream fis=new FileInputStream(new File(filepath));
			Workbook wb = WorkbookFactory.create(fis);
		    int rc = wb.getSheet(sheetN).getLastRowNum();
		    return rc;
		}
		catch(Exception e) {
			return 0;
		} }
	public static int getCellCount(String filepath, String sheetN, int rn) {
		try {
			FileInputStream fis=new FileInputStream(new File(filepath));
			Sheet sh = WorkbookFactory.create(fis).getSheet(sheetN);
			int cc = sh.getRow(rn).getLastCellNum();
			return cc; }
		catch(Exception e) { 
			return 0;
		} }
}