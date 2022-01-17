package examenes.extra7.solucion.ejercicio2;

import java.io.File;
import java.util.Deque;
import java.util.LinkedList;

import structures.notOrderedMapsAndDictionaries.Entry;
import structures.notOrderedMapsAndDictionaries.maps.HashTableMapDH;
import structures.notOrderedMapsAndDictionaries.maps.Map;

/**
 *
 * @author Rackumi
 */
public class MRUCache {
    int cachesize;

    Map<String,MyFile> cache;
    Deque<String> cola;
    
    public MRUCache(int max) {
        cachesize = max;
        cola = new LinkedList<>();
        cache = new HashTableMapDH<>();
    }

    public String getFile(String fname) {
        MyFile myfile = cache.get (fname);
        if (myfile==null) {
            myfile = readFileFromDisk (fname);
            if (cache.size()==cachesize) {
                String toDelete = cola.removeLast();
                cache.remove(toDelete);
                cola.addFirst(fname);
            }else {
                cola.add (fname);
            }
            cache.put (fname, myfile);
        }else {
            cola.remove(fname);
            cola.addFirst(fname);
        }
        
        return myfile.getContents();
    }

    protected MyFile readFileFromDisk(String fname) {
        return new MyFile ("");
    }

    public void printMRU() {
        for (Entry<String, MyFile> entrada: cache.entries()) {
            System.out.println (entrada.getKey());
        }
    }

    public static void main(String[] args) {
       // Number of entries in MRU cache is set to 10 
       MRUCache h1=new MRUCache(10);
        for (int i = 1; i <= 20; i++) {
            // files are stored in a subdirectory called data
            h1.getFile("data" + File.separatorChar + i);
        }
        h1.printMRU();
    }

}