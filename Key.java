/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska), Kenneth Ding (dkenny), Jeffrey Peng (jeffpeng123)
 */

package prj5;

import java.awt.Color;
import CS2114.*;

/**
 * Key is the front end legend for the glyphs
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.29
 */
public class Key {

    private TextShape keyTitle;
    private TextShape keyName1;
    private TextShape keyName2;
    private TextShape keyName3;
    private TextShape keyName4;

    private TextShape keySong;
    private TextShape keyHeard;
    private TextShape keyLiked;

    private Shape keyBlackBar;
    private Shape keyWhiteBox;
    private Shape keyBlackBox;


    /**
     * Constructor for Key
     */
    public Key() {
        keyTitle = new TextShape(620, 110, "Hobby Legend");
        keyName1 = new TextShape(620, 125, "Read", Color.PINK);
        keyName2 = new TextShape(620, 140, "Art", Color.BLUE);
        keyName3 = new TextShape(620, 155, "Sports", Color.YELLOW);
        keyName4 = new TextShape(620, 170, "Music", Color.GREEN);

        keySong = new TextShape(640, 190, "Song Title");
        keyHeard = new TextShape(620, 215, "Heard");
        keyLiked = new TextShape(685, 215, "Likes");
        keyBlackBox = new Shape(610, 100, 120, 140, Color.BLACK);
        keyWhiteBox = new Shape(615, 105, 110, 130, Color.WHITE);
        keyBlackBar = new Shape(670, 205, 10, 25, Color.BLACK);

        keyTitle.setBackgroundColor(Color.WHITE);
        keyName1.setBackgroundColor(Color.WHITE);
        keyName2.setBackgroundColor(Color.WHITE);
        keyName3.setBackgroundColor(Color.WHITE);
        keyName4.setBackgroundColor(Color.WHITE);
        keySong.setBackgroundColor(Color.WHITE);
        keyHeard.setBackgroundColor(Color.WHITE);
        keyLiked.setBackgroundColor(Color.WHITE);
    }


    /**
     * Updates the key for a given representation
     * 
     * @param rep
     *            The representation to be updated to
     */
    public void update(RepresentationEnum rep) {
        switch (rep) {
            case HOBBY:
                keyTitle.setText("Hobby Legend");
                keyName1.setText("Read");
                keyName2.setText("Art");
                keyName3.setText("Sports");
                keyName4.setText("Music");
                break;
            case MAJOR:
                keyTitle.setText("Major Legend");
                keyName1.setText("Comp Sci");
                keyName2.setText("Other Eng");
                keyName3.setText("Math/CDMA");
                keyName4.setText("Other");
                break;
            case REGION:
                keyTitle.setText("Region Legend");
                keyName1.setText("NE US");
                keyName2.setText("SE US");
                keyName3.setText("Other US");
                keyName4.setText("Outside US");
                break;
            default:
                throw new IllegalArgumentException(
                    "Invalid Representation pass to Key");
        }
    }


    /**
     * Displays the key in the window
     * 
     * @param win
     *            The window provided for the key
     */
    public void displayKey(Window win) {
        win.removeShape(keyTitle);
        win.removeShape(keyName1);
        win.removeShape(keyName2);
        win.removeShape(keyName3);
        win.removeShape(keyName4);
        win.removeShape(keySong);
        win.removeShape(keyHeard);
        win.removeShape(keyLiked);
        win.removeShape(keyBlackBar);
        win.removeShape(keyWhiteBox);
        win.removeShape(keyBlackBox);

        win.addShape(keyTitle);
        win.addShape(keyName1);
        win.addShape(keyName2);
        win.addShape(keyName3);
        win.addShape(keyName4);
        win.addShape(keySong);
        win.addShape(keyHeard);
        win.addShape(keyLiked);
        win.addShape(keyBlackBar);
        win.addShape(keyWhiteBox);
        win.addShape(keyBlackBox);
    }
}
