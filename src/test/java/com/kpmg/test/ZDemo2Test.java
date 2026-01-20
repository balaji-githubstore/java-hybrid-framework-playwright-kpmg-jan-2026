package com.kpmg.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Will be deleted. Not part of framework. Just listen
 */
public class ZDemo2Test {

	public static void main(String[] args) throws IOException  {
		
		FileInputStream file=new FileInputStream("test-data/orange-hrm-data.xlsx");
		
		XSSFWorkbook book=new XSSFWorkbook(file);
		
		XSSFSheet sheet= book.getSheet("invalidLoginTest");
		
		String value= sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(value);
		
		//write logic to print all cell values
		
		book.close();
		file.close();
	}

}
