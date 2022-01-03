package examenes.extra1.source.canals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import structures.graphs.graphAlgorithms.BreadthSearch;
import structures.graphs.graph.ELGraph;
import structures.graphs.Edge;
import structures.graphs.Vertex;

/**
 *
 * @author Rackumi
 */
public class CanalizationManager {

	ELGraph <CanalizationElement,Integer> red = new ELGraph<CanalizationElement,Integer> ();
	
    /**
     * Adds a house to the network.
     *
     * @param house The house to be added.
     * @param central The central in which the house is added
     * @param lps The liters per second of the connection between the house and
     * the central.
     */
    public void addHouse(House house, Central central, int lps) {
        Vertex<CanalizationElement> casa = red.insertVertex(house);
        Vertex<CanalizationElement> fabrica = red.insertVertex(central);
        
        red.insertEdge(casa, fabrica, lps);
        
    }

    /**
     * Adds a central to the network
     *
     * @param central The central to be added.
     * @param centralList The central list to which this central is connected
     * @param lps The lps for each central in centralList
     */
    public void addCentral(Central central, List<Central> centralList, List<Integer> lps) {
        Vertex<CanalizationElement> vertice_origen = red.insertVertex(central);
        
        Iterator<Central> it1 = centralList.iterator();
        Iterator<Integer> it2 = lps.iterator();
        while (it1.hasNext()) {
        	Central c = it1.next();
        	Integer peso = it2.next();
        	Vertex<CanalizationElement> vertice_destino = red.insertVertex(c);
        	red.insertEdge(vertice_origen, vertice_destino, peso);
        }
        
    }

    /**
     *
     * @param c
     * @return the centrals connected to the central c
     */
    public List<Central> getCentrals(Central c) {
    	ArrayList<Central> almacen = new ArrayList<Central>();
    	Vertex<CanalizationElement> origen=null;
    	
        for (Vertex<CanalizationElement> vertice: red.vertices()) {
        	if (vertice.getElement()==c) {
        		origen = vertice;
        	}
        }
        
        for (Edge<Integer> arco: red.incidentEdges(origen)) {
        	Vertex<CanalizationElement> opuesto = red.opposite(origen, arco);
        	if (opuesto.getElement() instanceof Central)
        		almacen.add((Central) opuesto.getElement());
        }
        return almacen;
    }

    /**
     *
     *
     * @param h
     * @return the central connected to the house h
     */
    public Central getCentral(House h) {
    	Vertex<CanalizationElement> casa=null;
        for (Vertex<CanalizationElement> vertice: red.vertices()) {
        	if (vertice.getElement()==h) {
        		casa = vertice;
        	}
        }
        Central toReturn = null;
        for (Edge<Integer> arco: red.incidentEdges(casa)) {
        	Vertex<CanalizationElement> opuesto = red.opposite(casa, arco);
        	toReturn = (Central) opuesto.getElement();
        }
        return toReturn;
    }

    /**
     *
     * @param h
     * @param c
     * @return Return the number of jumps between house h and central c
     */
    public int findHops(House h, Central c) {
    	BreadthSearch<CanalizationElement,Integer> recorridos = new BreadthSearch<CanalizationElement,Integer>();
    	Vertex<CanalizationElement> origen=null;
        for (Vertex<CanalizationElement> vertice: red.vertices()) {
        	if (vertice.getElement()==h) {
        		origen = vertice;
        	}
        }
        
        Vertex<CanalizationElement> destino=null;
        for (Vertex<CanalizationElement> vertice: red.vertices()) {
        	if (vertice.getElement()==c) {
        		destino = vertice;
        	}
        }
    	List<Edge<Integer>> camino = recorridos.getPath(red, origen, destino);
    	
    	return camino.size();
    }

}