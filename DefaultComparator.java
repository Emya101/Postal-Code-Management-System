//Emhenya Supreme 
import java.util.Comparator;

/**
 * A default comparator that compares objects of type {@code K}.
 * Assumes that the objects are instances of {@link Comparable}.
 *
 * @param <K> the type of objects that may be compared by this comparator
 */
public class DefaultComparator<K> implements Comparator<K> {

    /**
     * Compares its two arguments for order.
     * Assumes that both arguments implement {@link Comparable}.
     *
     * @param a the first object to be compared
     * @param b the second object to be compared
     * @return a negative integer, zero, or a positive integer as the first argument
     *         is less than, equal to, or greater than the second
     * @throws ClassCastException if the arguments' types prevent them from being compared
     */
    public int compare(K a, K b) {
        return ((Comparable<K>)a).compareTo(b);  // Cast 'a' to Comparable and compare to 'b'
    }
}
