package examenes.extra6.ejercicio3;

import practicas.practica2.Pair;
import structures.graphs.Edge;
import structures.graphs.Vertex;
import structures.graphs.graph.Graph;

import java.util.*;

public class GraphUtils<V> {

	public Iterable<Edge<Integer>> getKruskal(Graph<V,Integer> g) {
		//Tipo Solucion
		Set<Edge<Integer>> arcos_seleccionados = new HashSet<>();
		//Para simular la columna de comp. Conexas
		Map<V,V> compConexas = new HashMap<V,V>();
		for (Vertex<V> v: g.vertices()) {
			compConexas.put(v.getElement(), v.getElement());
		}
		//Me guardo todos los arcos en una bolsa mia
		List<Edge<Integer>> todos_los_arcos = new LinkedList<>();
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

	private static class getKruskalComparator<E> implements Comparator<E>{
		@Override
		public int compare(E o1, E o2) {
			Edge<Integer> p1 = (Edge<Integer>)o1;
			Edge<Integer> p2 = (Edge<Integer>)o2;
			int key1 = p1.getElement();
			int key2 = p2.getElement();
			return key1 - key2;
		}
	}
	
	public Iterable <Edge <Integer>> getPrim(Graph <V,Integer> g) { //prim no entra en el examen
		return null;
	}

	private Edge<Integer> dameMasBarato(List<Edge<Integer>> todos_los_arcos) {
		Edge<Integer> mejor = todos_los_arcos.get(0);
		for (Edge<Integer> arco: todos_los_arcos) {
			if (arco.getElement()<mejor.getElement()) {
				mejor = arco;
			}
		}
		return mejor;

	}

}