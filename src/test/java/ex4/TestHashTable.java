package ex4;

import ex2.HashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestHashTable {
    @Test
    void prueba1() {
        String key = "1";
        String value = "p1";
        HashTable ht = new HashTable();
        ht.put(key, value);
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, p1]", ht.toString());
        Assertions.assertEquals(ht.count(), 1);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba2() {
        String key = "1";
        String value = "p1";
        String key2 = "2";
        String value2 = "p2";
        HashTable ht = new HashTable();
        ht.put(key, value);
        ht.put(key2, value2);
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, p1]" + "\n" + " bucket[2] = [2, p2]", ht.toString());
        Assertions.assertEquals(ht.count(), 2);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba3() {
        String key = "1";
        String value = "p1";
        String key2 = "2";
        String value2 = "p2";
        HashTable ht = new HashTable();
        ht.put(key, value);
        ht.put(key2, value2);

        String key13 = "13";
        String value13 = "p13";
        ht.put(key13, value13);
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, p1]" + "\n" + " bucket[2] = [2, p2] -> [13, p13]", ht.toString());
        Assertions.assertEquals(ht.count(), 2);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba4() {
        String key = "1";
        String value = "p1";
        String key2 = "2";
        String value2 = "p2";
        HashTable ht = new HashTable();
        ht.put(key, value);
        ht.put(key2, value2);

        String key11 = "13";
        String value11 = "p13";
        ht.put(key11, value11);

        ht.put("24", "p24");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, p1]" + "\n" + " bucket[2] = [2, p2] -> [13, p13] -> [24, p24]", ht.toString());
        Assertions.assertEquals(ht.count(), 3);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba5() {
        //Tabla llena de elementos, prueba para hacer un update al value del bucket[1] cambiando el value por "p1.1"
        //Da error ya que en el codigo no hay nada hecho para que cuando intentes hacer un put en un elemento que ya tiene value
        String key = "1";
        String value = "p1";
        String keyupdate1 = "1";
        String valueupdate1 = "p1.1";

        HashTable ht = new HashTable();
        ht.put(key, value);
        ht.put(keyupdate1, valueupdate1);

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, p1.1]", ht.toString());
        Assertions.assertEquals(ht.count(), 1);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba6() {
        //Lo mismo que le prueba 5 pero en la 1r posicion
        String key = "1";
        String value = "p1";
        String keycolision01 = "12";
        String valuecolision01 = "p12";
        String keyupdate01 = "12";
        String valueupdate01 = "p12.1";

        HashTable ht = new HashTable();
        ht.put(key, value);
        ht.put(keycolision01, valuecolision01);
        ht.put(keyupdate01, valueupdate01);

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, p1] -> [12, p12.1]", ht.toString());
        Assertions.assertEquals(ht.count(), 2);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba7() {
        //Lo mismo que le prueba 5 pero en la 2n posicion
        String key = "1";
        String value = "p1";
        String keycolision01 = "12";
        String valuecolision01 = "p12";
        String keycolision02 = "23";
        String valuecolision02 = "p23";
        String keyupdate02 = "23";
        String valueupdate02 = "p23.1";

        HashTable ht = new HashTable();
        ht.put(key, value);
        ht.put(keycolision01, valuecolision01);
        ht.put(keycolision02, valuecolision02);
        ht.put(keyupdate02, valueupdate02);

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, p1] -> [12, p12] -> [23, p23.1]", ht.toString());
        Assertions.assertEquals(ht.count(), 2);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba8() {
        //Lo mismo que la prueba 5 pero en la 3r posicion
        String key = "1";
        String value = "p1";
        String keycolision01 = "12";
        String valuecolision01 = "p12";
        String keycolision02 = "23";
        String valuecolision02 = "p23";
        String keycolision03 = "34";
        String valuecolision03 = "p34";
        String keyupdate03 = "34";
        String valueupdate03 = "p34.1";

        HashTable ht = new HashTable();
        ht.put(key, value);
        ht.put(keycolision01, valuecolision01);
        ht.put(keycolision02, valuecolision02);
        ht.put(keycolision03, valuecolision03);
        ht.put(keyupdate03, valueupdate03);

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, p1] -> [12, p12] -> [23, p23] -> [34, p34.1]", ht.toString());
        Assertions.assertEquals(ht.count(), 3);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba9(){
        //Utilizamos el get para que nos devuelva el valor de la key "1"
        HashTable ht = new HashTable();
        ht.put("1", "p1");

        Assertions.assertEquals(ht.get("1"), "p1");
        Assertions.assertEquals(ht.count(), 1);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba10(){
        //Utilizamos 2 puts para que el segundo colisione y obtenemos la primera posición
        HashTable ht = new HashTable();
        ht.put("1", "p1");
        ht.put("01", "p2");

        Assertions.assertEquals(ht.get("1"), "p1");
        Assertions.assertEquals(ht.count(), 2);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba11(){
        //Utilizamos 2 puts para que el segundo colisione y obtenemos la segunda posición
        HashTable ht = new HashTable();
        ht.put("1", "p1");
        ht.put("01", "p01");

        Assertions.assertEquals(ht.get("01"), "p01");
        Assertions.assertEquals(ht.count(), 2);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba12(){
        //Utilizamos 3 puts para que el segundo y el tercero colisionen y obtenemos la tercera posición
        HashTable ht = new HashTable();
        ht.put("2", "p2");
        ht.put("02", "p02");
        ht.put("13", "p13");

        Assertions.assertEquals(ht.get("13"), "p13");
        Assertions.assertEquals(ht.count(), 3);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba13(){
        //Obtenemos una key de un elemento que no existe, el valor debe ser null
        HashTable ht = new HashTable();
        Assertions.assertEquals(ht.get("1"), null);
        Assertions.assertEquals(ht.count(), 0);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba14(){
        //Utilizamos un put y obtenemos una key de un elemento que no existe, pero puede colisionar con la segunda posición
        HashTable ht = new HashTable();
        ht.put("2", "p2");
        Assertions.assertEquals(ht.get("13"), null);
        Assertions.assertEquals(ht.count(), 1);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba15(){
        HashTable ht = new HashTable();
        ht.put("3", "p3");
        ht.put("03", "p03");
        ht.put("14", "p14");
        Assertions.assertEquals(ht.get("25"), null);
        Assertions.assertEquals(ht.count(), 3);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba16(){
        HashTable ht = new HashTable();
        ht.put("3", "p3");
        ht.put("4", "p4");
        ht.put("04", "p04");
        ht.put("15", "p15");
        //Comprobamos que la tabla este creada en el orden correcto
        Assertions.assertEquals(ht.toString(), " bucket[3] = [3, p3]" + " bucket[4] = [4, p4] ->" +
                " [04, p04] -> [15, p15]");
        //Eliminamos el primer elemento que no colisiona
        ht.drop("3");
        //Miramos si en la tabla ya no se muestra el bucket 3
        Assertions.assertEquals(ht.toString(), " bucket[4] = [4, p4] -> [04, p04] -> [15, p15]");
        Assertions.assertEquals(ht.count(), 3);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba17(){
        HashTable ht = new HashTable();
        ht.put("3", "p3");
        ht.put("4", "p4");
        ht.put("04", "p04");
        ht.put("15", "p15");
        //Comprobamos que la tabla este creada en el orden correcto
        Assertions.assertEquals(ht.toString(), " bucket[3] = [3, p3]" + " bucket[4] = [4, p4] ->" +
                " [04, p04] -> [15, p15]");
        ht.drop("4");

        Assertions.assertEquals(ht.toString(), " bucket[3] = [3, p3]" + " bucket[4] =" +
                " [04, p04] -> [15, p15]");
        //Con el codigo antiguo habia un bug que si borras la posicion 4, se borra el bucket entero, ahora ya esta arreglado
        Assertions.assertEquals(ht.count(), 3);
        Assertions.assertEquals(ht.count(), 16);
    }


    @Test
    void prueba18(){
        //Lo mismo que la prueba anterior pero la segunda posicion del bucket
        HashTable ht = new HashTable();
        ht.put("3", "p3");
        ht.put("4", "p4");
        ht.put("04", "p04");
        ht.put("15", "p15");
        //Comprobamos que la tabla este creada en el orden correcto
        Assertions.assertEquals(ht.toString(), " bucket[3] = [3, p3]" + " bucket[4] = [4, p4] ->" +
                " [04, p04] -> [15, p15]");
        ht.drop("04");

        Assertions.assertEquals(ht.toString(), " bucket[3] = [3, p3]" + " bucket[4] = [4, p4] -> " +
                "[15, p15]");
        Assertions.assertEquals(ht.count(), 3);
        Assertions.assertEquals(ht.count(), 16);
        //Con el codigo antiguo habia un bug que si borras la posicion 4, se borra el bucket entero, ahora ya esta arreglado
    }

    @Test
    void prueba19(){
        //Lo mismo que la prueba anterior pero la tercera posicion del bucket
        HashTable ht = new HashTable();
        ht.put("3", "p3");
        ht.put("4", "p4");
        ht.put("04", "p04");
        ht.put("15", "p15");
        //Comprobamos que la tabla este creada en el orden correcto
        Assertions.assertEquals(ht.toString(), " bucket[3] = [3, p3]" + " bucket[4] = [4, p4] ->" +
                " [04, p04] -> [15, p15]");
        ht.drop("04");

        Assertions.assertEquals(ht.toString(), " bucket[3] = [3, p3]" + " bucket[4] = [4, p4] -> " +
                "[15, p15]");
        Assertions.assertEquals(ht.count(), 3);
        Assertions.assertEquals(ht.count(), 16);
        //Con el codigo antiguo habia un bug que si borras la posicion 4, se borra el bucket entero, ahora ya esta arreglado
    }

    @Test
    void prueba20(){
        HashTable ht = new HashTable();
        ht.put("3", "p3");
        ht.put("4", "p4");
        ht.put("04", "p04");
        ht.put("15", "p15");
        ht.drop("5");
        //Comprobamos que la tabla este creada en el orden correcto
        Assertions.assertEquals(ht.toString(), " bucket[3] = [3, p3]" + " bucket[4] = [4, p4] ->" +
                " [04, p04] -> [15, p15]");
        Assertions.assertEquals(ht.count(), 4);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba21(){
        HashTable ht = new HashTable();
        ht.put("3", "p3");
        ht.put("4", "p4");
        ht.put("04", "p04");
        ht.put("15", "p15");
        ht.drop("03");
        //Comprobamos que la tabla este creada en el orden correcto
        Assertions.assertEquals(ht.toString(), " bucket[3] = [3, p3]" + " bucket[4] = [4, p4] ->" +
                " [04, p04] -> [15, p15]");
        Assertions.assertEquals(ht.count(), 4);
        Assertions.assertEquals(ht.count(), 16);
    }

    @Test
    void prueba22(){
        HashTable ht = new HashTable();
        ht.put("3", "p3");
        ht.put("4", "p4");
        ht.put("04", "p04");
        ht.put("15", "p15");
        ht.drop("26");
        //Comprobamos que la tabla este creada en el orden correcto
        Assertions.assertEquals(ht.toString(), " bucket[3] = [3, p3]" + " bucket[4] = [4, p4] ->" +
                " [04, p04] -> [15, p15]");
        Assertions.assertEquals(ht.count(), 4);
        Assertions.assertEquals(ht.count(), 16);
    }
}