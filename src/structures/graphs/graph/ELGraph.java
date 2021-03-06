package structures.graphs.graph;

import structures.graphs.Edge;
import structures.graphs.Vertex;
import java.util.*;

/**
 * Graph implemented as a edge list
 *
 * @author Rackumi
 */
public class ELGraph <V,E> implements Graph<V,E> {

    private class ELVertex<V> implements Vertex<V>{

        private V value;
        private final Graph graph;

        @Override
        public V getElement() {
            return value;
        }

        public void setValue(V value){
            this.value = value;
        }

        public ELVertex(V value, Graph graph) {
            this.value = value;
            this.graph = graph;
        }

        public Graph getGraph() {
            return graph;
        }

    }

    public class ELEdge<E> implements Edge<E>{

        private final Vertex<V> start;
        private final Vertex<V> end;
        private E value;
        private final Graph graph;

        public ELEdge(E value,Vertex<V> startVertex, Vertex<V> endVertex, Graph graph) {
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
            final ELEdge<E> other = (ELEdge<E>) obj;
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

    private final Set<ELEdge<E>> edgeList = new HashSet<>();
    private final Set<ELVertex<V>> vertexList = new HashSet<>();

    @Override
    public Collection<? extends Vertex<V>> vertices() { //O(1)
//        return vertexList;
        return Collections.unmodifiableCollection(vertexList);
    }

    @Override
    public Collection<? extends Edge<E>> edges() { //O(1)
//        return edgeList;
        return Collections.unmodifiableCollection(edgeList);
    }

    @Override
    public Collection<? extends Edge<E>> incidentEdges(Vertex<V> v) { //O(m) siendo m el num de aristas
        Set<ELEdge<E>> incident = new HashSet<>();
        for(ELEdge<E> e: edgeList){
            if(e.getStart() == v){
                incident.add(e);
            }
            if(e.getEnd() == v){
                incident.add(e);
            }
        }
        return incident;
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) { //O(1)
        ELEdge<E> edge = checkEdge(e);
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
        ELEdge<E> eledge = checkEdge(edge);
        List<Vertex<V>> l = new LinkedList<>();
        l.add(eledge.getStart());
        l.add(eledge.getEnd());
        return l;
    }

    @Override
    public Edge<E> areAdjacent(Vertex<V> v1, Vertex<V> v2) { //O(m) siendo m el num de aristas
        for(ELEdge<E> e: edgeList){
            if((e.getStart() == v1 && e.getEnd() == v2) || (e.getEnd() == v1 && e.getStart() == v2)){
                return e;
            }
        }
        return null;
    }

    @Override
    public V replace(Vertex<V> vertex, V vertexValue) { //O(1)
        ELVertex<V> elVertex = checkVertex(vertex);
        V val = elVertex.getElement();
        elVertex.setValue(vertexValue);
        return val;
    }

    @Override
    public E replace(Edge<E> edge, E edgeValue) { //O(1)
        ELEdge<E> elEdge = checkEdge(edge);
        E val = elEdge.getElement();
        elEdge.setValue(edgeValue);
        return val;
    }

    @Override
    public Vertex<V> insertVertex(V value) { //O(1)
        ELVertex<V> node = new ELVertex<>(value, this);
        vertexList.add(node);
        return node;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue) { //O(1)
        if (!vertexList.contains(v1)) {
            throw new RuntimeException("The vertex v1 doesn't belong to this graph");
        }
        if (!vertexList.contains(v2)){
            throw new RuntimeException("The vertex v2 doesn't belong to this graph");
        }

        ELEdge<E> node = new ELEdge<>(edgeValue, checkVertex(v1), checkVertex(v2), this);
        if(edgeList.contains(node)){
            edgeList.remove(node);
        }
        edgeList.add(node);
        return node;
    }

    @Override
    public V removeVertex(Vertex<V> vertex) { //O(m) siendo m el num de aristas
        ELVertex<V> elVertex = checkVertex(vertex);
        V val = elVertex.getElement();

        vertexList.remove(elVertex);

        List<ELEdge<E>> l = new LinkedList<>();
        for(ELEdge<E> e: edgeList){
            if(e.getStart() == elVertex || e.getEnd() == elVertex){
                l.add(e);
            }
        }

        for(ELEdge<E> elem: l){
            edgeList.remove(elem);
        }

        return val;
    }

    @Override
    public E removeEdge(Edge<E> edge) { //O(1)
        ELEdge<E> elEdge = checkEdge(edge);
        E val = elEdge.getElement();
        edgeList.remove(elEdge);
        return val;
    }

    private ELEdge<E> checkEdge(Edge<E> edge) {
        if (edge instanceof ELEdge){
            ELEdge<E> e = (ELEdge<E>)edge;
            if (e.getGraph() == this) {
                return e;
            }
        }
        throw new RuntimeException("The edge is not in the graph");
    }

    private ELVertex<V> checkVertex(Vertex<V> vertex) {
        if (vertex instanceof ELVertex){
            ELVertex<V> v = (ELVertex<V>)vertex;
            if (v.getGraph() == this) {
                return v;
            }
        }
        throw new RuntimeException("The vertex is not in the graph");
    }

}