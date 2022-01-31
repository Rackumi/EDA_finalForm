package examenes.ordinaria_2021_2022.test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import examenes.ordinaria_2021_2022.solution.Airport;

import examenes.ordinaria_2021_2022.solution.Flight;
import examenes.ordinaria_2021_2022.solution.URJCFlights;
import org.junit.Test;
import practicas.practica2.Pair;

import static org.junit.Assert.*;

/**
 *
 * @author Rackumi
 */
public class URJCFlightsTest {
    
    private final Airport HJ, Sidney, Denver, Frankfurt, Dubai, Pekin, Singapore, Tokio, Paris, Madrid, LA, Heathrow;// = new Airport("Hartsfiel-Jackson") ;
  //  private final Airport Sidney = new Airport("Síndey");
    private final Flight v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22,v23,v24;
    private final Flight v25,v26,v27,v28,v29,v30,v31,v32,v33,v34,v35,v36,v37,v38,v39,v40,v41,v42,v43,v44,v45,v46;
    private final Flight v47,v48,v49,v50,v51,v52,v53,v54,v55,v56,v57,v58,v59,v60,v61,v62;

    public URJCFlightsTest() {
        HJ = new Airport("Hartsfiel-Jackson") ;
        Sidney = new Airport("Síndey");
        Denver = new Airport("Denver");
        Frankfurt = new Airport("Frankfurt");
        Dubai = new Airport("Dubai");
        Pekin = new Airport("Pekin");
        Singapore = new Airport("Singapore");
        Tokio = new Airport("Tokio");
        Paris = new Airport("Paris");
        Madrid = new Airport("Madrid");
        LA = new Airport("Los Angeles");
        Heathrow = new Airport("Heathrow");
        v1 = new Flight(HJ,Madrid,LocalTime.of(10,30));
        v2 = new Flight(Madrid,HJ,LocalTime.of(12, 0));
        v3 = new Flight(HJ,Frankfurt,LocalTime.of(9, 20));
        v4 = new Flight(Frankfurt,HJ,LocalTime.of(15, 30));
        v5 = new Flight(HJ,Paris,LocalTime.of(7, 15));
        v6 = new Flight(Paris,HJ,LocalTime.of(18, 0));
        v7 = new Flight(HJ,Dubai,LocalTime.of(6, 25));
        v8 = new Flight(Dubai,HJ,LocalTime.of(20, 20));
        v9 = new Flight(HJ,LA,LocalTime.of(21, 30));
        v10 = new Flight(LA,HJ, LocalTime.of(22, 0));
        v11 = new Flight(Sidney,HJ,LocalTime.of(7, 15));
        v12 = new Flight(HJ,Sidney,LocalTime.of(7, 30));
        v25 = new Flight(HJ,Denver,LocalTime.of(14,0));
        v26 = new Flight(Denver,HJ,LocalTime.of(16, 30));
        v27 = new Flight(HJ,Singapore,LocalTime.of(5,45));
        v28 = new Flight(Singapore,HJ,LocalTime.of(8, 10));
        v29 = new Flight(HJ,Tokio,LocalTime.of(10,10));
        v30 = new Flight(Tokio,HJ,LocalTime.of(9, 10));
        v31 = new Flight(HJ,Heathrow,LocalTime.of(7, 10));
        v32 = new Flight(Heathrow,HJ,LocalTime.of(19, 30));
        v13 = new Flight(Sidney, Singapore,LocalTime.of(10, 25) );
        v14 = new Flight(Singapore,Sidney,LocalTime.of(18, 0));
        v15 = new Flight(Sidney,Pekin,LocalTime.of(6, 15));
        v16 = new Flight(Pekin,Sidney,LocalTime.of(20, 10));
        v17 = new Flight(Sidney,Dubai,LocalTime.of(9, 30));
        v18 = new Flight(Dubai,Sidney,LocalTime.of(7, 30));
        v19 = new Flight(Sidney,Tokio,LocalTime.of(9, 0));
        v20 = new Flight(Tokio,Sidney,LocalTime.of(21, 20));
        v21 = new Flight(Sidney,Frankfurt,LocalTime.of(6, 30));
        v22 = new Flight(Frankfurt,Sidney,LocalTime.of(12, 15));
        v23 = new Flight(Heathrow,Madrid,LocalTime.of(7, 37));
        v24 = new Flight(Madrid,Heathrow, LocalTime.of(7, 35));
        v33 = new Flight(Heathrow,Frankfurt,LocalTime.of(8, 20));
        v34 = new Flight(Frankfurt,Heathrow,LocalTime.of(11, 0));
        v35 = new Flight(Heathrow,Paris,LocalTime.of(8, 15));
        v36 = new Flight(Paris,Heathrow,LocalTime.of(10, 15));
        v37 = new Flight(Heathrow,Dubai,LocalTime.of(19,25));
        v38 = new Flight(Dubai,Heathrow,LocalTime.of(6,45));
        v39 = new Flight(Heathrow,LA, LocalTime.of(21,40));
        v40 = new Flight(LA,Heathrow,LocalTime.of(9, 35));
        v41 = new Flight(Madrid,Frankfurt,LocalTime.of(19, 45));
        v42 = new Flight(Frankfurt,Madrid, LocalTime.of(15,20));
        v43 = new Flight(Madrid,Paris,LocalTime.of(8,25));
        v44 = new Flight(Paris,Madrid,LocalTime.of(11,50));
        v45 = new Flight(Madrid,Dubai,LocalTime.of(6, 55));
        v46 = new Flight(Dubai,Madrid,LocalTime.of(18,55));
        v47 = new Flight(LA,Denver,LocalTime.of(11, 42));
        v48 = new Flight(Denver,LA,LocalTime.of(13,40));
        v49 = new Flight(LA,Tokio,LocalTime.of(5, 50));
        v50 = new Flight(Tokio,LA,LocalTime.of(7, 15));
        v51 = new Flight(LA,Pekin,LocalTime.of(12, 0));
        v52 = new Flight(Pekin,LA,LocalTime.of(10, 10));
        v53 = new Flight(LA,Sidney,LocalTime.of(8,20));
        v54 = new Flight(Sidney,LA,LocalTime.of(7,55));
        v55 = new Flight(Tokio,Singapore,LocalTime.of(6,45));
        v56 = new Flight(Singapore,Tokio,LocalTime.of(11,15));
        v57 = new Flight(Tokio,Pekin,LocalTime.of(23,15));
        v58 = new Flight(Pekin,Tokio,LocalTime.of(6,35));
        v59 = new Flight(Tokio,Dubai,LocalTime.of(14,30));
        v60 = new Flight(Dubai,Tokio,LocalTime.of(13,10));
        v61 = new Flight(Tokio,Frankfurt,LocalTime.of(8, 25));
        v62 = new Flight(Frankfurt,Tokio,LocalTime.of(15,50));
    }

