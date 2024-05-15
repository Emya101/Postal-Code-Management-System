//Emhenya Supreme 
import java.util.Comparator;

/**
 * Provides a static method for performing quicksort on a queue.
 */
public class QuickSort<K> {

    /**
     * Sorts the elements of a queue using the quicksort algorithm.
     *
     * @param S    The queue to be sorted.
     * @param comp The comparator to determine the order of elements.
     * @param <K>  The type of elements in the queue.
     */
    public static <K> void quickSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size(); // Number of elements in the queue
        if (n < 2) return; // If queue has 1 or fewer elements, it's already sorted

        K pivot = S.first(); // Choose the first element as the pivot
        Queue<K> L = new LinkedQueue<>(); // Queue for elements less than the pivot
        Queue<K> E = new LinkedQueue<>(); // Queue for elements equal to the pivot
        Queue<K> G = new LinkedQueue<>(); // Queue for elements greater than the pivot

        // Partitioning step: Iterate through each element in S and place them in appropriate queues
        while (!S.isEmpty()) {
            K element = S.dequeue(); // Dequeue an element from S
            int c = comp.compare(element, pivot); // Compare the element with the pivot
            if (c < 0)
                L.enqueue(element); // If element is less than pivot, enqueue it in L
            else if (c == 0)
                E.enqueue(element); // If element is equal to pivot, enqueue it in E
            else
                G.enqueue(element); // If element is greater than pivot, enqueue it in G
        }

        // Recursive step: Sort the sub-queues L and G
        quickSort(L, comp); // Sort elements less than the pivot
        quickSort(G, comp); // Sort elements greater than the pivot

        // Combine step: Enqueue elements from L, E, and G back into S
        while (!L.isEmpty())
            S.enqueue(L.dequeue()); // Enqueue elements from L back into S
        while (!E.isEmpty())
            S.enqueue(E.dequeue()); // Enqueue elements from E back into S
        while (!G.isEmpty())
            S.enqueue(G.dequeue()); // Enqueue elements from G back into S
    }
}
