package examenes.ordinaria_2021_2022.solution;

import java.time.LocalTime;
import java.util.Objects;

/**
 * @author Rackumi
 */
public class Flight {

    private Airport departure;
    private Airport arrival;
    private LocalTime time;

    public Flight(Airport departure, Airport arrival, LocalTime time) {
        this.departure = departure;
        this.arrival = arrival;
        this.time = time;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

}