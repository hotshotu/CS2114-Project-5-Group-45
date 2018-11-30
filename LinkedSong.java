/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska), Kenneth Ding (dkenny), Jeffrey Peng (jeffpeng123)
 */

package prj5;

/**
 * LinkedSong is our LinkedList implementation that holds a list of SongNodes
 * 
 * @author Ender Jaska (eljaska), Kenneth Ding (dkenny)
 * @version 11.14.2018
 */
public class LinkedSong {

    private SongNode head;
    private SongNode tail;
    private int size;


    /**
     * Constructor for LinkedSong
     */
    public LinkedSong() {
        head = null;
        tail = null;
        size = 0;
    }


    /**
     * Getter method for the head of the list
     * 
     * @return Returns the head of the list
     */
    public SongNode getHead() {
        return head;
    }


    /**
     * Getter method for the tail of the list
     * 
     * @return Returns the tail of the list
     */
    public SongNode getTail() {
        return tail;
    }


    /**
     * Getter method for the size
     * 
     * @return Returns the size
     */
    public int size() {
        return size;
    }


    /**
     * Adds an entry to the list
     * 
     * @param entry
     *            The SongNode to be added
     */
    public void add(SongNode entry) {
        if (head == null) {
            head = entry;
            tail = head;
        }
        else {
            tail.setNext(entry);
            tail = tail.getNext();
        }
        size++;
    }


    /**
     * Finds the entry at a position
     * 
     * @param index
     *            The position to look at
     * @return Returns the item at index's position
     */
    public SongNode getIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException(
                "LinkedSong Index Out Of Bounds");
        }
        SongNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }
}
