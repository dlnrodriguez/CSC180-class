package WeekTwo

import org.junit.Test

/**
 * Created by DLN on 6/30/16.
 */
class LinkFinderTest extends GroovyTestCase {
    @Test
    void test() {
        assertFalse(LinkFinder.test("Guess What!"));
        assertFalse(LinkFinder.test("Shouldn't work"));
        assertTrue(LinkFinder.test("Should\"work!\""));
    }
}
