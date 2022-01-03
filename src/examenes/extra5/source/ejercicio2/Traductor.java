package examenes.extra5.source.ejercicio2;

import structures.notOrderedMapsAndDictionaries.Entry;
import structures.notOrderedMapsAndDictionaries.maps.HashTableMapDH;
import structures.notOrderedMapsAndDictionaries.maps.Map;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;
import java.util.Set;

/**
 *
 * @author Rackumi
 */
public class Traductor {

    Map<String, Map<String, String>> map;

    public Traductor(){
        map = new HashTableMapDH<>();
    }

    public void añadir (String fuente, String traduccion, String idioma) {
        Map<String, String> mAux = map.get(fuente);
        if(mAux == null){
            mAux = new HashTableMapDH<>();
            mAux.put(idioma, traduccion);
            map.put(fuente, mAux);
        }
        else{
            mAux.put(idioma, traduccion);
        }
    }
    
    public String traducir (String fuente, String idioma) {
        Map<String, String> mAux = map.get(fuente);
        if(mAux == null){
            throw new RuntimeException("Error");
        }

        String trad = mAux.get(idioma);
        if(trad == null){
            throw new RuntimeException("Error");
        }

        return trad;
    } 
    
    public void traducciones (String fuente, ArrayList<String> traducciones, ArrayList<String> idiomas) { //este se podria hacer con el metodo entries que hemos implementado nosotros en nuestros mapas
        Map<String, String> mAux = map.get(fuente);
        if(mAux == null){
            throw new RuntimeException("Error");
        }
        for(Entry<String, String> p: mAux.entries()){
            idiomas.add(p.getKey());
            traducciones.add(p.getValue());
        }
    }

}