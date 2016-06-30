package WeekTwo.Class;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DLN on 6/27/16.
 */
public class FirstFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.exit('E');
            } else if (isXXNotXXX(input)) {
                System.out.println("Does match.");
            } else {
                System.out.println("Does not match.");
            }
        }
    }

    public static boolean isXXNotXXX(String s) {
        Pattern p = Pattern.compile("XX[^X]XX");
        Matcher m = p.matcher(s);
        boolean matches = m.matches();
        return matches;
    }
}