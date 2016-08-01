package WeekThree

import org.junit.Test

/**
 * Created by DLN on 8/1/16.
 */
class WebLinkFinderTest extends GroovyTestCase {
    @Test
    void test() {
        assertFalse(new WebLinkFinder("http://shalladay-iis1.student.neumont.edu").hasDuplicates())
    }
}
