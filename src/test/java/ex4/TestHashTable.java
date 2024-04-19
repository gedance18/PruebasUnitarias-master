package ex4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestHashTable {

    @Test
    void put() {
        HashTable hashTable = new HashTable();

        hashTable.put("un",false);
        hashTable.put("2",1);
        hashTable.put("3",2f);
        hashTable.put("4",'A');
        Assertions.assertEquals( "\n" +
                " bucket[2] = [2, 1]\n" +
                " bucket[3] = [3, 2.0]\n" +
                " bucket[4] = [4, A]\n" +
                " bucket[9] = [un, false]",hashTable.toString());
    }

    @Test
    void drop() {
        HashTable hashTable = new HashTable();

        hashTable.put("un",false);
        hashTable.put("2",1);
        hashTable.put("3",2f);
        hashTable.put("4",'A');
        hashTable.drop("2");
        Assertions.assertEquals("\n" +
                " bucket[3] = [3, 2.0]\n" +
                " bucket[4] = [4, A]\n" +
                " bucket[9] = [un, false]",hashTable.toString());
    }

    @Test
    void count() {
    }

    @Test
    void size() {
    }

    @Test
    void get() {
    }
}