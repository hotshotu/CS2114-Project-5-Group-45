/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska), Kenneth Ding (dkenny), Jeffrey Peng (jeffpeng123)
 */

package prj5;

import java.io.FileNotFoundException;
import CS2114.Button;

/**
 * Tests each method in ProjectWindow, Glyph, and Key
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.29
 */
public class ProjectWindowTest {

    /**
     * Sets up each test case
     */
    public void setUp() {
        /**
         * Nothing to set up
         */
    }


    /**
     * Tests all of the methods in ProjectWindow, Glyph, and Key
     * 
     * @throws FileNotFoundException
     */
    public void testAll() throws FileNotFoundException {
        String[] test = new String[2];
        test[0] = "MusicSurveyData2018S.csv";
        test[1] = "SongList2018S.csv";
        ProjectWindow testP = new ProjectWindow(test);
        testP.pressedRepHobby(null);
        testP.pressedRepMajor(null);
        testP.pressedRepRegion(null);
        testP.pressedSortTitle(null);
        testP.pressedSortArtist(null);
        testP.pressedSortYear(null);
        testP.pressedSortGenre(null);

        Button next = testP.getNPButtons()[0];
        Button prev = testP.getNPButtons()[1];
    }
}
