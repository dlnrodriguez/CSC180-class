package WeekFour;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by DLN on 8/3/16.
 */
public class PersistentArrayTest {
    @Test
    public void test() {
        PersistentArray test = new PersistentArray("testingfile1.bin");

        test.set(0, 15);
        test.set(1, 16);
        test.set(2, 17);
        test.set(1, 18);

        assertEquals(test.get(0), 15L);
        assertEquals(test.get(1), 18L);
        assertEquals(test.get(2), 17L);
        assertNotEquals(test.get(1), 16L);
    }

    @Test
    public void delete() throws Exception {
        PersistentArray test = new PersistentArray("testingFile2.bin");

        /* MUST RUN FIRST TEST METHOD FOR PRECEDING CODE TO WORK! */

        assertTrue(test.delete("testingfile1.bin"));
    }

}