    private URJCFlights inicia(){
        URJCFlights instance = new URJCFlights();
        instance.newAirport(HJ);
        instance.newAirport(Sidney);
        instance.newAirport(Denver);
        instance.newAirport(Frankfurt);
        instance.newAirport(Dubai);
        instance.newAirport(Pekin);
        instance.newAirport(Singapore);
        instance.newAirport(Tokio);
        instance.newAirport(Paris);
        instance.newAirport(Madrid);
        instance.newAirport(LA);
        instance.newAirport(Heathrow);
        return instance;
    }
    
    private URJCFlights iniciaTodoSinVuelos(){
        URJCFlights nuevo = inicia();
        List<Pair<Airport, Integer>> links = new ArrayList<>();
        //Sidney
        links.add(new Pair<>(HJ,15000));
        links.add(new Pair<>(Singapore,6302));
        links.add(new Pair<>(Pekin,8943));
        links.add(new Pair<>(Dubai,12042));
        links.add(new Pair<>(Tokio,7819));
        links.add(new Pair<>(Frankfurt,16473));
        nuevo.newConnection(Sidney, links);
        links.clear();
        //HJ
        links.add(new Pair<>(Madrid,6939));
        links.add(new Pair<>(Denver,2257));
        links.add(new Pair<>(Singapore,16009));
        links.add(new Pair<>(Paris,7072));
        links.add(new Pair<>(Tokio,11038));
        links.add(new Pair<>(LA,3514));
        links.add(new Pair<>(Frankfurt,7397));
        links.add(new Pair<>(Heathrow,6746));
        links.add(new Pair<>(Dubai, 12200));
        nuevo.newConnection(HJ, links);
        links.clear();
        //Heathrow
        links.add(new Pair<>(Madrid,1254));
        links.add(new Pair<>(Frankfurt,658));
        links.add(new Pair<>(Paris,343));
        links.add(new Pair<>(Dubai,5492));
        links.add(new Pair<>(LA,8741));
        nuevo.newConnection(Heathrow, links);
        links.clear();
        //Madrid
        links.add(new Pair<>(Frankfurt,1446));
        links.add(new Pair<>(Paris,1103));
        links.add(new Pair<>(Dubai,5923));
        nuevo.newConnection(Madrid, links);
        links.clear();
        //LA
        links.add(new Pair<>(Denver,1366));
        links.add(new Pair<>(Tokio,8820));
        links.add(new Pair<>(Pekin,10062));
        links.add(new Pair<>(Sidney,12074));
        nuevo.newConnection(LA, links);
        links.clear();
        //Tokio
        links.add(new Pair<>(Singapore,5310));
        links.add(new Pair<>(Pekin,2093));
        links.add(new Pair<>(Dubai,7926));
        links.add(new Pair<>(Frankfurt,9342));
        nuevo.newConnection(Tokio, links);
        return nuevo;
    }
    
