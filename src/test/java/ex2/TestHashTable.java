package ex2;

import ex2.HashTable;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class TestHashTable {

    @org.junit.jupiter.api.Test
    void putOneElementInVoidTable1() {

        HashTable hashTable = new HashTable();

        hashTable.put("un","elemento");

        Assertions.assertEquals( "\n" +
                " bucket[9] = [un, elemento]",hashTable.toString());

        Assertions.assertEquals( 1,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());
    }

    @org.junit.jupiter.api.Test
    void putOneElementInNoVoidTable2() {
        HashTable hashTable = new HashTable();

        hashTable.put("1","elemento");
        hashTable.put("2","elemento2");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento]\n" +
                " bucket[2] = [2, elemento2]" , hashTable.toString());

        Assertions.assertEquals( 2,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());
    }

    @org.junit.jupiter.api.Test
    void putOneElementCollisionSecondInNoVoidTable3() {
        HashTable hashTable = new HashTable();

        hashTable.put("1","elemento");
        hashTable.put("2","elemento2");
        hashTable.put("13","elemento13");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento]\n" +
                " bucket[2] = [2, elemento2] -> [13, elemento13]", hashTable.toString());

        Assertions.assertEquals( 3,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());
    }

    @org.junit.jupiter.api.Test
    void putOneElementCollisionThirdInNoVoidTable4() {
        HashTable hashTable = new HashTable();

        hashTable.put("1","elemento");
        hashTable.put("2","elemento2");
        hashTable.put("13","elemento13");
        hashTable.put("24","elemento24");


        Assertions.assertEquals("\n" +
                " bucket[1] = [1, elemento]\n" +
                " bucket[2] = [2, elemento2] -> [13, elemento13] -> [24, elemento24]", hashTable.toString());

        Assertions.assertEquals( 4,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());
    }


    @org.junit.jupiter.api.Test
    void putOneElementUpdateInNoVoidTable5() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento");
        hashTable.put("2","elemento2");
        hashTable.put("2","updated");

        Assertions.assertEquals( "\n" +
                " bucket[1] = [1, elemento]\n" +
                " bucket[2] = [2, updated]", hashTable.toString());

        Assertions.assertEquals( 2,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());
    }

    @org.junit.jupiter.api.Test
    void putOneElementCollisionSecondUpdateInNoVoidTable6() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento");
        hashTable.put("2","elemento2");
        hashTable.put("13","elemento13");
        hashTable.put("13","updated13");

        Assertions.assertEquals( "\n" +
                " bucket[1] = [1, elemento]\n" +
                " bucket[2] = [2, elemento2] -> [13, updated13]", hashTable.toString());

        Assertions.assertEquals( 3,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());
    }

    @org.junit.jupiter.api.Test
    void putOneElementCollisionThirdUpdateInNoVoidTable7() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","elemento");
        hashTable.put("2","elemento2");
        hashTable.put("13","elemento13");
        hashTable.put("24","elemento24");
        hashTable.put("24","update");

        Assertions.assertEquals( "\n" +
                " bucket[1] = [1, elemento]\n" +
                " bucket[2] = [2, elemento2] -> [13, elemento13] -> [24, update]", hashTable.toString());

        Assertions.assertEquals( 4,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());
    }

    @org.junit.jupiter.api.Test
    void getOneElementCollisionFirst1InVoidTable() {
        HashTable hashTable = new HashTable();
        hashTable.put("clave","valor");
        Assertions.assertEquals("valor",hashTable.get("clave"));
    }

    @org.junit.jupiter.api.Test
    void getOneElementCollisionFirst2() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","valor");
        hashTable.put("12","colision");
        Assertions.assertEquals("valor",hashTable.get("1"));
    }

    @org.junit.jupiter.api.Test
    void getOneElementCollisionSecond3() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","valor");
        hashTable.put("12","segundoValor");
        hashTable.put("23","colision");
        Assertions.assertEquals("segundoValor",hashTable.get("12"));
    }

    @org.junit.jupiter.api.Test
    void getOneElementCollisionThird4() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","valor");
        hashTable.put("12","colision");
        hashTable.put("23","tercerValor");
        Assertions.assertEquals("tercerValor",hashTable.get("23"));
    }




    @org.junit.jupiter.api.Test
    void getOneElementWithoutExistence5() {
        HashTable hashTable = new HashTable();

        Assertions.assertEquals(null,hashTable.get("1"));
    }

    @org.junit.jupiter.api.Test
    void getOneElementCollisionWithoutExistence6() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","valor");
        Assertions.assertEquals(null,hashTable.get("12"));
    }

    @org.junit.jupiter.api.Test
    void getOneElementWith3CollisionsWithoutExistence7() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","colision1");
        hashTable.put("12","colision2");
        hashTable.put("23","colision3");
        Assertions.assertEquals(null,hashTable.get("34"));
    }




    @org.junit.jupiter.api.Test
    void dropOneElement1() {
        HashTable hashTable = new HashTable();
        hashTable.put("2","valor");
        hashTable.put("1","colision1");
        hashTable.put("12","colision2");
        hashTable.put("23","colision3");
        hashTable.drop("2");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, colision1] -> [12, colision2] -> [23, colision3]",hashTable.toString());

        Assertions.assertEquals( 3,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());

    }

    @org.junit.jupiter.api.Test
    void dropOneElementFirstCollision2() {
        HashTable hashTable = new HashTable();
        hashTable.put("2","valor");
        hashTable.put("1","colision1");
        hashTable.put("12","colision2");
        hashTable.put("23","colision3");
        hashTable.drop("1");

        Assertions.assertEquals("\n" +
                " bucket[1] = [12, colision2] -> [23, colision3]\n" +
                " bucket[2] = [2, valor]",hashTable.toString());

        Assertions.assertEquals( 3,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());

    }

    @org.junit.jupiter.api.Test
    void dropOneElementSecondCollision3() {
        HashTable hashTable = new HashTable();
        hashTable.put("2","valor");
        hashTable.put("1","colision1");
        hashTable.put("12","colision2");
        hashTable.put("23","colision3");
        hashTable.drop("12");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, colision1] -> [23, colision3]\n" +
                " bucket[2] = [2, valor]",hashTable.toString());

        Assertions.assertEquals( 3,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());

    }

    @org.junit.jupiter.api.Test
    void dropOneElementThirdCollision4() {
        HashTable hashTable = new HashTable();
        hashTable.put("2","valor");
        hashTable.put("1","colision1");
        hashTable.put("12","colision2");
        hashTable.put("23","colision3");
        hashTable.drop("23");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, colision1] -> [12, colision2]\n" +
                " bucket[2] = [2, valor]",hashTable.toString());

        Assertions.assertEquals( 3,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());
    }



    @org.junit.jupiter.api.Test
    void dropOneElementWithoutExistence5() {
        HashTable hashTable = new HashTable();
        hashTable.put("2","valor");
        hashTable.put("1","colision1");
        hashTable.put("12","colision2");
        hashTable.put("23","colision3");
        hashTable.drop("3");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, colision1] -> [12, colision2] -> [23, colision3]\n" +
                " bucket[2] = [2, valor]",hashTable.toString());

        Assertions.assertEquals( 4,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());
    }

    @org.junit.jupiter.api.Test
    void dropOneElementCollisionWithoutExistence6() {
        HashTable hashTable = new HashTable();
        hashTable.put("2","valor");
        hashTable.put("1","colision1");
        hashTable.put("12","colision2");
        hashTable.put("23","colision3");
        hashTable.drop("13");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, colision1] -> [12, colision2] -> [23, colision3]\n" +
                " bucket[2] = [2, valor]",hashTable.toString());

        Assertions.assertEquals( 4,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());
    }

    @org.junit.jupiter.api.Test
    void dropOneElementWith3CollisionsWithoutExistence7() {
        HashTable hashTable = new HashTable();
        hashTable.put("2","valor");
        hashTable.put("1","colision1");
        hashTable.put("12","colision2");
        hashTable.put("23","colision3");
        hashTable.drop("34");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, colision1] -> [12, colision2] -> [23, colision3]\n" +
                " bucket[2] = [2, valor]",hashTable.toString());

        Assertions.assertEquals( 4,hashTable.count());
        Assertions.assertEquals( 16,hashTable.size());
    }

}