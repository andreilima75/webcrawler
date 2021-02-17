package com.axreng.backend.webcrawler;

import com.axreng.backend.interfaces.CrawlService;
import com.axreng.backend.util.GenerateRandom;
import com.axreng.backend.util.Settings;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CrawlServiceImpl implements CrawlService {

    private final Map<String, Crawl> crawlMap;
    private final Spider spider;

    public CrawlServiceImpl() {
        crawlMap = new HashMap<>();
        spider = new Spider();
    }

    @Override
    public String addCrawl(Crawl crawl) {

        crawl.setId(GenerateRandom.generateRandomString(8));
        crawl.setKeyword(crawl.getKeyword().toLowerCase(Locale.ROOT));
        crawlMap.put(crawl.getId(), crawl);

        new Thread(() -> {
            spider.search(Settings.getBaseUrl(), crawl);
            crawl.setStatus("done");
        }).start();

        return crawl.getId();
    }

    @Override
    public CrawlReturn getCrawl(String id) {
        Crawl crawl = crawlMap.get(id);
        CrawlReturn crawlReturn = new CrawlReturn();
        crawlReturn.setId(crawl.getId());
        crawlReturn.setStatus(crawl.getStatus());
        crawlReturn.setUrls(crawl.getUrls());
        return crawlReturn;
    }
}
