package com.kpmg.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ZDemoLog4jTest {
	private static final Logger log =
	        LogManager.getLogger(ZDemoLog4jTest.class);


	@Test(groups = "smoke")
    void logCheck() {
        log.info("LOG4J WORKING");
        log.error("ERROR TEST");
    }

}
