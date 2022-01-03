package structures.linear.list.positionList;

import structures.Position;
import java.util.Iterator;

/**
 * Implementation for PositionLinkedList
 *
 * @author Rackumi
 */
public class PositionLinkedList<E> implements ListPosition<E> {

    private class Node<T> implements Position<E> {

        private Node<E> prev, next;
        private E element;

        public Node(Node<E> prev, Node<E> next, E element) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return this.prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setElement(E element) {
            this.element = element;
        }

        @Override
        public E getElement() {
            return this.element;
        }

    }

    private Node<E> head;
    private int size;

    public PositionLinkedList(){
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Position<E> add(E value) {
        Node<E> n = new Node<>(null, this.head, value);
        if(!isEmpty()){
            this.head.setPrev(n);
        }
        this.head = n;
        this.size++;
        return n;
    }

    @Override
    public Position<E> addAfter(Position<E> pos, E value) {
        Node<E> prev = checkPosition(pos);
        Node<E> node = new Node<>(prev, prev.getNext(), value);
        prev.setNext(node);

        if( node.getNext() != null) {
            node.getNext().setPrev(node);
        }
        this.size++;
        return node;
    }

    @Override
    public Position<E> addBefore(Position<E> pos, E value) {
        Node<E> next = checkPosition(pos);
        Node<E> node = new Node<>(next.getPrev(), next, value);

        if(this.head == next){
            this.head = node;
        }
        else{
            next.getPrev().setNext(node);
        }
        next.setPrev(node);
        this.size++;
        return node;
    }

    @Override
    public E remove(Position<E> pos) {
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        Node<E> n = checkPosition(pos);
        if(this.head == n){
            this.head = n.getNext();
        }
        else{
            if(n.getNext() != null){
                n.getPrev().setNext(n.getNext());
                n.getNext().setPrev(n.getPrev());
            }
            else{
                n.getPrev().setNext(null);
            }
        }
        this.size--;
        return n.getElement();
    }

    @Override
    public Position<E> get() {
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        return this.head;
    }

    @Override
    public Position<E> set(Position<E> pos, E value) {
        Node<E> n = checkPosition(pos);
        n.setElement(value);
        return n;
    }

    @Override
    public Position<E> search(E value) {
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        Node<E> aux = this.head;
        while(aux.getNext() != null){
            if(aux.getElement() == value){
                return aux;
            }
            aux = aux.getNext();
        }
        return null;
    }

    @Override
    public boolean contains(E value) {
        return search(value)!=null;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new PositionLinkedListIterator<E>(this);
    }

    private Node<E> checkPosition(Position<E> p){
        if(!(p instanceof Node)){ //p==null no haria falta xq ya se comprueba en el instanceof
            throw new RuntimeException("The position is invalid");
        }
        return (Node<E>) p;
    }

    public Position<E> getNext(Position<E> p) {
        Node<E> node = this.checkPosition(p);
        return node.getNext();
    }

}