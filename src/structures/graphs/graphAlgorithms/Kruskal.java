package structures.graphs.graphAlgorithms;

import structures.graphs.Edge;
import structures.graphs.Vertex;
import structures.graphs.graph.Graph;

import java.util.*;

/**
 * Los grafos utilizados por kruscal deben tener valores double en sus aristas
 * El algoritmo de Kruskal tiene complejidad O(m log(m)), donde m es el número de aristas.
 *
 * @author Rackumi
 */
public class Kruskal <K,V,E> {

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
				for (Map.Entry<V,V> entrada: compConexas.entrySet()) {
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