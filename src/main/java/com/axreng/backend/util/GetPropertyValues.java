package com.axreng.backend.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class GetPropertyValues {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetPropertyValues.class);
    InputStream inputStream;

    public Properties getPropValues() {
        Properties prop = new Properties();
        try {

            String propFileName = "application.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.validate(prop);
        return prop;
    }

    public void validate(Properties prop) {
        try {
            URL u = new URL(prop.getProperty(Settings.BASE_URL));
            u.toURI();
            prop.setProperty(Settings.BASE_URL, u.toURI().toString());
        } catch (MalformedURLException | URISyntaxException e) {
            LOGGER.error("Invalid URL:" + e.getMessage());
            System.exit(1);
        }
        try {
            int maxResults = Integer.parseInt(prop.getProperty(Settings.MAX_RESULTS));

            if (maxResults < -1 || maxResults == 0) {
                prop.setProperty(Settings.MAX_RESULTS, "-1");
                LOGGER.info(Settings.MAX_RESULTS + " value set to -1");
            }
        } catch (Exception e) {
            prop.setProperty(Settings.MAX_RESULTS, "-1");
            LOGGER.info(Settings.MAX_RESULTS + " value set to -1");
        }


    }
}
