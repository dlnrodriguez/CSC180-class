package WeekFour;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by DLN on 8/1/16.
 * *
 * ** just getting rid of the warning
 */

public class PersistentArray {
    private static RandomAccessFile file;

    public PersistentArray(String fileName) {
        fileName = binCheck(fileName);
        try {
            file = new RandomAccessFile(fileName, "rw");
        } catch (IOException e) {
            System.err.println("File not found!");
        }
    }

    public static void initialize(String fileName, int size, long initialValue) {
        fileName = binCheck(fileName);
        try {
            file = new RandomAccessFile(fileName, "rw");
            for (int a = 0; a < size; a++) {
                file.seek(a * 8);
                file.writeLong(initialValue);
            }
            file.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void set(long index, long value) {
        try {
            file.seek(index * 8);
            file.writeLong(value);
        } catch (IOException e) {
            System.err.println("Cannot set " + index + " to " + value + "!");
        }
    }

    public long get(long index) {
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
            return file.length() / 8;
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

    public static void delete(String fileName) {
        new File(fileName).delete();
    }

    private static String binCheck(String s) {
        if (!s.endsWith(".bin"))
            s = s + ".bin";
        return s;
    }
}
