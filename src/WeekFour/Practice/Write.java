package WeekFour.Practice;

import java.io.RandomAccessFile;

/**
 * Created by Dylon on 7/12/2016.
 */
public class Write {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("respect.bin", "rw");
            file.writeInt(-1);
            file.writeInt(42);
            file.writeInt(73);
            file.writeInt(19);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }
}

class Read {
    public static void main(String[] args) {
        try {
            RandomAccessFile classFile = new RandomAccessFile("src/WeekFour/Practice/Write.java", "r");
            RandomAccessFile file = new RandomAccessFile("respect.bin", "r");
            int number;
            file.seek(0);
            number = file.readInt();
            System.out.print(number);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }
}
