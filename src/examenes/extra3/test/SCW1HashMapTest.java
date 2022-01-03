package examenes.extra3.test;

import examenes.extra3.source.SCW1HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rackumi
 */
public class SCW1HashMapTest {
    
    public SCW1HashMapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of size method, of class SCW1HashTable.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        SCW1HashMap<String,Integer> instance = new SCW1HashMap <>();
        assertEquals(0, instance.size());
        instance.put("Jose", 1);
        assertEquals(1, instance.size());
        instance.put("Andres", 2);
        assertEquals(2, instance.size());
    }

    /**
     * Test of put method, of class SCW1HashTable.
     */
    @Test
    public void testPutGet() {
        System.out.println("put");
        SCW1HashMap <String,Integer> instance = new SCW1HashMap <>();
        assertEquals(0, instance.size());
        instance.put("Jose", 1);
        instance.put("Andres", 2);

        assertEquals(1, instance.get("Jose").intValue());
        assertEquals(2, instance.get("Andres").intValue());

    }

    /**
     * Test of remove method, of class SCW1HashTable.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        SCW1HashMap <String,Integer> instance = new SCW1HashMap <>();
        assertEquals(0, instance.size());
        instance.put("Jose", 1);
        instance.put("Andres", 2);

        assertEquals(1, instance.get("Jose").intValue());
        assertEquals(2, instance.get("Andres").intValue());

        instance.remove("Jose");
        
        try {
            instance.get("Jose");
            fail("No debería de estar");
        } catch (Exception e) {
            assertTrue(true);
        }
        assertEquals(1, instance.size());
    }

}