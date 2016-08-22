package WeekFive;

import WeekFour.PersistentArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by DLN on 8/3/16.
 */
public class ListFile {
    private static RandomAccessFile file;
    private static PersistentArray entrys;

    ListFile(String fileName) {
        try {
            file = new RandomAccessFile(binCheck(fileName), "rw");
            entrys = new PersistentArray("list-entrys.bin");
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found!");
        }
    }

    public static void initialize(String fileName) {
        try {
            file = new RandomAccessFile(binCheck(fileName), "rw");
            file.close();
            PersistentArray.initialize("list-entrys.bin", 100, -1);
        } catch (IOException e) {
            System.err.println("Error message: " + e.getMessage());
        }
    }

    public long newEntry(Entry entry) {
        try {
            file.seek(file.length());
            writeEntry(entry);
            return file.length() + entry.getString().length() + 16;
        } catch (IOException e) {
            return -1;
        }
    }

    public Entry getEntry(long offset) {
        try {
            file.seek(offset);
            return readEntry();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void putEntry(long offset, Entry entry) {
        try {
            file.seek(offset);
            writeEntry(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private Entry readEntry() {
        try {
            int stringLength = file.readInt();
            byte[] strings = new byte[stringLength];
            for (int j = 0; j < stringLength; j++)
                strings[j] = file.readByte();
            long value = file.readLong();
            long link = file.readLong();
            String string = new String(strings);
            return new Entry(string, value, link);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void writeEntry(Entry entry) {
        try {
            file.writeInt(entry.getString().length());
            file.writeBytes(entry.getString());
            file.writeLong(entry.getValue());
            file.writeLong(entry.getLink());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String binCheck(String s) {
        if (!s.endsWith(".bin"))
            s = s + ".bin";
        return s;
    }
}