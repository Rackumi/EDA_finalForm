package structures.graphs.graphAlgorithms;

import java.util.*;

import com.sun.source.doctree.SeeTree;
import practicas.practica2.Pair;
import structures.Position;
import structures.graphs.Edge;
import structures.graphs.Vertex;
import structures.graphs.digraph.Digraph;
import structures.graphs.digraph.ELDigraph;
import structures.graphs.graph.Graph;
import structures.tree.Tree;
import structures.tree.binarySearchTree.DefaultComparator;
import structures.tree.narytree.LinkedTree;
import structures.tree.narytree.NAryTree;

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
//          c.insert(pos);
//        recorrido.insert(pos);
//        for (Position aux: t.children(pos)){
//            p.push(aux);
//        }
//        return recorrido;
//    }

    enum Label {
        DISCOVERY, CROSS
    };

    /**
     * Devuelve el árbol que se genera al realizar el recorrido en profundidad
     *
     * @param graph
     * @param source
     * @return
    */
    public List<Vertex<V>> depthTravel(Graph<V,E> graph, Vertex<V> source){
        Deque<Vertex<V>> s = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();
        List<Vertex<V>> l = new LinkedList<>();

        s.push(source);
        while(!s.isEmpty()){
            Vertex<V> pos = s.pop();
            if(!visited.contains(pos)) {
                visited.add(pos);
                l.add(pos);
            }
            for(Edge<E> e: graph.incidentEdges(pos)){
                Vertex<V> vertex = graph.opposite(pos, e);
                if(!visited.contains(vertex)) {
                    s.push(vertex);
                }
            }
        }
        return l;
    }

    /**
     * Devuelve la lista que se genera al realizar el recorrido en anchura
     * 
     * @param graph
     * @param source
     * @return 
     */
    public List<Vertex<V>> widthTravel(Graph<V,E> graph, Vertex<V> source){
        Deque<Vertex<V>> q = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();
        List<Vertex<V>> l = new LinkedList<>();

        q.addFirst(source);
        while(!q.isEmpty()){
            Vertex<V> pos = q.removeLast();
            if(!visited.contains(pos)) {
                visited.add(pos);
                l.add(pos);
            }
            for(Edge<E> e: graph.incidentEdges(pos)){
                Vertex<V> vertex = graph.opposite(pos, e);
                if(!visited.contains(vertex)) {
                    q.addFirst(vertex);
                }
            }
        }
        return l;
    }

    private Set<Vertex<V>> adyacentVertex(Graph<V,E> graph, Vertex<V> v){
        Set<Vertex<V>> lVertex = new HashSet<>();
        Collection<? extends Edge<E>> lEdge = graph.incidentEdges(v);
        for(Edge<E> e: lEdge){
            lVertex.add(graph.opposite(v,e));
        }
        return lVertex;
    }

    /**
     * Devuelve el árbol que se genera al realizar el recorrido en anchura
     *
     * @param graph
     * @param source
     * @return
     */
    public Tree<Vertex<V>> widthTravelTree(Graph<V,E> graph, Vertex<V> source){
        Deque<Vertex<V>> q = new LinkedList<>();
        Set<Vertex<V>> conj = new HashSet<>();
        NAryTree<Vertex<V>> t = new LinkedTree<>();
        Position<Vertex<V>> parent = null;

        q.addFirst(source);
        while(!q.isEmpty()){
            Vertex<V> pos = q.removeLast();

            if(conj.isEmpty()){
                conj.add(pos);
                t.addRoot(pos);
            }
            if(!conj.contains(pos)){
                conj.add(pos);
                parent = t.add(pos, parent); //TODO esta mal
            }
            for(Edge<E> e: graph.incidentEdges(pos)){
                Vertex<V> vertex = graph.opposite(pos, e);
                q.addFirst(vertex);
            }
            if(t.size()==graph.vertices().size()){
                return t;
            }
        }

        return t;
    }

    /**
     * Get the path between two vertex with minimun number of nodes. (Bellman-Ford algorithm)
     *
     * @param graph
     * @param startVertex
     * @param endVertex
     * @return The edge list
     */
    public List<Edge<E>> getPath(Graph<V, E> graph, Vertex<V> startVertex, Vertex<V> endVertex) {
        LinkedTree<Vertex<V>> tree = new LinkedTree<>();
        HashMap<Edge<E>, Label> edgeLabels = new HashMap<>();

        Queue<Position<Vertex<V>>> queue = new LinkedList<>();
        HashSet<Vertex<V>> visitedNodes = new HashSet<>();

        visitedNodes.add(startVertex);
        tree.addRoot(startVertex);
        queue.add(tree.root());

        while (!queue.isEmpty()) {
            Position<Vertex<V>> vetexPos = queue.poll();
            Vertex<V> vertex = vetexPos.getElement();
            for (Edge<E> edge : graph.incidentEdges(vertex)) {
                if (edgeLabels.get(edge) == null) {
                    Vertex<V> nextNode = graph.opposite(vertex, edge);
                    if (!visitedNodes.contains(nextNode)) {
                        edgeLabels.put(edge, Label.DISCOVERY);
                        visitedNodes.add(nextNode);
                        Position<Vertex<V>> treeNode = tree.add(nextNode, vetexPos);
                        queue.add(treeNode);
                        if (nextNode == endVertex) {
                            return pathToRoot(graph, treeNode, tree);
                        }
                    } else {
                        edgeLabels.put(edge, Label.CROSS);
                    }
                }
            }
        }
        return null;
    }

    private List<Edge<E>> pathToRoot(Graph<V, E> g, Position<Vertex<V>> node, LinkedTree<Vertex<V>> tree) {
        List<Edge<E>> result = new LinkedList<>();

        while (node != tree.root()) {
            Position<Vertex<V>> parent = tree.parent(node);
            Edge<E> edge = g.areAdjacent(node.getElement(), parent.getElement());
            result.add(0, edge);
            node = parent;
        }

        return result;
    }

    /**
     * Devuelve el conjunto de vértices visitados al hacer un recorrido en profundidad partiendo de root
     * @param g
     * @param root
     * @return
     */
    public Set<Vertex<V>> traverse(Graph<V, E> g, Vertex<V> root) {
        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> q = new ArrayDeque<>();
        q.add(root);
        visited.add(root);
        while (!q.isEmpty()) {
            Vertex<V> v = q.peek();
            visited.add(v);
            for (Edge<E> e : g.incidentEdges(v)) {
                Vertex<V> op = g.opposite(v, e);
                if (!visited.contains(op)) {
                    q.add(op);
                    visited.add(op);
                }
            }
            q.poll();
        }
        return visited;
    }

