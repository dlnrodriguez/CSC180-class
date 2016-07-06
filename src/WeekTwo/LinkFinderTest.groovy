package WeekTwo

import org.junit.Test

/**
 * Created by DLN on 6/30/16.
 *
 * Submitted!
 */
class LinkFinderTest extends GroovyTestCase {
    @Test
    void test() {
        LinkFinder ln = new LinkFinder();
        while (ln.getOriginal().hasNext() && ln.getLinks().hasNext()) {
            assertEquals(ln.getOriginal().next(), ln.getLinks().next())
        }
    }
}
