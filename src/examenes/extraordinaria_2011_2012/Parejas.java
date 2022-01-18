package examenes.extraordinaria_2011_2012;

import structures.notOrderedMapsAndDictionaries.Entry;
import structures.notOrderedMapsAndDictionaries.maps.HashTableMapDH;
import structures.notOrderedMapsAndDictionaries.maps.Map;

import java.util.ArrayList;
import java.util.Arrays;

public class Parejas {

    static Map<Integer, Integer> pares = new HashTableMapDH<>();

    public static void parejas(ArrayList<Integer> array, Integer m){
        for(Integer p: array){
            if(p<=m){
                pares.put(p,null);
                if(pares.get(m-p)==null){
                    pares.put(p,m-p);
                    pares.put(m-p,p);
                }
            }
        }
    }

    public static void printMap(Map<Integer, Integer> map){
        for(Entry<Integer, Integer> p: map.entries()){
            if(p.getValue()!=null) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,3, 12, 23, 1, 2, 2));
        parejas(arrayList, 4);
        printMap(pares);
    }

}