package edu.project3.sources;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;

public class URLSource {

    public List<String> getLogsByURL(String url) {
        try (InputStream inputStream = new URI(url).toURL().openStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            return bufferedReader.lines().toList();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
