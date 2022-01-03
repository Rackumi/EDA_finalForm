package examenes.ordinaria_2019_2020.ejercicio3;

import structures.notOrderedMapsAndDictionaries.maps.HashTableMapDH;
import structures.notOrderedMapsAndDictionaries.maps.Map;

public class LaResistencia {

    Map<String, Map<String,Integer>> map;

    public LaResistencia(){
        map = new HashTableMapDH<>();
    }

    public void addVisit(String name, int money, String month) {
        Map<String,Integer> mapPeke = map.get(name);
        if(mapPeke == null){
            mapPeke = new HashTableMapDH<>();
            mapPeke.put(month, money);
            map.put(name, mapPeke);
        }
        else{
            mapPeke.put(month, money);
        }
    }

    public Iterable<String> overMedian() {
        throw new RuntimeException("Not yet implemented");
    }

    public int moneyInMonth(String month){
        throw new RuntimeException("Not yet implemented");
    }

    public Iterable<?> visitsInMonth(String month){
        throw new RuntimeException("Not yet implemented");
    }

}