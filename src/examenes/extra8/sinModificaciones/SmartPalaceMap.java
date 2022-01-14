package examenes.extra8.sinModificaciones;

import examenes.extra8.sinModificaciones.Room;
import structures.graphs.Edge;
import structures.graphs.Vertex;
import structures.graphs.graph.ELGraph;
import structures.graphs.graph.Graph;

import java.util.*;

/**
 *
 * @author Rackumi
 */
public class SmartPalaceMap {

    Graph<Room, Integer> g = new ELGraph<>();
    Map<Room, Vertex<Room>> map = new HashMap<>();
    Deque<String> stack = new LinkedList<>();

    public SmartPalaceMap(){
        stack.push("G");
        stack.push("F");
        stack.push("E");
        stack.push("D");
        stack.push("C");
        stack.push("B");
        stack.push("A");
    }

    /**
    * @param connectedRooms Rooms connected to the new created room.
    *                      It can be null if there aren't any connected room.
    * @return The new created room.
    */
    public Room insertRoom(List<Room> connectedRooms) {
        String next = stack.pop();
        Room room = new Room(next);
        Vertex<Room> vertex = g.insertVertex(room);
        map.put(room, vertex);
        if (connectedRooms!=null && !connectedRooms.isEmpty()) {
            for (Room r : connectedRooms) {
                Vertex<Room> auxR = map.get(r);
                g.insertEdge(vertex, auxR, 0);
            }
        }
        return room;
    }
    
    /**
    * @param  room1 Initial room of the path.
    * @param  room2 Final room of the path.
    * @return the ordered list of rooms. 
    *         The first room will be room1 and the last one will be room2. 
    *         If no path is found it will return null.
    */
    public List<Room> getPath(Room room1, Room room2) {
        print();

        Set<Vertex<Room>> set = new HashSet<>();
        Deque<Vertex<Room>> s = new LinkedList<>();
        s.push(map.get(room1));

        while(!s.isEmpty()){
            Vertex<Room> v = s.pop();
            for(Edge<Integer> e: g.incidentEdges(v)){
                Vertex<Room> r = g.opposite(v, e);
                if(!set.contains(r)) {
                    set.add(r);
                    s.push(r);
                }
            }
        }

        return null;
    }

    private void print(){
        for(Vertex<Room> v: g.vertices()){
            for(Edge<Integer> e: g.incidentEdges(v)){
                Vertex<Room> opo = g.opposite(v, e);
                System.out.println(v.getElement()+"--"+opo.getElement());
            }
        }
    }

}