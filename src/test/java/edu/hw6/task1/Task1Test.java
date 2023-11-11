package edu.hw6.task1;

import edu.hw6.DiskMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    private static final String DIRECTORY = "./src/test/java/edu/hw6/task1/";
    DiskMap diskMap;
    @BeforeEach
    public void createObject() throws IOException {
        Files.deleteIfExists(Path.of(DIRECTORY+"test.txt"));
        diskMap = new DiskMap(DIRECTORY + "test.txt");
    }
    @Test
    @DisplayName("Test put method")
    public void testPut() throws IOException {
        diskMap.put("hello", "world");
        diskMap.put("goodbye", "world");

        List<String> expected = List.of("hello:world", "goodbye:world");
        List<String> response = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(DIRECTORY + "test.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response.add(line);
            }
        }

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test get method")
    public void testGet() throws IOException {
        diskMap.put("hello", "world");
        diskMap.put("goodbye", "world");

        String expected = "world";

        String response = diskMap.get("hello");

        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test remove method")
    public void testRemove() throws IOException {
        diskMap.put("hello", "world");
        diskMap.put("goodbye", "world");
        diskMap.put("123", "12");

        diskMap.remove("goodbye");
        List<String> expected = List.of("hello:world", "123:12");
        List<String> response = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(DIRECTORY + "test.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response.add(line);
            }
        }

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test size method")
    public void testSize() throws IOException {
        diskMap.put("hello", "world");
        diskMap.put("goodbye", "world");

        int expected = 2;

        int response = diskMap.size();

        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Test isEmpty method")
    public void testIsEmpty() throws IOException {
        diskMap.put("hello", "world");

        boolean response = diskMap.isEmpty();

        assertThat(response).isFalse();
    }
    @Test
    @DisplayName("Test containKey method")
    public void testContainKey() throws IOException {
        diskMap.put("hello", "world");

        boolean response = diskMap.containsKey("hello");

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test contain value method")
    public void testContainValue() throws IOException {
        diskMap.put("hello", "world");

        boolean response = diskMap.containsValue("world");

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test clear method")
    public void testClear() throws IOException {
        diskMap.put("hello", "world");
        diskMap.clear();

        boolean response = diskMap.isEmpty();

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test put all method")
    public void testPutAll() throws IOException {
        diskMap.put("4", "1");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("hello", "world");
        map.put("goodbye", "world");
        diskMap.putAll(map);

        List<String> expected = List.of("4:1", "hello:world", "goodbye:world");
        List<String> response = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(DIRECTORY + "test.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response.add(line);
            }
        }

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }
}
