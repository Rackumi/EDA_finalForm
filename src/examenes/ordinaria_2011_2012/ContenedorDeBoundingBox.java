package examenes.ordinaria_2011_2012;

import structures.orderedMapsAndDictionaries.ordereddictionary.AVLOrderedDict;
import structures.orderedMapsAndDictionaries.ordereddictionary.Entry;

import java.util.LinkedList;
import java.util.List;

public class ContenedorDeBoundingBox {

    AVLOrderedDict<Integer, BoudingBox> dic = new AVLOrderedDict<>();

    public void insertBB(BoudingBox bb){
        dic.insert(bb.getArea(), bb);
    }

    public Iterable<BoudingBox> getBBs(int area){
        List<BoudingBox> l = new LinkedList<>();
        for(Entry<Integer, BoudingBox> ent: dic.findAll(area)){
            l.add(ent.getValue());
        }
        return l;
    }

}