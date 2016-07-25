package WeekThree;

/**
 * Created by DLN on 7/8/16.
 * <p>
 * <p>
 * This exercise builds on the last exercise to create a set of classes that load links from a web page. Then the program
 * recursively follows each of the retrieved links looking for new links. We need to also have a way to specify how many
 * total links to retrieve.
 * <p>
 * Step 1. Design a set of classes, incorporating the class from the last exercise, that will retrieve a web page, discover
 * the links within that web page, and then follow each of the discovered links. Have the program branch out on the links
 * until the program exhausts all links or the program has loaded a specific number of pages. For each page your crawler
 * visits, have the crawler call a method and pass the URL for the page (the method should be on an interface of some sort).
 * <p>
 * Be careful not to allow cycles in your traversal. Sequence diagrams and class diagrams may help you visualize how these
 * classes work.
 * <p>
 * You may want to use Java’s URL class (specifically look at the openStream method).
 * <p>
 * Step 2. Write the stubs for each of your classes based on your design from the previous step. Don’t forget to commit your work.
 * <p>
 * Step 3. For each of the stubs from the previous step, write JUnit test cases. Commit your work. You may find it difficult
 * to test these classes since they rely on a web server. Do the best you can on this. Ideally you would have your own web
 * server with a set of test pages, but if that is not possible, I will relax the JUnit testing requirement on this exercise.
 * However, you should at least do enough manual testing to give you confidence you code works.
 * <p>
 * Step 4. Finally, implement and test the classes from your design. Commit your work.
 * <p>
 * Step 5. Review your work with the instructor.
 */

public class WebLinkFinder_main {
    public static void main(String[] args) {
        new WebLinkFinder_old();
    }
}
