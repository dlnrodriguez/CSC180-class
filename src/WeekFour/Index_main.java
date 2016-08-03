package WeekFour;

/**
 * Created by DLN on 8/1/16.
 * <p>
 * Once your crawler can find pages, your crawler will want to remember what is on those pages. Specifically, your search engine will use the crawler to feed an “indexor”. The job
 * of the indexor is to build a persistent keyword index. This index allows the search engine to ask the question: given some specific word X, list all the URLs where that word occurs.
 * <p>
 * You will use binary files to store the contents of the index. The index works a lot like a hashmap that you store on the disk. However, the hashmap will become very large, so you
 * won’t be able to hold the entire map in memory at one time. Because of this, you will build a hashmap that operates directly with files on the disk.
 * <p>
 * Specifically, you will need three binary files. These are not text files and are not directly human readable. The first file operates like a big array of integers. These integers
 * act as offsets (or pointers) into the second file. The second file will contain words and their associated lists. The instructor will explain how these files work in class.
 * <p>
 * For Part A of the PersistentArray, we will build a persistent array of long values. Think about an array interface. What operations would we want to provide for an array? These operations
 * might include:
 * <p>
 * Initialization
 * Setting an element’s value
 * Getting an element’s value
 * Getting the length of the array
 * In addition to these operations, since our array will actually be stored on disk instead of in memory, we will also need methods that open and close the file that holds the array. We
 * can open the file in the constructor, but we will create a separate method for closing the file.
 * <p>
 * These method signatures might look like this:
 * <p>
 * public static void initialize(String arrayFileName, int arraySize, long initialValue)
 * <p>
 * public PersistentArray(String arrayFileName)
 * <p>
 * public void set(int index, long value)
 * <p>
 * public long get(int index)
 * <p>
 * public long getLength()
 * <p>
 * public void close()
 * <p>
 * public static void delete(String arrayFileName)
 * <p>
 * Step 1. Take each of the methods of the persistent array and work through them by hand. It may be easiest to start with the “set” and “get” methods. Next, think about opening and
 * closing the persistent array. Finally, you may want to think about initialization and getting the array length. You will probably find it helpful to draw pictures to help you think
 * about this class.
 * <p>
 * Step 2. Next, create the class with method stubs using the signatures previously described. Be sure to check in you work.
 * <p>
 * Step 3. Build JUnit test cases for the methods. Check in your work.
 * <p>
 * Step 4. Fill in the method stubs so that you test cases pass. Add new test cases as you come to realize what is missing from your test suite. As usual, check in your work.
 * <p>
 * Step 5. Show you work to the instructor.
 */
public class Index_main {
    public static void main(String[] args) {
        PersistentArray pa = new PersistentArray("file.bin");
        pa.set(0, 4876347485L);
        pa.set(1, 93);
        pa.set(2, 59997L);
        for (int a = 0; a < pa.getLength() / 8; a++)
            System.out.println(pa.get(a));
        pa.close();
    }
}
