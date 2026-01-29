package com.kpmg.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ZDemoExtentReport {
	
	public static void main(String[] args) {
		
		//run in the beginning - only once --> @BeforeSuite
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		//Before each @Test --> create a test --> @BeforeMethod
		ExtentTest test= extent.createTest("MyFirstTest");
		
		test.log(Status.INFO, "Entered username ");
		
		//after each @Test --> check @Test and add status --> @AfterMethod
		test.log(Status.FAIL, "This is a logging event for MyFirstTest, and it passed!");
		
		
		//flush at the report --> at the end of all test ---> @AfterSuite
		extent.flush();

	}

}
