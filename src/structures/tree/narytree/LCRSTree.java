package structures.tree.narytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import structures.Position;
import structures.tree.binarytree.BinaryTree;
import structures.tree.iterators.BFSIterator;

/**
 * Implementation for LCRSTree
 *
 * @author Rackumi
 */
public class LCRSTree<E> implements NAryTree<E> {
    
    private class LCRSnode<T> implements Position<T>{

        private T element;
        private LCRSnode<T> parent;
        private LCRSnode<T> lChild;
        private LCRSnode<T> rSibling;

        public LCRSnode(LCRSnode<T> parent, T element) {
            this.element = element;
            this.parent = parent;
            this.lChild = null;
            this.rSibling = null;
        }

        @Override
        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public LCRSnode<T> getParent() {
            return parent;
        }

        public void setParent(LCRSnode<T> parent) {
            this.parent = parent;
        }

        public LCRSnode<T> getlChild() {
            return lChild;
        }

        public void setlChild(LCRSnode<T> lChild) {
            this.lChild = lChild;
        }

        public LCRSnode<T> getrSibling() {
            return rSibling;
        }

        public void setrSibling(LCRSnode<T> rSibling) {
            this.rSibling = rSibling;
        }

    }

    private LCRSnode<E> root;
    private int size;

    public LCRSTree(){
        this.root = null;
        this.size = 0;
    }

    public LCRSTree(LCRSnode<E> node){
        this.root = node;
        this.size = 1;
    }

    @Override
    public Position<E> addRoot(E e) {
        if(isEmpty()){
            this.root = new LCRSnode<>(null, e);
        }
        else{
            throw new RuntimeException("Tree already has a root");
        }
        size++;
        return this.root;
    }

    @Override
    public Position<E> add(E element, Position<E> p) {
        LCRSnode<E> parent = checkPosition(p);
        LCRSnode<E> node = new LCRSnode<>(parent, element);

        if(parent.getlChild() != null){
            LCRSnode<E> aux = parent.getlChild();
            while (aux.getrSibling() != null) {
                aux = aux.getrSibling();
            }
            aux.setrSibling(node);
        }
        else{
            parent.setlChild(node);
        }
        this.size++;
        return node;
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
        LCRSnode<E> parent = checkPosition(p);
        LCRSnode<E> node = new LCRSnode<>(parent, element);

        if(parent.getlChild() != null){
            LCRSnode<E> aux = parent.getlChild();
            while (n>=0) {
                aux = aux.getrSibling();
                n--;
            }
            aux.setrSibling(node);
        }
        else{
            parent.setlChild(node);
        }
        this.size++;
        return node;
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
        LCRSnode<E> n1 = checkPosition(p1);
        LCRSnode<E> n2 = checkPosition(p2);
        E aux = n1.getElement();
        n1.setElement(n2.getElement());
        n2.setElement(aux);
    }

    @Override
    public E replace(Position<E> p, E e) {
        LCRSnode<E> node = checkPosition(p);
        E aux = node.getElement();
        node.setElement(e);
        return aux;
    }

    @Override
    public void remove(Position<E> p) {
        LCRSnode<E> node = checkPosition(p);
        if(!isRoot(node)){

            int cont = 0;
            Iterator<Position<E>> it = new BFSIterator<E>(this,  node);
            while(it.hasNext()){
                cont++;
                it.next();
            }

            LCRSnode<E> parent = node.getParent();
            if(parent.getlChild() == node){
                if(node.getrSibling() != null){
                    parent.setlChild(node.getrSibling());
                }
                else{
                    parent.setlChild(null);
                }
            }
            else{
                LCRSnode<E> aux = parent.getlChild();
                while(aux.getrSibling() != null && aux.getrSibling() != node){
                    aux = aux.getrSibling();
                }
                if(aux.getrSibling() == node){
                    aux.setrSibling(aux.getrSibling().getrSibling());
                }
                else{
                    throw new RuntimeException("The element is not in the tree");
                }
            }
            this.size = this.size - cont;
        }
        else{
            this.root = null;
            this.size = 0;
        }
    }

    @Override
    public NAryTree<E> subTree(Position<E> v) {
        LCRSnode<E> node = checkPosition(v);
        this.remove(node);
        return new LCRSTree<>(node);
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {
        LCRSnode<E> node = checkPosition(p);
        LCRSnode<E> root = checkPosition(t.root());
        root.setParent(node);

        int cont = 0;
        Iterator<Position<E>> it = new BFSIterator<E>(t,  t.root());
        while(it.hasNext()){
            cont++;
            it.next();
        }

        if(node.getlChild()!=null){
            LCRSnode<E> aux = node.getlChild();
            while(aux.getrSibling()!=null){
                aux = aux.getrSibling();
            }
            aux.setrSibling(root);
        }
        else{
            node.setlChild(root);
        }

        this.size = this.size + cont;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public Position<E> root() {
        if(isEmpty()){
            throw new RuntimeException("The tree is empty");
        }
        return this.root;
    }

    @Override
    public Position<E> parent(Position<E> v) {
        LCRSnode<E> node = checkPosition(v);
        if(isRoot(node)){
            throw new RuntimeException("The node has not parent");
        }
        return node.getParent();
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        LCRSnode<E> node = checkPosition(v);
        List<LCRSnode<E>> siblings = new LinkedList<>();
        if(node.getlChild() != null){
            siblings.add(node.getlChild());
            LCRSnode<E> aux = node.getlChild().getrSibling();
            while(aux != null){
                siblings.add(aux);
                aux = aux.getrSibling();
            }
        }
        return siblings;
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !isLeaf(v);
    }

    @Override
    public boolean isLeaf(Position<E> v) {
        LCRSnode<E> node = checkPosition(v);
        return node.getlChild() == null;
    }

    @Override
    public boolean isRoot(Position<E> v) {
        return this.root==checkPosition(v);
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new BFSIterator<>(this);
    }

    public int size() {
        return this.size;
    }

    @Override
    public BinaryTree<E> convertToBinaryTree() {
        return null;
    }

    private LCRSnode<E> checkPosition(Position<E> p){
        if(!(p instanceof LCRSnode)){ //p==null no haria falta xq ya se comprueba en el instanceof
            throw new RuntimeException("The position is invalid");
        }
        return (LCRSnode<E>) p;
    }

    //Extra methods

    public void moveSubtree(Position<E> pOrig, Position<E> pDest) throws RuntimeException {
        LCRSnode<E> nodeOrig = checkPosition(pOrig);
        LCRSnode<E> nodeDest = checkPosition(pDest);

        if(nodeOrig == this.root){
            throw new RuntimeException("Root node can't be moved");
        }
        else if(nodeDest == nodeOrig){
            throw new RuntimeException("Both positions are the same");
        }
        Iterator<Position<E>> it = new BFSIterator<>(this, nodeOrig);
        while(it.hasNext()){
            if(nodeDest == it.next()){
                throw new RuntimeException("Target position can't be a subtree of origin");
            }
        }
        this.remove(nodeOrig);
        if(nodeDest.getlChild() == null){
            nodeDest.setlChild(nodeOrig);
        }
        else{
            LCRSnode<E> aux = nodeDest.getlChild();
            while(aux.getrSibling() != null){
                aux = aux.getrSibling();
            }
            aux.setrSibling(nodeOrig);
        }
    }

}