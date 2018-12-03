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
public class GlyphGUI {

    public TextShape titleShape;
    public TextShape otherShape;

    public Shape l1Shape;
    public Shape r1Shape;
    public Shape l2Shape;
    public Shape r2Shape;
    public Shape l3Shape;
    public Shape r3Shape;
    public Shape l4Shape;
    public Shape r4Shape;

    public Shape glyphBlackBar;
    public boolean initialized;


    /**
     * Constructor for Glyph
     */
    public GlyphGUI() {
        glyphBlackBar = new Shape(0, 0, 15, 60, Color.BLACK);
        initialized = false;
    }
    
    public void remove(Window win) {
        win.removeShape(titleShape);
        win.removeShape(otherShape);
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
    public void update(
        Window win,
        RepresentationEnum rep,
        SortEnum sort,
        Song song) {
        if (initialized) {
            remove(win);
        }

        int l1width;
        int r1width;
        int l2width;
        int r2width;
        int l3width;
        int r3width;
        int l4width;
        int r4width;

        titleShape = new TextShape(0, 0, song.getTitle());
        titleShape.setBackgroundColor(Color.WHITE);

        switch (sort) {
            case TITLE:
                otherShape = new TextShape(0, 0, "by " + song.getArtist());
                break;
            case ARTIST:
                otherShape = new TextShape(0, 0, "by " + song.getArtist());
                break;
            case YEAR:
                otherShape = new TextShape(0, 0, "released in: " + song
                    .getYear());
                break;
            case GENRE:
                otherShape = new TextShape(0, 0, "genre: " + song.getYear());
                break;
            default:
                throw new IllegalArgumentException(
                    "Invalid SortEnum pass to Glyph");
        }

        otherShape.setBackgroundColor(Color.WHITE);

        l1width = (int)((double)song.getRepresentation(rep)[0] / song
            .getNumResponse(rep)[0] * 75);
        r1width = (int)((double)song.getRepresentation(rep)[1] / song
            .getNumResponse(rep)[1] * 75);
        l2width = (int)((double)song.getRepresentation(rep)[2] / song
            .getNumResponse(rep)[2] * 75);
        r2width = (int)((double)song.getRepresentation(rep)[3] / song
            .getNumResponse(rep)[3] * 75);
        l3width = (int)((double)song.getRepresentation(rep)[4] / song
            .getNumResponse(rep)[4] * 75);
        r3width = (int)((double)song.getRepresentation(rep)[5] / song
            .getNumResponse(rep)[5] * 75);
        l4width = (int)((double)song.getRepresentation(rep)[6] / song
            .getNumResponse(rep)[6] * 75);
        r4width = (int)((double)song.getRepresentation(rep)[7] / song
            .getNumResponse(rep)[7] * 75);

        l1Shape = new Shape(0, 0, l1width, 15, Color.PINK);
        r1Shape = new Shape(0, 0, r1width, 15, Color.PINK);
        l2Shape = new Shape(0, 0, l2width, 15, Color.BLUE);
        r2Shape = new Shape(0, 0, r2width, 15, Color.BLUE);
        l3Shape = new Shape(0, 0, l3width, 15, Color.YELLOW);
        r3Shape = new Shape(0, 0, r3width, 15, Color.YELLOW);
        l4Shape = new Shape(0, 0, l4width, 15, Color.GREEN);
        r4Shape = new Shape(0, 0, r4width, 15, Color.GREEN);
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
        int yLoc = y;

        titleShape.moveTo(x - (titleShape.getWidth() / 2), yLoc);
        yLoc += titleShape.getHeight() + 5;
        otherShape.moveTo(x - (otherShape.getWidth() / 2), yLoc);
        yLoc += otherShape.getHeight() + 5;

        glyphBlackBar.moveTo(x - (glyphBlackBar.getWidth() / 2), yLoc);
        l1Shape.moveTo(x - l1Shape.getWidth() - (glyphBlackBar.getWidth() / 2),
            yLoc);
        r1Shape.moveTo(x + (glyphBlackBar.getWidth() / 2), yLoc);
        yLoc += l1Shape.getHeight();
        l2Shape.moveTo(x - l2Shape.getWidth() - (glyphBlackBar.getWidth() / 2),
            yLoc);
        r2Shape.moveTo(x + (glyphBlackBar.getWidth() / 2), yLoc);
        yLoc += l2Shape.getHeight();
        l3Shape.moveTo(x - l3Shape.getWidth() - (glyphBlackBar.getWidth() / 2),
            yLoc);
        r3Shape.moveTo(x + (glyphBlackBar.getWidth() / 2), yLoc);
        yLoc += l3Shape.getHeight();
        l4Shape.moveTo(x - l4Shape.getWidth() - (glyphBlackBar.getWidth() / 2),
            yLoc);
        r4Shape.moveTo(x + (glyphBlackBar.getWidth() / 2), yLoc);

        win.addShape(titleShape);
        win.addShape(otherShape);
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
