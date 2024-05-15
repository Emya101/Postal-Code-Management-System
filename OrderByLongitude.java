//Emhenya Supreme 
// Importing the Comparator interface from the Java utility library
import java.util.Comparator;

/**
 * A comparator for sorting PostalCode objects based on their longitude values.
 */
public class OrderByLongitude implements Comparator<PostalCode> {

    /**
     * Compares two PostalCode objects based on their longitude values.
     *
     * @param code1 The first PostalCode object to compare.
     * @param code2 The second PostalCode object to compare.
     * @return -1 if code1 precedes code2, 1 if code1 follows code2, or 0 if their longitudes are equal.
     */
    public int compare(PostalCode code1, PostalCode code2) {
        // Comparing the longitudes of the PostalCode objects
        if (code1.getLongitude() < code2.getLongitude()) {
            // If the longitude of code1 is less than code2, return -1 indicating code1 precedes code2
            return -1;
        } else if (code1.getLongitude() > code2.getLongitude()) {
            // If the longitude of code1 is greater than code2, return 1 indicating code1 follows code2
            return 1;
        } else {
            // If the longitudes are equal, return 0 indicating both PostalCode objects have the same longitude
            return 0;
        }
    }
}
 

