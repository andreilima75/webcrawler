package com.axreng.backend;

import com.axreng.backend.util.GetPropertyValues;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class GetPropertyValuesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetPropertyValuesTest.class);

    @Test
    void propertyValuesTest() {
        GetPropertyValues properties = new GetPropertyValues();
        Properties prop = properties.getPropValues();

        assertEquals("http://hiring.axreng.com/", prop.getProperty("BASE_URL"));
        assertEquals("10", prop.getProperty("MAX_RESULTS"));

        LOGGER.info("Testing empty value to URL");
        prop.setProperty("BASE_URL","");
        properties.validate(prop);
        LOGGER.info("New URL:" + prop.getProperty("BASE_URL"));

        LOGGER.info("Testing asdf value to URL");
        prop.setProperty("BASE_URL","asdf");
        properties.validate(prop);
        LOGGER.info("New URL:" + prop.getProperty("BASE_URL"));

        LOGGER.info("Testing http:hiring value to URL");
        prop.setProperty("BASE_URL","http:hiring");
        properties.validate(prop);
        LOGGER.info("New URL:" + prop.getProperty("BASE_URL"));

        LOGGER.info("Testing http:/hiring.axreng.com value to URL");
        prop.setProperty("BASE_URL","http:/hiring.axreng.com/");
        properties.validate(prop);
        LOGGER.info("New URL:" + prop.getProperty("BASE_URL"));

        LOGGER.info("Testing http://hiring.axreng.com/ value to URL");
        prop.setProperty("BASE_URL","http://hiring.axreng.com/");
        properties.validate(prop);
        LOGGER.info("New URL:" + prop.getProperty("BASE_URL"));

        LOGGER.info("Testing empty value to MAX_RESULTS");
        prop.setProperty("MAX_RESULTS","");
        properties.validate(prop);

        LOGGER.info("Testing 0 value to MAX_RESULTS");
        prop.setProperty("MAX_RESULTS","0");
        properties.validate(prop);

        LOGGER.info("Testing -10 value to MAX_RESULTS");
        prop.setProperty("MAX_RESULTS","-10");
        properties.validate(prop);

        LOGGER.info("Testing -1 value to MAX_RESULTS");
        prop.setProperty("MAX_RESULTS","-1");
        properties.validate(prop);

        LOGGER.info("Testing 10 value to MAX_RESULTS");
        prop.setProperty("MAX_RESULTS","10");
        properties.validate(prop);

    }


}