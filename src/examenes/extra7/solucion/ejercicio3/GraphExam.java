package examenes.extra7.solucion.ejercicio3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import practicas.practica2.Pair;
import structures.Position;
import structures.graphs.Edge;
import structures.graphs.graph.Graph;
import structures.graphs.Vertex;
import structures.tree.binarySearchTree.AVLTree;

/**
 *
 * @author Rackumi
 */
public class GraphExam {
    public Collection<Autor> getRankingV2 (Graph<Autor, Integer> grafo) {
        ArrayList<Autor> lista = new ArrayList<>();
        AVLTree<Autor> avl = new AVLTree<>(  );
        for (Vertex<Autor> v: grafo.vertices()) {
            avl.insert (v.getElement());
        }
        
        for (Position<Autor> p: avl) {
            lista.add (p.getElement());
        }
        
        return lista;
        
    }
    public Collection<Autor> getRanking (Graph<Autor, Integer> grafo) {
        ArrayList<Autor> lista = new ArrayList<>();
        for (Vertex<Autor> v: grafo.vertices()) {
            lista.add (v.getElement());
        }
        Collections.sort(lista);
        return lista;
        
    }
    public Collection<Autor> getDistanciaKV2 (Graph<Autor, Integer> grafo, Vertex<Autor> autor, int distancia) {
        HashSet<Vertex<Autor>> visitados = new HashSet<>();
        ArrayList<Autor> lista = new ArrayList<>();
        ArrayList<Pair<Vertex<Autor>, Integer>>  superCola = new ArrayList<>();
        
        superCola.add (new Pair (autor, 0));
        visitados.add (autor);
        
        while (!superCola.isEmpty()) {
            Pair<Vertex<Autor>, Integer> pareja = superCola.remove(0);
            Vertex<Autor> v = pareja.getFirst();
            Integer distanciaActual = pareja.getSecond();
            
            for (Edge<Integer> adj: grafo.incidentEdges(v)) {
                Vertex<Autor> adyacente = grafo.opposite(v, adj);
                if (!visitados.contains(adyacente)) {
                    if (distanciaActual+1==distancia) {
                        lista.add (adyacente.getElement());
                    }else {
                        superCola.add (new Pair (adyacente, distanciaActual+1));
                        visitados.add (adyacente);
                    }
                }
                
            }
            
        }
 
        return lista;
    }

    public Collection<Autor> getDistanciaK (Graph<Autor, Integer> grafo, Vertex<Autor> autor, int distancia) {
        HashSet<Vertex<Autor>> visitados = new HashSet<>();
        ArrayList<Autor> lista = new ArrayList<>();
        ArrayList<Vertex<Autor>> cola = new ArrayList<>();
        ArrayList<Integer> colaNumeros = new ArrayList<>();
        cola.add(autor);
        colaNumeros.add(0);
        visitados.add (autor);
        while (!cola.isEmpty()) {
            Vertex<Autor> v = cola.remove(0);
            Integer distanciaActual = colaNumeros.remove(0);
            
            for (Edge<Integer> adj: grafo.incidentEdges(v)) {
                Vertex<Autor> adyacente = grafo.opposite(v, adj);
                if (!visitados.contains(adyacente)) {
                    if (distanciaActual+1==distancia) {
                        lista.add (adyacente.getElement());
                    }else {
                        cola.add (adyacente);
                        colaNumeros.add (distanciaActual+1);
                        visitados.add (adyacente);
                    }
                }
                
            }
            
        }
        return lista;
    }

}