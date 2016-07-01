package WeekTwo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DLN on 6/28/16.
 *
 * For this exercise you will create class that will find links within a single web page.

 Step 1. Set up your GitHub account.

 http://eclipsesource.com/blogs/tutorials/egit-tutorial/ (Links to an external site.)

 Step 2. Write a stub a class that has the following interface:

 class LinkFinder {

 public void processPage(InputStream in) {

 }

 public Iterator<String> getLinks() {

 }

 }

 Step 3. On the LMS you will find an HTML page and a results file for exercise 1. Download these files.

 Step 4. Write a JUnit test case for the class based on your review of the HTML file. The test case should find all the links in the HTML file and compare the findings to the results file. Be sure to commit your work.

 This tutorial may be helpful: http://www.tutorialspoint.com/java/java_regular_expressions.htm (Links to an external site.)

 Step 5. Using Java’s regular expression capabilities, fill out the class so that the class finds the links in the webpage. The class should store these links in a container of strings. Be sure to commit your work.

 Step 6. Review your work with the instructor (including your Git log).
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
