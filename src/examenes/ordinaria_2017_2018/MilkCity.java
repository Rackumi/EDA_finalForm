package examenes.ordinaria_2017_2018;

import practicas.practica2.Pair;
import structures.graphs.Edge;
import structures.graphs.Vertex;
import structures.graphs.graph.ALGraph;
import structures.graphs.graph.Graph;
import structures.graphs.graphAlgorithms.Recorridos;
import structures.orderedMapsAndDictionaries.ordereddictionary.AVLOrderedDict;
import structures.orderedMapsAndDictionaries.ordereddictionary.Entry;

import java.util.*;

public class MilkCity {

    private Graph<Pair<Integer, Set<String>>, Integer> g = new ALGraph<>();

    public Vertex<Pair<Integer, Set<String>>> addTown(int numberTown, Set<String> milks){
        Pair<Integer, Set<String>> pair = new Pair<>();
        pair.setFirst(numberTown);
        pair.setSecond(milks);
        return g.insertVertex(pair);
    }

    public Edge<Integer> addRoad(Vertex<Pair<Integer, Set<String>>> v1, Vertex<Pair<Integer, Set<String>>> v2){
        return g.insertEdge(v1 ,v2, 1);
    }

    public void milkSafeTown(){
        AVLOrderedDict<Integer, Integer> dic = new AVLOrderedDict<>();
        for(Vertex<Pair<Integer, Set<String>>> v: g.vertices()){
            int dist = distCalculate(v);
            dic.insert(dist, v.getElement().getFirst());
        }
        for(Entry<Integer, Integer> ent : dic.findRange(dic.first().getKey(), dic.last().getKey())){ //para ver las distancias de las ciudades
            System.out.print("City: "+ent.getValue());
            System.out.println(" Dist: "+ent.getKey());
        }
        System.out.println("Camino minimo: "); //realmente va a coger 2, 3 o 5 ya que los tres tienen distancia 3
        System.out.print("City: "+dic.first().getValue());
        System.out.println(" Dist: "+dic.first().getKey());
    }

    public Integer distCalculate(Vertex<Pair<Integer, Set<String>>> v){
        Deque<Vertex<Pair<Integer, Set<String>>>> q = new LinkedList<>();
        Set<Vertex<Pair<Integer, Set<String>>>> visited = new HashSet<>();
        Set<String> milk = new HashSet<>();

        q.addFirst(v);
        int cont = 0;
        while(!q.isEmpty()){
            Vertex<Pair<Integer, Set<String>>> node = q.removeLast();
            if(!visited.contains(node)){
                milk.addAll(node.getElement().getSecond());
                if(milk.size() == 5){
                    return cont;
                }
                cont++;
                visited.add(node);
                for(Edge<Integer> e: g.incidentEdges(node)){
                    Vertex<Pair<Integer, Set<String>>> oppo = g.opposite(node, e);
                    q.addFirst(oppo);
                }
            }
        }
        return 0;
    }

    //creo que este está regular xq no va restando cuando cambia de camino pero xd
    public boolean survive(Vertex<Pair<Integer, Set<String>>> v, String lecheBebida, int n){
        Deque<Vertex<Pair<Integer, Set<String>>>> q = new LinkedList<>();
        Set<Vertex<Pair<Integer, Set<String>>>> visited = new HashSet<>();

        q.addFirst(v);
        int cont = 0;
        while(!q.isEmpty()){
            Vertex<Pair<Integer, Set<String>>> node = q.removeLast();
            if(!visited.contains(node)){
                if(node.getElement().getSecond().contains(lecheBebida)){
                    return cont<n;
                }
                cont++;
                visited.add(node);
                for(Edge<Integer> e: g.incidentEdges(node)){
                    Vertex<Pair<Integer, Set<String>>> oppo = g.opposite(node, e);
                    q.addFirst(oppo);
                }
            }
        }
        return false;
    }

    public int jumps(Vertex<Pair<Integer, Set<String>>> v1, Vertex<Pair<Integer, Set<String>>> v2){
        int cont = 0;
        Recorridos<Pair<Integer, Set<String>>, Integer> recorridos = new Recorridos<>();
        Map<Vertex<Pair<Integer, Set<String>>>, Vertex<Pair<Integer, Set<String>>>> map = recorridos.dijkstra(g, v1);
        while(map.get(v2) != null){
            cont++;
            v2 = map.get(v2);
        }

        return cont;
    }

    public static void main(String[] args){

        MilkCity milkCity = new MilkCity();

        Set<String> A = new HashSet<>();
        A.add("A");
        Set<String> B = new HashSet<>();
        B.add("B");
        Set<String> C = new HashSet<>();
        C.add("C");
        Set<String> DE = new HashSet<>();
        DE.add("D");
        DE.add("E");
        Set<String> AE = new HashSet<>();
        AE.add("A");
        AE.add("E");

        Vertex<Pair<Integer, Set<String>>> n1 = milkCity.addTown(1, AE);
        Vertex<Pair<Integer, Set<String>>> n2 = milkCity.addTown(2, C);
        Vertex<Pair<Integer, Set<String>>> n3 = milkCity.addTown(3, DE);
        Vertex<Pair<Integer, Set<String>>> n4 = milkCity.addTown(4, B);
        Vertex<Pair<Integer, Set<String>>> n5 = milkCity.addTown(5, B);
        Vertex<Pair<Integer, Set<String>>> n6 = milkCity.addTown(6, C);
        Vertex<Pair<Integer, Set<String>>> n7 = milkCity.addTown(7, A);

        milkCity.addRoad(n1, n2);
        milkCity.addRoad(n2, n3);
        milkCity.addRoad(n2, n4);
        milkCity.addRoad(n1, n4);
        milkCity.addRoad(n1, n6);
        milkCity.addRoad(n6, n7);
        milkCity.addRoad(n4, n7);
        milkCity.addRoad(n5, n7);
        milkCity.addRoad(n3, n5);

        milkCity.milkSafeTown();

        System.out.println(milkCity.survive(n1, "A", 2));

        System.out.println(milkCity.jumps(n1, n5));
    }

}