package practicas.ejerciciosRepaso;

import structures.graphs.Edge;
import structures.graphs.digraph.Digraph;
import structures.graphs.graph.Graph;
import structures.graphs.Vertex;
import structures.Position;
import structures.tree.Tree;
import structures.tree.binarySearchTree.BinarySearchTree;

import java.util.*;

public class ejRepaso {

    //arboles 1
    //Devolver todos los padres de un nodo hoja
    public Iterable<Integer> arboles1(Tree<Integer> t){
        Set<Integer> set = new HashSet<>();
        Iterator<Position<Integer>> it = t.iterator();
        while(it.hasNext()){
            Position<Integer> node = it.next();
            if(t.isLeaf(node)){
                set.add(t.parent(node).getElement());
            }
        }
        return set;
    }

    //arboles 2
    //Devolver el nodo hoja más cercano a la raíz
    public Position<Integer> arboles2(Tree<Integer> t){
        Deque<Position<Integer>> q = new LinkedList<>();
        q.addFirst(t.root());
        while(!q.isEmpty()){
            Position<Integer> node = q.removeLast();
            if(t.isLeaf(node)){
                return node;
            }
            for(Position<Integer> p: t.children(node)){
                q.addFirst(p);
            }
        }
        return null;
    }

    //ABB 1
    //Devolver el menor número mayor que N -> el mas pegado a N por la derecha (sucesor)
    public Position<Integer> abb1(BinarySearchTree<Integer> t, Position<Integer> n){
        return t.successor(n);
    }

    //ABB 2
    //Devolver el mayor número menor que N -> el mas pegado a N por la izquierda (predecesor)
    public Position<Integer> abb2(BinarySearchTree<Integer> t, Position<Integer> n){
        return t.predecessor(n);
    }

    //Grafos 1
    //Devolver los segundos adyacentes, los nodos accesibles recorriendo 2 aristas
    public Iterable<Vertex<Integer>> grafos1(Graph<Integer, Integer> g, Vertex<Integer> v){
        Set<Vertex<Integer>> set = new HashSet<>();
        for(Edge<Integer> e1: g.incidentEdges(v)){
            Vertex<Integer> vAux1 = g.opposite(v, e1);
            for(Edge<Integer> e2: g.incidentEdges(vAux1)){
                Vertex<Integer> vAux2 = g.opposite(vAux1, e2);
                set.add(vAux2);
            }
        }
        //podrias hacer antes una comprobacion para no meter v pero
        //realmente nos sale la misma o incluso menos complejidad asi
        set.remove(v);
        return set;
    }

    //Grafos 2
    //Devolver el nodo con más aristas
    public Vertex<Integer> grafos2(Graph<Integer, Integer> g){
        Vertex<Integer> resp = null;
        for(Vertex<Integer> v: g.vertices()){
            if(resp == null || g.incidentEdges(v).size() > g.incidentEdges(resp).size()){
                resp = v;
            }
        }
        return resp;
    }

    //Digrafos 1
    //Devolver el nodo que tiene más aristas incidentes
    public Vertex<Integer> digrafos1(Digraph<Integer, Integer> g){ //TODO
        Vertex<Integer> resp = null;
        for(Vertex<Integer> v: g.vertices()){
            if(resp == null || g.outputEdges(v).size() > g.outputEdges(resp).size()){
                resp = v;
            }
        }
        return resp;
    }

    //Digrafos 2
    //Devolver los nodos fuente

    //Digrafos 3
    //Devolver los nodos sumidero

}