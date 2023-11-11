package edu.hw6;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesFilters {

    private FilesFilters() {
    }

    public static final AbstractFilter REGULAR_FILE = Files::isRegularFile;
    public static final AbstractFilter READABLE_FILE = Files::isReadable;
    public static final AbstractFilter EXECUTABLE_FILE = Files::isExecutable;
    public static final AbstractFilter WRITABLE_FILE = Files::isWritable;

    public static AbstractFilter largerThan(int minSize) {
        return (Path path) -> {
                return Files.size(path) >= minSize;
            };
    }

    public static AbstractFilter globMatches(String string) {
        return (Path path) -> {
            String reg = "\\.";
            String neededFileExtension = string.split(reg)[1];
            String realFileExtension = new File(path.toString()).getName().split(reg)[1];
            return realFileExtension.equals(neededFileExtension);
        };
    }

    public static AbstractFilter regexContains(String string) {
        return (Path path) -> {
            Pattern pattern = Pattern.compile(string);
            File file = new File(String.valueOf(path));
            Matcher matcher = pattern.matcher(file.getName());
            return matcher.find();
        };
    }

    public static AbstractFilter magicNumber(char[] bytes) {
        return (Path path) -> {
            boolean isNormal = true;
            byte[] allBytes = Files.readAllBytes(path);
            if (allBytes.length < bytes.length) {
                isNormal = false;
            }
            for (int i = 0; i < bytes.length && isNormal; i++) {
                if (bytes[i] != allBytes[i]) {
                    isNormal = false;
                }
            }
            return isNormal;
        };
    }
}
