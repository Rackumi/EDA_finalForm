package examenes.extra7.ejercicio2;

import java.io.File;
import java.util.*;

/**
 *
 * @author Rackumi
 */
public class MRUCache {

    int cachesize;

    private Map<String, MyFile> cache;
    private Deque<String> mru;

    public MRUCache(int max) {
        cachesize = max;
        cache = new HashMap<>(cachesize);
        mru = new LinkedList<>();
    }

    public String getFile(String fname) {
        String f = cache.get(fname).getContents();

        if(f==null){
            MyFile mf = readFileFromDisk(fname);
        }
        else{
            mru.removeLast();
        }
        mru.addFirst(fname);


        return null;
    }

    protected MyFile readFileFromDisk(String fname) {
        return new MyFile ("");
    }

    public void printMRU() {
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