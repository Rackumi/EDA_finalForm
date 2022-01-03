package examenes.extra5.solucion.ejercicio3;

import java.util.ArrayList;
import java.util.HashSet;

import structures.graphs.Edge;
import structures.graphs.graph.Graph;
import structures.graphs.Vertex;

/**
 *
 * @author Rackumi
 */
public class GraphUtils<V, E> {

    public boolean esConexo(Graph<V, E> g) {
        if (g.vertices().isEmpty()){
            return true;
        }
        
        //Nos basamos en un recorrido Iterativo
        Vertex<V> inicio = g.vertices().iterator().next();
        ArrayList<Vertex<V>> cola = new ArrayList<Vertex<V>>();
        HashSet<Vertex<V>> visitados = new HashSet<Vertex<V>>();
        cola.add(inicio);
        while (!cola.isEmpty()) {
            Vertex<V> v = cola.remove(0);
            if (!visitados.contains(v)) {
                visitados.add (v);
                for (Edge<E> arco: g.incidentEdges(v)) {
                    Vertex<V> otro = g.opposite(v, arco);
                    if (!visitados.contains(otro)) {
                        cola.add (otro);
                    }
                }
            }
            
        }
        return visitados.size()==g.vertices().size();
    }

    public boolean tieneCiclos(Graph<V, E> g) {
        if (g.vertices().isEmpty()){
            return false;
        }
        Vertex<V> inicio = g.vertices().iterator().next();
        HashSet<Vertex<V>> visitados = new HashSet<Vertex<V>>();
        return tieneCiclos (g, inicio, inicio, visitados);
        
    }
    

    public boolean esArbol(Graph<V, E> g) {
        return esConexo (g) && !tieneCiclos (g);
    }

    private boolean tieneCiclos(Graph<V, E> g, Vertex<V> anterior, 
                            Vertex<V> actual, HashSet<Vertex<V>> visitados) {
        visitados.add (actual);
        for (Edge<E> arco: g.incidentEdges(actual)) {
            Vertex<V> adyacente = g.opposite(actual, arco);
            if (adyacente!=anterior) {
                if (!visitados.contains(adyacente)) {
                    boolean tiene = tieneCiclos (g, actual, adyacente, visitados);
                    if (tiene)
                        return true;
                }else {
                    return true;
                }
            }
        }
        return false;
    }

}