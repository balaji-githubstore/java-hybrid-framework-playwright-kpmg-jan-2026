package com.kpmg.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

/**
 * All the @DataProvider required for the project.
 */
public class DataSource {

	@DataProvider
	public Object[][] invalidLoginData() {
		Object[][] data = new Object[2][3];

		data[0][0] = "saul";
		data[0][1] = "saul123";
		data[0][2] = "Invalid credentials";

		data[1][0] = "john";
		data[1][1] = "john123";
		data[1][2] = "Invalid credentials";

		return data;
	}
	
	/**
	 * CommonDataProvider to handle all @Test data. SheetName should be as per the @Test method name
	 * @param method
	 * @return Object[][]
	 * @throws IOException
	 */
	@DataProvider
	public Object[][] commonDataProvider(Method method) throws IOException
	{
		//SheetName is @Test method name
		//method.getName(); --> Current @Test name which is nothing the sheetName
		String sheetName= method.getName();
		
		Object[][] data=ExcelUtils.getSheetIntoTwoDimensionalArray
				("test-data/orange-hrm-data.xlsx",sheetName);
		return data;
	}

}
