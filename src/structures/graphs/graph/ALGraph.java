package structures.graphs.graph;

import structures.graphs.Edge;
import structures.graphs.Vertex;
import java.util.*;

/**
 * Graph implemented as a adyacency list
 *
 * @author Rackumi
 */
public class ALGraph <V,E> implements Graph<V,E> {

    private class ALVertex<V> implements Vertex<V>{

        private V value;
        private final Set<Edge<E>> adyacencyList;
        private final Graph graph;

        public ALVertex(V value, Graph graph) {
            this.value = value;
            this.adyacencyList = new HashSet<>();
            this.graph = graph;
        }
        
        @Override
        public V getElement() {
            return value;
        }

        public void setValue(V value){
            this.value = value;
        }
        
        public Graph getGraph() {
            return graph;
        }

        public void addAdyacencyList(Edge<E> edge){
            adyacencyList.add(edge);
        }

        public void removeAdyacencyList(Edge<E> edge){
            adyacencyList.remove(edge);
        }
        
        public Set<Edge<E>> getAdyacencyList() {
            return adyacencyList;
        }
    }

    public class ALEdge<E> implements Edge<E>{

        private final Vertex<V> start;
        private final Vertex<V> end;
        private E value;
        private final Graph graph;

        public ALEdge(E value,Vertex<V> startVertex, Vertex<V> endVertex, Graph graph) {
            this.value = value;
            this.start = startVertex;
            this.end = endVertex;
            this.graph = graph;
        }

        @Override
        public E getElement() {
            return value;
        }

        public void setValue(E value){
            this.value = value;
        }

        public Vertex<V> getStart() {
            return start;
        }

        public Vertex<V> getEnd() {
            return end;
        }

        public Graph getGraph() {
            return graph;
        }

        @Override
        public int hashCode() {
            int hash = 3;

            final int min = Math.min(Objects.hashCode(this.start), Objects.hashCode(this.end));
            final int max = Math.max(Objects.hashCode(this.start), Objects.hashCode(this.end));

            hash = 67 * hash + Objects.hashCode(this.graph);
            hash = 67 * hash + min;
            hash = 67 * hash + max;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ALEdge<E> other = (ALEdge<E>) obj;
            if (!Objects.equals(this.graph, other.graph)) {
                return false;
            }

            final int min1 = Math.min(Objects.hashCode(this.start), Objects.hashCode(this.end));
            final int max1 = Math.max(Objects.hashCode(this.start), Objects.hashCode(this.end));

            final int min2 = Math.min(Objects.hashCode(other.start), Objects.hashCode(other.end));
            final int max2 = Math.max(Objects.hashCode(other.start), Objects.hashCode(other.end));

            if (!Objects.equals(min1, min2)) {
                return false;
            }
            if (!Objects.equals(max1, max2)) {
                return false;
            }
            return true;
        }

    }

    private final Set<ALEdge<E>> edgeList = new HashSet<>();
    private final Set<ALVertex<V>> vertexList = new HashSet<>();

    @Override
    public Collection<? extends Vertex<V>> vertices() { //O(1)
        return Collections.unmodifiableCollection(vertexList);
    }

    @Override
    public Collection<? extends Edge<E>> edges() { //O(1)
        return Collections.unmodifiableCollection(edgeList);
    }

    @Override
    public Collection<? extends Edge<E>> incidentEdges(Vertex<V> v) { //O(1)
        ALVertex<V> vertex = checkVertex(v);
        return vertex.getAdyacencyList();
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) { //O(1)
        ALVertex<V> vertex = checkVertex(v);
        ALEdge<E> edge = checkEdge(e);
        if(edge.getStart() == vertex){
            return edge.getEnd();
        }
        if(edge.getEnd() == vertex){
            return edge.getStart();
        }
        throw new RuntimeException("The vertex is not in the edge");
    }

