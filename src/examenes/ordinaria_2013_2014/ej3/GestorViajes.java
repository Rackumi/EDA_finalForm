package examenes.ordinaria_2013_2014.ej3;

import structures.notOrderedMapsAndDictionaries.Entry;
import structures.notOrderedMapsAndDictionaries.dictionaries1.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GestorViajes {

    Dictionary<String, Viaje> dicOrigen;
    Dictionary<String, Viaje> dicDestino;
    List<Viaje> viajes;
    Set<String> ciudads1viaje;

    public GestorViajes(){ //O(1)
        dicOrigen = new HashTableDictionarySC<>();
        dicDestino = new HashTableDictionarySC<>();
        viajes = new LinkedList<>();
        ciudads1viaje = new HashSet<>();
    }

    public void insertarViaje(String origen, String destino, int dur){ //O(1)
        Viaje viaje = new Viaje(origen, destino, dur);
        viajes.add(viaje);
        dicOrigen.insert(origen, viaje);
        dicDestino.insert(destino, viaje);
        ciudads1viaje.add(origen);
        ciudads1viaje.add(destino);
    }

    //O(1) seria O(m) siendo m el numero de viajes que tienen como origen esta ciudad
    public Iterable<Viaje> getOrigenes(String ciudad){
        List<Viaje> l = new LinkedList<>();
        for(Entry<String, Viaje> ent : dicOrigen.findAll(ciudad)){
            l.add(ent.getValue());
        }
        return l;
    }

    //O(1) seria O(m) siendo m el numero de viajes que tienen como destino esta ciudad
    public Iterable<Viaje> getDestinos(String ciudad){
        List<Viaje> l = new LinkedList<>();
        for(Entry<String, Viaje> ent : dicDestino.findAll(ciudad)){
            l.add(ent.getValue());
        }
        return l;
    }

    public Iterable<Viaje> getViajes(){ //O(1)
        return viajes;
    }

    public Iterable<String> getCiudades1Viaje(){ //O(1)
        return ciudads1viaje;
    }

}