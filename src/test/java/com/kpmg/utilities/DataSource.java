package com.kpmg.utilities;

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

}
