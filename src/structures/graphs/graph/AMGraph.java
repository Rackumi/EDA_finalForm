package structures.graphs.graph;

import structures.graphs.Edge;
import structures.graphs.Vertex;
import java.util.*;

/**
 * Graph implemented as a adyacency matrix
 *
 * @author Rackumi
 */
public class AMGraph<V,E> implements Graph<V,E>{

    private class AMVertex<V> implements Vertex<V> {

        private V value;
        private final Graph graph;
        private int num;

        @Override
        public V getElement() {
            return value;
        }

        public void setValue(V value){
            this.value = value;
        }

        public AMVertex(V value, Graph graph) {
            this.value = value;
            this.graph = graph;
        }

        public Graph getGraph() {
            return graph;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

    }

    public class AMEdge<E> implements Edge<E> {

        private final Vertex<V> start;
        private final Vertex<V> end;
        private E value;
        private final Graph graph;

        public AMEdge(E value,Vertex<V> startVertex, Vertex<V> endVertex, Graph graph) {
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
            final AMEdge<E> other = (AMEdge<E>) obj;
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

    private final Set<AMEdge<E>> edgeList = new HashSet<>();
    private final Set<AMVertex<V>> vertexList = new HashSet<>();
    private final Edge<E>[][] adjacencyMatrix = (Edge<E>[][]) new Object[100][100];

    @Override
    public Collection<? extends Vertex<V>> vertices() { //O(1)
        return Collections.unmodifiableCollection(vertexList);
    }

    @Override
    public Collection<? extends Edge<E>> edges() { //O(1)
        return Collections.unmodifiableCollection(edgeList);
    }

    @Override
    public Collection<? extends Edge<E>> incidentEdges(Vertex<V> v) { //O(n)
        AMVertex<V> amVertex = checkVertex(v);
        List<Edge<E>> l = new LinkedList<>();

        for(Edge<E> p: adjacencyMatrix[amVertex.getNum()]){
            if(p != null){
                l.add(p);
            }
        }
        return l;
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) { //O(1)
        AMEdge<E> edge = checkEdge(e);
        if(edge.getStart() == v){
            return edge.getEnd();
        }
        if(edge.getEnd() == v){
            return edge.getStart();
        }
        throw new RuntimeException("The vertex is not in the edge");
    }

    @Override
    public List<Vertex<V>> endVertices(Edge<E> edge) { //O(1)
        AMEdge<E> eledge = checkEdge(edge);
        List<Vertex<V>> l = new LinkedList<>();
        l.add(eledge.getStart());
        l.add(eledge.getEnd());
        return l;
    }

    @Override
    public Edge<E> areAdjacent(Vertex<V> v1, Vertex<V> v2) { //O(1)
        for(AMEdge<E> e: edgeList){
            if((e.getStart() == v1 && e.getEnd() == v2) || (e.getEnd() == v1 && e.getStart() == v2)){
                return e;
            }
        }
        return null;
    }

    @Override
    public V replace(Vertex<V> vertex, V vertexValue) { //O(1)
        AMVertex<V> elVertex = checkVertex(vertex);
        V val = elVertex.getElement();
        elVertex.setValue(vertexValue);
        return val;
    }

    @Override
    public E replace(Edge<E> edge, E edgeValue) { //O(1)
        AMEdge<E> elEdge = checkEdge(edge);
        E val = elEdge.getElement();
        elEdge.setValue(edgeValue);
        return val;
    }

    @Override
    public Vertex<V> insertVertex(V value) { //O()
        AMVertex<V> node = new AMVertex<>(value, this);
        vertexList.add(node);
        return node;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue) { //O()
        if (!vertexList.contains(v1)) {
            throw new RuntimeException("The vertex v1 doesn't belong to this graph");
        }
        if (!vertexList.contains(v2)){
            throw new RuntimeException("The vertex v2 doesn't belong to this graph");
        }

        AMEdge<E> node = new AMEdge<>(edgeValue, checkVertex(v1), checkVertex(v2), this);
        if(edgeList.contains(node)){
            edgeList.remove(node);
        }
        edgeList.add(node);
        return node;
    }

    @Override
    public V removeVertex(Vertex<V> vertex) { //O()
        AMVertex<V> elVertex = checkVertex(vertex);
        V val = elVertex.getElement();

        vertexList.remove(elVertex);

        List<AMEdge<E>> l = new LinkedList<>();
        for(AMEdge<E> e: edgeList){
            if(e.getStart() == elVertex || e.getEnd() == elVertex){
                l.add(e);
            }
        }

        for(AMEdge<E> elem: l){
            edgeList.remove(elem);
        }

        return val;
    }

    @Override
    public E removeEdge(Edge<E> edge) { //O()
        AMEdge<E> elEdge = checkEdge(edge);
        E val = elEdge.getElement();
        edgeList.remove(elEdge);
        return val;
    }

    private AMEdge<E> checkEdge(Edge<E> edge) {
        if (edge instanceof AMEdge){
            AMEdge<E> e = (AMEdge<E>)edge;
            if (e.getGraph() == this) {
                return e;
            }
        }
        throw new RuntimeException("The edge is not in the graph");
    }

    private AMVertex<V> checkVertex(Vertex<V> vertex) {
        if (vertex instanceof AMVertex){
            AMVertex<V> v = (AMVertex<V>)vertex;
            if (v.getGraph() == this) {
                return v;
            }
        }
        throw new RuntimeException("The vertex is not in the graph");
    }

}