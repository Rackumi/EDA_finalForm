package structures.linear.queue.floatQueue;

/**
 * Implementation for FloatLinkedQueue
 *
 * @author Rackumi
 */
public class FloatLinkedQueue implements QueueFloat{

    private class Node{

        private float element;
        private Node next;

        public Node(float element){
            this.element = element;
            this.next = null;
        }

        public float getElement() {
            return element;
        }

        public void setElement(float element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public void enqueue(Float element) {
        Node node = new Node(element);
        if(isEmpty()){
            this.head = node;
        }
        else{
            Node aux = this.tail;
            aux.setNext(node);
        }
        this.tail = node;
        this.size++;
    }

    @Override
    public Float dequeue() throws RuntimeException {
        if(!isEmpty()){
            float element = this.front();
            this.head = this.head.getNext();
            this.size--;
            return element;
        }
        throw new RuntimeException("The queue is empty");
    }

    @Override
    public Float front() throws RuntimeException {
        if(!isEmpty()){
            return this.head.getElement();
        }
        throw new RuntimeException("The queue is empty");
    }

}