package com.kpmg.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Will be deleted. Not part of framework. Just listen
 */
public class ZDemo1Test {

	@DataProvider
	public Object[][] validData() {
		Object[][] data = new Object[3][2];
		// i--> number of test case
		// j-->number of arguments

		data[0][0] = "john";
		data[0][1] = "john123";

		data[1][0] = "peter";
		data[1][1] = "peter123";

		data[2][0] = "kim";
		data[2][1] = "kim123";

		return data;
	}

	@Test(dataProvider = "validData")
	public void validTest(String username, String password) {
		System.out.println("valid " + username + password);
	}
}
