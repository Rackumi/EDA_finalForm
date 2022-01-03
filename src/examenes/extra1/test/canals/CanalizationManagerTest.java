/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenes.extra1.test.canals;

import java.util.Arrays;
import java.util.List;

import examenes.extra1.source.canals.CanalizationManager;
import examenes.extra1.source.canals.Central;
import examenes.extra1.source.canals.House;
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
public class CanalizationManagerTest {
    
    public CanalizationManagerTest() {
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
    public void testGetCentrals() {
        System.out.println("CreateNetwork");

        CanalizationManager net = new CanalizationManager();
        
        Central c1 = new Central("Lozoya");
        Central c2 = new Central("Pinilla");
        Central c3 = new Central("Lanjaron");
        Central c4 = new Central("Plaza Castilla");

        net.addCentral(c1, null, null);
        net.addCentral(c2, Arrays.asList(c1), Arrays.asList(15));
        net.addCentral(c3, Arrays.asList(c1,c2), Arrays.asList(10,20));
        net.addCentral(c4, Arrays.asList(c2), Arrays.asList(12));

        List <Central> l = net.getCentrals(c1);
        
        assertEquals(2, l.size());
        boolean conection = ((c2 == l.get(0)) && (c3 == l.get(1))) ||
                ((c2 == l.get(1)) && (c3 == l.get(0)));

        assertTrue(conection);
    }

    @Test
    public void testGetCentral() {
        System.out.println("CreateNetwork");

        CanalizationManager net = new CanalizationManager();
        
        Central c1 = new Central("Lozoya");
        Central c2 = new Central("Pinilla");
        Central c3 = new Central("Lanjaron");
        Central c4 = new Central("Plaza Castilla");

        net.addCentral(c1, null, null);
        net.addCentral(c2, Arrays.asList(c1), Arrays.asList(15));
        net.addCentral(c3, Arrays.asList(c1,c2), Arrays.asList(10,20));
        net.addCentral(c4, Arrays.asList(c2), Arrays.asList(12));

        House h1 = new House("Leganitos",12);
        House h2 = new House("Recoletos",22);
        House h3 = new House("Alcala",21);
        House h4 = new House("Gran vía",21);
        House h5 = new House("Atocha",5);
        House h6 = new House("Preciados",13);
        House h7 = new House("Fuecarral",5);
        House h8 = new House("Serrano",2);
        House h9 = new House("Paseo del Prado",3);
        
        net.addHouse(h1, c1, 2);
        net.addHouse(h2, c1, 2);
        net.addHouse(h3, c1, 3);
        net.addHouse(h4, c2, 5);
        net.addHouse(h5, c2, 3);
        net.addHouse(h6, c2, 2);
        net.addHouse(h7, c3, 1);
        net.addHouse(h8, c4, 3);
        net.addHouse(h9, c4, 4);

        assertEquals(c1, net.getCentral(h1));
        assertEquals(c1, net.getCentral(h2));
        assertEquals(c1, net.getCentral(h3));
        assertEquals(c2, net.getCentral(h4));
    }

    /**
     * Test of findHops method, of class CanalizationManager.
     */
    @Test
    public void testFindHops() {
        System.out.println("findHops");

        CanalizationManager net = new CanalizationManager();
        
        Central c1 = new Central("Lozoya");
        Central c2 = new Central("Pinilla");
        Central c3 = new Central("Lanjaron");
        Central c4 = new Central("Plaza Castilla");

        net.addCentral(c1, null, null);
        net.addCentral(c2, Arrays.asList(c1), Arrays.asList(10));
        net.addCentral(c3, Arrays.asList(c1,c2), Arrays.asList(18,10));
        net.addCentral(c4, Arrays.asList(c3), Arrays.asList(14));

        House h1 = new House("Leganitos",12);
        House h2 = new House("Recoletos",22);
        House h3 = new House("Alcala",21);
        House h4 = new House("Gran vía",21);
        House h5 = new House("Atocha",5);
        House h6 = new House("Preciados",13);
        House h7 = new House("Fuecarral",5);
        House h8 = new House("Serrano",2);
        House h9 = new House("Paseo del Prado",3);
        
        net.addHouse(h1, c1, 2);
        net.addHouse(h2, c1, 2);
        net.addHouse(h3, c1, 3);
        net.addHouse(h4, c2, 5);
        net.addHouse(h5, c2, 3);
        net.addHouse(h6, c2, 2);
        net.addHouse(h7, c3, 1);
        net.addHouse(h8, c4, 3);
        net.addHouse(h9, c4, 4);

        assertEquals(2,net.findHops(h1, c2));
        assertEquals(3,net.findHops(h1, c4));
        assertEquals(1,net.findHops(h9, c4));
    }

}