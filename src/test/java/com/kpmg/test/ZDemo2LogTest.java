package com.kpmg.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
/**
 * 1. update pom.xml for log4j libraries
 * 2. add src/test/resources/log4j2.xml
 * 3. try below code 
 */
public class ZDemo2LogTest {
	 private static final Logger LOGGER = LogManager.getLogger(ZDemo2LogTest.class);
	 
	 
	@Test
	public void validTest()
	{
		LOGGER.info("check info logged");
		LOGGER.error("log error************");
	}

}
