package practicas.practica2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rackumi
 */
public class Organize {

    private Map<String, String> map;
    private List<Pair<String,String>> list;

    public Organize (List<Pair<String,String>> lista){

        this.list = lista;
        map = new HashMap<>();
        for(Pair<String, String> p: lista){
            map.put(p.getFirst(),p.getSecond());

        }
    }

    /**
     * Returns the itinerary to travel or thrown an exception
     * @return
     */
    public List<String> itineratio(){

        boolean exp = true;
        List<String> l = new LinkedList<>();
        String first = "";

        for(Pair<String, String> p: list){
            if(!map.containsValue(p.getFirst())){
                first = p.getFirst();
                exp = false;
            }
        }

        if(exp){
            throw new RuntimeException("No se puede pasar 2 veces por el mismo destino.");
        }

        String aux;
        l.add(first);

        while(map.isEmpty()){
            aux = map.remove(first);
            l.add(aux);
            first = aux;
        }

        return l;
    }

}