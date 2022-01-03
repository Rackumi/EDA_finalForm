package examenes.extra5.test.ejercicio2;

import java.util.ArrayList;

import examenes.extra5.source.ejercicio2.Traductor;
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
public class TraductorTest {
    
    public TraductorTest() {
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
    public void testAñadirTraducir() {
        Traductor traductor = new Traductor();
        traductor.añadir("hola", "hello", "Inglés");
        traductor.añadir("hola", "salut", "Francés");
        traductor.añadir("hola", "ciao", "Italiano");
        traductor.añadir("hola", "Hallo", "Alemán");
        assertTrue(traductor.traducir("hola", "Inglés").equals("hello"));
        assertTrue(traductor.traducir("hola", "Italiano").equals("ciao"));
        
        try {
            traductor.traducir("adios", "Italiano");
            fail("No debería de estar");
        } catch (Exception e) {
            assertTrue(true);
        }
        
        try {
            traductor.traducir("hola", "Holandes");
            fail("No debería de estar");
        } catch (Exception e) {
            assertTrue(true);
        }
        
    }

    @Test
    public void testTraducciones() {
        Traductor traductor = new Traductor();
        traductor.añadir("hola", "hello", "Inglés");
        traductor.añadir("hola", "salut", "Francés");
        traductor.añadir("hola", "ciao", "Italiano");
        traductor.añadir("hola", "Hallo", "Alemán");
        
        ArrayList<String> traducciones = new ArrayList<String> ();
        ArrayList<String> idiomas = new ArrayList<String> ();
        traductor.traducciones("hola", traducciones, idiomas);
        
        assertEquals(4, traducciones.size());
        assertEquals(4, idiomas.size());
       
    }
    
}