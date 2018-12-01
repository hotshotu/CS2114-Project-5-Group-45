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
import student.testingsupport.ExitCalledException;

/**
 * @author Jeffrey Peng(jeffp123)
 * @version 12/1/2018
 *          Test the rest of the Glyph Class
 */
public class KeyGlyphTest extends TestCase {

    private Glyph glyph;
    private Key key;


    /**
     * Sets up the Glyph Test
     */
    public void setUp() {
        glyph = new Glyph();
        key = new Key();
    }


    /**
     * Tests rest of the updates except for the default Case
     * 
     * @throws FileNotFoundException
     */
    public void testUpdateAll() throws FileNotFoundException {

        String[] test = new String[2];

        test[0] = "MusicSurveyData2018S.csv";

        test[1] = "SongList2018S.csv";

        GUIProjectWindow testP = new GUIProjectWindow(test);

        testP.pressedRepHobby(null);

        testP.pressedRepMajor(null);

        testP.pressedRepRegion(null);

        testP.pressedSortTitle(null);

        testP.pressedSortArtist(null);

        testP.pressedSortYear(null);

        testP.pressedSortGenre(null);
        Exception exception2 = null;

        try {

            testP.pressedQuit(null);

        }

        catch (ExitCalledException e) {

            exception2 = e;

        }

        assertNotNull(exception2);

    }


    /**
     * Calls update and puts RepNum DEF as its parameter
     */
    public void testUpdateIfDefault() {
        Exception exception2 = null;
        try {
            glyph.update(RepresentationEnum.DEF, null, 0);

        }
        catch (IllegalArgumentException e) {
            exception2 = e;

        }
        assertNotNull(exception2);
        Exception exception1 = null;
        try {
            key.update(RepresentationEnum.DEF);

        }
        catch (IllegalArgumentException e) {
            exception1 = e;

        }
        assertNotNull(exception1);

    }

}
