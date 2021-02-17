package com.axreng.backend;

import com.axreng.backend.util.URLReader;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class URLReaderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Test
    void readerTest() {
        String page = URLReader.read("http://hiring.axreng.com/");
        LOGGER.info("Reading http://hiring.axreng.com/");
        LOGGER.info(page);
    }
}