package structures.linear.queue.genericQueue;

/**
 * Implementation for GenericLinkedQueue
 *
 * @author Rackumi
 */
public class GenericLinkedQueue<E> implements QueueGeneric<E> {

    private class Node<E>{

        private E element;
        private Node<E> next;

        public Node(E element){
            this.element = element;
            this.next = null;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private int size;
    private Node<E> head;
    private Node<E> tail;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public void enqueue(E element) {
        Node<E> node = new Node<E>(element);
        if(isEmpty()){
            this.head = node;
        }
        else{
            Node<E> aux = this.tail;
            aux.setNext(node);
        }
        this.tail = node;
        this.size++;
    }

    @Override
    public E dequeue() throws RuntimeException {
        if(!isEmpty()){
            E element = this.front();
            this.head = this.head.getNext();
            this.size--;
            return element;
        }
        throw new RuntimeException("The queue is empty");
    }

    @Override
    public E front() throws RuntimeException {
        if(!isEmpty()){
            return this.head.getElement();
        }
        throw new RuntimeException("The queue is empty");
    }

}