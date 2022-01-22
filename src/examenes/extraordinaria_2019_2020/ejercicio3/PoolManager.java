package examenes.extraordinaria_2019_2020.ejercicio3;

import structures.notOrderedMapsAndDictionaries.dictionaries2.*;
import structures.orderedMapsAndDictionaries.ordereddictionary.*;

import java.util.LinkedList;
import java.util.List;

public class PoolManager {

    OAHashDictionary<String, String> objetosVecino = new OAHashDictionary<>();
    OrderedDictionary<Integer, String> time = new AVLOrderedDict<>();

    public Iterable<String> neighborsBetween(int start, int end) {
        List<String> l = new LinkedList<>();
        for(Entry<Integer, String> ent: time.findRange(start, end)){
            l.add(ent.getValue());
        }
        return l;
    }

    public void addObject(String neighbor, String object) {
        objetosVecino.put(neighbor, object);
    }

    public Iterable<String> getObjects(String neighbor) {
        List<String> l = new LinkedList<>();
        for(structures.notOrderedMapsAndDictionaries.Entry<String, String> ent: objetosVecino.findAll(neighbor)){
            l.add(ent.getValue());
        }
        return l;
    }

    public Iterable<String> objectsInPool(int start, int end) {
        List<String> l = new LinkedList<>();
        for(String neig: neighborsBetween(start, end)) {
            for(String obj: (getObjects(neig))){
                l.add(obj);
            }
        }
        return l;
    }

}