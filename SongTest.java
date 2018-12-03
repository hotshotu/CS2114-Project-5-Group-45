/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska), Kenneth Ding (dkenny), Jeffrey Peng (jeffpeng123)
 */

package prj5;

import student.TestCase;

/**
 * Tests each method in Song
 * 
 * @author Ender Jaska (eljaska), Kenneth Ding (dkenny)
 * @version 2018.11.29
 *
 */
public class SongTest extends TestCase {

    /**
     * Sets up each test case
     */
    public void setUp() {
        /**
         * Nothing to set up
         */
    }


    /**
     * Tests the all of the methods in Song
     */
    public void testAll() {
        Song song = new Song("A", "B", 0, "C");

        assertEquals("A", song.getTitle());
        assertEquals("B", song.getArtist());
        assertEquals(0, song.getYear());
        assertEquals("C", song.getGenre());

        song.addYes(HobbyEnum.READ, MajorEnum.COMPSCI, RegionEnum.NEUS,
            HorLEnum.HEARD);
        song.addYes(HobbyEnum.READ, MajorEnum.COMPSCI, RegionEnum.NEUS,
            HorLEnum.LIKED);
        song.addYes(HobbyEnum.ART, MajorEnum.OTHERENG, RegionEnum.SEUS,
            HorLEnum.HEARD);
        song.addYes(HobbyEnum.ART, MajorEnum.OTHERENG, RegionEnum.SEUS,
            HorLEnum.LIKED);
        song.addYes(HobbyEnum.SPORTS, MajorEnum.MATHCDMA, RegionEnum.OTHERUS,
            HorLEnum.HEARD);
        song.addYes(HobbyEnum.SPORTS, MajorEnum.MATHCDMA, RegionEnum.OTHERUS,
            HorLEnum.LIKED);
        song.addYes(HobbyEnum.MUSIC, MajorEnum.OTHER, RegionEnum.OUTSIDEUS,
            HorLEnum.HEARD);
        song.addYes(HobbyEnum.MUSIC, MajorEnum.OTHER, RegionEnum.OUTSIDEUS,
            HorLEnum.LIKED);

        song.addYes(null, null, null, HorLEnum.LIKED);

        int[] hobby = song.getRepresentation(RepresentationEnum.HOBBY);
        int[] major = song.getRepresentation(RepresentationEnum.MAJOR);
        int[] region = song.getRepresentation(RepresentationEnum.REGION);

        assertEquals(1, hobby[0]);
        assertEquals(1, hobby[1]);
        assertEquals(1, hobby[2]);
        assertEquals(1, hobby[3]);
        assertEquals(1, hobby[4]);
        assertEquals(1, hobby[5]);
        assertEquals(1, hobby[6]);
        assertEquals(1, hobby[7]);
        assertEquals(1, major[0]);
        assertEquals(1, major[1]);
        assertEquals(1, major[2]);
        assertEquals(1, major[3]);
        assertEquals(1, major[4]);
        assertEquals(1, major[5]);
        assertEquals(1, major[6]);
        assertEquals(1, major[7]);
        assertEquals(1, region[0]);
        assertEquals(1, region[1]);
        assertEquals(1, region[2]);
        assertEquals(1, region[3]);
        assertEquals(1, region[4]);
        assertEquals(1, region[5]);
        assertEquals(1, region[6]);
        assertEquals(1, region[7]);

        try {
            song.getRepresentation(RepresentationEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.addYes(HobbyEnum.READ, null, null, HorLEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.addYes(null, MajorEnum.COMPSCI, null, HorLEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.addYes(null, null, RegionEnum.NEUS, HorLEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.addYes(HobbyEnum.DEF, MajorEnum.COMPSCI, RegionEnum.NEUS,
                HorLEnum.HEARD);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.addYes(HobbyEnum.DEF, MajorEnum.COMPSCI, RegionEnum.NEUS,
                HorLEnum.LIKED);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.addYes(HobbyEnum.ART, MajorEnum.DEF, RegionEnum.NEUS,
                HorLEnum.HEARD);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.addYes(HobbyEnum.ART, MajorEnum.DEF, RegionEnum.NEUS,
                HorLEnum.LIKED);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.addYes(HobbyEnum.ART, MajorEnum.COMPSCI, RegionEnum.DEF,
                HorLEnum.HEARD);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.addYes(HobbyEnum.ART, MajorEnum.COMPSCI, RegionEnum.DEF,
                HorLEnum.LIKED);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
}
