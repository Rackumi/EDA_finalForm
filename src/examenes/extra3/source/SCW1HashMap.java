package examenes.extra3.source;

import java.util.HashMap;

/**
 *
 * @author Rackumi
 *
 */
public class SCW1HashMap<K, V> {

    HashMap<K,V> bucket[] = new HashMap [100];;
    int size;

    public SCW1HashMap(){
        for (int i=0; i<bucket.length; i++) {
            bucket[i]= new HashMap<> ();
        }
        size=0;
    }

    private static class Entry<K,V> {

        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }        
    }
      
    /**
     * Deveulve el número de elementos almacenados en el objeto.
     * @return un entero.
     */
    public int size() {
        return size;
    }

    /**
     * Inserta un par clave valor.
     * @param key La clave
     * @param value El valor
     */
    public void put(K key, V value) {
        int posicion = key.hashCode() % 100;
        V ret = bucket[posicion].put(key, value);
        if(ret == null){
            size++;
        }
    }

    /**
     * Dada una clave devuelve el valor asociado.
     * @param key La clave
     * @throws IllegalStateException Si la clave no existe.
     * @return El valor.
     */
    public V get(K key) throws IllegalStateException {
        int posicion = key.hashCode() % 100;
        V ret = bucket[posicion].get(key);
        if(ret == null){
            throw new RuntimeException("error");
        }
        return ret;
    }

    /**
     * Elimina el valor asociado a una clave.
     * @param key La clave
     * @throws IllegalStateException Si la clave no existe.
     */
    public void remove(K key) throws IllegalStateException {
        int posicion = key.hashCode() % 100;
        V ret = bucket[posicion].remove(key);
        if(ret == null){
            throw new RuntimeException("error");
        }
        size--;
    }

}