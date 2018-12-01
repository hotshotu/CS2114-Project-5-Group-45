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
 * Tests each method in SongNode
 * 
 * @author Ender Jaska (eljaska), Jeffrey Peng (jeffp123)
 * @version 2018.11.29
 *
 */
public class SongNodeTest extends TestCase {

    private Song song1;

    private SongNode node1;
    private SongNode node2;


    /**
     * Sets up each test case
     */
    public void setUp() {
        Song song2;
        song1 = new Song("A", "B", 0, "C");
        song2 = new Song("X", "Y", 1, "Z");
        node1 = new SongNode(song1);
        node2 = new SongNode(song2);
    }

 
    /**
     * Tests all of the methods in SongNode
     */
    public void testAll() {
        assertEquals(song1, node1.getData());
        node1.setNext(node2);
        assertEquals(node2, node1.getNext());
        node2.setData(song1);
        assertEquals(node1.getData(), node2.getData());
    }
}
