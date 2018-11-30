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
 * Tests each method in LinkedSong
 * 
 * @author Ender Jaska (eljaska), Jeffrey Peng (jeffp123)
 * @version 2018.11.29
 */
public class LinkedSongTest extends TestCase {

    private SongNode node1;
    private SongNode node2;
    private LinkedSong songs;


    /**
     * Sets up the required variables
     */
    public void setUp() {
        Song song1 = new Song("A", "B", 0, "C");
        Song song2 = new Song("X", "Post Y", 1, "Z");
        node1 = new SongNode(song1);
        node2 = new SongNode(song2);
        songs = new LinkedSong();
        songs.add(node1);
        songs.add(node2);
    }


    /**
     * Tests the getter methods
     */
    public void testGet() {
        assertEquals(node1, songs.getHead());
        assertEquals(node2, songs.getTail());
        assertEquals(2, songs.size());
    }


    /**
     * Tests the getIndex method
     */
    public void testGetIndex() {
        assertEquals(node1, songs.getIndex(0));
        assertEquals(node2, songs.getIndex(1));
        try {
            songs.getIndex(3);
        }
        catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }
}
