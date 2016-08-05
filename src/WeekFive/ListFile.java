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

    public static void initialize(String fileName) {
        if (!fileName.endsWith(".bin"))
            fileName = fileName + ".bin";
        try {
            file = new RandomAccessFile(fileName, "rw");
        } catch (FileNotFoundException e) {
            System.err.println(fileName + " not found.");
        }
    }

    public long newEntry(Entry entry) {
        return (long) entry.hashCode();
    }

    public Entry getEntry(long offset) {
        try {
            file.seek(offset * 8);
            file.readLong();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return new Entry("", 0, 0);
    }

    public void putEntry(long offset, Entry entry) {
        try {
            file.seek(offset * 8);
            file.writeLong(entry.getValue());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static boolean delete(String fileName) {
        File f = new File(fileName);
        return f.delete();
    }

    public void close() {
        try {
            file.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