//    function Dijkstra(graph, source)
//        for each vertex v in Graph // Initializations
//          dist[v] = infinity // Mark distances from source to v as not yet computed
//          visited[v] = false // Mark all nodes as unvisited
//          previous[v] = undefined // Previous node in optimal path from source
//
//        dist[source] = 0; // Distance from source to itself is zero
//        insert source into Q; // Start off with the source node in priority queue Q
//
//        while Q is not empty // The main loop
//          u = vertex in Q with smallest distance in dist[] and !visited
//          remove u from Q;
//          visited[u] = true // Mark this node as visited
//
//          for each neighbor v of u
//              alt = dist[u] + dist_between(u, v) // Accumulate shortest dist from source
//              if alt < dist[v] && !visited[v]
//                  dist[v] = alt // Keep the shortest dist from src to v
//                  previous[v] = u
//                  insert v into Q // Add unvisited v into the Q to be processed
//
//        return dist,previous

    public Map<Vertex<V>, Vertex<V>> dijkstra(Graph<V,E> graph, Vertex<V> source){ //devuelve
        PriorityQueue<Pair<Vertex<V>, Integer>> pq = new PriorityQueue<>(new DijkstraComparator<>());
        Map<Vertex<V>, Integer> dist = new HashMap<>();
        Set<Vertex<V>> visited = new HashSet<>();
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();

        for(Vertex<V> v: graph.vertices()){
            dist.put(v, Integer.MAX_VALUE);
            previous.put(v, null);
        }

        dist.put(source, 0);
        pq.add(new Pair<>(source, 0));

        while(!pq.isEmpty()){
            Pair<Vertex<V>, Integer> pos = pq.remove();
            visited.add(pos.getFirst());

            for(Edge<E> e: graph.incidentEdges(pos.getFirst())){
                Vertex<V> oppo = graph.opposite(pos.getFirst(), e);
                int alt = dist.get(pos.getFirst()) + (Integer)e.getElement();
                if(alt < dist.get(oppo) && !visited.contains(oppo)){
                    dist.put(oppo, alt);
                    previous.put(oppo, pos.getFirst());
                    pq.add(new Pair<>(oppo, alt));
                }
            }
        }

        return previous;
    }

    private class DijkstraComparator<E> implements Comparator<E>{
        @Override
        public int compare(E o1, E o2) {
            Pair<Integer, Integer> p1 = (Pair<Integer, Integer>)o1;
            Pair<Integer, Integer> p2 = (Pair<Integer, Integer>)o2;
            int key1 = p1.getSecond();
            int key2 = p2.getSecond();
            return key1 - key2;
        }
    }

