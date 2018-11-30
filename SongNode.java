/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska), Kenneth Ding (dkenny), Jeffrey Peng (jeffpeng123)
 */

package prj5;

/**
 * SongNode is our Node implementation that holds a song
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.10
 */
public class SongNode {

    private Song data;
    private SongNode next;


    /**
     * Constructor for SongNode
     * 
     * @param entry
     *            The song to be stored
     */
    public SongNode(Song entry) {
        data = entry;
        next = null;
    }


    /**
     * Getter method for the stored song
     * 
     * @return Returns the stored song
     */
    public Song getData() {
        return data;
    }


    /**
     * Getter method for the next SongNode
     * 
     * @return Returns the next SongNode
     */
    public SongNode getNext() {
        return next;
    }


    /**
     * Setter method for the stored song
     * 
     * @param song
     *            The new song
     */
    public void setData(Song song) {
        data = song;
    }


    /**
     * Setter method for the next SongNode
     * 
     * @param entry
     *            The new next SongNode
     */
    public void setNext(SongNode entry) {
        next = entry;
    }
}
