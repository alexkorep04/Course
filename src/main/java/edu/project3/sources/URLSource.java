package edu.project3.sources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class URLSource {
    private final static Logger LOGGER = LogManager.getLogger();
    public List<String> getLogsByURL(String url){
        try(InputStream inputStream = new URI(url).toURL().openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            return bufferedReader.lines().toList();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