//    algorithm FloydWarshall(graph)
//        auxGraph[0] = graph
//        for k=1 to graph.vertices().size()
//            v = graph.vertices()
//            auxGraph[k] = auxGraph[k-1]
//            for i=1 to v.size()
//                for j=1 to v.size()
//                    if (i != j) & (i != k) & (j != k)
//                        if auxGraph[k-1].areAdjacent(v[i],v[k]) && auxGraph[k-1].areAdjacent(v[k],v[j])
//                            auxGraph[k].insertEdge(v[i],v[j])
//        return auxGraph[v.size()]

    /**
     * Computes the Digraph's transitive clousure using the Floyd-Wharsall algorithm
     * @param g
     * @return
     */
    public Digraph<V,E> transitiveClosure(Digraph<V,E> g){ //creo que aqui faltarian varias condiciones ya que el areadyacent no va en los dos sentidos
        for(Vertex<V> v1: g.vertices()) {
            for(Vertex<V> v2: g.vertices()){
                for(Vertex<V> v3: g.vertices()){
                    if(g.areAdjacent(v2, v1) && g.areAdjacent(v1, v3) && !g.areAdjacent(v2, v3) && v2 != v3){
                            g.insertEdge(v2, v3, null);
                    }
                }
            }
        }
        return g;
    }

    /**
     * Computes the Digraph's transitive clousure using the Floyd-Wharsall algorithm
     * @param g
     * @return
     */
    public Digraph<V,E> transitiveClosure2(Digraph<V,E> g){ //otra forma de hacerlo
        for(Vertex<V> v: g.vertices()){
            for (Edge<E> e1 : g.incidentEdges(v)){
                Vertex<V> opp1 = g.opposite(v, e1);
                for (Edge<E> e2 : g.outputEdges(v)){
                    Vertex<V> opp2 = g.opposite(v, e2);
                    if (opp1 != opp2 && !g.areAdjacent(opp1, opp2) && !g.areAdjacent(opp2, opp1)){
                        g.insertEdge(opp1, opp2, null);
                    }
                }
            }
        }
        return g;
    }

//	function Kruskal(graph)
//	Initialice a priority queue Q with all edges using weights as keys
//	foreach v : graph.vertices()
//			conjuntos.createconjunto(v)
//	tree = ∅
//			while tree.size() < (graph.vertices().size() - 1)
//			(u,v) = Q.removeMin()
//			if conjuntos.getconjunto(u) ≠ conjuntos.getconjunto(v)
//			tree.add(u, v)
//			conjuntos.joinconjuntos(u, v)
//			return tree

    public List<Edge<E>> getKruskal(Graph<V,E> g){
        PriorityQueue<Pair<Edge<E>,Integer>> priorityQueue = new PriorityQueue<>(new KruskalComparator<>());
        List<Set<Vertex<V>>> conj = new LinkedList<>();
        List<Edge<E>> l = new LinkedList<>();

        for (Edge<E> e: g.edges()){
            priorityQueue.add(new Pair<>(e, (Integer)e.getElement()));
        }

        for(Vertex<V> v: g.vertices()){
            Set<Vertex<V>> s = new HashSet<>();
            s.add(v);
            conj.add(s);
        }

        while(l.size() != g.vertices().size()-1){

            Edge<E> first = priorityQueue.poll().getFirst();
            Vertex<V> v1 = g.endVertices(first).get(0);
            Vertex<V> v2 = g.endVertices(first).get(1);
            Set<Vertex<V>> s1 = new HashSet<>();
            Set<Vertex<V>> s2 = new HashSet<>();

            for (Set<Vertex<V>> s : conj){
                if (s.contains(v1)){
                    s1 = s;
                }
                if (s.contains(v2)){
                    s2 = s;
                }
            }
            if (s1 != s2){
                l.add(first);
                s1.addAll(s2);
                conj.remove(s2);
            }
        }
        return l;
    }

    private class KruskalComparator<E> implements Comparator<E>{
        @Override
        public int compare(E o1, E o2) {
            Pair<Integer, Integer> p1 = (Pair<Integer, Integer>)o1;
            Pair<Integer, Integer> p2 = (Pair<Integer, Integer>)o2;
            int key1 = p1.getSecond();
            int key2 = p2.getSecond();
            return key1 - key2;
        }
    }

}