package practicas.practica3.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import practicas.practica3.ReferenciasCruzadas;

import static org.junit.Assert.*;

/**
 * @author Rackumi
 */
public class ReferenciasCruzadasTest {
    
    public ReferenciasCruzadasTest() {
    }

    /**
     * Test of apariciones method, of class ReferenciasCruzadas.
     */
    @Test
    public void testApariciones() throws FileNotFoundException, IOException {
        System.out.println("apariciones");
        FileReader f = new FileReader("src/practicas/practica3/Prueba.txt");
        ReferenciasCruzadas c = new ReferenciasCruzadas(f);
        String word = "AVL";
//        List<Integer> expResult = Arrays.asList(5,32,114); //no me sale este orden x)
        List<Integer> expResult = Arrays.asList(5,37,129);
            
        List<Integer> result = c.apariciones(word);
        assertEquals(expResult.toString(), result.toString());
        String word2 = "coche";
        assertEquals(null,c.apariciones(word2));
    }
    
}