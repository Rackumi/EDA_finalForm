package structures.linear.list.floatList;

import java.util.Arrays;

/**
 * Implementation for FloatArrayList
 *
 * @author Rackumi
 */
public class FloatArrayList implements ListFloat{

    private float[] l;
    private int head;
    private int MAX_SIZE;

    public FloatArrayList(){
        this.MAX_SIZE = 10;
        l = new float[this.MAX_SIZE];
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
    public void add(Float value) {
        this.l[this.head] = value;
        this.head++;
    }

    @Override
    public void add(int index, Float value) {
        System.out.println(Arrays.toString(this.l));
        System.out.println("valor:"+value+"posicion:"+index);
        if((index>=1)&&(index<=this.head)) {
            for(int i=this.head; i>=index-1; i--){
                l[i+1] = l[i];
            }
            l[index-1] = value;
            System.out.println(Arrays.toString(this.l));
            this.head++;
        }
        else{
            throw new RuntimeException("Not valid operation right now");
        }
    }

    @Override
    public Float remove() {
        this.head--;
        return this.l[head];
    }

    @Override
    public Float remove(int index) {
        if((index>=1)&&(index<=this.head)) {
            float aux = l[index-1];
            if (this.head - (index - 1) >= 0) System.arraycopy(l, index - 1, l, index - 1 - 1, this.head - (index - 1));
            //for(int i=index-1; i<this.head; i++){
                //l[i-1] = l[i];
            //}
            return aux;

        }
        else{
            throw new RuntimeException("Not valid operation right now");
        }
    }

    @Override
    public Float get() {
        return this.l[head-1];
    }

    @Override
    public Float get(int index) {
        if((index>=1)&&(index<=this.head)) {
            return l[index-1];
        }
        else{
            throw new RuntimeException("Not valid operation right now");
        }
    }

    @Override
    public int search(Float value) {
        if(!isEmpty()){
            for(int i=this.head-1; i>=0; i--){
                if(this.l[i] == value){
                    return this.head-i;
                }
            }
        }
        return 0;
    }

    @Override
    public boolean contains(Float value) {
        int position = search(value);
        return position != 0;
    }
    
}