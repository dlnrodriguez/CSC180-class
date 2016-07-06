package WeekTwo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DLN on 6/28/16.
 * <p>
 * For this exercise you will create class that will find links within a single web page.
 * <p>
 * Step 1. Set up your GitHub account.
 * <p>
 * http://eclipsesource.com/blogs/tutorials/egit-tutorial/ (Links to an external site.)
 * <p>
 * Step 2. Write a stub a class that has the following interface:
 * <p>
 * class LinkFinder {
 * <p>
 * public void processPage(InputStream in) {
 * <p>
 * }
 * <p>
 * public Iterator<String> getLinks() {
 * <p>
 * }
 * <p>
 * }
 * <p>
 * Step 3. On the LMS you will find an HTML page and a results file for exercise 1. Download these files.
 * <p>
 * Step 4. Write a JUnit test case for the class based on your review of the HTML file. The test case should find all the links in the HTML file and compare the findings to the results file. Be sure to commit your work.
 * <p>
 * This tutorial may be helpful: http://www.tutorialspoint.com/java/java_regular_expressions.htm (Links to an external site.)
 * <p>
 * Step 5. Using Java’s regular expression capabilities, fill out the class so that the class finds the links in the webpage. The class should store these links in a container of strings. Be sure to commit your work.
 * <p>
 * Step 6. Review your work with the instructor (including your Git log).
 */

public class LinkFinder {
    private static ArrayList<String> arrayLinks = new ArrayList<>(), arrayOriginal = new ArrayList<>();
    private static Iterator<String> links, original;
    private InputStream file = null, originalFile = null;
    private String linkPattern = "(.*?)(a\\s+href\\s*=\\s*)\"(\\S*)\"(.*)";

    LinkFinder() {
        this("Exercise 2 files/neumont.edu");
    }

    LinkFinder(String filePath) {
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("File \"" + filePath + "\" not found!");
        }
        try {
            originalFile = new FileInputStream("Exercise 2 files/results");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        processPage(file);
        processOriginal(originalFile);
    }

    private void processPage(InputStream in) {
        Scanner input = new Scanner(in);
        Pattern pattern = Pattern.compile(linkPattern, Pattern.CASE_INSENSITIVE);

        while (input.hasNext()) {
            Matcher matcher = pattern.matcher(input.nextLine());
            boolean matches = matcher.matches();

            if (matches) {
                arrayLinks.add(matcher.group(3));
            }
        }
        links = arrayLinks.iterator();
    }

    private void processOriginal(InputStream in) {
        Scanner input = new Scanner(in);

        while (input.hasNext()) {
            arrayOriginal.add(input.nextLine());
        }
        original = arrayOriginal.iterator();
    }

    static Iterator<String> getLinks() {
        return links;
    }

    static Iterator<String> getOriginal() {
        return original;
    }

    void printLinks() {
        while (getLinks().hasNext())
            System.out.println(getLinks().next());
    }

    static boolean test() {
        while (getOriginal().hasNext() && getLinks().hasNext()) {
            if (getOriginal().next().equals(getLinks().next()))
                return true;
        }
        return false;
    }
}
