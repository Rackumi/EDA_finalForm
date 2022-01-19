package examenes.extraordinaria_2020_2021;

import java.util.Arrays;
import java.util.Comparator;

public class HeapTree<E> { //este ejercicio es bastasta loco, no obesesionarse con él (no está bien resuelto)

    private int n;
    private int size;
    private E [] heap;
    private Comparator<E> comparator;
    private int capacity;

    public HeapTree(int capacity, int numChild) {
        size = 0;
        n = numChild;
        this.capacity = capacity;
        heap = (E[]) new Object[this.capacity];
        Arrays.fill(heap, -1);
        this.comparator = new DefaultComparator<>();
    }

    /** Función que comprueba si el heap está vacío **/
    public boolean isEmpty() {
        return size == 0;
    }

    /** Función que comprueba si el heap está lleno **/
    public boolean isFull() {
        return size == heap.length;
    }

    /** Función para vaciar el heap**/
    public void clear() {
        size = 0;
    }

    /** Función que devuelve el ínidce del padre del elemento en la posición i **/
    private int parent(int i) {
        return (i - 1) / n;
    }

    /** Función que devuelve el ínidce del hijo k (1 <= k <= n) del elemento en la posición i **/
    private int kthChild(int i, int k) {
        return n * i + k;
    }

    /** Función para devolver el mínimo elemento de un árbol **/
    public E findMin() {
        if (isEmpty())
            throw new RuntimeException("The tree is empty");
        return heap[0];
    }

    /** Función que devuelve el índice del menor hijo entre los del elemento que ocupa
     * la posición que se pasa por argumento **/
    private int minChild(int ind) {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);

        while ((k <= n) && (pos < size)) {
            if (comparator.compare(heap[pos], heap[bestChild]) < 0)
                bestChild = pos;
            pos = kthChild(ind, ++k);
        }
        return bestChild;
    }

    public String printHeap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
//            System.out.print(heap[i] + " ");
            sb.append(heap[i]).append(" ");
        }
//        System.out.println();
        return sb.toString();
    }

    /** Función para insertar un elemento nuevo en el heap **/
    public void insert(E x) {
        if(!isFull()){
            this.heap[size] = x;
            subirEnHeap(n);
            this.n++;
            this.size++;
        }
        else{
            this.resize();
            insert(x);
        }
    }

    /** Función para eliminar un elemento nuevo en el heap **/
    public E remove(int ind) {
        E aux = this.heap[ind];
        this.heap[ind] = null;
        this.size--;
        bajarEnHeap(ind);
        return aux;
    }

    /** Función para mantener el heap ordenado, colocando en
     * la raíz del árbol el nodo mínimo cuando un nodo se inserte **/
    private void subirEnHeap(int childInd) {
        this.heap[0] = this.heap[minChild(childInd)];
    }

    /** Función para mantener el heap ordenado, colocando en la posición
     del nodo eliminado el elemento que corresponda**/
    private void bajarEnHeap(int ind) {
        while(minChild(ind)>parent(ind)){
            subirEnHeap(ind);
        }
    }

    private void resize(){
        capacity = capacity * 2;
        E[] aux = (E[]) new Object[this.capacity];
        System.arraycopy(heap,0,aux,0,capacity/2);
        heap = aux;
    }

}