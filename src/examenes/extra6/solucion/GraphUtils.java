package examenes.extra6.solucion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import structures.graphs.Edge;
import structures.graphs.graph.Graph;
import structures.graphs.Vertex;

public class GraphUtils<V> {

    public Iterable<Edge<Integer>> getKruskal(Graph<V, Integer> g) {
        //Tipo Solucion
        HashSet<Edge<Integer>> arcos_seleccionados = new HashSet<Edge<Integer>>();
        //Para simular la columna de comp. Conexas
        HashMap<V,V> compConexas = new HashMap<V,V>();
        for (Vertex<V> v: g.vertices()) {
            compConexas.put(v.getElement(), v.getElement());
        }
        //Me guardo todos los arcos en una bolsa mia
        ArrayList<Edge<Integer>> todos_los_arcos = new ArrayList<Edge<Integer>>();
        todos_los_arcos.addAll(g.edges());
        while (arcos_seleccionados.size()!= g.vertices().size()-1) {
            Edge<Integer> arco_mas_barato = dameMasBarato (todos_los_arcos);
            todos_los_arcos.remove (arco_mas_barato);
            
            Vertex<V> e1 = g.endVertices(arco_mas_barato).get(0);
            Vertex<V> e2 = g.endVertices(arco_mas_barato).get(1);
            
            V color1 = compConexas.get(e1.getElement());
            V color2 = compConexas.get(e2.getElement());
            
            if (color1==color2) {
                System.out.println ("Rechazada");
            }else {
                //Recorremos toda tabla y si una entrada tiene como color el 1 ponemos el 2
                for (Entry<V,V> entrada: compConexas.entrySet()) {
                    if (entrada.getValue().equals(color1)) {
                        compConexas.put (entrada.getKey(), color2);
                    }
                }
                //Añadir el arco a la solucion
                arcos_seleccionados.add(arco_mas_barato);
            }
        }
        return arcos_seleccionados;
    }

    public Iterable<Edge<Integer>> getPrim(Graph<V, Integer> g) {
        //Tipo Solucion
        HashSet<Edge<Integer>> arcos_seleccionados = new HashSet<Edge<Integer>>();
        
        //Tercera columna de la tabla de Prim
        HashSet<Vertex<V>> nodos_conquistados = new HashSet<Vertex<V>> ();
        
        //Seleccionamos un nodo cualquiera del grafo
        Vertex<V> inicial = g.vertices().iterator().next();
        
        nodos_conquistados.add(inicial);
        //Me guardo todos los arcos en una bolsa mia
        ArrayList<Edge<Integer>> todos_los_arcos_alcanzables = 
                new ArrayList<Edge<Integer>>();

        for (Edge<Integer> edge: g.edges()) {
            if ((g.endVertices(edge).get(0).equals(inicial)) ||
                    (g.endVertices(edge).get(1).equals(inicial))) {
                todos_los_arcos_alcanzables.add (edge);
            }
        }
        
        while (arcos_seleccionados.size()!= g.vertices().size()-1) {
            Edge<Integer> arco_mas_barato = dameMasBarato (todos_los_arcos_alcanzables);
            todos_los_arcos_alcanzables.remove (arco_mas_barato);
            
            Vertex<V> e1 = g.endVertices(arco_mas_barato).get(0);
            Vertex<V> e2 = g.endVertices(arco_mas_barato).get(1);
            
            if ((nodos_conquistados.contains(e1)) && (nodos_conquistados.contains(e2))) {
                System.out.println ("Rechazada");
                
            }else {
                arcos_seleccionados.add (arco_mas_barato);
                Vertex<V> nuevo_conquistado;
                if (nodos_conquistados.contains(e1))
                    nuevo_conquistado=e2;
                else 
                    nuevo_conquistado=e1;
                
                nodos_conquistados.add(nuevo_conquistado);
                todos_los_arcos_alcanzables.addAll (g.incidentEdges(nuevo_conquistado));
                
            }
        }
        
        return null;
    }

    private Edge<Integer> dameMasBarato(ArrayList<Edge<Integer>> todos_los_arcos) {
        Edge<Integer> mejor = todos_los_arcos.get(0);
        for (Edge<Integer> arco: todos_los_arcos) {
            if (arco.getElement()<mejor.getElement()) {
                mejor = arco;
            }
        }
        return mejor;
        
    }

}