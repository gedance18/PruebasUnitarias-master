package ex4;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        //Hacemos put de keys y values
        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            hashTable.put(key, key);
        }

        //Imprimimos la estructura de la HashTable
        HashTable.log("****   HashTable  ***");
        HashTable.log(hashTable.toString());
        HashTable.log("\nValue for key(20) : " + hashTable.get("20") );
    }
}
