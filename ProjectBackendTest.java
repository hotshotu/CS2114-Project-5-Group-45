/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska), Kenneth Ding (dkenny), Jeffrey Peng (jeffpeng123)
 */

package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

/**
 * Tests each method in ProjectBackend
 * 
 * @author Ender Jaska (eljaska), Kenneth Ding (dkenny)
 * @version 2018.11.29
 */
public class ProjectBackendTest extends TestCase {

    /**
     * Sets up each test case
     */
    public void setUp() {
        /**
         * Nothing to set up
         */
    }


    /**
     * Tests all of the methods in ProjectBackend
     * 
     * @throws FileNotFoundException
     */
    public void testAll() throws FileNotFoundException {
        ProjectBackend backend = new ProjectBackend(new String[] {
            "MusicSurveyData.csv", "SongList.csv" });

        backend.sortSongs(SortEnum.TITLE);
        backend.sortSongs(SortEnum.ARTIST);
        backend.sortSongs(SortEnum.YEAR);
        backend.sortSongs(SortEnum.GENRE);

        assertEquals(59, backend.getSongs().size());

        try {
            backend.sortSongs(SortEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
}
