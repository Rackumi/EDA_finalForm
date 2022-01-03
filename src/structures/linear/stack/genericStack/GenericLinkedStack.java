package structures.linear.stack.genericStack;

/**
 * Implementation for ELinkedStack
 *
 * @author Rackumi
 */
public class GenericLinkedStack<E> implements StackGeneric<E> {

    private class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> top;
    private int size;

    public GenericLinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public void push(E element) {
        Node<E> node = new Node<E>(element);
        if (!isEmpty()) {
            node.setNext(this.top);
        }
        this.top = node;
        this.size++;
    }

    @Override
    public E pop() throws RuntimeException {
        if(!isEmpty()){
            this.size--;
            Node<E> aux = this.top;
            this.top = this.top.getNext();
            return aux.getElement();
        }
        throw new RuntimeException("The stack is empty");
    }

    @Override
    public E top() throws RuntimeException {
        if(!isEmpty()){
            return top.getElement();
        }
        throw new RuntimeException("The stack is empty");
    }
    
}
