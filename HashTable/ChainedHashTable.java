import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable<K, V> {

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

    private LinkedList<Entry>[] hashTable;

    public ChainedHashTable() {
        this.hashTable = new LinkedList[10];

        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<Entry>();
        }
    }

    public void put(K key, V value) {
        int hashedKey = hashKey(key);
        hashTable[hashedKey].add(new Entry(key, value));
    }

    public V get(K key) {
        int hashedKey = hashKey(key);

        ListIterator<Entry> itr = hashTable[hashedKey].listIterator();
        Entry entry = null;
        while (itr.hasNext()) {
            entry = itr.next();
            if (entry.key.equals(key)) {
                return (V) entry.value;
            }
        }
        return null;
    }

    public Entry remove(K key) {
        int hashedKey = hashKey(key);

        ListIterator<Entry> itr = hashTable[hashedKey].listIterator();
        Entry entry = null;
        int index = -1;
        while (itr.hasNext()) {
            entry = itr.next();
            if (entry.key.equals(key)) {
                index++;
                break;
            }
        }

        if (entry == null || !entry.key.equals(key)) {
            return null;
        } else {
            hashTable[hashedKey].remove(index);
            return entry;
        }
    }

    public void printTable() {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i].isEmpty()) {
                System.out.println("Position " + i + " empty");
            } else {
                ListIterator itr = hashTable[i].listIterator();
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
            }
        }
    }

    public int hashKey(K key) {
        return Math.abs(key.hashCode()) % hashTable.length;
    }

    public static void main(String[] args) {
        ChainedHashTable hashTable = new ChainedHashTable();
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
