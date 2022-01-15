package practicas.practica3;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Rackumi
 */
public class ReferenciasCruzadas {

    TreeMap<String, List<Integer>> map;

    /**
    * Builds an ordered dictionary from a file
    * 
    * @param fichero
    * @throws java.io.IOException
    */
    public ReferenciasCruzadas(FileReader fichero) throws IOException{
//        Scanner sc = new Scanner(fichero).useDelimiter("[.,:;()?!\" \t\n\r]+");
        Scanner sc = new Scanner(fichero).useDelimiter("\\`|\\~|\\!|\\@|\\#|\\$|\\%|\\^|\\&|\\*|\\(|\\)|\\+|\\=|\\[|\\{|\\]|\\}|\\||\\\\|\\'|\\<|\\,|\\.|\\>|\\?|\\/|\\\"\"|\\;|\\:|\\s+");
        List<String> text = new LinkedList<>();
        while(sc.hasNext()){
            text.add(sc.next());
        }

        map = new TreeMap<>();
//        int cont = 1;
        int cont = 0;
        for(String p: text){
            List<Integer> l;
            if (!map.containsKey(p)) {
                l = new LinkedList<>();
            }
            else{
                l = map.get(p);
            }
            l.add(cont);
            map.put(p, l);
            cont++;
        }
        System.out.println(map);

    }
    
    /**
    * Returns the list of indexes that the word occupies in the text with which the dictionary has been built. 
    * If the word does not belong to the file returns null
    * @param word     
    * @return      
    */
    public List<Integer> apariciones(String word){
        if(map.get(word) != null) {
            return new LinkedList<>(map.get(word));
        }
        else{
            return null;
        }
    }
    
}