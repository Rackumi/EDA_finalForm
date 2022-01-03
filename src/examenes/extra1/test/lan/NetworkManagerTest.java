package examenes.extra1.test.lan;

import java.util.Arrays;
import java.util.List;

import examenes.extra1.source.lan.NetworkManager;
import examenes.extra1.source.lan.Router;
import examenes.extra1.source.lan.Terminal;
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
public class NetworkManagerTest {
    
    public NetworkManagerTest() {
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

    @Test
    public void testGetRouters() {
        System.out.println("CreateNetwork");

        NetworkManager net = new NetworkManager();
        
        Router r1 = new Router("AB:01:CB:DA:AB:01:A0:01", "AB:01:CB:DA:AB:01:A1:01", "192.168.0.1", "8.8.8.1");
        Router r2 = new Router("AB:01:CB:DA:AB:01:A0:01", "AB:01:CB:DA:AB:01:A1:01", "192.168.0.1", "8.8.8.2");
        Router r3 = new Router("AB:01:CB:DA:AB:01:A0:01", "AB:01:CB:DA:AB:01:A1:01", "192.168.0.1", "8.8.8.3");
        Router r4 = new Router("AB:01:CB:DA:AB:01:A0:01", "AB:01:CB:DA:AB:01:A1:01", "192.168.0.1", "8.8.8.4");

        net.addRouter(r1, null, null);
        net.addRouter(r2, Arrays.asList(r1), Arrays.asList(10));
        net.addRouter(r3, Arrays.asList(r1,r2), Arrays.asList(18,10));
        net.addRouter(r4, Arrays.asList(r3), Arrays.asList(14));

        List <Router> l = net.getRouters(r1);
        
        assertEquals(2, l.size());
        boolean conection = ((r2 == l.get(0)) && (r3 == l.get(1))) ||
                ((r2 == l.get(1)) && (r3 == l.get(0)));

        assertTrue(conection);
    }

    @Test
    public void testGetRouter() {
        System.out.println("CreateNetwork");

        NetworkManager net = new NetworkManager();
        
        Router r1 = new Router("AB:01:CB:DA:AB:01:A0:01", "AB:01:CB:DA:AB:01:A1:01", "192.168.0.1", "8.8.8.1");
        Router r2 = new Router("AB:01:CB:DA:AB:01:A0:01", "AB:01:CB:DA:AB:01:A1:01", "192.168.0.1", "8.8.8.2");
        Router r3 = new Router("AB:01:CB:DA:AB:01:A0:01", "AB:01:CB:DA:AB:01:A1:01", "192.168.0.1", "8.8.8.3");
        Router r4 = new Router("AB:01:CB:DA:AB:01:A0:01", "AB:01:CB:DA:AB:01:A1:01", "192.168.0.1", "8.8.8.4");

        net.addRouter(r1, null, null);
        net.addRouter(r2, Arrays.asList(r1), Arrays.asList(10));
        net.addRouter(r3, Arrays.asList(r1,r2), Arrays.asList(18,10));
        net.addRouter(r4, Arrays.asList(r3), Arrays.asList(14));

        Terminal t1 = new Terminal("AB:01:CB:DA:AB:01:CB:01","192.168.0.2");
        Terminal t2 = new Terminal("AB:01:CB:DA:AB:01:CB:02","192.168.0.3");
        Terminal t3 = new Terminal("AB:01:CB:DA:AB:01:CB:03","192.168.0.4");
        Terminal t4 = new Terminal("AB:01:CB:DA:AB:01:CB:04","192.168.0.2");
        Terminal t5 = new Terminal("AB:01:CB:DA:AB:01:CB:05","192.168.0.2");
        Terminal t6 = new Terminal("AB:01:CB:DA:AB:01:CB:06","192.168.0.3");
        Terminal t7 = new Terminal("AB:01:CB:DA:AB:01:CB:07","192.168.0.2");
        Terminal t8 = new Terminal("AB:01:CB:DA:AB:01:CB:08","192.168.0.3");
        Terminal t9 = new Terminal("AB:01:CB:DA:AB:01:CB:09","192.168.0.4");
        
        net.addTerminal(t1, r1, 4);
        net.addTerminal(t2, r1, 7);
        net.addTerminal(t3, r1, 2);
        net.addTerminal(t4, r2, 2);
        net.addTerminal(t5, r3, 2);
        net.addTerminal(t6, r3, 3);
        net.addTerminal(t7, r4, 2);
        net.addTerminal(t8, r4, 9);
        net.addTerminal(t9, r4, 8);
        
        assertEquals(r1, net.getRouter(t1));
        assertEquals(r1, net.getRouter(t2));
        assertEquals(r1, net.getRouter(t3));
        assertEquals(r2, net.getRouter(t4));
    }


    /**
     * Test of findHops method, of class NetworkManager.
     */
    @Test
    public void testFindHops() {
        System.out.println("findHops");

        NetworkManager net = new NetworkManager();
        
        Router r1 = new Router("AB:01:CB:DA:AB:01:A0:01", "AB:01:CB:DA:AB:01:A1:01", "192.168.0.1", "8.8.8.1");
        Router r2 = new Router("AB:01:CB:DA:AB:01:A0:01", "AB:01:CB:DA:AB:01:A1:01", "192.168.0.1", "8.8.8.2");
        Router r3 = new Router("AB:01:CB:DA:AB:01:A0:01", "AB:01:CB:DA:AB:01:A1:01", "192.168.0.1", "8.8.8.3");
        Router r4 = new Router("AB:01:CB:DA:AB:01:A0:01", "AB:01:CB:DA:AB:01:A1:01", "192.168.0.1", "8.8.8.4");

        net.addRouter(r1, null, null);
        net.addRouter(r2, Arrays.asList(r1), Arrays.asList(10));
        net.addRouter(r3, Arrays.asList(r1,r2), Arrays.asList(18,10));
        net.addRouter(r4, Arrays.asList(r3), Arrays.asList(14));

        Terminal t1 = new Terminal("AB:01:CB:DA:AB:01:CB:01","192.168.0.2");
        Terminal t2 = new Terminal("AB:01:CB:DA:AB:01:CB:02","192.168.0.3");
        Terminal t3 = new Terminal("AB:01:CB:DA:AB:01:CB:03","192.168.0.4");
        Terminal t4 = new Terminal("AB:01:CB:DA:AB:01:CB:04","192.168.0.2");
        Terminal t5 = new Terminal("AB:01:CB:DA:AB:01:CB:05","192.168.0.2");
        Terminal t6 = new Terminal("AB:01:CB:DA:AB:01:CB:06","192.168.0.3");
        Terminal t7 = new Terminal("AB:01:CB:DA:AB:01:CB:07","192.168.0.2");
        Terminal t8 = new Terminal("AB:01:CB:DA:AB:01:CB:08","192.168.0.3");
        Terminal t9 = new Terminal("AB:01:CB:DA:AB:01:CB:09","192.168.0.4");
        
        net.addTerminal(t1, r1, 4);
        net.addTerminal(t2, r1, 7);
        net.addTerminal(t3, r1, 2);
        net.addTerminal(t4, r2, 2);
        net.addTerminal(t5, r3, 2);
        net.addTerminal(t6, r3, 3);
        net.addTerminal(t7, r4, 2);
        net.addTerminal(t8, r4, 9);
        net.addTerminal(t9, r4, 8);

        assertEquals(4, net.findHops(t1, t9));
        assertEquals(2, net.findHops(t1, t2));
        assertEquals(3, net.findHops(t1, t4));
    }

}