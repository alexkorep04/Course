package edu.hw6;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    default AbstractFilter and(AbstractFilter second) {
        return path -> accept(path) && second.accept(path);
    }
}
