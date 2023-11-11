package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public class PrintComposition {
    public void writeText(String path, String message) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(path)) {
            try (CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new CRC32())) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
                OutputStreamWriter outputStreamWriter =
                    new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
                PrintWriter printWriter = new PrintWriter(outputStreamWriter);
                printWriter.write(message);
                printWriter.close();
                outputStreamWriter.close();
                bufferedOutputStream.close();
            }
        }
    }
}
