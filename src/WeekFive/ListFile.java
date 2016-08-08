package WeekFive;

import WeekFour.PersistentArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by DLN on 8/3/16.
 */
public class ListFile extends PersistentArray {
    private static RandomAccessFile file;

    ListFile(String fileName) {
        super(fileName);
    }

    public static void initialize(String fileName) {
        if (!fileName.endsWith(".bin"))
            fileName = fileName + ".bin";
        try {
            file = new RandomAccessFile(fileName, "rw");
            file.close();
        } catch (IOException e) {
            System.err.println("Error message: " + e.getMessage());
        }
    }

    public long newEntry(Entry entry) {
        return (long) entry.hashCode();
    }

    public Entry getEntry(long offset) {
        this.get((int) offset);
        return new Entry("", 0, 0);
    }

    public void putEntry(long offset, Entry entry) {
        this.set(offset, newEntry(entry));
    }

    public static void delete(String fileName) {
        File f = new File(fileName);
        f.delete();
    }

    public void close() {
        try {
            file.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


}
