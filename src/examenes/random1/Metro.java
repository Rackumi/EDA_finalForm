package examenes.random1;

import structures.graphs.Vertex;
import structures.graphs.graph.ALGraph;
import structures.graphs.graph.Graph;
import structures.graphs.graphAlgorithms.Recorridos;

import java.util.*;

public class Metro {

    List<Line> lines;
    Map<Integer, Line> map;
    Graph<String, Integer> g;
    Map<String , Vertex<String>> vm;
    int id;

    public Metro(){
        id = 0;
        lines = new LinkedList<>();
        map = new HashMap<>();
        g = new ALGraph<>();
        vm = new HashMap<>();
    }

    public int numberOfLines(){
        return lines.size();
    }

    public Line getLine(int lineNumber){
        return map.get(lineNumber);
    }

    public int addLine(){
        id++;
        Line newLine = new Line();
        map.put(id, newLine);
        return id;
    }

    public void addStationToLine(int lineNumber, String stationName){
        Line line = map.get(lineNumber);
        line.addStation(stationName);
        vm.put(stationName, g.insertVertex(stationName));
    }

    public List<String> pathBetweenStations(String startStationName, String endStationName){
        Recorridos<String, Integer> recorridos = new Recorridos<>();
        Map<Vertex<String>, Vertex<String>> m = recorridos.dijkstra(g, vm.get(startStationName));
        List<String> l = new LinkedList<>();
        while(m.get(vm.get(endStationName)).getElement() != null){
            l.add(m.get(vm.get(endStationName)).getElement());
            endStationName = m.get(vm.get(endStationName)).getElement();
        }
        l.add(endStationName);
        Collections.reverse(l);
        return l;
    }

    //Se presupone que en test ya se han creado las aristas ke unen a cada estacion ya que no nos dan ninguna informacion al respecto

}