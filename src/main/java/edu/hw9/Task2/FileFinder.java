package edu.hw9.Task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

public class FileFinder extends RecursiveTask<List<String>> {
    private final Path directory;
    private final Predicate<Path> predicate;

    public FileFinder(Path directory, Predicate<Path> predicate) {
        this.directory = directory;
        this.predicate = predicate;
    }

    @Override
    protected List<String> compute() {
        List<String> ans = new ArrayList<>();
        List<FileFinder> forks = new ArrayList<>();
        try (DirectoryStream<Path> pathDirectoryStream = Files.newDirectoryStream(directory)) {
            for (Path path: pathDirectoryStream) {
                if (Files.isDirectory(path)) {
                    FileFinder finder = new FileFinder(path, predicate);
                    forks.add(finder);
                    finder.fork();
                } else if (Files.isRegularFile(path) && predicate.test(path)) {
                    ans.add(path.toString());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < forks.size(); i++) {
            ans.addAll(forks.get(i).join());
        }
        return ans;
    }
}
