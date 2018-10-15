public class HashTableLinerProbing<K, V> {

    public class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Entry[] hashTable;
    private int capacity;

    public HashTableLinerProbing(int capacity) {
        this.capacity = capacity;
        this.hashTable = new Entry[capacity];
    }

    public void put(K key, V value) {
        int hashedKey = hashKey(key);

        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashTable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashTable.length;
            }
        }

        if (occupied(hashedKey)) {
            System.out.println("Sorry, there is already entry at position" + hashedKey);
        } else {
            hashTable[hashedKey] = new Entry(key, value);
        }
    }

    public V get(K key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return (V) hashTable[hashedKey].value;
    }

    private int findKey(K key) {
        int hashedKey = hashKey(key);
        if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        int stopIndex = hashedKey;
        if (hashedKey == hashTable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex &&
                hashTable[hashedKey] != null &&
                !hashTable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashTable.length;
        }

        if (hashTable[hashedKey] != null &&
                !hashTable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            if (hashTable[i] == null) {
                System.out.println("Empty");
            } else {
                System.out.println(hashTable[i]);
            }
        }
    }

    public Entry remove(K key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        Entry entry = hashTable[hashedKey];
        hashTable[hashedKey] = null;

        Entry[] oldHashTable = hashTable;
        hashTable = new Entry[oldHashTable.length];
        for (int i = 0; i < oldHashTable.length; i++) {
            if (oldHashTable[i] != null) {
                put((K) oldHashTable[i].key, (V) oldHashTable[i].value);
            }
        }
        return entry;
    }

    private boolean occupied(int hashedKey) {
        return hashTable[hashedKey] != null;
    }

    private int hashKey(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public static void main(String[] args) {
        HashTableLinerProbing hashTable = new HashTableLinerProbing(10);
        hashTable.put(1, 2);
        hashTable.put(1, 3);
        hashTable.put(1, 4);
        hashTable.put(2, 3);
        System.out.println(hashTable.get(1));
        hashTable.printTable();
        System.out.println();
        System.out.println("Removed item: " + hashTable.remove(1));
        System.out.println();
        hashTable.printTable();
    }
}
