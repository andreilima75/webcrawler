package com.axreng.backend.util;

public class Settings {
    private static String baseUrl;
    private static Integer maxResults;
    public static final String BASE_URL = "BASE_URL";
    public static final String MAX_RESULTS = "MAX_RESULTS";

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        Settings.baseUrl = baseUrl;
    }

    public static Integer getMaxResults() {
        return maxResults;
    }

    public static void setMaxResults(Integer maxResults) {
        Settings.maxResults = maxResults;
    }
}
