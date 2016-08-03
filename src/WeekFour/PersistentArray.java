package WeekFour;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by DLN on 8/1/16.
 */
public class PersistentArray {
    private static RandomAccessFile file;

    public PersistentArray(String fileName) {
        if (!fileName.endsWith(".bin"))
            fileName = fileName + ".bin";
        int size = 0;
        long initialValue = 0;
        initialize(fileName, size, initialValue);
    }

    public static void initialize(String fileName, int size, long initialValue) {
        try {
            file = new RandomAccessFile(fileName, "rw");
            file.setLength(size);
            file.seek(initialValue);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void set(int index, long value) {
        try {
            file.seek(index * 8);
            file.writeLong(value);
        } catch (IOException e) {
            System.err.println("Cannot set " + index + " to " + value + "!");
        }
    }

    public long get(int index) {
        try {
            file.seek(index * 8);
            return file.readLong();
        } catch (EOFException e) {
            System.err.println("End of file!");
        } catch (IOException e) {
            System.err.println("Can't read line!");
        }
        return -0;
    }

    public long getLength() {
        try {
            return (file.length());
        } catch (IOException e) {
            System.err.println("Length not found!");
        }
        return 0;
    }

    public void close() {
        try {
            file.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static boolean delete(String fileName) {
        File f = new File(fileName);
        return f.delete();
    }
}
