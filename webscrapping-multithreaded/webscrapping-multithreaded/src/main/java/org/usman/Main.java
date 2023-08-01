package org.usman;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

        private static final int THREAD_POOL_SIZE = 7;

        public static void main(String[] args) {
            List<String> urls = new ArrayList<>();
            urls.add("https://scrapeme.live/shop/");
            urls.add("https://scrapeme.live/shop/page/2/");
            // Add more URLs you want to scrape...

            Main scraper = new Main();
            scraper.scrapeUrls(urls);
        }

        public void scrapeUrls(List<String> urls) {
            ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            for (String url : urls) {
                executorService.submit(() -> {
                    try {
                        scrapeData(url);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

            executorService.shutdown();
            try {
                executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void scrapeData(String url) throws IOException {
            System.out.println(url);
            Document doc = Jsoup.connect(url).get();
            System.out.println(doc);

        }


}