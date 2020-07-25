
@SuppressWarnings("unused")
public class SimpleHashMap<K, V> {

    private MapEntry<K, V>[] entries;

    public SimpleHashMap() {
        this(1024);
    }

    public SimpleHashMap(int intitialSize) {
        entries = new MapEntry[intitialSize];
    }

    public V get(K key) {
        if (key == null)// as per javadoc in java.util.Map
            throw new IllegalArgumentException("null keys not allowed");

        MapEntry<K, V> entry = entries[getIndex(key)];

        while (entry != null && !key.equals(entry.getKey()))
            entry = entry.getNext();

        return entry != null ? entry.getValue() : null;

    }


    public void put(K key, V value) {

        if (key == null)// as per javadoc in java.util.Map
            throw new NullPointerException("null keys not allowed");

        int entryIdx = getIndex(key);
        MapEntry<K, V> entry = entries[entryIdx];

        if (entry != null) {
            boolean found = false;

            while (!found) {
                if (key.equals(entry.getKey())) {
                    entry.setValue(value);
                    found = true;
                } else if (entry.getNext() == null) {
                    entry.setNext(new MapEntry<K, V>(key, value));
                    found = true;
                }
                entry = entry.getNext();
            }
        } else {
            entries[entryIdx] = new MapEntry<K, V>(key, value);
        }
    }


    public void remove(K key) {
        if (key == null) throw new NullPointerException("null keys not allowed");

        int entryIdx = getIndex(key);
        MapEntry<K, V> entry = entries[entryIdx];
        if (entry != null) {
            MapEntry<K, V> prevEntry = null;
            boolean found = false;

            while (!found) {
                if (key.equals(entry.getKey())) {
                    if (prevEntry != null) {
                        prevEntry.setNext(entry.getNext());
                    } else {
                        entries[entryIdx] = null;
                    }
                    found = true;
                } else if (entry.getNext() == null) {
                    return;
                }
                prevEntry = entry;
                entry = entry.getNext();
            }
        }
    }

    private int getIndex(K key) {
        return key.hashCode() % entries.length;
    }

    private class MapEntry<K, V> {

        private final K key;

        private V value;

        private MapEntry<K, V> next;

        public MapEntry(K key, V value) { this.key = key; this.setValue(value); }

        public K getKey() {  return key; }

        public V getValue() {  return value; }

        public void setValue(V value) {  this.value = value;  }

        public void setNext(MapEntry<K, V> next) {  this.next = next; }

        public MapEntry<K, V> getNext() { return next; }

    }
}

 

 