package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileCloning {
    private final static Logger LOGGER = LogManager.getLogger();

    public void cloneFile(Path path) {
        Path directory = path.getParent();
        String name = path.getFileName().toString();
        String extension = name.substring(name.lastIndexOf('.'));
        String baseName = name.substring(0, name.lastIndexOf('.'));
        int cnt = 1;
        while (true) {
            String fileName;
            if (cnt == 1) {
                fileName = baseName + " — копия" + extension;
            } else {
                fileName = baseName + " — копия (" + cnt + ")" + extension;
            }
            Path newPath = directory.resolve(fileName);
            if (!Files.exists(newPath)) {
                try {
                    Files.copy(path, newPath, StandardCopyOption.COPY_ATTRIBUTES);
                    break;
                } catch (IOException exception) {
                    LOGGER.info(exception.getMessage());
                    break;
                }
            }
            cnt++;
        }
    }
}
