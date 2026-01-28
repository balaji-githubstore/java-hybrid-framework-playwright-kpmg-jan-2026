package com.kpmg.test;

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

}
