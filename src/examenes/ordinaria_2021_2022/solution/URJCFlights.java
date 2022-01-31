package examenes.ordinaria_2021_2022.solution;

import java.util.*;

import practicas.practica2.Pair;
import structures.graphs.*;
import structures.graphs.graph.ELGraph;
import structures.graphs.graph.Graph;
import structures.graphs.graphAlgorithms.Recorridos;

/**
 *
 * @author mayte
 */
public class URJCFlights {

    Map<Airport, Vertex<Airport>> map = new HashMap<>();
    Map<Airport, Set<Flight>> vuelos = new HashMap<>();
    Graph<Airport, Integer> g = new ELGraph<>();

    /**
     * Adds a new airfield to the company
     * @param novel
     */
    public void newAirport(Airport novel){
        map.put(novel, g.insertVertex(novel));
    }
    
    /**
     * Adds new connections between company's airfields 
     * @param novel
     * @param links
     */
    public void newConnection(Airport novel, List<Pair<Airport,Integer>> links){
        for(Pair<Airport,Integer> p: links){
            if(!map.containsKey(p.getFirst())){
                throw new RuntimeException("La compañia no opera con ese aeropuerto.");
            }
            g.insertEdge(map.get(novel), map.get(p.getFirst()), p.getSecond());
        }
    }
    
    /**
     * Adds a new flight from the airport passed as a parameter. 
     * The flight can only be added if there is a connection to the destination airport.
     * @param airfield     
     * @param flight     
     */
    public void newFlight(Airport airfield, Flight flight){
        Vertex<Airport> origen = map.get(airfield);
        Vertex<Airport> destino = map.get(flight.getDeparture());
        Edge<Integer> edgeAd = g.areAdjacent(origen, destino);
        if(edgeAd != null){ //me esta dando null al hacer areAdjacent, si quitas el if pasa el test, pero entendemos que no puede haber vuelo si no hay arista
            origen.getElement().addVuelos(flight); //asumimos que solo lo metemos en el aeropuerto de origen
            if(vuelos.get(airfield) == null){
                Set<Flight> aux = new HashSet<>();
                aux.add(flight);
                vuelos.put(airfield, aux);
            }
            else{
                vuelos.get(airfield).add(flight);
            }
            airfield.addVuelos(flight);
        }
    }
    
    /**
     * Returns the list of all airports to which flights can be added.
     * @param departure
     * @return 
     */
    public List<Airport> availableAirportsConnection(Airport departure){
        List<Airport> l = new LinkedList<>();
        Vertex<Airport> v = map.get(departure);
        for(Edge<Integer> e: g.incidentEdges(v)){
            Vertex<Airport> oppo = g.opposite(v, e);
            l.add(oppo.getElement());
        }
        return l;
    }
   
    /**
     * Returns the list of available flights from the airport
     * @param departure     
     * @return      
     */
    public List<Flight> availableFlights(Airport departure){
       return departure.getVuelos();
//       return (List<Flight>) vuelos.get(departure); //tmb se podria hacer
    }
    
    /**
     * Returns the list of flights that are available from the origin airport to the destination airport. 
     * If no flights are available, null is returned.
     * @param departure     
     * @param destination     
     * @return      
     */
    public List<Flight> searchItinerary(Airport departure, Airport destination){
        Vertex<Airport> origen = map.get(departure);
        Vertex<Airport> destino = map.get(destination);
        Recorridos<Airport, Integer> recorrido = new Recorridos<>();
        List<Edge<Integer>> edgeList = recorrido.getPath(g, origen, destino);
        if(!edgeList.isEmpty()){
            List<Flight> l = new LinkedList<>();
            for(Edge<Integer> e: edgeList){
                List<Vertex<Airport>> airp = g.endVertices(e);
                Vertex<Airport> a1 = airp.get(0);
                Vertex<Airport> a2 = airp.get(1);
                Set<Flight> s1 = vuelos.get(a1.getElement());
                Set<Flight> s2 = vuelos.get(a2.getElement());
                for(Flight f: s1){
                    if(f.getDeparture()==departure && f.getArrival()==destination){
                        l.add(f);
                    }
                }
                for(Flight f: s2){
                    if(f.getDeparture()==departure && f.getArrival()==destination){
                        l.add(f);
                    }
                }
            }
            return l;
        }
        else{
            return null;
        }
    }

}