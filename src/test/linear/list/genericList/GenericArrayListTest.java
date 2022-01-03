package test.linear.list.genericList;

import org.junit.Test;
import structures.linear.list.genericList.GenericArrayList;

import static org.junit.Assert.*;

/**
 * Test class for GenericArrayList
 *
 * @author Rackumi
 */
public class GenericArrayListTest<E> {
    
    public GenericArrayListTest() {
    }

    public GenericArrayList inicializa(){
       
        GenericArrayList<Integer> instance = new GenericArrayList<>();
        
        instance.add(new Integer(3));
        instance.add(new Integer(8));
        instance.add(new Integer(12));
        
        return instance; //[12, 8, 3]
    }
    /**
     * Test of size method, of class IntegerArrayList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        GenericArrayList<Integer> instance = inicializa();
              
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isempty method, of class IntegerArrayList.
     */
    @Test
    public void testIsempty1() {
        System.out.println("isempty");
        GenericArrayList<Integer> instance = inicializa();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isempty method, of class IntegerArrayList.
     */
    @Test
    public void testIsempty2() {
        System.out.println("isempty");
        GenericArrayList<Integer> instance = new GenericArrayList<>();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
       
    }
    
    /**
     * Test of add method, of class IntegerArrayList.
     */
    @Test
    public void testAdd_Integer() {
        System.out.println("add");
        Integer value = null;
        GenericArrayList<Integer> instance = new GenericArrayList<>();
        assertTrue(instance.isEmpty());
        instance.add(new Integer(2));
        assertFalse(instance.isEmpty());
        assertEquals(instance.size(),1);
    }

    /**
     * Test of add and remove methods, of class IntegerArrayList.
     */
    @Test
    public void testAdd_int_Remove() {
        System.out.println("add");
        int index = 2;
        Integer value = new Integer(5);
        GenericArrayList<Integer> instance = inicializa(); // [12, 8, 3]
        instance.add(index, value); // [12, 8, 5, 3]
        assertEquals(instance.size(),4);
        Integer remove = instance.remove();
        assertEquals(12.0,remove,0.01);
        remove = instance.remove();
        assertEquals(8.0,remove,0.01);
        remove = instance.remove();
        assertEquals(5.0,remove,0.01);
        remove = instance.remove();
        assertEquals(3.0,remove,0.01);
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of remove method, of class IntegerArrayList.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int index = 2;
        GenericArrayList<Integer> instance = inicializa(); // [12, 8, 3]
        Integer result = instance.remove(index);// 8
        assertEquals(8.0, result,0.01);
       
    }

    /**
     * Test of get method, of class IntegerArrayList.
     */
    @Test
    public void testGet_0args() {
        System.out.println("get");
        GenericArrayList<Integer> instance = inicializa(); // [12, 8, 3]
        Integer result = instance.get();//12
        assertEquals(12.0, result,0.01);
        
    }

    /**
     * Test of get method, of class IntegerArrayList.
     */
    @Test
    public void testGet_int() {
        System.out.println("get");
        int index = 2;
        GenericArrayList<Integer> instance = inicializa(); // [12, 8, 3]
        Integer result = instance.get(index);// 8
        assertEquals(8.0, result,0.01);
       
    }

    /**
     * Test of search method, of class IntegerArrayList.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        Integer value = new Integer(5);
        GenericArrayList<Integer> instance = inicializa();// [12, 8, 3]
        int expResult = 0;
        int result = instance.search(value);
        assertEquals(expResult, result);
        value = new Integer(3);
        expResult = 3;
        result = instance.search(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class IntegerArrayList.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Integer value = new Integer(5);
        GenericArrayList<Integer> instance = inicializa();// [12, 8, 3]
        boolean result = instance.contains(value);
        assertFalse(result);
        value = new Integer(12);
        result = instance.contains(value);
        assertTrue(result);
    }
    
}