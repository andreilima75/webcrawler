package com.axreng.backend.interfaces;

import com.axreng.backend.webcrawler.Crawl;
import com.axreng.backend.webcrawler.CrawlReturn;

public interface CrawlService {

    String addCrawl(Crawl crawl);

    CrawlReturn getCrawl(String id);
}
