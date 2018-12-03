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
    private GUIGlyph[] glyphs;
    private GUIKey key;
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
        if (backend.getSongs().size() < 9) {
            glyph2Num = backend.getSongs().size();
        }
        else {
            glyph2Num = 9;
        }
        glyphs = new GUIGlyph[9];
        for (int i = 0; i < glyph2Num; i++) {
            glyphs[i] = new GUIGlyph();
        }
        key = new GUIKey();
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

        window.setTitle("Project 5 eljaska dkenny jeffp123");

        currentRep = RepresentationEnum.HOBBY;
        currentSort = SortEnum.TITLE;
        pressedRepHobby(repHobby);
        pressedSortGenre(sortGenre);
        output();
        pressedSortTitle(sortTitle);
        output();
    }


    /**
     * Displays the glyphs and key
     */
    public void display() {
        for (int i = 0; i < glyph2Num - glyph1Num; i++) {
            if (i < 3) {
                glyphs[i].displayGlyph(window, i * 200 + 130, 50);
            }
            else if (i < 6) {
                glyphs[i].displayGlyph(window, (i - 3) * 200 + 130, 200);
            }
            else {
                glyphs[i].displayGlyph(window, (i - 6) * 200 + 130, 350);
            }
        }
        key.displayKey(window);
        window.repaint();
    }


    /**
     * Updates the various glyphs and keys
     */
    public void update() {
        for (int i = 0; i < glyph2Num - glyph1Num; i++) {
            Song temp = backend.getSongs().getIndex(i + glyph1Num).getData();
            glyphs[i].update(window, currentRep, currentSort, temp);
        }
        key.update(currentRep);
    }


    /**
     * Displays next set of glyphs
     * 
     * @param button
     *            Next button
     */
    public void pressedNext(Button button) {
        if (glyph2Num + 9 < backend.getSongs().size()) {
            glyph1Num += 9;
            glyph2Num += 9;
            prev.enable();
        }
        else if (glyph1Num + 9 < backend.getSongs().size()) {
            glyph1Num += 9;
            glyph2Num = backend.getSongs().size();
            next.disable();
            for (int i = glyph2Num - glyph1Num; i < 9; i++) {
                glyphs[i].remove(window);
            }
        }
        update();
        display();
    }


    /**
     * Displays previous set of glyphs
     * 
     * @param button
     *            Previous button
     */
    public void pressedPrev(Button button) {
        if (glyph2Num == backend.getSongs().size()) {
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
        update();
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
        prev.disable();
        if (backend.getSongs().size() < 9) {
            glyph2Num = backend.getSongs().size();
            next.disable();
        }
        else {
            glyph2Num = 9;
            next.enable();
        }
        update();
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
        prev.disable();
        if (backend.getSongs().size() < 9) {
            glyph2Num = backend.getSongs().size();
            next.disable();
        }
        else {
            glyph2Num = 9;
            next.enable();
        }
        update();
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
        prev.disable();
        if (backend.getSongs().size() < 9) {
            glyph2Num = backend.getSongs().size();
            next.disable();
        }
        else {
            glyph2Num = 9;
            next.enable();
        }
        update();
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
        prev.disable();
        if (backend.getSongs().size() < 9) {
            glyph2Num = backend.getSongs().size();
            next.disable();
        }
        else {
            glyph2Num = 9;
            next.enable();
        }
        update();
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
        update();
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
        update();
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
        update();
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
     * Responsible for outputing the correct songs
     */
    private void output() {
        for (int i = 0; i < backend.getSongs().size(); i++) {
            System.out.println("song title " + backend.getSongs().getIndex(i)
                .getData().getTitle());
            System.out.println("song artist " + backend.getSongs().getIndex(i)
                .getData().getArtist());
            System.out.println("song genre " + backend.getSongs().getIndex(i)
                .getData().getGenre());
            System.out.println("song year " + backend.getSongs().getIndex(i)
                .getData().getYear());

            Song temp = backend.getSongs().getIndex(i).getData();

            System.out.println("heard");
            System.out.print("reading" + (int)(100.0 * temp.getRepresentation(
                currentRep)[0] / temp.getNumResponse(currentRep)[0]));
            System.out.print(" art" + (int)(100.0 * temp.getRepresentation(
                currentRep)[2] / temp.getNumResponse(currentRep)[2]));
            System.out.print(" sports" + (int)(100.0 * temp.getRepresentation(
                currentRep)[4] / temp.getNumResponse(currentRep)[4]));
            System.out.println(" music" + (int)(100.0 * temp.getRepresentation(
                currentRep)[6] / temp.getNumResponse(currentRep)[6]));

            System.out.println("likes");
            System.out.print("reading" + (int)(100.0 * temp.getRepresentation(
                currentRep)[1] / temp.getNumResponse(currentRep)[1]));
            System.out.print(" art" + (int)(100.0 * temp.getRepresentation(
                currentRep)[3] / temp.getNumResponse(currentRep)[3]));
            System.out.print(" sports" + (int)(100.0 * temp.getRepresentation(
                currentRep)[5] / temp.getNumResponse(currentRep)[5]));
            System.out.println(" music" + (int)(100.0 * temp.getRepresentation(
                currentRep)[7] / temp.getNumResponse(currentRep)[7]));
            System.out.println("");
        }
    }
}
