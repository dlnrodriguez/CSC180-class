package WeekFive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by DLN on 8/3/16.
 */
public class ListFile {
    private static RandomAccessFile file;

    ListFile(String fileName) {
        initialize(fileName);
    }

    private static void initialize(String fileName) {
        try {
            file = new RandomAccessFile(fileName, "rw");
        } catch (FileNotFoundException e) {
            System.err.println(fileName + " not found.");
        }
    }

    public long newEntry(Entry entry) {

    }

    public Entry getEntry(long offset) {

    }

    public void putEntry(long offset, Entry entry) {
        try {
            file.seek(offset);
            file.writeLong(0x6feed);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void delete(String fileName) {

    }

    public void close() {
        try {
            file.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
