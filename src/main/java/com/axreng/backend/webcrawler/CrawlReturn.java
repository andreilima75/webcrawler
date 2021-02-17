package com.axreng.backend.webcrawler;

import java.util.HashSet;
import java.util.Set;

public class CrawlReturn {


    private String id;
    private String status = "active";
    private Set<String> urls = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public void setUrls(Set<String> urls) {
        this.urls = urls;
    }
}
