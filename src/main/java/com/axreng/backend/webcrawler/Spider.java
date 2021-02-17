package com.axreng.backend.webcrawler;

import com.axreng.backend.util.Settings;
import com.axreng.backend.util.URLReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spider {

    private static final Logger LOGGER = LoggerFactory.getLogger(Spider.class);

    public void search(String url, Crawl crawl) {

        if (Settings.getMaxResults() > crawl.getNumberOfPagesVisited()) {

            if (!crawl.getPagesVisited().contains(url)) {
                LOGGER.debug("Started search for " + crawl.getKeyword() + " in page " + url);
                crawl.getPagesVisited().add(url);
                crawl.setNumberOfPagesVisited(crawl.getNumberOfPagesVisited() + 1);

                String page = URLReader.read(url);

                Set<String> links = grabHTMLLinks(page, url);

                if (page.toLowerCase(Locale.ROOT).contains(crawl.getKeyword())) {
                    crawl.getUrls().add(url);
                }

                for (String link : links)
                    this.search(link, crawl);

            }
        }

    }


    private static Set<String> grabHTMLLinks(final String html, final String url) {
        LOGGER.debug("URL: " + url);
        Set<String> result = new HashSet<>();

        Pattern patternLink;
        Matcher matcherLink;

        String HTML_A_HREF_TAG_PATTERN =
                "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";

        patternLink = Pattern.compile(HTML_A_HREF_TAG_PATTERN);
        matcherLink = patternLink.matcher(html);

        while (matcherLink.find()) {
            String link = matcherLink.group(1).replace("\"", "");
            LOGGER.debug("Link: " + link);

            if (link.contains(Settings.getBaseUrl()))
                result.add(link);

            if (!link.contains("http")
                    && url.contains(Settings.getBaseUrl())
                    && !link.contains("../")
                    && !link.contains("mailto:")
                    && !link.contains("ftp:"))
                result.add(Settings.getBaseUrl() + link);
        }

        return result;

    }
}
