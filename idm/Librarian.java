package com.idm;
import java.io.File;
import java.io.IOException;

/**
 * A simple (and contrived) Librarian class that allows storing and retrieving books by name.
 */
public class Librarian {

    private FileReaderWriter readerWriter;

    /**
     * Default constructor
     */
    public Librarian() {
        this(new FileReaderWriter());
    }

    /**
     * Constructor that supports specifying a FileReaderWriter implementation.
     */
    public Librarian(FileReaderWriter readerWriter) {
        this.readerWriter = readerWriter;
    }

    /**
     * Stores the content of a book by name.
     *
     * @param name    the name of the book
     * @param content the content of the book
     * @throws IOException
     */
    public void storeBook(String name, String content) throws IOException {
        readerWriter.saveFile(getBookFileName(name), content);
    }

    /**
     * Retrieves the content of a book by name.
     *
     * @param name the name of the book
     * @return
     * @throws IOException
     */
    public String retrieveBook(String name) throws IOException {
        return readerWriter.loadFile(getBookFileName(name));
    }

    private String getBookFileName(String name) {
        String workingDirectory = System.getProperty("user.dir");
        String bookFileName = new File(workingDirectory, name).toString() + ".txt";
        return bookFileName;
    }

    /**
     * Entry point for running the Librarian class as an application.
     *
     * @param args
     */
    public static void main(String[] args) {
        Librarian librarian = new Librarian();
        String bookName = "War and Peace";
        String bookContent = "Soooooooo much text....";
        try {
            librarian.storeBook(bookName, bookContent);
            System.out.println(librarian.retrieveBook(bookName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}