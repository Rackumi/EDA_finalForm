package structures.notOrderedMapsAndDictionaries.maps;

/**
 * Implementation for double hashing method
 *
 * @author Rackumi
 */
public class HashTableMapDH<K, V> extends AbstractHashTableMap<K, V> {

    private int capacidad;
    int cont = 0; //practica 2

    public HashTableMapDH(int size) {
        super(size);
    }

    public HashTableMapDH() {
        super();
    }

    public HashTableMapDH(int p, int cap) {
        super(p, cap);
    }

    @Override
    protected int offset(K key, int i) {
        //si cambia la capacidad
        //hay utilizar la funcion que recalcule
//        return i + capacidad - (hashValue(key) % capacidad);
        System.out.println("DH: "+this.cont++);
//        return ((5437 - (Math.abs(hashValue(key)) % 691)) *i);
        return (5437-(i % 5437))*i;
    }
}
