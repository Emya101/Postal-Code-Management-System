import java.util.Iterator;

/**
 * Abstract base class for a map implementation.
 * Provides basic implementations for common map methods.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {
    
    /**
     * Returns {@code true} if this map contains no key-value mappings.
     * 
     * @return {@code true} if this map contains no key-value mappings
     */
    public boolean isEmpty() {
        return size() == 0;  // Return true if size is 0
    }

    /**
     * A concrete implementation of the Entry interface.
     * Represents a key-value pair.
     *
     * @param <K> the type of keys maintained by this map entry
     * @param <V> the type of mapped values
     */
    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K k;  // Key of the entry
        private V v;  // Value of the entry
        
        /**
         * Constructs a new map entry with the specified key and value.
         * 
         * @param key the key for this entry
         * @param value the value for this entry
         */
        public MapEntry(K key, V value) {
            k = key;  // Initialize key
            v = value;  // Initialize value
        }

        /**
         * Returns the key corresponding to this entry.
         * 
         * @return the key corresponding to this entry
         */
        public K getKey() {
            return k;  // Return the key
        }

        /**
         * Returns the value corresponding to this entry.
         * 
         * @return the value corresponding to this entry
         */
        public V getValue() {
            return v;  // Return the value
        }

        /**
         * Sets the key for this entry.
         * 
         * @param key the new key
         */
        protected void setKey(K key) {
            k = key;  // Set the key
        }

        /**
         * Sets the value for this entry and returns the old value.
         * 
         * @param value the new value
         * @return the old value
         */
        protected V setValue(V value) {
            V old = v;  // Store old value
            v = value;  // Set new value
            return old;  // Return old value
        }
    }

    /**
     * An iterator over the keys of the map.
     */
    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();  // Iterator over the map entries

        /**
         * Returns {@code true} if the iteration has more elements.
         * 
         * @return {@code true} if the iteration has more elements
         */
        public boolean hasNext() {
            return entries.hasNext();  // Check if more entries are available
        }

        /**
         * Returns the next key in the iteration.
         * 
         * @return the next key in the iteration
         */
        public K next() {
            return entries.next().getKey();  // Return the next key
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).
         * 
         * @throws UnsupportedOperationException if the remove operation is not supported
         */
        public void remove() {
            throw new UnsupportedOperationException();  // Remove not supported
        }
    }

    /**
     * An iterable over the keys of the map.
     */
    private class KeyIterable implements Iterable<K> {
        
        /**
         * Returns an iterator over elements of type {@code K}.
         * 
         * @return an Iterator
         */
        public Iterator<K> iterator() {
            return new KeyIterator();  // Return a new key iterator
        }
    }

    /**
     * Returns an iterable view of the keys contained in this map.
     * 
     * @return an iterable view of the keys contained in this map
     */
    public Iterable<K> keySet() {
        return new KeyIterable();  // Return an iterable for keys
    }

    /**
     * An iterator over the values of the map.
     */
    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();  // Iterator over the map entries

        /**
         * Returns {@code true} if the iteration has more elements.
         * 
         * @return {@code true} if the iteration has more elements
         */
        public boolean hasNext() {
            return entries.hasNext();  // Check if more entries are available
        }

        /**
         * Returns the next value in the iteration.
         * 
         * @return the next value in the iteration
         */
        public V next() {
            return entries.next().getValue();  // Return the next value
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).
         * 
         * @throws UnsupportedOperationException if the remove operation is not supported
         */
        public void remove() {
            throw new UnsupportedOperationException();  // Remove not supported
        }
    }

    /**
     * An iterable over the values of the map.
     */
    private class ValueIterable implements Iterable<V> {
        
        /**
         * Returns an iterator over elements of type {@code V}.
         * 
         * @return an Iterator
         */
        public Iterator<V> iterator() {
            return new ValueIterator();  // Return a new value iterator
        }
    }

    /**
     * Returns an iterable view of the values contained in this map.
     * 
     * @return an iterable view of the values contained in this map
     */
    public Iterable<V> value() {
        return new ValueIterable();  // Return an iterable for values
    }
}
