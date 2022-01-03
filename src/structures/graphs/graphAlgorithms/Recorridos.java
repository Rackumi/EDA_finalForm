package structures.graphs.graphAlgorithms;

import java.util.List;
import java.util.Set;

import structures.graphs.Edge;
import structures.graphs.Vertex;
import structures.graphs.graph.Graph;

/**
 *
 * @author Rackumi
 * @param <V>
 * @param <E>
 */
public class Recorridos<V, E> {

//    Pila p; //si ponemos una cola ya tenemos el recorrido en anchura
//    Conjunto c;
//    List recorrido;
//
//p.push(root);
//
//while (!p.isEmpty()){
//        Position pos = p.pop();
//        if !c.contains(pos)
//        c.insert(pos);
//        recorrido.insert(pos);
//        for (Position aux: t.children(pos)){
//            p.push(aux);
//        }
//        return recorrido;
//    }

    /**
     * Devuelve el árbol que se genera al realizar el recorrido en profundidad
     * 
     * @param graph
     * @param source
     * @return 
     */
    public List<Vertex<V>> depthTravel(Graph<V,E> graph, Vertex<V> source){
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Devuelve el árbol que se genera al realizar el recorrido en anchura
     * 
     * @param graph
     * @param source
     * @return 
     */
    public List<Vertex<V>> widthTravel(Graph<V,E> graph, Vertex<V> source){
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Get the path between two vertex with minimun number of nodes.
     *
     * @param graph
     * @param startVertex
     * @param endVertex
     * @return The edge list
     */
    public List<Edge<E>> getPath(Graph<V, E> graph, Vertex<V> startVertex, Vertex<V> endVertex) {
       throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Devuelve el conjunto de vértices visitados al hacer un recorrido en profundidad partiendo de root
     * @param g
     * @param root
     * @return 
     */
    public Set<Vertex<V>> traverse(Graph<V, E> g, Vertex<V> root) {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}