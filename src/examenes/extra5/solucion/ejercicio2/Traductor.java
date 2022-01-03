package examenes.extra5.solucion.ejercicio2;

import java.util.ArrayList;
import structures.notOrderedMapsAndDictionaries.Entry;
import structures.notOrderedMapsAndDictionaries.maps.HashTableMapLP;

/**
 *
 * @author Rackumi
 */
public class Traductor {
    
    HashTableMapLP<String, HashTableMapLP<String, String>> mapa;
    public Traductor () {
        mapa = new HashTableMapLP<String, HashTableMapLP<String, String>>();
    }
    
    public void añadir (String fuente, String traduccion, String idioma) {
        HashTableMapLP<String, String> mapa_peque = mapa.get (fuente);
        if (mapa_peque==null) {
            mapa_peque = new HashTableMapLP<> ();
            mapa_peque.put (idioma, traduccion);
            mapa.put (fuente, mapa_peque);
        }else {
            mapa_peque.put (idioma, traduccion);
        }
    }
    
    public String traducir (String fuente, String idioma) {
        HashTableMapLP<String, String> mapa_peque = mapa.get (fuente);
        if (mapa_peque==null) {
            throw new RuntimeException ("....");
        }
        
        String traduccion = mapa_peque.get (idioma);
        if (traduccion==null) {
            throw new RuntimeException ("....");
        }
        return traduccion;
    } 
    
    public void traducciones (String fuente, ArrayList<String> traducciones, ArrayList<String> idiomas) {
        HashTableMapLP<String, String> mapa_peque = mapa.get (fuente);
        if (mapa_peque!=null) {
            for (Entry<String, String> entry: mapa_peque.entries()){
                traducciones.add (entry.getValue());
                idiomas.add (entry.getKey());
            }
        }

    }

}

//public class Traductor {
//    HashTableMapLP<String, HashTableMapLP<String, String>> traducciones=
//            new HashTableMapLP<String, HashTableMapLP<String, String>>();
//
//
//    public void añadir (String palabra, String traducida, String idioma) {
//        HashTableMapLP<String, String> t = traducciones.get(palabra);
//
//        if (t==null) {
//            t = new HashTableMapLP<String, String>();
//            t.put(idioma, traducida);
//            traducciones.put(palabra, t);
//        }else {
//
//            t.put(idioma, traducida);
//        }
//    }
//
//    //Si el usuario solicita una traduccion de la palabra en un idioma que no tenemos,
//    //le devolvemos un null
//    public String traducir (String palabra, String idioma){
//        HashTableMapLP<String, String> t = traducciones.get(palabra);
//        return t.get(idioma);
//    }
//    /*
//    public Iterable<Entry<String, String>> traducciones (String palabra) {
//        HashTableMapLP<String, String> t = traducciones.get(palabra);
//
//        return t.entries();
//    }
//
//    */
//    public Iterable<Traduccion> traducciones (String palabra) {
//        HashTableMapLP<String, String> t = traducciones.get(palabra);
//        ArrayList<Traduccion> almacen = new ArrayList<Traduccion>();
//
//        for (Entry<String, String> entrada: t.entries()) {
//            Traduccion traduccion = new Traduccion ();
//            traduccion.idioma=entrada.getKey();
//            traduccion.traduccion=entrada.getValue();
//            almacen.add(traduccion);
//        }
//
//        return almacen;
//
//    }
//
//}