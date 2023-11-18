package edu.hw6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private String filePath;
    private final static Logger LOGGER = LogManager.getLogger();
    private Map<String, String> cachedData;

    public DiskMap(String filePath) {
        this.filePath = filePath;
        cachedData = new LinkedHashMap<>();
    }

    private Map<String, String> readDataFromFile() {
        if (!cachedData.isEmpty()) {
            return cachedData;
        }
        Map<String, String> data = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(":");
                if (array.length == 2) {
                    data.put(array[0], array[1]);
                }
            }
        } catch (IOException exception) {
            LOGGER.info(exception.getMessage());
        }
        cachedData = new LinkedHashMap<>(data);
        return data;
    }

    private void writeDataToFile(Map<String, String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry: data.entrySet()) {
                cachedData.clear();
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException exception) {
            LOGGER.info(exception.getMessage());
        }
    }

    private void addDataToFile(String key, String value) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw")) {
            randomAccessFile.seek(randomAccessFile.length());
            cachedData.clear();
            if (randomAccessFile.length() != 0) {
                randomAccessFile.writeBytes("\n");
            }
            randomAccessFile.writeBytes(key + ":" + value);
        } catch (IOException exception) {
            LOGGER.info(exception.getMessage());
        }
    }

    @Override
    public int size() {
        return readDataFromFile().size();
    }

    @Override
    public boolean isEmpty() {
        return readDataFromFile().size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return readDataFromFile().containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return readDataFromFile().containsValue(value);
    }

    @Override
    public String get(Object key) {
        return readDataFromFile().get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String line = key + ":" + value;
        addDataToFile(key, value);
        return line;
    }

    @Override
    public String remove(Object key) {
        Map<String, String> dataFromFile = readDataFromFile();
        String str = dataFromFile.remove(key);
        writeDataToFile(dataFromFile);
        return str;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        Map<String, String> dataFromFile = new HashMap<>();
        dataFromFile = readDataFromFile();
        dataFromFile.putAll(m);
        writeDataToFile(dataFromFile);
    }

    @Override
    public void clear() {
        writeDataToFile(new HashMap<>());
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return readDataFromFile().keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return readDataFromFile().values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return readDataFromFile().entrySet();
    }

}
