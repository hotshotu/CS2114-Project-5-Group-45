/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska), Kenneth Ding (dkenny), Jeffrey Peng (jeffpeng123)
 */

package prj5;

import java.io.FileNotFoundException;

/**
 * Runs the program
 * 
 * @author Ender Jaska (eljaska), Kenneth Ding (dkenny)
 * @version 2018.11.29
 */
public class Input {

    /**
     * The main method that runs the program
     * 
     * @param args
     *            The input files
     * @throws FileNotFoundException
     */ 
    public static void main(String[] args) throws FileNotFoundException {
        GUIProjectWindow window = new GUIProjectWindow(args);
    }
}
