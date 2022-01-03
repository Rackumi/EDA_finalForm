package structures.linear.list.genericList;

/**
 * Implementation for GenericLinkedList
 *
 * @author Rackumi
 */
public class GenericLinkedList<E> implements ListGeneric<E> {

    private class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E element){
            this.element = element;
            this.next = null;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

    }

    private Node<E> head;
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public void add(E value) {
        Node<E> node = new Node<E>(value);
        node.setNext(this.head); //si esta vacia apuntará a null
        this.head = node;
        this.size++;
    }

    @Override
    public void add(int index, E value) {
        if((index>=1)&&(index<=this.size)) {
            Node<E> node = new Node<E>(value);
            if (index==1) {
                node.setNext(this.head);
                this.head = node;
            }
            else{
                Node<E> aux = head;
                for (int i = 0; i<index-1; i++) {
                    aux = aux.getNext();
                }
                Node<E> auxPrev = aux;
                aux = aux.getNext();

                auxPrev.setNext(node);
                node.setNext(aux);
            }
            this.size++;
        }
        else{
            throw new RuntimeException("Not valid operation right now");
        }
    }

    @Override
    public E remove() {
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        else{
            this.size--;
            Node<E> aux = this.head;
            this.head = this.head.getNext();
            return aux.getElement();
        }
    }

    @Override
    public E remove(int index) {
        if((index>=1)&&(index<=this.size)) {
            this.size--;
            if (index==1) {
                E auxElem = this.head.getElement();
                this.head = this.head.getNext();
                return auxElem;
            }
            else{
                Node<E> aux = head;
                E auxElem;
                for (int i = 1; i<index-1; i++) {
                    aux = aux.getNext();
                }
                auxElem = aux.getNext().getElement();
                aux.setNext(aux.getNext().getNext());
                return auxElem;
            }
        }
        else{
            throw new RuntimeException("Not valid operation right now");
        }
    }

    @Override
    public E get() {
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        else{
            return head.getElement();
        }
    }

    @Override
    public E get(int index) {
        if((index>=1)&&(index<=this.size)) {
            if (index==1) {
                return this.head.getElement();
            }
            else{
                Node<E> aux = head;
                E auxElem;
                for (int i = 1; i<index-1; i++) {
                    aux = aux.getNext();
                }
                auxElem = aux.getNext().getElement();
                return auxElem;
            }
        }
        else{
            throw new RuntimeException("Not valid operation right now");
        }
    }

    @Override
    public int search(E value) {
        if(!isEmpty()) {
            if (this.head.getElement().equals(value)) {
                return 1;
            }
            else {
                int cont = 1;
                Node<E> aux = this.head;
                while(cont<this.size) {
                    cont++;
                    aux = aux.getNext();
                    if (aux.getElement().equals(value)) {
                        return cont;
                    }
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