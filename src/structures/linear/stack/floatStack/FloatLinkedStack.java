package structures.linear.stack.floatStack;

/**
 * Implementation for FloatLinkedStack
 *
 * @author Rackumi
 */
public class FloatLinkedStack implements StackFloat{

    private class Node{

        private float element;
        private Node next;

        public Node(float element) {
            this.element = element;
            this.next = null;
        }

        public float getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public void setElement(float element) {
            this.element = element;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node top;
    private int size;

    public FloatLinkedStack() {
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
    public void push(Float element) {
        Node node = new Node(element);
        if (!isEmpty()) {
            node.setNext(this.top);
        }
        this.top = node;
        this.size++;
    }

    @Override
    public Float pop() throws RuntimeException {
        if(!isEmpty()){
            this.size--;
            Node aux = this.top;
            this.top = this.top.getNext();
            return aux.getElement();
        }
        throw new RuntimeException("The stack is empty");
    }

    @Override
    public Float top() throws RuntimeException {
        if(!isEmpty()){
            return top.getElement();
        }
        throw new RuntimeException("The stack is empty");
    }
    
}
