package structures.graphs.graphAlgorithms;

import structures.graphs.Edge;
import structures.graphs.Vertex;
import structures.graphs.graph.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Los grafos utilizados por kruscal deben tener valores double en sus aristas
 * El algoritmo de Kruskal tiene complejidad O(m log(m)), donde m es el número de aristas.
 *
 * @author Rackumi
 */
public class Kruskal <K> {

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

	private PriorityQueue<Edge<Double>> q;
	private List<Edge<Double>> mst;
	private List<Set<Vertex<K>>> sets;
	
	private void initKruskal(Graph<K, Double> graph) {
		mst = new ArrayList<>(graph.edges().size());
		sets = new ArrayList<>(graph.vertices().size());
		for (Vertex<K> v : graph.vertices()) {
			Set<Vertex<K>> s = new HashSet<>();
			s.add(v);
			sets.add(s);
		}
		q = new PriorityQueue<>();
                
		for (Edge<Double> e : graph.edges()) {
			q.add(e);
		}
	}
	
	private int getSetOf(Vertex<K> v) {
		int n = sets.size();
		for (int i=0;i<n;i++) {
			if (sets.get(i).contains(v)) {
				return i;
			}
		}
		return -1;
	}
	
	private void join(int s1, int s2) {
		sets.get(s1).addAll(sets.get(s2));
		sets.remove(s2);
	}
	
	public void print(Graph<K, Double> graph) {
		for (Edge<Double> e : mst) {
			List<Vertex<K>> endpoints = graph.endVertices(e);
			System.out.println(endpoints.get(0).getElement()+" -- "+endpoints.get(1).getElement()+": "+e.getElement());
		}
	}
	
	public void kruskal(Graph<K, Double> graph) {
		initKruskal(graph);
		while (mst.size() < graph.vertices().size()-1) {
			Edge<Double> e = q.poll();
			List<Vertex<K>> endpoints = graph.endVertices(e);
			int s1 = getSetOf(endpoints.get(0));
			int s2 = getSetOf(endpoints.get(1));
			if (s1 != s2) {
				mst.add(e);
				join(s1, s2);
			}
		}
	}

}