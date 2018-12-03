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

    private int[] numHReps;
    private int[] numMReps;
    private int[] numRReps;


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

        numHReps = new int[8];
        numMReps = new int[8];
        numRReps = new int[8];

        for (int i = 0; i < 8; i++) {
            hobby[i] = 0;
            major[i] = 0;
            region[i] = 0;
            numHReps[i] = 0;
            numMReps[i] = 0;
            numRReps[i] = 0;
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
    public void add(
        HobbyEnum hobbyE,
        MajorEnum majorE,
        RegionEnum regionE,
        HorLEnum horl,
        YorNEnum yorn) {
        switch (horl) {
            case HEARD:
                switch (hobbyE) {
                    case READ:
                        switch (yorn) {
                            case YES:
                                hobby[0]++;
                                numHReps[0]++;
                                break;
                            case NO:
                                numHReps[0]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case ART:
                        switch (yorn) {
                            case YES:
                                hobby[2]++;
                                numHReps[2]++;
                                break;
                            case NO:
                                numHReps[2]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case SPORTS:
                        switch (yorn) {
                            case YES:
                                hobby[4]++;
                                numHReps[4]++;
                                break;
                            case NO:
                                numHReps[4]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case MUSIC:
                        switch (yorn) {
                            case YES:
                                hobby[6]++;
                                numHReps[6]++;
                                break;
                            case NO:
                                numHReps[6]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid HobbyEnum pass to Song");
                }
                break;
            case LIKED:
                switch (hobbyE) {
                    case READ:
                        switch (yorn) {
                            case YES:
                                hobby[1]++;
                                numHReps[1]++;
                                break;
                            case NO:
                                numHReps[1]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case ART:
                        switch (yorn) {
                            case YES:
                                hobby[3]++;
                                numHReps[3]++;
                                break;
                            case NO:
                                numHReps[3]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case SPORTS:
                        switch (yorn) {
                            case YES:
                                hobby[5]++;
                                numHReps[5]++;
                                break;
                            case NO:
                                numHReps[5]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case MUSIC:
                        switch (yorn) {
                            case YES:
                                hobby[7]++;
                                numHReps[7]++;
                                break;
                            case NO:
                                numHReps[7]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
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
        switch (horl) {
            case HEARD:
                switch (majorE) {
                    case COMPSCI:
                        switch (yorn) {
                            case YES:
                                major[0]++;
                                numMReps[0]++;
                                break;
                            case NO:
                                numMReps[0]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case OTHERENG:
                        switch (yorn) {
                            case YES:
                                major[2]++;
                                numMReps[2]++;
                                break;
                            case NO:
                                numMReps[2]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case MATHCDMA:
                        switch (yorn) {
                            case YES:
                                major[4]++;
                                numMReps[4]++;
                                break;
                            case NO:
                                numMReps[4]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case OTHER:
                        switch (yorn) {
                            case YES:
                                major[6]++;
                                numMReps[6]++;
                                break;
                            case NO:
                                numMReps[6]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid majorEnum pass to Song");
                }
                break;
            case LIKED:
                switch (majorE) {
                    case COMPSCI:
                        switch (yorn) {
                            case YES:
                                major[1]++;
                                numMReps[1]++;
                                break;
                            case NO:
                                numMReps[1]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case OTHERENG:
                        switch (yorn) {
                            case YES:
                                major[3]++;
                                numMReps[3]++;
                                break;
                            case NO:
                                numMReps[3]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case MATHCDMA:
                        switch (yorn) {
                            case YES:
                                major[5]++;
                                numMReps[5]++;
                                break;
                            case NO:
                                numMReps[5]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case OTHER:
                        switch (yorn) {
                            case YES:
                                major[7]++;
                                numMReps[7]++;
                                break;
                            case NO:
                                numMReps[7]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
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
        switch (horl) {
            case HEARD:
                switch (regionE) {
                    case NEUS:
                        switch (yorn) {
                            case YES:
                                region[0]++;
                                numRReps[0]++;
                                break;
                            case NO:
                                numRReps[0]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case SEUS:
                        switch (yorn) {
                            case YES:
                                region[2]++;
                                numRReps[2]++;
                                break;
                            case NO:
                                numRReps[2]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case OTHERUS:
                        switch (yorn) {
                            case YES:
                                region[4]++;
                                numRReps[4]++;
                                break;
                            case NO:
                                numRReps[4]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case OUTSIDEUS:
                        switch (yorn) {
                            case YES:
                                region[6]++;
                                numRReps[6]++;
                                break;
                            case NO:
                                numRReps[6]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid regionEnum pass to Song");
                }
                break;
            case LIKED:
                switch (regionE) {
                    case NEUS:
                        switch (yorn) {
                            case YES:
                                region[1]++;
                                numRReps[1]++;
                                break;
                            case NO:
                                numRReps[1]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case SEUS:
                        switch (yorn) {
                            case YES:
                                region[3]++;
                                numRReps[3]++;
                                break;
                            case NO:
                                numRReps[3]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case OTHERUS:
                        switch (yorn) {
                            case YES:
                                region[5]++;
                                numRReps[5]++;
                                break;
                            case NO:
                                numRReps[5]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
                        break;
                    case OUTSIDEUS:
                        switch (yorn) {
                            case YES:
                                region[7]++;
                                numRReps[7]++;
                                break;
                            case NO:
                                numRReps[7]++;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Invalid YorNEnum pass to Song");
                        }
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


    public int[] getNumResponse(RepresentationEnum RepE) {
        switch (RepE) {
            case HOBBY:
                return numHReps;
            case MAJOR:
                return numMReps;
            case REGION:
                return numRReps;
            default:
                throw new IllegalArgumentException(
                    "Invalid Representation pass to Song");
        }
    }


    /**
     * Getter method for the heard and liked numbers of a given representation
     * 
     * @param RepE
     *            The representation to be returned
     * @return Returns the corresponding array
     */
    public int[] getRepresentation(RepresentationEnum RepE) {
        switch (RepE) {
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