    private void todosVuelos(URJCFlights instance){
        //desde HJ
        instance.newFlight(HJ, v1);
        instance.newFlight(HJ, v3);
        instance.newFlight(HJ, v5);
        instance.newFlight(HJ, v7);
        instance.newFlight(HJ, v9);
        instance.newFlight(HJ, v12);
        instance.newFlight(HJ, v25);
        instance.newFlight(HJ, v27);
        instance.newFlight(HJ, v29);
        instance.newFlight(HJ, v31);
        //desde Madrid
        instance.newFlight(Madrid, v2);
        instance.newFlight(Madrid, v24);
        instance.newFlight(Madrid, v41);
        instance.newFlight(Madrid, v43);
        instance.newFlight(Madrid, v45);
        //Frankfurt
        instance.newFlight(Frankfurt, v4);
        instance.newFlight(Frankfurt, v22);
        instance.newFlight(Frankfurt, v34);
        instance.newFlight(Frankfurt, v42);
        instance.newFlight(Frankfurt, v62);
        //Paris
        instance.newFlight(Paris, v6);
        instance.newFlight(Paris, v36);
        instance.newFlight(Paris, v44);
        //Dubai
        instance.newFlight(Dubai, v8);
        instance.newFlight(Dubai, v18);
        instance.newFlight(Dubai, v38);
        instance.newFlight(Dubai, v46);
        instance.newFlight(Dubai, v60);
        //LA
        instance.newFlight(LA, v10);
        instance.newFlight(LA, v40);
        instance.newFlight(LA, v47);
        instance.newFlight(LA, v49);
        instance.newFlight(LA, v51);
        instance.newFlight(LA, v53);
        //Sidney
        instance.newFlight(Sidney, v11);
        instance.newFlight(Sidney, v13);
        instance.newFlight(Sidney, v15);
        instance.newFlight(Sidney, v17);
        instance.newFlight(Sidney, v19);
        instance.newFlight(Sidney, v21);
        instance.newFlight(Sidney, v54);
        //Denver
        instance.newFlight(Denver, v26);
        instance.newFlight(Denver, v48);
        //Singapore
        instance.newFlight(Singapore, v28);
        instance.newFlight(Singapore, v14);
        instance.newFlight(Singapore, v56);
        //Tokio
        instance.newFlight(Tokio, v30);
        instance.newFlight(Tokio, v20);
        instance.newFlight(Tokio, v50);
        instance.newFlight(Tokio, v55);
        instance.newFlight(Tokio, v57);
        instance.newFlight(Tokio, v59);
        instance.newFlight(Tokio, v61);
        //Heathrow
        instance.newFlight(Heathrow, v32);
        instance.newFlight(Heathrow, v23);
        instance.newFlight(Heathrow, v33);
        instance.newFlight(Heathrow, v35);
        instance.newFlight(Heathrow, v37);
        instance.newFlight(Heathrow, v39);
        //Pekin
        instance.newFlight(Pekin, v16);
        instance.newFlight(Pekin, v52);
        instance.newFlight(Pekin, v58);
        
    }
    
