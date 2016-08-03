package WeekFour;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by DLN on 8/1/16.
 */
public class PersistentArray {
    private String fileName;
    private int size;
    private long initialValue;
    private static RandomAccessFile file;

    public PersistentArray(String fileName) {
        this.fileName = fileName;
        this.size = 0;
        this.initialValue = 0;
        initialize(fileName, size, initialValue);
    }

    public static void initialize(String fileName, int size, long initialValue) {
        if (!fileName.endsWith(".bin"))
            fileName = fileName + ".bin";

        try {
            file = new RandomAccessFile(fileName, "rw");
            file.setLength(size);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void set(int index, long value) {
        try {
            file.seek(index);
            file.writeLong(value);
            System.out.format("%d %d ", index, value);
        } catch (IOException e) {
            System.err.println("Cannot set " + index + " to " + value + " ");
        }
        try {
            file.seek(index);
            System.out.println(file.readLong());
        } catch (IOException e) {
            System.err.println("Cannot read line: " + index);
        }
    }

    public long get(int index) {
        try {
            file.seek(index);
            return file.readLong();
        } catch (IOException e) {
            System.err.println("Can't read line!");
        }
        return -69;
    }

    public long getLength() {
        try {
            return file.length();
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
