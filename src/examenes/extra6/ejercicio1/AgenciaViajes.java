package examenes.extra6.ejercicio1;

import structures.orderedMapsAndDictionaries.ordereddictionary.*;

public class AgenciaViajes {

    private AbstractTreeOrderedDict<Integer, String> treeMap = new BSTOrderedDict<>();

    public AgenciaViajes(){
        treeMap.insert(2, "Barcelona");
        treeMap.insert(5, "Munich");
        treeMap.insert(10, "Tokio");
        treeMap.insert(13, "Sngapure");
        treeMap.insert(1, "Valencia");
        treeMap.insert(12, "Pekin");
        treeMap.insert(16, "Melbourne");
        treeMap.insert(14, "Tasmania");
        treeMap.insert(15, "Honolulu");
    }

    public void umbral(int n){
        for(Entry<Integer,String> p : treeMap.findRange(treeMap.first().getKey(), n)){
            System.out.println(p.getValue());
        }
    }

    public static void main(String[] args){
        AgenciaViajes obj = new AgenciaViajes(); //falla un poco xq el abb esta regular creo
        obj.umbral(15);
    }

}