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
 * @author Jeffrey Peng, Ender Jaska (eljaska), Kenneth Ding (dkenny)
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

        song.add(HobbyEnum.READ, MajorEnum.COMPSCI, RegionEnum.NEUS,
            HorLEnum.HEARD, YorNEnum.YES);
        song.add(HobbyEnum.READ, MajorEnum.COMPSCI, RegionEnum.NEUS,
            HorLEnum.HEARD, YorNEnum.NO);
        song.add(HobbyEnum.READ, MajorEnum.COMPSCI, RegionEnum.NEUS,
            HorLEnum.LIKED, YorNEnum.YES);
        song.add(HobbyEnum.READ, MajorEnum.COMPSCI, RegionEnum.NEUS,
            HorLEnum.LIKED, YorNEnum.NO);
        song.add(HobbyEnum.ART, MajorEnum.OTHERENG, RegionEnum.SEUS,
            HorLEnum.HEARD, YorNEnum.YES);
        song.add(HobbyEnum.ART, MajorEnum.OTHERENG, RegionEnum.SEUS,
            HorLEnum.LIKED, YorNEnum.YES);
        song.add(HobbyEnum.ART, MajorEnum.OTHERENG, RegionEnum.SEUS,
            HorLEnum.LIKED, YorNEnum.NO);
        song.add(HobbyEnum.ART, MajorEnum.COMPSCI, RegionEnum.NEUS,
            HorLEnum.HEARD, YorNEnum.NO);
        song.add(HobbyEnum.SPORTS, MajorEnum.MATHCDMA, RegionEnum.OTHERUS,
            HorLEnum.HEARD, YorNEnum.YES);
        song.add(HobbyEnum.MUSIC, MajorEnum.COMPSCI, RegionEnum.NEUS,
            HorLEnum.HEARD, YorNEnum.NO);
        song.add(HobbyEnum.SPORTS, MajorEnum.MATHCDMA, RegionEnum.OTHERUS,
            HorLEnum.LIKED, YorNEnum.YES);
        song.add(HobbyEnum.SPORTS, MajorEnum.COMPSCI, RegionEnum.NEUS,
            HorLEnum.HEARD, YorNEnum.NO);
        song.add(HobbyEnum.MUSIC, MajorEnum.OTHER, RegionEnum.OUTSIDEUS,
            HorLEnum.HEARD, YorNEnum.YES);
        song.add(HobbyEnum.MUSIC, MajorEnum.OTHER, RegionEnum.OUTSIDEUS,
            HorLEnum.LIKED, YorNEnum.YES);
        song.add(HobbyEnum.MUSIC, MajorEnum.COMPSCI, RegionEnum.NEUS,
            HorLEnum.LIKED, YorNEnum.NO);
        song.add(HobbyEnum.SPORTS, MajorEnum.COMPSCI, RegionEnum.NEUS,
            HorLEnum.LIKED, YorNEnum.NO);
        song.add(HobbyEnum.ART, MajorEnum.OTHERENG, RegionEnum.OTHERUS,
            HorLEnum.HEARD, YorNEnum.NO);
        song.add(HobbyEnum.ART, MajorEnum.MATHCDMA, RegionEnum.OTHERUS,
            HorLEnum.HEARD, YorNEnum.NO);
        song.add(HobbyEnum.ART, MajorEnum.OTHER, RegionEnum.OTHERUS,
            HorLEnum.HEARD, YorNEnum.NO);
        song.add(HobbyEnum.ART, MajorEnum.MATHCDMA, RegionEnum.OTHERUS,
            HorLEnum.LIKED, YorNEnum.NO);
        song.add(HobbyEnum.ART, MajorEnum.OTHER, RegionEnum.OTHERUS,
            HorLEnum.LIKED, YorNEnum.NO);
        song.add(HobbyEnum.ART, MajorEnum.OTHER, RegionEnum.SEUS,
            HorLEnum.HEARD, YorNEnum.NO);

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

        song.add(HobbyEnum.ART, MajorEnum.OTHER, RegionEnum.SEUS,
            HorLEnum.HEARD, YorNEnum.NO);
        song.add(HobbyEnum.ART, MajorEnum.OTHER, RegionEnum.SEUS,
            HorLEnum.HEARD, YorNEnum.YES);
        try {
            song.getRepresentation(RepresentationEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.READ, null, null, HorLEnum.DEF, null);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.ART, MajorEnum.DEF, RegionEnum.OTHERUS,
                HorLEnum.HEARD, YorNEnum.NO);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }

        try {
            song.add(HobbyEnum.READ, MajorEnum.COMPSCI, RegionEnum.NEUS,
                HorLEnum.HEARD, YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.ART, MajorEnum.COMPSCI, RegionEnum.NEUS,
                HorLEnum.HEARD, YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.SPORTS, MajorEnum.COMPSCI, RegionEnum.NEUS,
                HorLEnum.HEARD, YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }

        try {
            song.add(HobbyEnum.MUSIC, MajorEnum.COMPSCI, RegionEnum.NEUS,
                HorLEnum.HEARD, YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.ART, MajorEnum.DEF, RegionEnum.OTHERUS,
                HorLEnum.LIKED, YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }

        try {
            song.add(HobbyEnum.SPORTS, MajorEnum.COMPSCI, RegionEnum.NEUS,
                HorLEnum.LIKED, YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.MUSIC, MajorEnum.COMPSCI, RegionEnum.NEUS,
                HorLEnum.LIKED, YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }

        try {
            song.add(HobbyEnum.READ, MajorEnum.COMPSCI, RegionEnum.NEUS,
                HorLEnum.LIKED, YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.DEF, MajorEnum.COMPSCI, RegionEnum.DEF,
                HorLEnum.HEARD, YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.ART, MajorEnum.OTHERENG, RegionEnum.OTHERUS,
                HorLEnum.HEARD, YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }

        try {
            song.add(HobbyEnum.ART, MajorEnum.COMPSCI, RegionEnum.NEUS,
                HorLEnum.LIKED, YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(null, MajorEnum.COMPSCI, null, HorLEnum.DEF, null);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(null, null, RegionEnum.NEUS, HorLEnum.DEF, null);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.DEF, MajorEnum.COMPSCI, RegionEnum.NEUS,
                HorLEnum.HEARD, null);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.DEF, MajorEnum.COMPSCI, RegionEnum.NEUS,
                HorLEnum.LIKED, null);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.DEF, MajorEnum.DEF, RegionEnum.DEF, HorLEnum.DEF,
                YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.ART, MajorEnum.DEF, RegionEnum.NEUS,
                HorLEnum.LIKED, YorNEnum.YES);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.ART, MajorEnum.COMPSCI, RegionEnum.OUTSIDEUS,
                HorLEnum.HEARD, YorNEnum.NO);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.ART, MajorEnum.COMPSCI, RegionEnum.OUTSIDEUS,
                HorLEnum.LIKED, YorNEnum.NO);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
        try {
            song.add(HobbyEnum.ART, MajorEnum.COMPSCI, RegionEnum.OUTSIDEUS,
                HorLEnum.HEARD, YorNEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
    }


    /**
     * Tests getNumReponses
     */
    public void testGetNumResponses() {
        Song song = new Song("A", "B", 0, "C");
        assertEquals(song.getNumHRep(), song.getNumResponse(
            RepresentationEnum.HOBBY));
        assertEquals(song.getNumMRep(), song.getNumResponse(
            RepresentationEnum.MAJOR));
        assertEquals(song.getNumRRep(), song.getNumResponse(
            RepresentationEnum.REGION));
        try {
            song.getNumResponse(RepresentationEnum.DEF);
        }
        catch (Exception e) {
            assertNotNull(e);
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
}
