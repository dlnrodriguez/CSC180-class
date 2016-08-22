package WeekFive

/**
 * Created by Dylon on 8/18/2016.
 */
class ListFileTest extends GroovyTestCase {
    void testGetEntry() {
        ListFile l = new ListFile("listfile.bin");
        l.putEntry(0, new Entry("apple.gov", 681, 98520));
        assertNotNull(l.getEntry(0))
        assertEquals(l.getEntry(0).getString(), "apple.gov")
    }
}
