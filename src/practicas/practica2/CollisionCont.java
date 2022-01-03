package practicas.practica2;

import structures.notOrderedMapsAndDictionaries.maps.*;
import structures.notOrderedMapsAndDictionaries.maps.Map;

import java.util.Random;

public class CollisionCont {

    private static Map<Integer, String> mapLP = new HashTableMapLP<>();
    private static Map<Integer, String> mapQP = new HashTableMapQP<>();
    private static Map<Integer, String> mapDH = new HashTableMapDH<>();

    public static void main(String[] args) {
        for (int i = 0; i < 15000; i++) {
            Random r = new Random();
            int x = r.nextInt();
            mapLP.put(x, "i1");
            mapQP.put(x, "i2");
            mapDH.put(x, "i3");
        }
    }

    //LP -> 14290
    //QP -> 12581
    //DH -> 12488

}