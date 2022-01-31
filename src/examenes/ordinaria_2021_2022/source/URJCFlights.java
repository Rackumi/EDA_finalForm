package examenes.ordinaria_2021_2022.source;

import practicas.practica2.Pair;

import java.util.List;

/**
 *
 * @author Rackumi
 */
public class URJCFlights {

    /**
     * Adds a new airfield to the company
     * @param novel
     */
    public void newAirport(Airport novel){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
    }
    
    /**
     * Adds new connections between company's airfields 
     * @param novel
     * @param links
     */
    public void newConnection(Airport novel, List<Pair<Airport,Integer>> links){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    /**
     * Adds a new flight from the airport passed as a parameter. 
     * The flight can only be added if there is a connection to the destination airport.
     * @param airfield     
     * @param flight     
     */
    public void newFlight(Airport airfield, Flight flight){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               
    }
    
    /**
     * Returns the list of all airports to which flights can be added.
     * @param departure
     * @return 
     */
    public List<Airport> availableAirportsConnection(Airport departure){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
   
    /**
     * Returns the list of available flights from the airport
     * @param departure     
     * @return      
     */
    public List<Flight> availableFlights(Airport departure){
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Returns the list of flights that are available from the origin airport to the destination airport. 
     * If no flights are available, null is returned.
     * @param departure     
     * @param destination     
     * @return      
     */
    public List<Flight> searchItinerary(Airport departure, Airport destination){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

}