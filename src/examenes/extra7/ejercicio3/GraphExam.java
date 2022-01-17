package examenes.extra7.ejercicio3;

import java.util.*;

import structures.graphs.Edge;
import structures.graphs.graph.ALGraph;
import structures.graphs.graph.Graph;
import structures.graphs.Vertex;

/**
 *
 * @author Rackumi
 */
public class GraphExam {

    public Collection<Autor> getRanking (Graph<Autor, Integer> grafo) {
        List<Autor> l = new LinkedList<>();
        for(Vertex<Autor> v : grafo.vertices()){
            l.add(v.getElement());
        }
        Collections.sort(l);
        return l;
    }
    
    public Collection<Autor> getDistanciaK (Graph<Autor, Integer> grafo, Vertex<Autor> autor, int distancia) {
        Deque<Vertex<Autor>> q = new LinkedList<>();
        Set<Vertex<Autor>> visited = new HashSet<>();
        Map<Vertex<Autor>, Integer> dist = new HashMap<>();
        Set<Autor> l = new HashSet<>();

        Vertex<Autor> first = grafo.vertices().iterator().next();
        q.addFirst(first);
        dist.put(first, 0);
        while(!q.isEmpty()){
            Vertex<Autor> v = q.removeLast();
            if(!visited.contains(v)){
                visited.add(v);
                for(Edge<Integer> e: grafo.incidentEdges(v)){
                    Vertex<Autor> oppo = grafo.opposite(v, e);
                    dist.put(oppo, dist.get(v)+1);
                    q.addFirst(oppo);
                }
                if(dist.get(v) == distancia){
                    l.add(v.getElement());
                }
            }
        }
        return l;
    }

}