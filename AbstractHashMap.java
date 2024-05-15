//Emhenya Supreme//
import java.util.Random;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    // Number of entries in the hash map
    protected int n = 0; 
    // Number of buckets in the hash table
    protected int capacity; 
    // A large prime number for hash function
    public int prime; 
    // Scaling factor for hash function, a random value between 1 and prime-1
    public long scale;
    // Shifting factor for hash function, a random value between 0 and prime
    protected long shift; 
    
    // Constructor that takes capacity and prime number
    public AbstractHashMap(int cap, int p) {
        prime = p;  // Initialize prime number
        capacity = cap;  // Initialize capacity
        java.util.Random rand = new Random();  // Random number generator
        scale = rand.nextInt(prime - 1) + 1;  // Scale factor in range 1 to prime-1
        shift = rand.nextInt(prime);  // Shift factor in range 0 to prime
        createTable();  // Call to abstract method to initialize table
    }

    // Constructor that takes only capacity, uses a default prime number
    public AbstractHashMap(int cap) {
        this(cap, 109345121);  // Default prime number 109345121
    }

    // Default constructor with default capacity
    public AbstractHashMap() {
        this(17);  // Default capacity 17
    }

    // Returns the number of entries in the hash map
    public int size() {
        return n;  // Return current size
    }

    // Retrieves the value associated with the specified key
    public V get(K key) {
        return bucketGet(hashValue(key), key);  // Calculate hash and call bucketGet
    }

    // Removes the entry associated with the specified key
    public V remove(K key) {
        return bucketRemove(hashValue(key), key);  // Calculate hash and call bucketRemove
    }

    // Inserts or updates the key-value pair in the hash map
    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);  // Calculate hash and call bucketPut
        if (n > capacity / 2)  // If load factor exceeds 0.5
            resize(2 * capacity - 1);  // Resize the table to twice the capacity minus one
        return answer;  // Return the previous value associated with the key, if any
    }

    // Computes the hash value for the given key
    protected int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);  // Compute hash value
    }

    // Resizes the hash table to the new capacity
    private void resize(int newCap) {
        LinkedPositionalList<Entry<K, V>> buffer = new LinkedPositionalList<>();  // Temporary buffer for entries
        for (Entry<K, V> e : entrySet())  // Iterate over all entries
            buffer.addLast(e);  // Add entries to buffer
    
        capacity = newCap;  // Update capacity
        createTable();  // Reinitialize table with new capacity
        n = 0;  // Reset size
    
        for (Entry<K, V> e : buffer)  // Reinsert entries from buffer to new table
            put(e.getKey(), e.getValue());  // Reinsert each entry
    }
    
    // Abstract method to initialize the table, to be implemented by subclasses
    protected abstract void createTable();

    // Abstract method to get a value from a specific bucket, to be implemented by subclasses
    protected abstract V bucketGet(int h, K k);

    // Abstract method to put a value in a specific bucket, to be implemented by subclasses
    protected abstract V bucketPut(int h, K k, V v);

    // Abstract method to remove a value from a specific bucket, to be implemented by subclasses
    protected abstract V bucketRemove(int h, K k);
}
