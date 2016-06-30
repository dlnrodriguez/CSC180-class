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
    private ArrayList<String> arrayLinks = new ArrayList<>();
    private Iterator<String> links;
    private InputStream file = null;

    LinkFinder() {
        this("Exercise 2 files/neumont.edu");
    }

    private LinkFinder(String filePath) {
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("File \"neumont.edu\" not found!");
        }
        processPage(file);
    }

    private void processPage(InputStream in) {
        Scanner input = new Scanner(in);
        Pattern pattern = Pattern.compile("(.*?)(a href=)\"(\\S*)\"(.*)", Pattern.CASE_INSENSITIVE);

        while (input.hasNext()) {
            Matcher matcher = pattern.matcher(input.nextLine());
            boolean matches = matcher.matches();

            if (matches) {
                arrayLinks.add(matcher.group(3));
            }
        }
        links = arrayLinks.iterator();
    }

    private Iterator<String> getLinks() {
        return links;
    }

    void printLinks() {
        while (getLinks().hasNext())
            System.out.println(getLinks().next());
    }

    public static boolean test(String inTest) {
        String testpattern = "(.*)(\".*\")(.*)";
        Pattern p = Pattern.compile(testpattern);
        Matcher m = p.matcher(inTest);
        return m.matches();
    }
}
