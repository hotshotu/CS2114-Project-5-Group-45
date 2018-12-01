/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska), Kenneth Ding (dkenny), Jeffrey Peng (jeffpeng123)
 */

package prj5;

import java.io.*;
import CS2114.*;

/**
 * The front end for the project
 * 
 * @author Ender Jaska (eljaska), Kenneth Ding (dkenny)
 * @version 2018.11.29
 */
public class GUIProjectWindow {

    private ProjectBackend backend;
    private int glyph1Num;
    private int glyph2Num;
    private Glyph[] glyphs;
    private Key key;
    private Window window;
    private Button prev;
    private Button next;
    private RepresentationEnum currentRep;
    private SortEnum currentSort;


    /**
     * Constructor for ProjectWindow
     * 
     * @param args
     *            the files we are looking for
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public GUIProjectWindow(String[] args) throws FileNotFoundException {
        backend = new ProjectBackend(args);
        glyph1Num = 0;
        if (backend.getNumReps() < 9) {
            glyph2Num = backend.getNumReps();
        }
        else {
            glyph2Num = 9;
        }
        glyphs = new Glyph[9];
        for (int i = 0; i < glyph2Num; i++) {
            glyphs[i] = new Glyph();
        }
        key = new Key();
        window = new Window(); 
        prev = new Button("<-- Prev");
        prev.disable();
        next = new Button("Next -->");
        if (glyph2Num < 9) {
            next.disable();
        }

        Button sortArtist = new Button("Sort by Artist Name");
        Button sortTitle = new Button("Sort by Title Name");
        Button sortYear = new Button("Sort by Release year");
        Button sortGenre = new Button("Sort by Genre");

        Button repHobby = new Button("Represent Hobby");
        Button repMajor = new Button("Represent Major");
        Button repRegion = new Button("Represent Region");

        Button quit = new Button("Quit");

        window.addButton(prev, WindowSide.NORTH);
        prev.onClick(this, "pressedPrev");

        window.addButton(sortArtist, WindowSide.NORTH);
        sortArtist.onClick(this, "pressedSortArtist");
        window.addButton(sortTitle, WindowSide.NORTH);
        sortTitle.onClick(this, "pressedSortTitle");
        window.addButton(sortYear, WindowSide.NORTH);
        sortYear.onClick(this, "pressedSortYear");
        window.addButton(sortGenre, WindowSide.NORTH);
        sortGenre.onClick(this, "pressedSortGenre");
        window.addButton(next, WindowSide.NORTH);
        next.onClick(this, "pressedNext");

        window.addButton(repHobby, WindowSide.SOUTH);
        repHobby.onClick(this, "pressedRepHobby");
        window.addButton(repMajor, WindowSide.SOUTH);
        repMajor.onClick(this, "pressedRepMajor");
        window.addButton(repRegion, WindowSide.SOUTH);
        repRegion.onClick(this, "pressedRepRegion");

        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "pressedQuit");

        currentRep = RepresentationEnum.HOBBY;
        currentSort = null;
        pressedRepHobby(repHobby);
        pressedSortTitle(sortTitle);
    }


    /**
     * Displays the glyphs and key
     */
    public void display() {
        for (int i = 0; i < glyph2Num - glyph1Num; i++) {
            if (i < 2) {
                glyphs[i].displayGlyph(window, i * 100, 0);
            }
            else if (i < 5) {
                glyphs[i].displayGlyph(window, (i - 3) * 100, 100);
            }
            else {
                glyphs[i].displayGlyph(window, (i - 6), 200);
            }
        }
        key.displayKey(window);
        window.repaint();
    }


    /**
     * Displays next set of glyphs
     * 
     * @param button
     *            Next button
     */
    public void pressedNext(Button button) {
        if (glyph2Num + 9 < backend.getNumReps()) {
            glyph1Num += 9;
            glyph2Num += 9;
            prev.enable();
        }
        else if (glyph1Num + 9 < backend.getNumReps()) {
            glyph1Num += 9;
            glyph2Num = backend.getNumReps();
            next.disable();
        }
        display();
    }


    /**
     * Displays previous set of glyphs
     * 
     * @param button
     *            Previous button
     */
    public void pressedPrev(Button button) {
        if (glyph2Num == backend.getNumReps()) {
            glyph1Num -= 9;
            glyph2Num = glyph1Num + 9;
            next.enable();
        }
        else if (glyph1Num - 9 >= 0) {
            glyph1Num -= 9;
            glyph2Num -= 9;
            next.enable();
        }
        else {
            glyph1Num -= 9;
            glyph2Num -= 9;
            prev.disable();
        }
        display();
    }


