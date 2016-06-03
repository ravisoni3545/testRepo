package com.idm;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * A simple (and contrived) class that reads and writes text files.
 */
public class FileReaderWriter {
    /**
     * Write string contents to a text file.
     *
     * @param fileName the full path to the file
     * @param content  the content to write
     * @throws IOException
     */
    public void saveFile(String fileName, String content) throws IOException {
        FileWriter writer = new FileWriter(new File(fileName), false);
        writer.write(content);
        writer.close();
    }

    /**
     * Read string contents from a text file.
     *
     * @param fileName the full path to the file
     * @return         the string contents of the file
     * @throws IOException
     */
    public String loadFile(String fileName) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(fileName));
        return new String(encoded, Charset.defaultCharset());
    }
}