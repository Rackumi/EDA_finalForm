package examenes.adelanto_2018_2019.grafo;

import java.util.Collection;
import java.util.List;

/**
 * @author Rackumi
 */
public interface Graphh<V,E> {
    /**
     * @return all vertices of the graph.
     */
    Collection<? extends Vertexx<V>> vertices();
        
    /**
     * @return all the edges of the graph.
     */
    Collection<? extends Edgee<E>> edges();

    /**
     * @return an iterable collection of the edges incident upon vertex v.
     */
    Collection<? extends Edgee<E>> incidentEdges(Vertexx<V> v);
    
    /**
     * @return the end vertex of the edge e distinct of v.
     */
    Vertexx<V> opposite(Vertexx<V> v, Edgee<E> e);

    /**
     * @return an array storing the end vertices of edge.
     */
    List<Vertexx<V>> endVertices(Edgee<E> edge);
        
    /**
     * Test whether vertices v1 and v2 are adjacent.
     * @return the edge if are adjacent, or null if not.
     */
    Edgee<E> areAdjacent(Vertexx<V> v1, Vertexx<V> v2);

    /**
     * Replace the element stored at vertex with vertexValue.
     * @return the old element stored at vertex.
     */
    V replace(Vertexx<V> vertexx, V vertexValue);
    
    /**
     * Replace the element stored at edge with edgeValue.
     * @return the old element stored at edge.
     */
    E replace(Edgee<E> edge, E edgeValue);
            
    /**
     * Insert and return a new vertex storing element value.
     */
    Vertexx<V> insertVertex(V value);

    /**
     * Insert and return a new undirected edge with end vertices 
     * v1 and v2 and storing element vertexValue.
     * If already exists an edge with this vertices the edge is replaced.
     */
    Edgee<E> insertEdge(Vertexx<V> v1, Vertexx<V> v2, E edgeValue);
    
    /**
     * Remove vertex v and all its incident edges.
     * @return the element stored at vertex
     */
    V removeVertex(Vertexx<V> vertexx);

    /**
     * Remove edge
     * @return the element stored at e.
     */
    E removeEdge(Edgee<E> edge);

}