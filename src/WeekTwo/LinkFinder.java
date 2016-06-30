package WeekTwo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DLN on 6/28/16.
 */
public class LinkFinder {
    private static final String testpattern = "(.*)(\".*\")(.*)";
    private static final String testInput = "Hey \"girl\", hey!";

    ArrayList<String> arrayLinks = new ArrayList<>();
    private Iterator<String> links = arrayLinks.iterator();

    public void processPage(InputStream in) {
        Scanner input = new Scanner(in);
        Pattern pattern = Pattern.compile("(.*)(a href)(.*)\"(.*)\"(.*)", Pattern.CASE_INSENSITIVE);

        while (input.hasNext()) {
            Matcher matcher = pattern.matcher(input.nextLine());
            boolean matches = matcher.matches();

            if (matches) {
                arrayLinks.add(matcher.group(4));
            }
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

    public static boolean test(String inTest) {
        Pattern p = Pattern.compile(testpattern);
        Matcher m = p.matcher(inTest);
        boolean matches = m.matches();
        return matches;
    }
}
