package examenes.extra8.modificaciones;

import org.junit.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Rackumi
 */
public class SmartPalaceMapTest {
    
    public SmartPalaceMapTest() {
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
     * Test of insertRoom method, of class SmartPalaceMap.
     */
    @Test
    public void testgGetPath() {
        System.out.println("insertRoom");

        Room a = new Room("A");
        Room b = new Room("B");
        Room c = new Room("C");
        Room d = new Room("D");
        Room e = new Room("E");
        Room f = new Room("F");
        Room g = new Room("G");

        List<Room> l = new LinkedList<>();
        l.add(a);
        l.add(b);
        l.add(c);
        l.add(d);
        l.add(e);
        l.add(f);
        l.add(g);
        SmartPalaceMap instance = new SmartPalaceMap(l);
        l.clear();

        l.add(c);
        l.add(e);
        instance.insertRoom(a, l);
        l.clear();

        l.add(c);
        instance.insertRoom(b, l);
        l.clear();

        l.add(a);
        l.add(b);
        l.add(d);
        instance.insertRoom(c, l);
        l.clear();

        l.add(c);
        l.add(e);
        l.add(f);
        instance.insertRoom(d, l);
        l.clear();

        l.add(a);
        l.add(d);
        l.add(f);
        instance.insertRoom(e, l);
        l.clear();

        l.add(d);
        l.add(e);
        instance.insertRoom(f, l);
        l.clear();

        instance.insertRoom(g, l);
        l.clear();

        //test 1 A to F -> [A,E,F]
        l.add(a);
        l.add(e);
        l.add(f);
        List<Room> result1 = instance.getPath(a, f);
        assertEquals(l, result1);
        l.clear();

        //test 2 A to C -> [A,C]
        l.add(a);
        l.add(c);
        List<Room> result2 = instance.getPath(a, c);
        assertEquals(l, result2);
        l.clear();

        //test 3 A to B -> [A,C,B]
        l.add(a);
        l.add(c);
        l.add(b);
        List<Room> result3 = instance.getPath(a, b);
        assertEquals(l, result3);
        l.clear();

        //test 4 D to A -> [D,C,A] || [D,E,A]
        l.add(d);
        l.add(c);
        l.add(a);
        List<Room> result4 = instance.getPath(d, a);
        assertEquals(l, result4);
        l.clear();

        //test 4 G to A -> null
        List<Room> result5 = instance.getPath(g, a);
        assertNull(result5);
    }

}