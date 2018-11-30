/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska), Kenneth Ding (dkenny), Jeffrey Peng (jeffpeng123)
 */

package prj5;

import java.io.*;
import java.util.Scanner;

/**
 * The backend for the project
 * 
 * @author Ender Jaska (eljaska), Kenneth Ding (dkenny), Jeffrey Peng (jeffp123)
 * @version 2018.11.29
 */
public class ProjectBackend {

    private LinkedSong songs;
    private int numResponse;


    /**
     * The constructor for ProjectBackend
     * 
     * @param args
     *            The input files
     * @throws FileNotFoundException
     */
    public ProjectBackend(String[] args) throws FileNotFoundException {
        songs = new LinkedSong();
        numResponse = 0;
        loadSongs(args[1]);
        loadSurvey(args[0]);
    }


    /**
     * Getter method for the song list
     * 
     * @return Returns the song list
     */
    public LinkedSong getSongs() {
        return songs;
    }


    /**
     * Getter method for the number of respondents
     * 
     * @return Returns the number of people who responded
     */
    public int getNumReps() {
        return numResponse;
    }


    /**
     * Loads the data from the song file into a LinkedSong
     * 
     * @param fileName
     *            The name of the song file
     * @throws FileNotFoundException
     */
    public void loadSongs(String fileName) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        file.nextLine();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] params = line.split(",");

            String name = params[0];
            String artist = params[1];
            int year = Integer.parseInt(params[2]);
            String genre = params[3];

            Song song = new Song(name, artist, year, genre);
            SongNode node = new SongNode(song);
            songs.add(node);
        }
        file.close();
    }


    /**
     * Loads the data from the response file into the LinkedSong
     * 
     * @param fileName
     *            The name of the response file
     * @throws FileNotFoundException
     */
    public void loadSurvey(String fileName) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        file.nextLine();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] params = line.split(",", -1);

            HobbyEnum hobby = null;
            MajorEnum major = null;
            RegionEnum region = null;
            numResponse++;

            if (params[2].equals("Math or CMDA")) {
                major = MajorEnum.MATHCDMA;
            }
            else if (params[2].equals("Computer Science")) {
                major = MajorEnum.COMPSCI;
            }
            else if (params[2].equals("Other Engineering")) {
                major = MajorEnum.OTHERENG;
            }
            else if (params[2].equals("Other")) {
                major = MajorEnum.OTHER;
            }

            if (params[3].equals("Northeast")) {
                region = RegionEnum.NEUS;
            }
            else if (params[3].equals("Southeast")) {
                region = RegionEnum.SEUS;
            }
            else if (params[3].equals(
                "United States (other than Southeast or Northwest)")) {
                region = RegionEnum.OTHERUS;
            }
            else if (params[3].equals("Outside of United States")) {
                region = RegionEnum.OUTSIDEUS;
            }

            if (params[4].equals("reading")) {
                hobby = HobbyEnum.READ;
            }
            else if (params[4].equals("art")) {
                hobby = HobbyEnum.ART;
            }
            else if (params[4].equals("sports")) {
                hobby = HobbyEnum.SPORTS;
            }
            else if (params[4].equals("music")) {
                hobby = HobbyEnum.MUSIC;
            }

            for (int i = 5; i < params.length; i++) {
                if (params[i].equals("Yes")) {
                    if (i % 2 == 1) {
                        songs.getIndex((i - 5) / 2).getData().addYes(hobby,
                            major, region, HorLEnum.HEARD);
                    }
                    else {
                        songs.getIndex((i - 5) / 2).getData().addYes(hobby,
                            major, region, HorLEnum.LIKED);
                    }
                }
            }
        }
        file.close();
    }


    /**
     * Sorts the songs for a given Sort
     * 
     * @param sort
     *            How the songs should be sorted
     */
    public void sortSongs(SortEnum sort) {
        int tempInt = 0;
        switch (sort) {
            case TITLE:
                for (int i = 0; i < songs.size(); i++) {
                    String original = songs.getIndex(i).getData().getTitle();
                    for (int j = i; j < songs.size(); j++) {
                        String compared = songs.getIndex(j).getData()
                            .getTitle();
                        if (original.compareTo(compared) > 0) {
                            original = compared;
                            tempInt = j;
                        }
                    }
                    Song tempSong = songs.getIndex(i).getData();
                    songs.getIndex(i).setData(songs.getIndex(tempInt)
                        .getData());
                    songs.getIndex(tempInt).setData(tempSong);
                }
                break;
            case ARTIST:
                for (int i = 0; i < songs.size(); i++) {
                    String original = songs.getIndex(i).getData().getArtist();
                    for (int j = i; j < songs.size(); j++) {
                        String compared = songs.getIndex(j).getData()
                            .getArtist();
                        if (original.compareTo(compared) > 0) {
                            original = compared;
                            tempInt = j;
                        }
                    }
                    Song tempSong = songs.getIndex(i).getData();
                    songs.getIndex(i).setData(songs.getIndex(tempInt)
                        .getData());
                    songs.getIndex(tempInt).setData(tempSong);
                }
                break;
            case YEAR:
                for (int i = 0; i < songs.size(); i++) {
                    int original = songs.getIndex(i).getData().getYear();
                    for (int j = i; j < songs.size(); j++) {
                        int compared = songs.getIndex(j).getData().getYear();
                        if (original > compared) {
                            original = compared;
                            tempInt = j;
                        }
                    }
                    Song tempSong = songs.getIndex(i).getData();
                    songs.getIndex(i).setData(songs.getIndex(tempInt)
                        .getData());
                    songs.getIndex(tempInt).setData(tempSong);
                }
                break;
            case GENRE:
                for (int i = 0; i < songs.size(); i++) {
                    String original = songs.getIndex(i).getData().getGenre();
                    for (int j = i; j < songs.size(); j++) {
                        String compared = songs.getIndex(j).getData()
                            .getGenre();
                        if (original.compareTo(compared) > 0) {
                            original = compared;
                            tempInt = j;
                        }
                    }
                    Song tempSong = songs.getIndex(i).getData();
                    songs.getIndex(i).setData(songs.getIndex(tempInt)
                        .getData());
                    songs.getIndex(tempInt).setData(tempSong);
                }
                break;
            default:
                throw new IllegalArgumentException(
                    "Invalid Sort pass to ProjectBackend");
        }
    }
}
