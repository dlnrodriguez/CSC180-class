package WeekFour;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by DLN on 8/3/16.
 */
public class PersistentArrayTest {
    @Test
    public void test() {
        PersistentArray test = new PersistentArray("testingfile1");

        test.set(0, 15);
        test.set(1, 16);
        test.set(2, 17);
        test.set(1, 18);

        assertEquals(test.get(0), 15L);
        assertEquals(test.get(1), 18L);
        assertEquals(test.get(2), 17L);
        assertNotEquals(test.get(1), 16L);

        test.close();
    }

}