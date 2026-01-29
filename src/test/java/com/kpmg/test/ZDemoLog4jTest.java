package com.kpmg.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Add mvn - log4j-api, log4j-core, log4j-slf4j2-impl from groupid- org.apache.logging.log4j
 * Add log4j2.xml with log level as DEBUG
 * Add below code
 */
public class ZDemoLog4jTest {
	private static final Logger log =
	        LogManager.getLogger(ZDemoLog4jTest.class);


	@Test(groups = "smoke")
    void logCheck() {
        log.info("LOG4J WORKING");
        log.error("ERROR TEST");
    }
	

	@Test
    void readPropTest() throws FileNotFoundException, IOException {
      
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/test/resources/config.properties"));
		
		String url = prop.getProperty("url");
		System.out.println(url);
    }

}
