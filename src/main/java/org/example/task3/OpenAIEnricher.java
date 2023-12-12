package org.example.task3;

import lombok.SneakyThrows;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

public class OpenAIEnricher {
    @SneakyThrows
    public static Map<String, String> extract(String domain) {
        URL url = new URL(domain);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        System.out.println(text);
        return null;
    }
}
