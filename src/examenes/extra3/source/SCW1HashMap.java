package examenes.extra3.source;

/**
 *
 * @author Rackumi
 */
public class SCW1HashMap<K, V> {
    
    private class Entry {

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
        return 0;
    }

    /**
     * Inserta un par clave valor.
     * @param key La clave
     * @param value El valor
     */
    public void put(K key, V value) {
    }

    /**
     * Dada una clave devuelve el valor asociado.
     * @param key La clave
     * @throws IllegalStateException Si la clave no existe.
     * @return El valor.
     */
    public V get(K key) throws IllegalStateException {
        throw new IllegalStateException();
    }

    /**
     * Elimina el valor asociado a una clave.
     * @param key La clave
     * @throws IllegalStateException Si la clave no existe.
     */
    public void remove(K key) throws IllegalStateException {
        throw new IllegalStateException();
    }

}