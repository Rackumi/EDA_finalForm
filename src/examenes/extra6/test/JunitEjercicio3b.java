package examenes.extra6.test;

import java.util.ArrayList;

import examenes.extra6.ejercicio3.GraphUtils;
import structures.graphs.graph.ELGraph;
import structures.graphs.Edge;
import structures.graphs.Vertex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jvergara
 */
public class JunitEjercicio3b {
    
    public JunitEjercicio3b() {
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
        ELGraph<Integer, Integer> grafo = new ELGraph <> ();
        
        ArrayList<Vertex<Integer>> vertices = new ArrayList<Vertex<Integer>>();
        
        for (int i=1; i<=4; i++)
            vertices.add (grafo.insertVertex(i));
        
        ArrayList<Edge<Integer>> arcos_solucion = new ArrayList<Edge<Integer>>();
        
        grafo.insertEdge(vertices.get (0), vertices.get (1), 2);
        Edge<Integer> arco2 = grafo.insertEdge(vertices.get (0), vertices.get (2), 1);
        arcos_solucion.add (arco2);
        grafo.insertEdge(vertices.get (1), vertices.get (2), 2);
        Edge<Integer> arco1 = grafo.insertEdge(vertices.get (1), vertices.get (3), 1);
        arcos_solucion.add (arco1);
        Edge<Integer> arco3 = grafo.insertEdge(vertices.get (2), vertices.get (3), 2);
        arcos_solucion.add (arco3);
        
        GraphUtils<Integer> gu = new GraphUtils<>();
        ArrayList<Edge<Integer>> arcos_devueltos = new ArrayList<Edge<Integer>>();
        for (Edge<Integer> arco: gu.getKruskal(grafo)) {
            System.out.println (grafo.endVertices(arco).get(0).getElement()+" "+
                    grafo.endVertices(arco).get(1).getElement());
            arcos_devueltos.add (arco);
        }
        assertTrue (arcos_solucion.containsAll(arcos_devueltos));
        assertTrue (arcos_devueltos.containsAll(arcos_solucion));
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}