package structures.notOrderedMapsAndDictionaries.maps;

/**
 * Implementation for quadratic proof method
 *
 * @author Rackumi
 */
public class HashTableMapQP<K, V> extends AbstractHashTableMap<K, V> {

    int cont = 0; //practica 2

    public HashTableMapQP(int size) {
        super(size);
    }

    public HashTableMapQP() {
        super();
    }

    public HashTableMapQP(int p, int cap) {
        super(p,cap);
    }

    @Override
    protected int offset(K key, int i) {
        //return i*i;
        System.out.println("QP: "+this.cont++);
        return (17 * i + 13 * i^2);
    }

}