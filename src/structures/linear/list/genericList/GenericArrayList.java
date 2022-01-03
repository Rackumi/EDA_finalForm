package structures.linear.list.genericList;

import java.util.Arrays;

/**
 * Implementation for GenericArrayList
 *
 * @author Rackumi
 */
public class GenericArrayList<E> implements ListGeneric<E> {

    private E[] l;
    private int head;
    private int MAX_SIZE;

    public GenericArrayList(){
        this.MAX_SIZE = 10;
        l = (E[]) new Object[this.MAX_SIZE];
        this.head = 0;
    }

    @Override
    public int size() {
        return this.head;
    }

    @Override
    public boolean isEmpty() {
        return this.head==0;
    }

    @Override
    public void add(E value) {
        this.l[this.head] = value;
        this.head++;
    }

    @Override
    public void add(int index, E value) {
        if((index>=1)&&(index<=this.head)) {
            for(int i=this.head; i>=index-1; i--){
                l[i+1] = l[i];
            }
            l[index-1] = value;
            this.head++;
        }
        else{
            throw new RuntimeException("Not valid operation right now");
        }
    }

    @Override
    public E remove() {
        this.head--;
        return this.l[head];
    }

    @Override
    public E remove(int index) {
        if((index>=1)&&(index<=this.head)) {
            E aux = l[index-1];
            if (this.head - (index - 1) >= 0) {
                System.arraycopy(l, index - 1, l, index - 1 - 1, this.head - (index - 1));
            }
            return aux;
        }
        else{
            throw new RuntimeException("Not valid operation right now");
        }
    }

    @Override
    public E get() {
        return this.l[head-1];
    }

    @Override
    public E get(int index) {
        if((index>=1)&&(index<=this.head)) {
            return l[index-1];
        }
        else{
            throw new RuntimeException("Not valid operation right now");
        }
    }

    @Override
    public int search(E value) {
        if(!isEmpty()){
            for(int i=this.head-1; i>=0; i--){
                if(this.l[i].equals(value)){ //ya no nos valdria el == y habrá que usar equals para comparar objetos
                    return this.head-i;
                }
            }
        }
        return 0;
    }

    @Override
    public boolean contains(E value) {
        int position = search(value);
        return position != 0;
    }
    
}