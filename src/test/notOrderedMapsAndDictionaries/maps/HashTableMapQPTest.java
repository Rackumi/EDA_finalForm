package test.notOrderedMapsAndDictionaries.maps;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;
import structures.notOrderedMapsAndDictionaries.Entry;
import structures.notOrderedMapsAndDictionaries.maps.HashTableMapQP;

import static org.junit.Assert.*;

/**
 * Test for class HashTableMapQP
 *
 * @author Rackumi
 */
public class HashTableMapQPTest {

    private HashTableMapQP<String,Integer> instance;
    public HashTableMapQPTest() {
    }

   /**
     * Test of size method, of class HashTableMapSC.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        instance = new HashTableMapQP<>();
        assertEquals(instance.size(),0);
        
        instance.put("Jose", 912127659);
        instance.put("Angel", 912127658);
        instance.put("Abraham", 912127657);
        instance.put("Mayte", 912127656);
        instance.put("Raul", 912127655);
        assertEquals(instance.size(),5);
        
        instance.remove("Angel");
        assertEquals(instance.size(),4);
    }

    /**
     * Test of isEmpty method, of class HashTableMapSC.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        instance = new HashTableMapQP<>();
        assertTrue(instance.isEmpty());
        instance.put("Jose", 912127654);
        assertFalse(instance.isEmpty());
        instance.remove("Jose");
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of get method, of class HashTableMapSC.
     */
    @Test
    public void testPutAndGet() {
        instance = new HashTableMapQP<>();

        try {
            instance.get(null);
            fail("Deberia lanzar: InvalidKeyException");

        } catch (RuntimeException e) {
            // OK
        }

        try {
            instance.put(null, 1213123);
            fail("Deberia lanzar: InvalidKeyException");

        } catch (RuntimeException e) {
            // OK
        }

        assertEquals(instance.get("Jose"), null);

        instance.put("Jose", 912127654);
        instance.put("Mayte", 912127651);
        instance.put("Andres", 912127624);
        assertEquals(instance.size(), 3);
        assertEquals(instance.get("Jose").intValue(), 912127654);
        assertEquals(instance.get("Andres").intValue(), 912127624);
        instance.put("Jose", 5);
        assertEquals(instance.get("Jose").intValue(), 5);
    }

    /**
     * Test of remove method, of class HashTableMapSC.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        instance = new HashTableMapQP<>();
        instance.put("Jose", 912127651);
        instance.put("Andres", 912127624);
        instance.remove("Andres");
        assertEquals(instance.size(), 1);
        assertEquals(instance.get("Jose").intValue(), 912127651);
        assertEquals(instance.get("Andres"), null);

        try {
            instance.remove(null);
            fail("Deberia lanzar: InvalidKeyException");

        } catch (RuntimeException e) {
            // OK
        }
    }

    /**
     * Test of keys method, of class HashTableMapSC.
     */
    @Test
    public void testKeys() {
        System.out.println("keys");
        instance = new HashTableMapQP<>();
        instance.put("Angel", 912127654);
        instance.put("Jose", 912127651);
        instance.put("Andres", 912127624);
        Iterable<String> keys = instance.keys();

        ArrayList<String> l = new ArrayList<>();

        for (String k : keys) {
            l.add(k);
        }

        assertEquals(l.size(), 3);

        Iterator<Entry<String, Integer>> it = instance.iterator();

        while (it.hasNext()) {
            String s = it.next().getKey();
            assertEquals(l.contains(s), true);
        }
    }

    /**
     * Test of values method, of class HashTableMapSC.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        instance = new HashTableMapQP<>();
        instance.put("Angel", 912127654);
        instance.put("Jose", 912127651);
        instance.put("Andres", 912127624);
        Iterable<Integer> values = instance.values();
        Iterator<Integer> it = values.iterator();

        ArrayList<Integer> l = new ArrayList<>();

        while (it.hasNext()) {
            l.add(it.next());
        }

        assertEquals(l.size(), 3);
        assertEquals(l.contains((912127654)), true);
        assertEquals(l.contains((912127651)), true);
        assertEquals(l.contains((912127624)), true);
    }

    /**
     * Test of entries method, of class HashTableMapSC.
     */
    @Test
    public void testEntries() {
        System.out.println("entries");
        instance = new HashTableMapQP<>();
        instance.put("Angel", 912127654);
        instance.put("Jose", 912127651);
        instance.put("Andres", 912127624);
        Iterable<Entry<String, Integer>> entries = instance.entries();
        ArrayList<Entry<String, Integer>> l = new ArrayList<>();

        for (Entry<String, Integer> i : entries) {
            l.add(i);
        }

        assertEquals(l.size(), 3);

        Iterator<Entry<String, Integer>> it = instance.iterator();

        while (it.hasNext()) {
            Entry<String, Integer> e = it.next();
            assertEquals(l.contains(e), true);
        }
    }

    /**
     * Test of rehash method, of class HashTableMapSC.
     */
    @Test
    @SuppressWarnings("deprecation")
    public void testRehash() {
        System.out.println("rehash");
        HashTableMapQP<Integer,Integer> listin1 = new HashTableMapQP<>(10);
        final int NUM_ENTRIES = 1000;

        // Testing size
        for (int cont = 0; cont < NUM_ENTRIES; cont++) {
            listin1.put(cont, cont);
        }
        assertEquals(listin1.size(), NUM_ENTRIES);
        assertTrue(listin1.get(125).equals(125));
        
    }
     
}