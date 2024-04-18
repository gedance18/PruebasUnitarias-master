package ex4;

public class HashEntry {
    Object key;
    String value;

    // Linked list of same hash entries.
    /*HashTable*/HashEntry next;
    /*HashTable*/HashEntry prev;

    public HashEntry(Object key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "[" + key + ", " + value + "]";
    }
}