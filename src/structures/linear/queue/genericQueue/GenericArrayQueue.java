package structures.linear.queue.genericQueue;

/**
 * Implementation for GenericArrayQueue
 *
 * @author Rackumi
 */
public class GenericArrayQueue<E> implements QueueGeneric<E> {

    private E[] q;
    private int tail; //el head sera la posicion 0
    private int MAX_SIZE;

    public GenericArrayQueue(int cap){
        this.q = (E[]) new Object[cap];
        this.tail = 0;
        this.MAX_SIZE = cap;
    }

    @Override
    public int size() {
        return this.tail;
    }

    @Override
    public boolean isEmpty() {
        return this.size()==0;
    }

    @Override
    public void enqueue(E element) {
        if(this.tail == MAX_SIZE/2){
            MAX_SIZE *= 2;
            E[] q2 = (E[]) new Object[this.MAX_SIZE];
            System.arraycopy(q,0,q2,0,tail);
            q = q2;
        }
        this.q[this.tail] = element;
        tail++;
    }

    @Override
    public E dequeue() throws RuntimeException {
        if(isEmpty()){
            throw new RuntimeException("The queue is empty");
        }
        E elem = this.q[0];
        System.arraycopy(q, 1, q, 0, this.tail - 1);
        this.tail--;
        return elem;
    }

    @Override
    public E front() throws RuntimeException {
        if(isEmpty()){
            throw new RuntimeException("The queue is empty");
        }
        return this.q[0];
    }

}