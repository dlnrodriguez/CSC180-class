package WeekTwo;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DLN on 6/28/16.
 */
public class LinkFinder {
    private static final String pattern = "(.*)(\".*\")(.*)";
    private static final String testInput = "Hey \"girl\", hey!";

    private Iterator<String> links;

    public void processPage(InputStream in) {
        Scanner input = new Scanner(in);
        Pattern pattern = Pattern.compile("(.*)(\".*\")(.*)");
        Matcher matcher = pattern.matcher(input.nextLine());
        boolean matches = matcher.matches();

        if (matches) {
            System.out.println(matcher.group(2));
        } else {
            System.out.println("Nothing");
        }
    }

    public Iterator<String> getLinks() {
        InputStream file = null;
        try {
            file = new FileInputStream("Exercise 2 files/neumont.edu");
        } catch (FileNotFoundException e) {
            System.out.println("\n\tDidn't work!\n\t\t" + e);
        }
        processPage(file);

        return links;
    }

    public boolean test(String inTest) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(inTest);
        boolean matches = m.matches();
        return matches;
    }
}
