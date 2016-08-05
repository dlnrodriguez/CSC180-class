package WeekFive;

/**
 * Created by DLN on 8/3/16.
 * <p>
 * Now that you have a persistent array, which you can use for your persistent HashMap, you need a way to store persistent lists. These lists have nodes that contain a string, a long value and a link to another node. Your persistent list file will allow the indexor to store and retrieve list nodes.
 * <p>
 * Each ListFile node (herein called Entry) has the following form:
 * <p>
 * public class Entry {
 * <p>
 * private String string;
 * <p>
 * private long value;
 * <p>
 * private long link;
 * <p>
 * public Entry(String string, long value, long link)
 * <p>
 * public String getString()
 * <p>
 * public long getValue()
 * <p>
 * public void setValue(long value)
 * <p>
 * public long getLink()
 * <p>
 * public void setLink(long link)
 * <p>
 * }
 * <p>
 * The ListFile has the following methods:
 * <p>
 * public static void initialize(String listFileName)
 * <p>
 * public static void delete(String listFileName)
 * <p>
 * public ListFile(String listFileName)
 * <p>
 * public void close()
 * <p>
 * public long newEntry(Entry entry)
 * <p>
 * public Entry getEntry(long offset)
 * <p>
 * public void putEntry(long offset, Entry entry)
 * <p>
 * You will use the list file to build out the persistent HashMap in the next exercise. For now, just focus on building the ListFile.
 * <p>
 * Step1. Work through the behavior of each of the methods by hand. Make sure you understand all the details before you proceed.
 * <p>
 * Step 2. Build the class with method stubs. Check in your work.
 * <p>
 * Step 3. Build JUnit test cases for each of the methods. Check in your work.
 * <p>
 * Step 4. Implement the methods and add any additional test cases that cover conditions you didn’t think about before. Check in your work.
 * <p>
 * Step 5. Review your work with the instructor.
 */
public class ListFile_main {
    public static void main(String[] args) {
        new ListFile("listfile.bin");
    }
}
