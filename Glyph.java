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
 * Glyph is the front end representation of a song
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.29
 */
public class Glyph {

    private TextShape titleShape;
    private TextShape artistShape;

    private Shape l1Shape;
    private Shape r1Shape;
    private Shape l2Shape;
    private Shape r2Shape;
    private Shape l3Shape;
    private Shape r3Shape;
    private Shape l4Shape;
    private Shape r4Shape;

    private Shape glyphBlackBar;
    private boolean initialized;


    /** 
     * Constructor for Glyph
     */
    public Glyph() {
        glyphBlackBar = new Shape(10, 50, 0, 0, Color.BLACK);
        initialized = false;
    }


    /**
     * Updates the glyphs measurements, taking into account which button was
     * pressed
     * 
     * @param rep
     *            The representation requested
     * @param song
     *            The songs that will be updated
     * @param numResponse
     *            The amount of recorded responses
     */
    public void update(RepresentationEnum rep, Song song, int numResponse) {
        int l1width;
        int r1width;
        int l2width;
        int r2width;
        int l3width;
        int r3width;
        int l4width;
        int r4width;

        switch (rep) {
            case HOBBY:
                titleShape = new TextShape(0, 0, song.getTitle());
                artistShape = new TextShape(0, 0, song.getArtist());

                l1width = (int)((double)song.getRepresentation(rep)[0]
                    / numResponse * 100);
                r1width = (int)((double)song.getRepresentation(rep)[1]
                    / numResponse * 100);
                l2width = (int)((double)song.getRepresentation(rep)[2]
                    / numResponse * 100);
                r2width = (int)((double)song.getRepresentation(rep)[3]
                    / numResponse * 100);
                l3width = (int)((double)song.getRepresentation(rep)[4]
                    / numResponse * 100);
                r3width = (int)((double)song.getRepresentation(rep)[5]
                    / numResponse * 100);
                l4width = (int)((double)song.getRepresentation(rep)[6]
                    / numResponse * 100);
                r4width = (int)((double)song.getRepresentation(rep)[7]
                    / numResponse * 100);

                l1Shape = new Shape(0, 0, l1width, 50, Color.PINK);
                r1Shape = new Shape(0, 0, r1width, 50, Color.PINK);
                l2Shape = new Shape(0, 0, l2width, 50, Color.BLUE);
                r2Shape = new Shape(0, 0, r2width, 50, Color.BLUE);
                l3Shape = new Shape(0, 0, l3width, 50, Color.YELLOW);
                r3Shape = new Shape(0, 0, r3width, 50, Color.YELLOW);
                l4Shape = new Shape(0, 0, l4width, 50, Color.GREEN);
                r4Shape = new Shape(0, 0, r4width, 50, Color.GREEN);
                break;
            case MAJOR:
                titleShape = new TextShape(0, 0, song.getTitle());
                artistShape = new TextShape(0, 0, song.getArtist());

                l1width = (int)((double)song.getRepresentation(rep)[0]
                    / numResponse * 100);
                r1width = (int)((double)song.getRepresentation(rep)[1]
                    / numResponse * 100);
                l2width = (int)((double)song.getRepresentation(rep)[2]
                    / numResponse * 100);
                r2width = (int)((double)song.getRepresentation(rep)[3]
                    / numResponse * 100);
                l3width = (int)((double)song.getRepresentation(rep)[4]
                    / numResponse * 100);
                r3width = (int)((double)song.getRepresentation(rep)[5]
                    / numResponse * 100);
                l4width = (int)((double)song.getRepresentation(rep)[6]
                    / numResponse * 100);
                r4width = (int)((double)song.getRepresentation(rep)[7]
                    / numResponse * 100);

                l1Shape = new Shape(0, 0, l1width, 50, Color.PINK);
                r1Shape = new Shape(0, 0, r1width, 50, Color.PINK);
                l2Shape = new Shape(0, 0, l2width, 50, Color.BLUE);
                r2Shape = new Shape(0, 0, r2width, 50, Color.BLUE);
                l3Shape = new Shape(0, 0, l3width, 50, Color.YELLOW);
                r3Shape = new Shape(0, 0, r3width, 50, Color.YELLOW);
                l4Shape = new Shape(0, 0, l4width, 50, Color.GREEN);
                r4Shape = new Shape(0, 0, r4width, 50, Color.GREEN);
                break;
            case REGION:
                titleShape = new TextShape(0, 0, song.getTitle());
                artistShape = new TextShape(0, 0, song.getArtist());

                l1width = (int)((double)song.getRepresentation(rep)[0]
                    / numResponse * 100);
                r1width = (int)((double)song.getRepresentation(rep)[1]
                    / numResponse * 100);
                l2width = (int)((double)song.getRepresentation(rep)[2]
                    / numResponse * 100);
                r2width = (int)((double)song.getRepresentation(rep)[3]
                    / numResponse * 100);
                l3width = (int)((double)song.getRepresentation(rep)[4]
                    / numResponse * 100);
                r3width = (int)((double)song.getRepresentation(rep)[5]
                    / numResponse * 100);
                l4width = (int)((double)song.getRepresentation(rep)[6]
                    / numResponse * 100);
                r4width = (int)((double)song.getRepresentation(rep)[7]
                    / numResponse * 100);

                l1Shape = new Shape(0, 0, l1width, 50, Color.PINK);
                r1Shape = new Shape(0, 0, r1width, 50, Color.PINK);
                l2Shape = new Shape(0, 0, l2width, 50, Color.BLUE);
                r2Shape = new Shape(0, 0, r2width, 50, Color.BLUE);
                l3Shape = new Shape(0, 0, l3width, 50, Color.YELLOW);
                r3Shape = new Shape(0, 0, r3width, 50, Color.YELLOW);
                l4Shape = new Shape(0, 0, l4width, 50, Color.GREEN);
                r4Shape = new Shape(0, 0, r4width, 50, Color.GREEN);
                break;
            default:
                throw new IllegalArgumentException(
                    "Invalid Representation pass to Glyph");
        }
    } 

 
    /**
     * Adds the glyph to the window
     * 
     * @param win
     *            The window that will get glyphs displayed on it
     * @param x
     *            The center x position of the glyph
     * @param y
     *            The top y position of the glyph
     */
    public void displayGlyph(Window win, int x, int y) {
        if (initialized) {
            win.removeShape(titleShape);
            win.removeShape(artistShape);
            win.removeShape(l1Shape);
            win.removeShape(r1Shape);
            win.removeShape(l2Shape);
            win.removeShape(r2Shape);
            win.removeShape(l3Shape);
            win.removeShape(r3Shape);
            win.removeShape(l4Shape);
            win.removeShape(r4Shape);
            win.removeShape(glyphBlackBar);
        }

        int yLoc = y;

        titleShape.moveTo(x - (titleShape.getWidth() / 2), yLoc);
        yLoc += titleShape.getHeight();
        artistShape.moveTo(x - (artistShape.getWidth() / 2), yLoc);
        yLoc += artistShape.getHeight();

        glyphBlackBar.moveTo(x - (glyphBlackBar.getWidth() / 2), yLoc);
        l1Shape.moveTo(x - l1Shape.getWidth() - (glyphBlackBar.getWidth() / 2),
            yLoc);
        r1Shape.moveTo(x + r1Shape.getWidth() + (glyphBlackBar.getWidth() / 2),
            yLoc);
        yLoc += l1Shape.getHeight();
        l2Shape.moveTo(x - l2Shape.getWidth() - (glyphBlackBar.getWidth() / 2),
            yLoc);
        r2Shape.moveTo(x + r2Shape.getWidth() + (glyphBlackBar.getWidth() / 2),
            yLoc);
        yLoc += l2Shape.getHeight();
        l3Shape.moveTo(x - l3Shape.getWidth() - (glyphBlackBar.getWidth() / 2),
            yLoc);
        r3Shape.moveTo(x + r3Shape.getWidth() + (glyphBlackBar.getWidth() / 2),
            yLoc);
        yLoc += l3Shape.getHeight();
        l4Shape.moveTo(x - l4Shape.getWidth() - (glyphBlackBar.getWidth() / 2),
            yLoc);
        r4Shape.moveTo(x + r4Shape.getWidth() + (glyphBlackBar.getWidth() / 2),
            yLoc);

        win.addShape(titleShape);
        win.addShape(artistShape);
        win.addShape(glyphBlackBar);
        win.addShape(l1Shape);
        win.addShape(r1Shape);
        win.addShape(l2Shape);
        win.addShape(r2Shape);
        win.addShape(l3Shape);
        win.addShape(r3Shape);
        win.addShape(l4Shape);
        win.addShape(r4Shape);

        initialized = true;
    }
}
