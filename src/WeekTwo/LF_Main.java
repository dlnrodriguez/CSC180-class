package WeekTwo;

import java.util.Scanner;

/**
 * Created by DLN on 6/30/16.
 */
public class LF_Main {
    public static void main(String[] args) {
        LinkFinder finder = new LinkFinder();
        Scanner scanner = new Scanner("Exercise 2 files/neumont.edu");
        finder.processPage(System.in);
    }
}
