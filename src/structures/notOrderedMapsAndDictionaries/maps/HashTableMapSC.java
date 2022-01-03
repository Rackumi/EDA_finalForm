package structures.notOrderedMapsAndDictionaries.maps;

import structures.notOrderedMapsAndDictionaries.Entry;
import java.util.*;

/**
 * Separate chaining table implementation of hash tables in maps. Note that all "matching" is based on the equals method.
 *
 * @author Rackumi
 */
public class HashTableMapSC<K, V> implements Map<K, V> {

    private class HashEntry<T, U> implements Entry<T, U> {

        protected T key;
        protected U value;

        public HashEntry(T k, U v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public U getValue() {
            return this.value;
        }

        @Override
        public T getKey() {
            return this.key;
        }

        public U setValue(U val) {
            U aux = this.value;
            this.value = val;
            return aux;
        }

        @Override
        public boolean equals(Object o) {
            if(o.getClass() == this.getClass()){
                HashEntry<T,U> map = (HashEntry<T,U>) o;
                return this.key.equals(map.getKey()) && this.value.equals(map.getValue());
            }
            else{
                return false;
            }
        }

        /**
         * Entry visualization.
         */
        @Override
        public String toString() {
            return "Key: "+this.key+", Value: "+this.value;
        }
    }

    private class HashTableMapIterator<T, U> implements Iterator<Entry<T, U>> {

        private int bucketIndex;
        private Deque<Entry<T,U>> entryQueue;
        private List<HashEntry<T, U>>[] bucket;

        public HashTableMapIterator(List<HashEntry<T, U>>[] map, int numElems) {
            this.bucket = map;
            this.entryQueue = new LinkedList<>();
            if(numElems == 0)
                this.bucketIndex = bucket.length;
        }

        private void goToNextElement(int start){
            this.bucketIndex = start;
            while(this.bucketIndex < bucket.length && this.bucket[this.bucketIndex].isEmpty())
                this.bucketIndex++;
        }

        @Override
        public boolean hasNext() {
            if(entryQueue.isEmpty()){
                goToNextElement(this.bucketIndex + 1);
                if(this.bucketIndex < this.bucket.length){
                    for(Entry<T,U> e: this.bucket[this.bucketIndex])
                        entryQueue.push(e);
                }else
                    return false;
            }
            return true;
        }

        @Override
        public Entry<T, U> next() {
            if (hasNext()) {
                return entryQueue.pop();
            } else {
                throw new IllegalStateException("The map has not more elements");
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Obsolete method");
        }

    }

    private class HashTableMapKeyIterator<T, U> implements Iterator<T> {

        public HashTableMapIterator<T, U> it;

        public HashTableMapKeyIterator(HashTableMapIterator<T, U> it) {
            this.it = it;
        }

        @Override
        public T next() {
            return it.next().getKey();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Obsolete method");
        }

    }

    private class HashTableMapValueIterator<T, U> implements Iterator<U> {

        public HashTableMapIterator<T, U> it;

        public HashTableMapValueIterator(HashTableMapIterator<T, U> it) {
            this.it = it;
        }

        @Override
        public U next() {
            return it.next().getValue();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Obsolete method");
        }
    }

    protected int n; // number of entries in the dictionary
    protected int prime, capacity; // prime factor and capacity of bucket array
    protected long scale, shift; // the shift and scaling factors
    protected List<HashEntry<K, V>>[] bucket;// bucket array

    /**
     * Creates a hash table
     */
    public HashTableMapSC() {
        this(109345121,1000);
    }

    /**
     * Creates a hash table.
     *
     * @param cap initial capacity
     */
    public HashTableMapSC(int cap) {
        this(109345121,cap);
    }

    /**
     * Creates a hash table with the given prime factor and capacity.
     *
     * @param p prime number
     * @param cap initial capacity
     */
    public HashTableMapSC(int p, int cap) {
        this.n = 0;
        this.prime = p;
        this.capacity = cap;
        this.bucket = (List<HashEntry<K, V>>[]) new List[capacity];
        for (int i = 0; i < capacity; i++){
            bucket[i] = new LinkedList<>();
        }
        Random r = new Random();
        this.scale = r.nextInt(this.prime-1)+1;
        this.shift = r.nextInt(this.prime);
    }

