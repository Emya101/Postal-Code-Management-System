//Emhenya Supreme 
public class LinkedPositionalChainHashMap<K, V> extends AbstractHashMap<K, V> {
    private LinkedPositionalList<Entry<K, V>>[] table;
    private int collisions;

    public LinkedPositionalChainHashMap(int cap, int p) {
        super(cap, p);
    }

    public LinkedPositionalChainHashMap(int cap) {
        super(cap);
    }

    public LinkedPositionalChainHashMap() {
        super();
    }
    
    protected void createTable() {
        table = (LinkedPositionalList<Entry<K, V>>[]) new LinkedPositionalList[capacity];
    }

    protected V bucketGet(int h, K k) {
        LinkedPositionalList<Entry<K, V>> storage = table[h];
        if (storage == null) return null;
        for (Entry<K, V> entries : storage) {
            if (entries.getKey().equals(k)) {
                return entries.getValue();
            }
        }
        return null;
    }

    protected V bucketPut(int h, K k, V v) {
        LinkedPositionalList<Entry<K, V>> storage = table[h];
        if (storage == null) {
            storage = table[h] = new LinkedPositionalList<>();
        }
        for (Position<Entry<K, V>> pos : storage.positions()) {
            if (pos.getElement().getKey().equals(k)) {
                V oldValue = pos.getElement().getValue();
                Entry<K, V> updatedEntry = new MapEntry<>(k, v);
                storage.set(pos, updatedEntry);
                return oldValue;
            }
        }
        storage.addLast(new MapEntry<>(k, v));
        n++;
        if (storage.size() > 1) {
            collisions++;
        }
        if ((double) n / capacity > 0.5) {
            resize(2 * capacity); 
        }

        return null;
    }
    
    protected V bucketRemove(int h, K k) {
        LinkedPositionalList<Entry<K, V>> storage = table[h];
        if (storage == null) return null;
        for (Position<Entry<K, V>> pos : storage.positions()) {
            if (pos.getElement().getKey().equals(k)) {
                V value = pos.getElement().getValue();
                storage.remove(pos);
                n--;
                return value;
            }
        }
        return null;
    }

    public int getCollisions() {
        return collisions;
    }

    protected void resize(int newCap) {
        LinkedPositionalList<Entry<K, V>>[] newTable = (LinkedPositionalList<Entry<K, V>>[]) new LinkedPositionalList[newCap];
        for (Entry<K, V> entry : entrySet()) {
            int h = hashValue(entry.getKey(), newCap);
            if (newTable[h] == null) {
                newTable[h] = new LinkedPositionalList<>();
            }
            newTable[h].addLast(entry);
        }
        capacity = newCap;
        table = newTable;
    }

    private int hashValue(K key, int newCap) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % newCap);
    }

    public Iterable<Entry<K, V>> entrySet() {
        LinkedPositionalList<Entry<K, V>> list = new LinkedPositionalList<>();
        for (LinkedPositionalList<Entry<K, V>> storage : table) {
            if (storage != null) {
                for (Entry<K, V> entry : storage) {
                    list.addLast(entry);
                }
            }
        }
        return list;
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        n = 0;
        collisions = 0;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean containsValue(V value) {
        for (LinkedPositionalList<Entry<K, V>> storage : table) {
            if (storage != null) {
                for (Entry<K, V> entry : storage) {
                    if (entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Iterable<V> values() {
        LinkedPositionalList<V> valueList = new LinkedPositionalList<>();
        for (LinkedPositionalList<Entry<K, V>> storage : table) {
            if (storage != null) {
                for (Entry<K, V> entry : storage) {
                    valueList.addLast(entry.getValue());
                }
            }
        }
        return valueList;
    }

}

