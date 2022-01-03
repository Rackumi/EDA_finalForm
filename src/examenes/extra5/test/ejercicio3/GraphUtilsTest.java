package examenes.extra5.test.ejercicio3;

import examenes.extra5.source.ejercicio3.GraphUtils;
import structures.graphs.graph.ELGraph;
import structures.graphs.Vertex;
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
public class GraphUtilsTest {
    
    public GraphUtilsTest() {
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
    public void testConexo() {
        System.out.println("conexo");
        ELGraph<String, Integer> grafo = new ELGraph<String, Integer> ();
        Vertex<String> v1 = grafo.insertVertex("A");
        Vertex<String> v2 =grafo.insertVertex("B");
        Vertex<String> v3 =grafo.insertVertex("C");
        Vertex<String> v4 =grafo.insertVertex("D");
        Vertex<String> v5 =grafo.insertVertex("E");
        grafo.insertEdge(v1, v2, Integer.MIN_VALUE);
        grafo.insertEdge(v2, v3, Integer.MIN_VALUE);
        grafo.insertEdge(v3, v4, Integer.MIN_VALUE);
        grafo.insertEdge(v4, v5, Integer.MIN_VALUE);
        
        GraphUtils<String, Integer> utils = new GraphUtils<String, Integer>();
        
        assertTrue (utils.esConexo(grafo));
        grafo = new ELGraph<String, Integer> ();
        v1 = grafo.insertVertex("A");
        v2 =grafo.insertVertex("B");
        v3 =grafo.insertVertex("C");
        v4 =grafo.insertVertex("D");
        v5 =grafo.insertVertex("E");
        grafo.insertEdge(v1, v2, Integer.MIN_VALUE);
        grafo.insertEdge(v2, v3, Integer.MIN_VALUE);
        grafo.insertEdge(v3, v4, Integer.MIN_VALUE);
        
        assertFalse (utils.esConexo(grafo));
    }

    /**
     * Test of put method, of class SCW1HashTable.
     */
    @Test
    public void testTieneCiclos() {
        System.out.println("tieneCiclos");
        ELGraph<String, Integer> grafo = new ELGraph<String, Integer> ();
        Vertex<String> v1 = grafo.insertVertex("A");
        Vertex<String> v2 =grafo.insertVertex("B");
        Vertex<String> v3 =grafo.insertVertex("C");
        Vertex<String> v4 =grafo.insertVertex("D");
        Vertex<String> v5 =grafo.insertVertex("E");
        grafo.insertEdge(v1, v2, Integer.MIN_VALUE);
        grafo.insertEdge(v2, v3, Integer.MIN_VALUE);
        grafo.insertEdge(v3, v4, Integer.MIN_VALUE);
        grafo.insertEdge(v4, v5, Integer.MIN_VALUE);
        
        GraphUtils<String, Integer> utils = new GraphUtils<String, Integer>();
        
        assertFalse (utils.tieneCiclos(grafo));
        grafo = new ELGraph<String, Integer> ();
        v1 = grafo.insertVertex("A");
        v2 =grafo.insertVertex("B");
        v3 =grafo.insertVertex("C");
        v4 =grafo.insertVertex("D");
        v5 =grafo.insertVertex("E");
        grafo.insertEdge(v1, v2, Integer.MIN_VALUE);
        grafo.insertEdge(v2, v3, Integer.MIN_VALUE);
        grafo.insertEdge(v3, v4, Integer.MIN_VALUE);
        grafo.insertEdge(v4, v5, Integer.MIN_VALUE);
        grafo.insertEdge(v2, v5, Integer.MIN_VALUE);
        
        assertTrue (utils.tieneCiclos(grafo));

    }

    /**
     * Test of remove method, of class SCW1HashTable.
     */
    @Test
    public void testEsArbol() {
        System.out.println("esArbol");
        
        ELGraph<String, Integer> grafo = new ELGraph<String, Integer> ();
        Vertex<String> v1 = grafo.insertVertex("A");
        Vertex<String> v2 =grafo.insertVertex("B");
        Vertex<String> v3 =grafo.insertVertex("C");
        Vertex<String> v4 =grafo.insertVertex("D");
        Vertex<String> v5 =grafo.insertVertex("E");
        grafo.insertEdge(v1, v2, Integer.MIN_VALUE);
        grafo.insertEdge(v2, v3, Integer.MIN_VALUE);
        grafo.insertEdge(v3, v4, Integer.MIN_VALUE);
        grafo.insertEdge(v4, v5, Integer.MIN_VALUE);
        
        GraphUtils<String, Integer> utils = new GraphUtils<String, Integer>();
        
        assertTrue (utils.esArbol(grafo));
        grafo = new ELGraph<String, Integer> ();
        v1 = grafo.insertVertex("A");
        v2 =grafo.insertVertex("B");
        v3 =grafo.insertVertex("C");
        v4 =grafo.insertVertex("D");
        v5 =grafo.insertVertex("E");
        grafo.insertEdge(v1, v2, Integer.MIN_VALUE);
        grafo.insertEdge(v2, v3, Integer.MIN_VALUE);
        grafo.insertEdge(v3, v4, Integer.MIN_VALUE);
        grafo.insertEdge(v4, v5, Integer.MIN_VALUE);
        grafo.insertEdge(v2, v5, Integer.MIN_VALUE);
        
        assertFalse (utils.esArbol(grafo));
    }

}