package practicas.ejerciciosRepaso;

import org.junit.*;
import structures.graphs.Vertex;
import structures.graphs.graph.ELGraph;
import structures.graphs.graph.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Rackumi
 */
public class ejRepasoTest {

    public ejRepasoTest() {
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
    public void nodosDist2() {
        System.out.println("nodos distancia 2");
        List<Integer> connected = new ArrayList<>();
        ejRepaso er = new ejRepaso();
        Graph<Integer, Integer> grafo = new ELGraph<>();
        Vertex<Integer> uno = grafo.insertVertex(1);
        Vertex<Integer> dos = grafo.insertVertex(2);
        Vertex<Integer> tres = grafo.insertVertex(3);
        Vertex<Integer> cuatro = grafo.insertVertex(4);
        Vertex<Integer> cinco = grafo.insertVertex(5);
        Vertex<Integer> seis = grafo.insertVertex(6);

        grafo.insertEdge(uno, dos, 0);
        grafo.insertEdge(dos, tres, 0);
        grafo.insertEdge(uno, cuatro, 0);
        grafo.insertEdge(cuatro, cinco, 0);
        grafo.insertEdge(cinco, seis, 0);

        Set<Vertex<Integer>> list = er.kAdyacentes(grafo, uno);
        Set<Vertex<Integer>> esperado = new HashSet<>();
        esperado.add(tres);
        esperado.add(cinco);

        assertEquals(esperado, list);

    }

}