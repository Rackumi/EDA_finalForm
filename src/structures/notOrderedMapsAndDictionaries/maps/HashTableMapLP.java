package structures.notOrderedMapsAndDictionaries.maps;

/**
 * Implementation for linear proof method
 *
 * @author Rackumi
 */
public class HashTableMapLP<K, V> extends AbstractHashTableMap<K, V> {

    int cont = 0; //practica 2

    public HashTableMapLP(int size) {
        super(size);
    }

    /**
     * Creates a hash table with prime factor 109345121 and capacity 1000.
     */
    public HashTableMapLP() {
        super();
    }

    //protected AbstractHashTableMap(int p, int cap)
    public HashTableMapLP(int p, int cap) {
        super(p, cap);
    }

    @Override
    protected int offset(K key, int i) {
        System.out.println("LP: "+this.cont++);
        return i;
    }

}