    private Set<Airport> soloAeropuertos(List<Pair<Airport, Integer>> links) {
        Set<Airport> c = new HashSet<>();
        
        for (Pair<Airport,Integer> p : links) {
            c.add(p.getFirst());       
        }
        return c;
    }

    /**
     * Test of newAirport method, of class URJCFlights.
     */
    @Test
    public void testNewAirportAndNewConnection() {
        System.out.println("newAirport");
        URJCFlights instance = inicia();
        List<Pair<Airport, Integer>> links = new ArrayList<>();
        //Sidney
        links.add(new Pair<>(HJ,15000));
        links.add(new Pair<>(Singapore,6302));
        links.add(new Pair<>(Pekin,8943));
        links.add(new Pair<>(Dubai,12042));
        links.add(new Pair<>(Tokio,7819));
        links.add(new Pair<>(Frankfurt,16473));
        instance.newConnection(Sidney, links);
        List<Airport> conexion = instance.availableAirportsConnection(Sidney);
        assertEquals(conexion.size(),links.size());
        links.clear();
        //HJ
        links.add(new Pair<>(Madrid,6939));
        links.add(new Pair<>(Denver,2257));
        links.add(new Pair<>(Singapore,16009));
        links.add(new Pair<>(Paris,7072));
        links.add(new Pair<>(Tokio,11038));
        links.add(new Pair<>(LA,3514));
        links.add(new Pair<>(Frankfurt,7397));
        links.add(new Pair<>(Heathrow,6746));
        links.add(new Pair<>(Dubai, 12200));
        instance.newConnection(HJ, links);
        conexion = instance.availableAirportsConnection(HJ);
        assertEquals(conexion.size(),links.size()+1);
        Set<Airport> c = soloAeropuertos(links);
        c.add(Sidney);
        
        assertTrue(c.containsAll(conexion));       
        
    }

    /**
     * Test of newFlight method, of class URJCFlights.
     */
    @Test
    public void testNewFlightAvailableFlights() {
        System.out.println("newFlight");
        URJCFlights instance = inicia();
        try{
            instance.newFlight(HJ, v1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        instance = iniciaTodoSinVuelos();//Conexiones on, ya se pueden añadir vuelos
        todosVuelos(instance);
        List<Flight> availableFlights = instance.availableFlights(Paris);
        Set<Flight> c = new HashSet<>(availableFlights);
        List<Flight> l= Arrays.asList(v6,v36,v44);
        assertEquals(c.size(),l.size());
        assertTrue(c.containsAll(l));
    }

    /**
     * Test of searchItinerary method, of class URJCFlights.
     */
    @Test
    public void testSearchItinerary() {
        System.out.println("searchItinerary");
        Airport departure = Sidney;
        Airport destination = Madrid;
        URJCFlights instance = iniciaTodoSinVuelos();
        List<Flight> expResult = null;
        List<Flight> result = instance.searchItinerary(departure, destination);
        assertEquals(expResult, result);
        todosVuelos(instance);
        expResult = Arrays.asList(v21,v42);
        result = instance.searchItinerary(departure, destination);
        assertEquals(expResult.size(),result.size());
        Iterator<Flight> ite = expResult.iterator();
        for (Flight flight : result) {
            assertEquals(ite.next(),flight);
        }
        
    }

    /**
     * Test of availableAirports method, of class URJCFlights.
     */
    @Test
    public void testAvailableAirportsConnection() {
        System.out.println("availableAirports");
        URJCFlights instance = inicia();
        List<Airport> expResult = new ArrayList<>();
        List<Airport> result = instance.availableAirportsConnection(HJ);
        assertEquals(expResult, result);
        instance = iniciaTodoSinVuelos();
        result = instance.availableAirportsConnection(HJ);
        expResult = Arrays.asList(Sidney, Denver, Frankfurt, Dubai, Singapore, Tokio, Paris, Madrid, LA, Heathrow);
        Set<Airport> c1 = new HashSet<>(result);
        c1.containsAll(expResult);
        assertEquals(c1.size(),expResult.size());
       
    }

}