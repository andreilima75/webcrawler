package com.axreng.backend.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
    public static String read(String url) {

        StringBuilder page = new StringBuilder();
        try {
            URL urlPage = new URL(url);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(urlPage.openStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null)
                page.append(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page.toString();
    }

}