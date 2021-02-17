package com.axreng.backend.webcrawler;

import java.util.HashSet;
import java.util.Set;

public class Crawl {

    private String keyword;
    private String id;
    private String status = "active";
    private Set<String> urls = new HashSet<>();
    private Integer numberOfPagesVisited = 0;
    private Set<String> pagesVisited = new HashSet<>();

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

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

    public Integer getNumberOfPagesVisited() {
        return numberOfPagesVisited;
    }

    public void setNumberOfPagesVisited(Integer numberOfPagesVisited) {
        this.numberOfPagesVisited = numberOfPagesVisited;
    }

    public Set<String> getPagesVisited() {
        return pagesVisited;
    }

    public void setPagesVisited(Set<String> pagesVisited) {
        this.pagesVisited = pagesVisited;
    }
}
