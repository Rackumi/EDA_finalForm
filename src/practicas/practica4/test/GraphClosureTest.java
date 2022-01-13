package practicas.practica4.test;

import java.util.Collection;

import practicas.practica4.GraphClosure;
import structures.graphs.*;
import org.junit.Test;
import structures.graphs.digraph.Digraph;
import structures.graphs.digraph.ELDigraph;

import static org.junit.Assert.*;

/**
 * @author Rackumi
 */
public class GraphClosureTest {
    
    public GraphClosureTest() {
    }

    /**
     * Test of transitiveClosure method, of class GraphClosure.
     */
    @Test
    public void testTransitiveClosure() {
        System.out.println("transitiveClosure");
        GraphClosure instance = new GraphClosure();
        ELDigraph<Integer,Boolean> digrafo = new ELDigraph<>();
        Vertex<Integer> insert0 = digrafo.insertVertex(0);
        Vertex<Integer> insert1 = digrafo.insertVertex(1);
        Vertex<Integer> insert2 = digrafo.insertVertex(2);
        Vertex<Integer> insert3 = digrafo.insertVertex(3);
        digrafo.insertEdge(insert0, insert2, true);
        digrafo.insertEdge(insert2, insert3, true);
        digrafo.insertEdge(insert3, insert1, true);
        digrafo.insertEdge(insert2, insert0, true);
        
        Digraph<Integer,Boolean> result = instance.transitiveClosure(digrafo);
        Collection<? extends Edge<Boolean>> edges = result.edges();
        assertEquals(edges.size(),7);
        assertTrue(edges.containsAll(digrafo.edges()));
        assertTrue(result.vertices().containsAll(digrafo.vertices()));
    }
    
}