    @Override
    public List<Vertex<V>> endVertices(Edge<E> edge) { //O(1)
        ALEdge<E> alEdge = checkEdge(edge);
        List<Vertex<V>> l = new LinkedList<>();
        l.add(alEdge.getStart());
        l.add(alEdge.getEnd());
        return l;
    }

//    @Override
//    public Edge<E> areAdjacent(Vertex<V> v1, Vertex<V> v2) { //O(grado(v1))
//        ALVertex<V> alVertex1 = checkVertex(v1);
//        ALVertex<V> alVertex2 = checkVertex(v2);
//        Set<Edge<E>> alEdge1 = alVertex1.getAdyacencyList();
//        for(Edge<E> e: alEdge1){
//            if(alVertex2.getAdyacencyList().contains(e)){
//               return e;
//            }
//        }
//        return null;
//    }

    @Override
    public Edge<E> areAdjacent(Vertex<V> v1, Vertex<V> v2) { //O(min(grado(v1), grado(v2)))
        ALVertex<V> alVertex1 = checkVertex(v1);
        ALVertex<V> alVertex2 = checkVertex(v2);
        Set<Edge<E>> edges1;
        Set<Edge<E>> edgesAux;

        //buscamos hacer el for en el set mas pequeño para que la complejidad sea lo menor posible
        if(alVertex1.getAdyacencyList().size() > alVertex2.getAdyacencyList().size()){
            edges1 = alVertex2.getAdyacencyList();
            edgesAux = alVertex1.getAdyacencyList();
        }
        else{
            edges1 = alVertex1.getAdyacencyList();
            edgesAux = alVertex2.getAdyacencyList();
        }
        for(Edge<E> e: edges1){
            if(edgesAux.contains(e)){
                return e;
            }
        }

        return null;
    }

    @Override
    public V replace(Vertex<V> vertex, V vertexValue) { //O(1)
        ALVertex<V> alVertex = checkVertex(vertex);
        V val = alVertex.getElement();
        alVertex.setValue(vertexValue);
        return val;
    }

    @Override
    public E replace(Edge<E> edge, E edgeValue) { //O(1)
        ALEdge<E> alEdge = checkEdge(edge);
        E val = alEdge.getElement();
        alEdge.setValue(edgeValue);
        return val;
    }

    @Override
    public Vertex<V> insertVertex(V value) { //O(1)
        ALVertex<V> alVertex = new ALVertex<>(value, this);
        vertexList.add(alVertex);
        return alVertex;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue) { //O(1)
        if (!vertexList.contains(v1)) {
            throw new RuntimeException("The vertex v1 doesn't belong to this graph");
        }
        if (!vertexList.contains(v2)){
            throw new RuntimeException("The vertex v2 doesn't belong to this graph");
        }
        ALEdge<E> alEdge = new ALEdge<>(edgeValue, v1, v2, this);
        if(edgeList.contains(alEdge)){
            edgeList.remove(alEdge);
        }
        edgeList.add(alEdge);
        ALVertex<V> alVertex1 = checkVertex(v1);
        ALVertex<V> alVertex2 = checkVertex(v2);
        alVertex1.addAdyacencyList(alEdge);
        alVertex2.addAdyacencyList(alEdge);
        return alEdge;
    }

    @Override
    public V removeVertex(Vertex<V> v) { //O(v)
        ALVertex<V> alVertex = checkVertex(v);
        V val = alVertex.getElement();

        for(Edge<E> e: alVertex.getAdyacencyList()){
            edgeList.remove(e);
        }

        vertexList.remove(alVertex);
        return val;
    }

    @Override
    public E removeEdge(Edge<E> edge) { //O(1)
        ALEdge<E> alEdge = checkEdge(edge);
        E val = alEdge.getElement();
        edgeList.remove(alEdge);
        return val;
    }

    private ALEdge<E> checkEdge(Edge<E> edge) {
        if (edge instanceof ALEdge){
            ALEdge<E> e = (ALEdge<E>)edge;
            if (e.getGraph() == this) {
                return e;
            }
        }
        throw new RuntimeException("The edge is not in the graph");
    }

    private ALVertex<V> checkVertex(Vertex<V> vertex) {
        if (vertex instanceof ALVertex){
            ALVertex<V> v = (ALVertex<V>)vertex;
            if (v.getGraph() == this) {
                return v;
            }
        }
        throw new RuntimeException("The vertex is not in the graph");
    }

}