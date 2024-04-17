package ex3;

public class HashEntry {
    String key;
    String value;

    HashEntry next;
    HashEntry prev;

    public HashEntry(String key, String value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "HashEntry{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
