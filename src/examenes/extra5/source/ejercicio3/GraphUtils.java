package examenes.extra5.source.ejercicio3;

import structures.graphs.Edge;
import structures.graphs.Vertex;
import structures.graphs.graph.Graph;

import java.util.*;

/**
 *
 * @author Rackumi
 */
public class GraphUtils<V, E> {

    public boolean esConexo(Graph<V, E> g) {
        Deque<Vertex<V>> q = new LinkedList<>();
        List<Vertex<V>> bfs = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        q.addFirst(g.vertices().iterator().next());
        while(!q.isEmpty()){
            Vertex<V> v = q.removeLast();
            if(!visited.contains(v)) {
                visited.add(v);
                for (Edge<E> e : g.incidentEdges(v)) {
                    Vertex<V> oppo = g.opposite(v, e);
                    q.addFirst(oppo);
                }
                bfs.add(v);
            }
        }
        return bfs.size() >= g.vertices().size();
    }

    public boolean tieneCiclos(Graph<V, E> g) {
        if(g.vertices().isEmpty()){
            return false;
        }
        Vertex<V> v = g.vertices().iterator().next();
        return tieneCiclosAux(g, v, v, new HashSet<>());
    }

    private boolean tieneCiclosAux(Graph<V, E> g, Vertex<V> anterior, Vertex<V> actual, Set<Vertex<V>> visitados){
        visitados.add(actual);
        for(Edge<E> e: g.incidentEdges(actual)){
            Vertex<V> oppo = g.opposite(actual, e);
            if(oppo != anterior){
                if(!visitados.contains(oppo)){
                    boolean bool = tieneCiclosAux(g, actual, oppo, visitados);
                    if(bool){ //hacemos esto xq no keremos retornar false en caso de ke no se cumpla ya que queremos seguir buscando
                        return true;
                    }
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }

    public boolean esArbol(Graph<V, E> g) {
        return esConexo(g) && !tieneCiclos(g);
    }

}