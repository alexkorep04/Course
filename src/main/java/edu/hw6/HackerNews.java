package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    public long[] hackerNewsTopStories()  {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = null;
        long[] answer = {};
        try {
            request =
                HttpRequest.newBuilder().uri(new URI("https://hacker-news.firebaseio.com/v0/topstories.json")).GET().build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try {
            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            responseBody = responseBody.substring(1, responseBody.length() - 1);
            String[] arr = responseBody.split(",");
            answer = new long[arr.length];
            for (int i = 0; i < arr.length; i++) {
                answer[i] = Long.parseLong(arr[i]);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        httpClient.close();
        return answer;
    }

    public String news(Long id) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = null;
        String answer;
        try {
            request =
                HttpRequest.newBuilder().uri(new URI("https://hacker-news.firebaseio.com/v0/item/" + id.toString() + ".json")).GET().build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try {
            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            Pattern pattern = Pattern.compile("\"title\":\"(.*?)\"");
            Matcher matcher = pattern.matcher(responseBody);
            if (matcher.find()) {
                httpClient.close();
                return matcher.group(1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        httpClient.close();
        return null;
    }
}
