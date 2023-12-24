package edu.hw9.Task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class DirectoryFinder extends RecursiveTask<List<String>> {
    private final Path directory;
    private final int minFilesInDirectory;

    public DirectoryFinder(Path directory, int minFilesInDirectory) {
        this.directory = directory;
        this.minFilesInDirectory = minFilesInDirectory;
    }

    @Override
    protected List<String> compute() {
        List<String> ans = new ArrayList<>();
        List<DirectoryFinder> forks = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);
        try (DirectoryStream<Path> pathDirectoryStream = Files.newDirectoryStream(directory)) {
            for (Path path: pathDirectoryStream) {
                if (Files.isDirectory(path)) {
                    DirectoryFinder finder = new DirectoryFinder(path, minFilesInDirectory);
                    forks.add(finder);
                    finder.fork();
                } else if (Files.isRegularFile(path)) {
                    counter.incrementAndGet();
                }
            }
            if (minFilesInDirectory <= counter.get()) {
                ans.add(directory.toString());
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
