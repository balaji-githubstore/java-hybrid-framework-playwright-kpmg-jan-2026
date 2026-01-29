package com.kpmg.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getSheetIntoTwoDimensionalArray(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowCount - 1][cellCount];

		DataFormatter format = new DataFormatter();
		for (int r = 1; r < rowCount; r++) {
			for (int c = 0; c < cellCount; c++) {
				data[r - 1][c] = format.formatCellValue(sheet.getRow(r).getCell(c));
			}
		}

		book.close();
		file.close();

		return data;
	}
	
	/**
	 * Reads a single cell value from the given Excel file, sheet, row, and column.
	 * @param filePath Path to the Excel file
	 * @param sheetName Name of the sheet
	 * @param rowIndex Row index (0-based)
	 * @param colIndex Column index (0-based)
	 * @return Formatted cell value as String
	 * @throws IOException if file or sheet not found
	 */
	public static String getCellValue(String filePath, String sheetName, int rowIndex, int colIndex) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetName);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(sheet.getRow(rowIndex).getCell(colIndex));
		book.close();
		file.close();
		return value;
	}

}