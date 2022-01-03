package examenes.simulacro;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

import structures.graphs.Edge;
import structures.graphs.graph.Graph;
import structures.graphs.Vertex;

public class Ejercicio3 <V,E> {

	public boolean esConexo (Graph <V,E> g) {
		Collection <? extends Vertex <V> > vertices = g.vertices();
		if (vertices.isEmpty())
			return true;
		else {
			List<Vertex<V>> recorrido = recorridoAnchura (g, vertices.iterator().next());
			return (recorrido.size()==vertices.size());
		}
	}
	
	public boolean tieneCiclos (Graph <V,E> g) {
		Collection <? extends Vertex <V> > vertices = g.vertices();
		if (vertices.isEmpty())
			return false;
		else {
			Queue<Vertex<V>> cola = new ArrayDeque<Vertex<V>> ();
			ArrayList<Vertex<V>> recorrido = new ArrayList<Vertex<V>> ();
			cola.offer(vertices.iterator().next());

			while (!cola.isEmpty()) {
				Vertex<V> aux = cola.remove();
				if (!recorrido.contains(aux)) {
					recorrido.add(aux);
					ArrayList<Edge <E>> lista_arcos_incidentes =  (ArrayList<Edge<E>>) g.incidentEdges(aux);
					for (Edge <E> a: lista_arcos_incidentes) {
						Vertex<V> adyacente =  g.opposite(aux, a);
						if (!recorrido.contains(adyacente)) {
							cola.offer(adyacente);
						}else {
							return true;
						}
					}
				}else {
					return true;
				}
			}
			return false;
		}
	}
	
	public boolean esArbol (Graph <V,E> g) {
		return (!tieneCiclos (g) && esConexo (g));
	}
	
	public List <Vertex<V>> recorridoAnchura (Graph <V,E> g, Vertex <V> v1) {
		Queue<Vertex<V>> cola = new ArrayDeque<Vertex<V>> ();
		ArrayList<Vertex<V>> recorrido = new ArrayList<Vertex<V>> ();

		cola.offer(v1);

		while (!cola.isEmpty()) {
			Vertex<V> aux = cola.remove();
			if (!recorrido.contains(aux)) {
				recorrido.add(aux);
				ArrayList<Edge <E>> lista_arcos_incidentes =  (ArrayList<Edge<E>>) g.incidentEdges(aux);
				for (Edge <E> a: lista_arcos_incidentes) {
					Vertex<V> adyacente =  g.opposite(aux, a);
					if (!recorrido.contains(adyacente)) {
						cola.offer(adyacente);
					}
				}
			}
		}
		return recorrido;
	}

}