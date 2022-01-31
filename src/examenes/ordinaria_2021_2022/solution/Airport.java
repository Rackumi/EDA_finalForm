package examenes.ordinaria_2021_2022.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Rackumu
 */
public class Airport {

    private String airport;
    private List<Flight> vuelos = new LinkedList<>();

    public Airport(String airport) {
        this.airport = airport;
    }

    public List<Flight> getVuelos() {
        return this.vuelos;
    }

    public void addVuelos(Flight f) {
        if(vuelos == null){
            vuelos = new LinkedList<>();
        }
        this.vuelos.add(f);
    }

}