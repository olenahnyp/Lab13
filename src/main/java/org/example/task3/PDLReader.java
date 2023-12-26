package org.example.task3;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class PDLReader {

    @SneakyThrows
    public static CompanyData extract(String domain) {
        URL url = new URL(domain);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        try {
            String html = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
            return parseHtml(domain, html);
        } finally {
            connection.disconnect();
        }
    }

    private static CompanyData parseHtml(String domain, String html) {
        Document doc = Jsoup.parse(html);

        String name = doc.title();
        Element descriptionElement = doc.select("meta[name=description]").first();
        String description = (descriptionElement != null) ? descriptionElement.attr("content") : "";

        Element logoElement = doc.select("img[src*=/logo], img[class*=logo], img[alt*=logo], img[src$=.png], img[src$=.jpg]").first();
        String logo = (logoElement!= null) ? logoElement.absUrl("src") : "";

        CompanyData company = new CompanyData(domain, description, logo, name);

        return company;
    }

}
