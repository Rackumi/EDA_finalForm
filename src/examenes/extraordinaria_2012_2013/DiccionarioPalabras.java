package examenes.extraordinaria_2012_2013;

import structures.orderedMapsAndDictionaries.ordereddictionary.*;

import java.util.LinkedList;
import java.util.List;

public class DiccionarioPalabras {

    OrderedDictionary<Character, String> dictionary;

    public void crearDiccionarioVacio(){ //O(1)
        this.dictionary = new AVLOrderedDict<>();
    }

    public void insertarPalabra(String palabra){ //O(1)
        char inicial = palabra.charAt(0);
        this.dictionary.insert(inicial, palabra);
    }

    public Iterable<String> autocompletar(String palabra){ //O(m) siendo m el numero de palabras que empiezan por la primera letra del parametro
        List<String> l = new LinkedList<>();
        char inicial = palabra.charAt(0);
        for(Entry<Character, String> str: this.dictionary.findAll(inicial)){
            String p = str.getValue();
            if(p.startsWith(palabra)){
                l.add(p);
            }
        }
        return l;
    }

    public static void main(String[] srgs){

        DiccionarioPalabras diccionarioPalabras = new DiccionarioPalabras();
        diccionarioPalabras.crearDiccionarioVacio();

        diccionarioPalabras.insertarPalabra("comer");
        diccionarioPalabras.insertarPalabra("comerciable");
        diccionarioPalabras.insertarPalabra("comercial");
        diccionarioPalabras.insertarPalabra("comercializable");
        diccionarioPalabras.insertarPalabra("comercialización");
        diccionarioPalabras.insertarPalabra("comercializar");
        diccionarioPalabras.insertarPalabra("comercialmente");
        diccionarioPalabras.insertarPalabra("comerciante");
        diccionarioPalabras.insertarPalabra("comerciar");
        diccionarioPalabras.insertarPalabra("comercio");

        System.out.println(diccionarioPalabras.autocompletar("com"));
        System.out.println(diccionarioPalabras.autocompletar("c"));
        System.out.println(diccionarioPalabras.autocompletar("comer"));
        System.out.println(diccionarioPalabras.autocompletar("comercial"));
        System.out.println(diccionarioPalabras.autocompletar("comerciali"));
        System.out.println(diccionarioPalabras.autocompletar("comercializa"));
        System.out.println(diccionarioPalabras.autocompletar("comercialmente"));
        System.out.println(diccionarioPalabras.autocompletar("a"));

    }

}