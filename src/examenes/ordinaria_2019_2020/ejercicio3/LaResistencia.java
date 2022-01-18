package examenes.ordinaria_2019_2020.ejercicio3;

import structures.notOrderedMapsAndDictionaries.maps.HashTableMapDH;
import structures.notOrderedMapsAndDictionaries.maps.Map;

import java.util.*;

public class LaResistencia {

    Map<String, Map<String, Integer>> map;

    SortedMap<String, Integer> orden;

    Map<String, Integer> monInMon;
    Map<String, Set<String>> visInMon;

    public LaResistencia(){
        map = new HashTableMapDH<>();
        orden = new TreeMap<>();
        monInMon = new HashTableMapDH<>();
        visInMon = new HashTableMapDH<>();
    }

    public void addVisit(String name, int money, String month) {
        Map<String, Integer> m = map.get(name);
        if(m == null){
            m = new HashTableMapDH<>();
            m.put(month, money);
            map.put(name, m);
        }
        else {
            m.put(month, money);
        }

        orden.put(name, money); //actualiza el valor anterior

        Integer aux = monInMon.get(month);
        if(aux == null){
            monInMon.put(month, money);
        }
        else{
            monInMon.put(month, money+aux);
        }

        Set<String> aux2 = visInMon.get(month);
        if(aux2 == null){
            Set<String> l = new HashSet<>();
            l.add(name);
            visInMon.put(month, l);
        }
        else{
            aux2.add(name);
            visInMon.put(month, aux2);
        }
    }

    public Iterable<String> overMedian() {
        List<String> l = new LinkedList<>();
        int median = orden.size()/2;
        Iterator<String> it = orden.keySet().iterator();
        int cont = 0;
        while(it.hasNext()) {
            String node = it.next();
            if(cont > median){
                l.add(node);
            }
            cont++;
        }
        return l;
    }

    public int moneyInMonth(String month){
        return monInMon.get(month);
    }

    public Iterable<?> visitsInMonth(String month){
        return visInMon.get(month);
    }

    public static void main(String[] args){
        LaResistencia lr = new LaResistencia();
        lr.addVisit("M", 12000, "Marzo");
        lr.addVisit("M", 200000, "Junio");
        lr.addVisit("A", 500000, "Junio");
        lr.addVisit("J", 20000, "Agosto");
        lr.addVisit("G", 1000000, "Septiembre");
        lr.addVisit("S", 75000, "Diciembre");
        lr.addVisit("H", 1000000, "Septiembre");

        System.out.println(lr.overMedian());
        System.out.println(lr.moneyInMonth("Septiembre"));
        System.out.println(lr.moneyInMonth("Junio"));
        System.out.println(lr.visitsInMonth("Septiembre"));
    }

}