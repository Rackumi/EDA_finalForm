package examenes.extra8.modificaciones;

import practicas.practica2.Pair;
import structures.Position;
import structures.graphs.Edge;
import structures.graphs.Vertex;
import structures.graphs.graph.ELGraph;
import structures.graphs.graph.Graph;
import structures.graphs.graphAlgorithms.Recorridos;
import structures.tree.Tree;
import structures.tree.narytree.LinkedTree;
import structures.tree.narytree.NAryTree;

import java.util.*;

/**
 *
 * @author Rackumi
 */
public class SmartPalaceMap {

    Graph<Room, Integer> g;
    Map<Room, Vertex<Room>> map;

    public SmartPalaceMap(List<Room> rooms){
        g =  new ELGraph<>();
        map = new HashMap<>();
        for(Room r: rooms) {
            Vertex<Room> v = g.insertVertex(r);
            map.put(r, v);
        }
    }

    /**
    * @param connectedRooms Rooms connected to the new created room.
    *                      It can be null if there aren't any connected room.
    * @return The new created room.
    */
    public void insertRoom(Room room, List<Room> connectedRooms) {
        Vertex<Room> vertex = map.get(room);
        if (connectedRooms!=null && !connectedRooms.isEmpty()) {
            for (Room r : connectedRooms) {
                Vertex<Room> auxR = map.get(r);
                g.insertEdge(vertex, auxR, 0);
            }
        }
    }
    
    /**
    * @param  room1 Initial room of the path.
    * @param  room2 Final room of the path.
    * @return the ordered list of rooms. 
    *         The first room will be room1 and the last one will be room2. 
    *         If no path is found it will return null.
    */
    public List<Room> getPath2(Room room1, Room room2) {
        Map<Room, Position<Room>> m = new HashMap<>();
        NAryTree<Room> t = new LinkedTree<>();
        Set<Vertex<Room>> set = new HashSet<>();
        Deque<Vertex<Room>> q = new LinkedList<>();

        m.put(room1, t.addRoot(room1));
        q.addFirst(map.get(room1));

        while(!q.isEmpty()){
            Vertex<Room> v = q.removeLast();
            Position<Room> parent = m.get(v.getElement());
            if(!set.contains(v)) {
                set.add(v);
                if(v.getElement() == room2){
                    return resultado(t,m.get(v.getElement()));
                }
                for (Edge<Integer> e : g.incidentEdges(v)) {
                    Vertex<Room> r = g.opposite(v, e);
                    q.addFirst(r);
                    if(!set.contains(r)) {
                        Position<Room> aux = t.add(r.getElement(), m.get(parent.getElement()));
                        m.put(r.getElement(), aux);
                    }
                }
            }
        }

        return null;
    }

    public List<Room> getPath(Room room1, Room room2) {
        Recorridos<Room, Integer> rec = new Recorridos<>();
        Map<Vertex<Room>, Vertex<Room>> m = rec.dijkstra(g, map.get(room1));
        List<Room> l = new LinkedList<>();
        while(m.get(map.get(room2)) != null){
            l.add(map.get(room2).getElement());
            room2 = m.get(map.get(room2)).getElement();
        }
        if(l.isEmpty()){
            return null;
        }
        l.add(room2);
        Collections.reverse(l);
        return l;
    }

    private List<Room> resultado(NAryTree<Room> t, Position<Room> pos){
        List<Room> l = new LinkedList<>();
        l.add(pos.getElement());
        while(t.parent(pos) != t.root()){
            pos = t.parent(pos);
            l.add(pos.getElement());
        }
        pos = t.parent(pos);
        l.add(pos.getElement());
        Collections.reverse(l);
        return l;
    }

    private void print(){
        for(Vertex<Room> v: g.vertices()){
            System.out.print(v.getElement()+"--");
            for(Edge<Integer> e: g.incidentEdges(v)){
                Vertex<Room> opo = g.opposite(v, e);
                System.out.print(opo.getElement()+" ");
            }
            System.out.println();
        }

    }

//    //1... CON PAIR
//    public List<Room> getPath(Room room1, Room room2) {
//        Deque<Vertex<Room>> deque = new ArrayDeque<>();
//        ArrayList<Vertex<Room>> visited = new ArrayList<>();
//        ArrayList<Pair<Room, HashSet<Room>>> pairs = new ArrayList<>();
//        deque.add(map.get(room1));
//        HashSet<Room> hashSetAnt = new HashSet<>();
//        pairs.add(new Pair<>(room1, hashSetAnt));
//        while (! deque.isEmpty()){
//            Vertex<Room> first = deque.removeFirst();
//            System.out.println("FIRST -- "+ first.getElement().getName());
//            if (! visited.contains(first)) {
//                visited.add(first);
//                if (first.getValue() == room2) {
//                    for (Pair<Room, HashSet<Room>> p : pairs){
//                        if(room2 == p.getFirst()){
//                            return devuelveCamino(p.getSecond());
//                        }
//                    }
//                }
//                for (Edge<Integer> e : grafo.incidentEdges(first)) {
//                    Vertex<Room> opposite = grafo.opposite(first, e);
//                    deque.add(opposite);
//                    if(!visited.contains(opposite)) {
//                        HashSet<Room> hashSet = buscaListaAnterior(pairs, first.getValue());
//                        addedElementoLista(pairs, first.getValue(), opposite.getValue(), hashSet);
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    private void addedElementoLista(ArrayList<Pair<Room, HashSet<Room>>> pairs, Room first, Room opp, HashSet<Room> hashSet){
//        hashSet.add(first);
//        Pair<Room, HashSet<Room>> par = new Pair<>(opp, hashSet);
//        pairs.add(par);
//    }
//
//    private HashSet<Room> buscaListaAnterior(ArrayList<Pair<Room, HashSet<Room>>> pairs, Room r){
//        for(Pair<Room, HashSet<Room>> pair : pairs){
//            if(pair.getFirst() == r){
//                return pair.getSecond();
//            }
//        }
//        return null;
//    }
//
//    private List<Room> devuelveCamino(HashSet<Room> hashSet){
//        LinkedList<Room> list = new LinkedList<>();
//        for (Room r : hashSet){
//            System.out.println(r.getName());
//            list.add(0, r);
//        }
//        return list;
//    }
//
}