    /**
     * Hash function applying MAD method to default hash code.
     *
     * @param key Key
     * @return
     */
    protected int hashValue(K key) { //h(y) = ((ay+b) mod p)mod N
        return (int) ((Math.abs(key.hashCode() * this.scale + this.shift) % this.prime) % this.capacity);
    }

    /**
     * Returns the number of entries in the hash table.
     *
     * @return the size
     */
    @Override
    public int size() {
        return this.n;
    }

    /**
     * Returns whether or not the table is empty.
     *
     * @return true if the size is 0
     */
    @Override
    public boolean isEmpty() {
        return n==0;
    }

    /**
     * Returns the value associated with a key.
     *
     * @param key
     * @return value
     */
    @Override
    public V get(K key) throws IllegalStateException {
        checkKey(key);
        int index = hashValue(key);
        for(HashEntry<K,V> e : bucket[index])
            if(key.equals(e.getKey()))
                return e.getValue();
        return null;
    }

    /**
     * Put a key-value pair in the map, replacing previous one if it exists.
     *
     * @param key
     * @param value
     * @return value
     */
    @Override
    public V put(K key, V value) throws IllegalStateException {
        checkKey(key);
        if(this.n > this.capacity/2){
            rehash(this.capacity*2);
        }
        int index = hashValue(key);
        for(HashEntry<K,V> e: this.bucket[index]){
            if(key.equals(e.getKey())){
                return e.setValue(value);
            }
        }
        this.bucket[index].add(new HashEntry<>(key, value));
        this.n++;
        return null;
    }

    /**
     * Removes the key-value pair with a specified key.
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) throws IllegalStateException {
        checkKey(key);
        int index = hashValue(key);
        V oldValue;
        for(HashEntry<K,V> e : this.bucket[index])
            if(key.equals(e.getKey())){
                oldValue = e.getValue();
                this.bucket[index].remove(e);
                this.n--;
                return oldValue;
            }
        return null;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new HashTableMapIterator<K, V>(this.bucket, this.n);
    }

    /**
     * Returns an iterable object containing all of the keys.
     *
     * @return
     */
    @Override
    public Iterable<K> keys() {
        return () -> new HashTableMapKeyIterator<K, V>(new HashTableMapIterator<K, V>(this.bucket, this.n));
    }

    /**
     * Returns an iterable object containing all of the values.
     *
     * @return
     */
    @Override
    public Iterable<V> values() {
        return () -> new HashTableMapValueIterator<K, V>(new HashTableMapIterator<K,V>(this.bucket, this.n));
    }

    /**
     * Returns an iterable object containing all of the entries.
     *
     * @return
     */
    @Override
    public Iterable<Entry<K, V>> entries() {
        return () -> new HashTableMapIterator<K,V>(this.bucket, this.n);
    }

    /**
     * Determines whether a key is valid.
     *
     * @param k Key
     */
    protected void checkKey(K k) {
        if (k == null) {
            throw new IllegalStateException("Invalid key: null.");
        }
    }

    /**
     * Increase/reduce the size of the hash table and rehashes all the entries.
     * @param newCap
     */
    protected void rehash(int newCap) {
        if (newCap < 2 * this.size())
            return;
        this.capacity = newCap;
        List<HashEntry<K, V>>[] old = this.bucket;
        this.bucket = (List<HashEntry<K, V>>[]) new List[this.capacity];
        for (int i = 0; i < this.capacity; i++)
            this.bucket[i] = new LinkedList<>();
        Random rand = new Random();
        this.scale = rand.nextInt(this.prime - 1) + 1;
        this.shift = rand.nextInt(this.prime);
        for(List<HashEntry<K,V>> l:old)
            for (HashEntry<K, V> e : l) {
                int index = hashValue(e.getKey());
                this.bucket[index].add(e);
            }
    }

}