    /**
     * Sorts the glyphs by title
     * 
     * @param button
     *            Sort title button
     */
    public void pressedSortTitle(Button button) {
        currentSort = SortEnum.TITLE;
        backend.sortSongs(currentSort);
        glyph1Num = 0;
        if (backend.getNumReps() < 9) {
            glyph2Num = backend.getNumReps();
        }
        else {
            glyph2Num = 9;
        }
        for (int i = 0; i < glyph2Num - glyph1Num; i++) {
            glyphs[i].update(currentRep, backend.getSongs().getIndex(i
                + glyph1Num).getData(), backend.getNumReps());
        }
        display();
    }


    /**
     * Sorts the glyphs by title
     * 
     * @param button
     *            Sort artist button
     */
    public void pressedSortArtist(Button button) {
        currentSort = SortEnum.ARTIST;
        backend.sortSongs(currentSort);
        glyph1Num = 0;
        if (backend.getNumReps() < 9) {
            glyph2Num = backend.getNumReps();
        }
        else {
            glyph2Num = 9;
        }
        for (int i = 0; i < glyph2Num - glyph1Num; i++) {
            glyphs[i].update(currentRep, backend.getSongs().getIndex(i
                + glyph1Num).getData(), backend.getNumReps());
        }
        display();
    }


    /**
     * Sorts the glyphs by year
     * 
     * @param button
     *            Sort year button
     */
    public void pressedSortYear(Button button) {
        currentSort = SortEnum.YEAR;
        backend.sortSongs(currentSort);
        glyph1Num = 0;
        if (backend.getNumReps() < 9) {
            glyph2Num = backend.getNumReps();
        }
        else {
            glyph2Num = 9;
        }
        for (int i = 0; i < glyph2Num - glyph1Num; i++) {
            glyphs[i].update(currentRep, backend.getSongs().getIndex(i
                + glyph1Num).getData(), backend.getNumReps());
        }
        display();
    }


    /**
     * Sorts the glyphs by genre
     * 
     * @param button
     *            Sort genre button
     */
    public void pressedSortGenre(Button button) {
        currentSort = SortEnum.GENRE;
        backend.sortSongs(currentSort);
        glyph1Num = 0;
        if (backend.getNumReps() < 9) {
            glyph2Num = backend.getNumReps();
        }
        else {
            glyph2Num = 9;
        }
        for (int i = 0; i < glyph2Num - glyph1Num; i++) {
            glyphs[i].update(currentRep, backend.getSongs().getIndex(i
                + glyph1Num).getData(), backend.getNumReps());
        }
        display();
    }


    /**
     * Represents the glyphs by hobby
     * 
     * @param button
     *            Represent hobby button
     */
    public void pressedRepHobby(Button button) {
        currentRep = RepresentationEnum.HOBBY;
        for (int i = 0; i < glyph2Num - glyph1Num; i++) {
            glyphs[i].update(currentRep, backend.getSongs().getIndex(i
                + glyph1Num).getData(), backend.getNumReps());
        }
        key.update(currentRep);
        display();
    }


    /**
     * Represents the glyphs by major
     * 
     * @param button
     *            Represent major button
     */
    public void pressedRepMajor(Button button) {
        currentRep = RepresentationEnum.MAJOR;
        for (int i = 0; i < glyph2Num - glyph1Num; i++) {
            glyphs[i].update(currentRep, backend.getSongs().getIndex(i
                + glyph1Num).getData(), backend.getNumReps());
        }
        key.update(currentRep);
        display();
    }


    /**
     * Represents the glyphs by region
     * 
     * @param button
     *            Represent region button
     */
    public void pressedRepRegion(Button button) {
        currentRep = RepresentationEnum.REGION;
        for (int i = 0; i < glyph2Num - glyph1Num; i++) {
            glyphs[i].update(currentRep, backend.getSongs().getIndex(i
                + glyph1Num).getData(), backend.getNumReps());
        }
        key.update(currentRep);
        display();
    }

 
    /**
     * Quits the program
     * 
     * @param button
     *            Quit button
     */
    public void pressedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Gets the next and previous buttons, used for testing
     * 
     * @return Returns the next and previous buttons
     */
    public Button[] getNPButtons() {

        Button[] temp = new Button[9];
        temp[0] = next;
        temp[1] = prev;
//        temp[2] = quit;
//        temp[3] = repMajor;
//        temp[4] = repHobby;
//        temp[5] = sortGenre;
//        temp[6] = sortYear;
//        temp[7] = sortTitle;
//        temp[8] = sortArtist;
        return temp;
    }
}
