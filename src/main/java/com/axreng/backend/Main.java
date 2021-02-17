package com.axreng.backend;

import com.axreng.backend.interfaces.CrawlService;
import com.axreng.backend.util.GetPropertyValues;
import com.axreng.backend.util.Settings;
import com.axreng.backend.util.StandardResponse;
import com.axreng.backend.util.StatusResponse;
import com.axreng.backend.webcrawler.Crawl;
import com.axreng.backend.webcrawler.CrawlServiceImpl;
import com.google.gson.Gson;

import java.util.Properties;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {

    public static void main(String[] args) {

        final CrawlService crawlService = new CrawlServiceImpl();
        GetPropertyValues properties = new GetPropertyValues();
        Properties prop = properties.getPropValues();
        Settings.setBaseUrl(prop.getProperty(Settings.BASE_URL));
        Settings.setMaxResults(Integer.parseInt(prop.getProperty(Settings.MAX_RESULTS)));

        get("/crawl/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(crawlService.getCrawl(request.params(":id")));
        });

        post("/crawl", (request, response) -> {
            response.type("application/json");
            Crawl crawl = new Gson().fromJson(request.body(), Crawl.class);
            String id;
            if (crawl.getKeyword().length() < 4 || crawl.getKeyword().length() > 32) {
                return new Gson()
                        .toJson(new StandardResponse(StatusResponse.ERROR));
            } else {
                id = crawlService.addCrawl(crawl);
            }


            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS, id));
        });
    }
}
