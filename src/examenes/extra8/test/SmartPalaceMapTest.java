package examenes.extra8.test;

import java.util.ArrayList;
import java.util.List;

import examenes.extra8.Room;
import examenes.extra8.SmartPalaceMap;
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
        List<Room> conectedRooms = new ArrayList<>();
        SmartPalaceMap instance = new SmartPalaceMap();
        Room a = instance.insertRoom(null);
        
        conectedRooms.add(a);
        Room b = instance.insertRoom(conectedRooms);

        conectedRooms.clear();
        conectedRooms.add(a);
        conectedRooms.add(b);        
        Room c = instance.insertRoom(conectedRooms);
        
        conectedRooms.clear();
        conectedRooms.add(c);
        Room d = instance.insertRoom(conectedRooms);

        conectedRooms.clear();
        conectedRooms.add(d);
        conectedRooms.add(a);
        Room e = instance.insertRoom(conectedRooms);

        conectedRooms.clear();
        conectedRooms.add(d);
        conectedRooms.add(e);
        Room f = instance.insertRoom(conectedRooms);

        Room g = instance.insertRoom(null);

        List<Room> result = instance.getPath(a, f);
        
        conectedRooms.clear();
        conectedRooms.add(a);
        conectedRooms.add(e);
        conectedRooms.add(f);
        
        assertEquals(conectedRooms, result);
    }

}