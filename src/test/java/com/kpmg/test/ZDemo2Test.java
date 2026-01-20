package com.kpmg.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Will be deleted. Not part of framework. Just listen
 */
public class ZDemo2Test {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("test-data/orange-hrm-data.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheet("invalidLoginTest");
		
		Object[][] data=new Object[2][3];

		// write logic to print all cell values
		for (int r = 1; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				String value = sheet.getRow(r).getCell(c).getStringCellValue();
				System.out.println(value);
				data[r-1][c]=value;
			}
		}

		book.close();
		file.close();
	}

}
