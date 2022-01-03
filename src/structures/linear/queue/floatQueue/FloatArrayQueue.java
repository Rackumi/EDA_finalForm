package structures.linear.queue.floatQueue;

/**
 * Implementation for FloatArrayQueue
 *
 * @author Rackumi
 */
public class FloatArrayQueue implements QueueFloat{

    private float[] q;
    private int tail; //el head sera la posicion 0
    private int MAX_SIZE;

    public FloatArrayQueue(int cap){
        this.q = new float[cap];
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
    public void enqueue(Float element) {
        if(this.tail == MAX_SIZE/2){
            MAX_SIZE *= 2;
            float[] q2 = new float[this.MAX_SIZE];
            System.arraycopy(q,0,q2,0,tail);
            q = q2;
        }
        this.q[this.tail] = element;
        tail++;
    }

    @Override
    public Float dequeue() throws RuntimeException {
        if(isEmpty()){
            throw new RuntimeException("The queue is empty");
        }
        float elem = this.q[0];
        System.arraycopy(q, 1, q, 0, this.tail - 1);
        this.tail--;
        return elem;
    }

    @Override
    public Float front() throws RuntimeException {
        if(isEmpty()){
            throw new RuntimeException("The queue is empty");
        }
        return this.q[0];
    }

}