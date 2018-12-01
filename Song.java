/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and integrity at all times. I
 * will not lie, cheat, or steal, nor will I accept the actions of those who do.
 * -- Ender Jaska (eljaska), Kenneth Ding (dkenny), Jeffrey Peng (jeffpeng123)
 */

package prj5;

/**
 * Song is the back end data that stores a single song
 * 
 * @author Ender Jaska (eljaska)
 * @version 2018.11.29
 */
public class Song {

    private String title;
    private String artist;
    private int year;
    private String genre;

    private int[] hobby;
    private int[] major;
    private int[] region;


    /**
     * Constructor for Song
     * 
     * @param title
     *            The title of the song
     * @param artist
     *            The artist of the song
     * @param year
     *            The release year of the song
     * @param genre
     *            The genre of the song
     */
    public Song(String title, String artist, int year, String genre) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;

        hobby = new int[8];
        major = new int[8];
        region = new int[8];

        for (int i = 0; i < 8; i++) {
            hobby[i] = 0;
            major[i] = 0;
            region[i] = 0;
        }
    }


    /**
     * Adds a "Yes" for a whether a song has been heard or liked with any given
     * hobby, major, or region
     * 
     * @param hobbyE
     *            The hobby to be added to
     * @param majorE
     *            The major to be added to
     * @param regionE
     *            The region to be added to
     * @param horl
     *            Whether the song was heard or liked
     */
    public void addYes(
        HobbyEnum hobbyE,
        MajorEnum majorE,
        RegionEnum regionE,
        HorLEnum horl) {
        if (hobbyE != null) {
            switch (horl) {
                case HEARD:
                    switch (hobbyE) {
                        case READ:
                            hobby[0]++;
                            break;
                        case ART:
                            hobby[2]++;
                            break;
                        case SPORTS:
                            hobby[4]++;
                            break;
                        case MUSIC:
                            hobby[6]++;
                            break;
                        default:
                            throw new IllegalArgumentException(
                                "Invalid HobbyEnum pass to Song");
                    }
                    break;
                case LIKED:
                    switch (hobbyE) {
                        case READ:
                            hobby[1]++;
                            break;
                        case ART:
                            hobby[3]++;
                            break;
                        case SPORTS:
                            hobby[5]++;
                            break;
                        case MUSIC:
                            hobby[7]++;
                            break;
                        default:
                            throw new IllegalArgumentException(
                                "Invalid HobbyEnum pass to Song");
                    }
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid HorLEnum pass to Song");
            }
        }
        if (majorE != null) {
            switch (horl) {
                case HEARD:
                    switch (majorE) {
                        case COMPSCI:
                            major[0]++;
                            break;
                        case OTHERENG:
                            major[2]++;
                            break;
                        case MATHCDMA:
                            major[4]++;
                            break;
                        case OTHER:
                            major[6]++;
                            break;
                        default:
                            throw new IllegalArgumentException(
                                "Invalid majorEnum pass to Song");
                    }
                    break;
                case LIKED:
                    switch (majorE) {
                        case COMPSCI:
                            major[1]++;
                            break;
                        case OTHERENG:
                            major[3]++;
                            break;
                        case MATHCDMA:
                            major[5]++;
                            break;
                        case OTHER:
                            major[7]++;
                            break;
                        default:
                            throw new IllegalArgumentException(
                                "Invalid majorEnum pass to Song");
                    }
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid HorLEnum pass to Song");
            }
        }
        if (regionE != null) {
            switch (horl) {
                case HEARD:
                    switch (regionE) {
                        case NEUS:
                            region[0]++;
                            break;
                        case SEUS:
                            region[2]++;
                            break;
                        case OTHERUS:
                            region[4]++;
                            break;
                        case OUTSIDEUS:
                            region[6]++;
                            break;
                        default:
                            throw new IllegalArgumentException(
                                "Invalid regionEnum pass to Song");
                    }
                    break;
                case LIKED:
                    switch (regionE) {
                        case NEUS:
                            region[1]++;
                            break;
                        case SEUS:
                            region[3]++;
                            break;
                        case OTHERUS:
                            region[5]++;
                            break;
                        case OUTSIDEUS:
                            region[7]++;
                            break;
                        default:
                            throw new IllegalArgumentException(
                                "Invalid regionEnum pass to Song");
                    }
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid HorLEnum pass to Song");
            }
        }
    }


    /**
     * Getter method for the heard and liked numbers of a given representation
     * 
     * @param repE
     *            The representation to be returned
     * @return Returns the corresponding array
     */
    public int[] getRepresentation(RepresentationEnum repE) {
        switch (repE) {
            case HOBBY:
                return hobby;
            case MAJOR:
                return major;
            case REGION:
                return region;
            default:
                throw new IllegalArgumentException(
                    "Invalid Representation pass to Song");
        }
    }


    /**
     * Getter method for title
     * 
     * @return Returns title
     */
    public String getTitle() {
        return title;
    }


    /**
     * Getter method for artist
     * 
     * @return Returns artist
     */
    public String getArtist() {
        return artist;
    }


    /**
     * Getter method for year
     * 
     * @return Returns year
     */
    public int getYear() {
        return year;
    }


    /**
     * Getter method for genre
     * 
     * @return Returns genre
     */
    public String getGenre() {
        return genre;
    }
}
