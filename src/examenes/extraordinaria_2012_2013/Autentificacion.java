package examenes.extraordinaria_2012_2013;

import structures.notOrderedMapsAndDictionaries.Entry;
import structures.notOrderedMapsAndDictionaries.maps.HashTableMapDH;
import structures.notOrderedMapsAndDictionaries.maps.Map;

import java.util.Objects;

public class Autentificacion {

    static Map<String, String> bd;

    public Autentificacion(){

    }

    public static void impresion(Map<String, String> bd){
        for(Entry<String, String> entry: bd.entries()){
            System.out.println(entry);
        }
    }

    public static boolean login(String k, String v){
        return bd.get(k) != null && Objects.equals(bd.get(k), v);
    }

    public static void main(String[] srgs){
        bd = new HashTableMapDH<>();
        bd.put("A","1");
        bd.put("B","2");
        bd.put("C","3");
        bd.put("D","4");
        bd.put("E","5");
        bd.put("F","6");
        bd.put("G","7");
        bd.put("H","8");
        bd.put("I","9");
        bd.put("J","10");
        bd.put("K","11");
        impresion(bd);

        if(login("A","7")){
            System.out.println("si");
        }
        else{
            System.out.println("no");
        }

        if(login("B","1")){
            System.out.println("si");
        }
        else{
            System.out.println("no");
        }

        if(login("C","3")){
            System.out.println("si");
        }
        else{
            System.out.println("no");
        }

    }

}