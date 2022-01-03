package structures.tree.binarytree;

import java.util.*;

import structures.Position;
import structures.tree.iterators.InOrderIterator;

/**
 * Implementation for ArrayBinaryTree
 *
 * @author Rackumi
 */
public class ArrayBinaryTree<E> implements BinaryTree<E> {

    private class BTNode<T> implements Position<T> {

        //root = 0
        //izq -> 2*n+1
        //der -> 2*2+2

        private T element;
        private int rank;

        @Override
        public T getElement() {
            return this.element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public int getRank() {
            return this.rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public BTNode(T element, int rank) {
            this.element = element;
            this.rank = rank;
        }

    }

    private BTNode<E>[] tree;
    private int size;
    private int capacity;

    public ArrayBinaryTree(){
        this.capacity = 100;
        this.tree = new BTNode[this.capacity];
        this.size = 0;
    }

    public ArrayBinaryTree(int capacity){
        this.capacity = capacity;
        this.tree = new BTNode[this.capacity];
        this.size=0;
    }

    @Override
    public Position<E> left(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        int n = node.getRank()* 2 + 1;
        if(this.tree[n] == null){
            throw new RuntimeException("No left child");
        }
        return this.tree[n];
    }

    @Override
    public Position<E> right(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        int n = node.getRank()* 2 + 2;
        if(this.tree[n] == null){
            throw new RuntimeException("No right child");
        }
        return this.tree[n];
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        int n = node.getRank()* 2 + 1;
        return (this.tree[n] != null);
    }

    @Override
    public boolean hasRight(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        int n = node.getRank()* 2 + 2;
        return (this.tree[n] != null);
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !isLeaf(v);
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        return !hasLeft(p) && !hasRight(p);
    }

    @Override
    public boolean isRoot(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        return node == this.tree[0];
    }

    @Override
    public Position<E> root() {
        if (this.tree[0] == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.tree[0];
    }

    @Override
    public E replace(Position<E> p, E e) {
        BTNode<E> node = checkPosition(p);
        E aux = node.getElement();
        node.setElement(e);
        return aux;
    }

    @Override
    public Position<E> sibling(Position<E> p) {
        if(isRoot(p)){
            throw new RuntimeException("No sibling");
        }
        BTNode<E> node = checkPosition(p);
        BTNode<E> parent = checkPosition(parent(node));
        BTNode<E> sibling;
        if(left(parent) == node && right(parent) != null){
            sibling = checkPosition(right(parent));
        }
        else if(right(parent) == node && left(parent) != null){
            sibling = checkPosition(left(parent));
        }
        else{
            throw new RuntimeException("No sibling");
        }
        return sibling;
    }

    @Override
    public Position<E> addRoot(E e) {
        resize(size >= capacity/2);
        if(this.tree[0] == null){
            BTNode<E> node = new BTNode<>(e, 0);
            this.tree[0] = node;
            this.size++;
            return node;
        }
        throw new RuntimeException("Tree already has a root");
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
        //resize(size >= capacity/2);
        BTNode<E> nodeParent = checkPosition(p);
        if(!hasLeft(nodeParent)) {
            int n = nodeParent.getRank() * 2 + 1;
            BTNode<E> node = new BTNode<>(e, n);
            this.tree[n] = node;
            this.size++;
            return node;
        }
        throw new RuntimeException("Node already has a left child");
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        //resize(size >= capacity/2);
        BTNode<E> nodeParent = checkPosition(p);
        if(!hasRight(nodeParent)) {
            int n = nodeParent.getRank() * 2 + 2;
            BTNode<E> node = new BTNode<>(e, n);
            this.tree[n] = node;
            this.size++;
            return node;
        }
        throw new RuntimeException("Node already has a right child");
    }

    @Override
    public E remove(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        if(hasLeft(node) && hasRight(node)){
            throw new RuntimeException("Cannot remove node with two children");
        }
        E ele = node.getElement();
        BTNode<E> child = null;
        if(tree[node.getRank()*2+1] != null)
            child = tree[node.getRank()*2+1];
        else if(tree[node.getRank()*2+2] != null)
            child = tree[node.getRank()*2+2];
        if(child == null){
            tree[node.getRank()] = null;
        }
        else{
            changeSubtreeIndex(this,child,(child.getRank()-1)/2);
        }
        size--;
        return ele;
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
        BTNode<E> node1 = checkPosition(p1);
        BTNode<E> node2 = checkPosition(p2);
        int aux = node1.getRank();
        node1.setRank(node2.getRank());
        node2.setRank(aux);
        this.tree[node1.getRank()] = node1;
        this.tree[node2.getRank()] = node2;
    }

    @Override
    public boolean isEmpty() {
        return this.tree[0] == null;
    }

    @Override
    public Position<E> parent(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        if(isRoot(node)){
            throw new RuntimeException("No parent");
        }

        int n;
        if(node.getRank()%2==0){
            n = node.getRank()/2-1;
        }
        else{
            n = node.getRank()/2;
        }
        return this.tree[n];
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        List<Position<E>> l = new LinkedList<>();
        BTNode<E> node = checkPosition(v);

        if(hasLeft(node)){
            l.add(left(node));
        }
        if(hasRight(node)){
            l.add(right(node));
        }
        return l;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new InOrderIterator<>(this);
    }

//    @Override
//    public void attachLeft(Position<E> h, BinaryTree<E> t1) { //TODO
//        if (t1 == this) {
//            throw new RuntimeException("Cannot attach a tree over himself");
//        }
//        BTNode<E> node = checkPosition(h);
//
//        if(hasLeft(node)){
//            throw new RuntimeException("The node already has a left child");
//        }
//
//    }
//
//    @Override
//    public void attachRight(Position<E> h, BinaryTree<E> t1) { //TODO
//        if (t1 == this) {
//            throw new RuntimeException("Cannot attach a tree over himself");
//        }
//        BTNode<E> node = checkPosition(h);
//        if(hasRight(node)){
//            throw new RuntimeException("The node already has a right child");
//        }


//    }

    @Override
    public void attachLeft(Position<E> p, BinaryTree<E> tree) throws RuntimeException {
        BTNode<E> node = checkPosition(p);
        if(hasLeft(p))
            throw new RuntimeException("Node already has a left child");
        if(this == tree)
            throw new RuntimeException("The position belongs to the provided tree");
        if(!(tree instanceof ArrayBinaryTree))
            throw new RuntimeException("The tree has a different implementation");
        ArrayBinaryTree<E> newTree = (ArrayBinaryTree<E>) tree;
        insertNewTree(node,newTree.tree[0],newTree,true);
        size += newTree.size;
        newTree.tree = new BTNode[newTree.capacity];
        newTree.size = 0;
    }

    @Override
    public void attachRight(Position<E> p, BinaryTree<E> tree) throws RuntimeException {
        BTNode<E> node = checkPosition(p);
        if(hasRight(p))
            throw new RuntimeException("Node already has a right child");
        if(this == tree)
            throw new RuntimeException("The position belongs to the provided tree");
        if(!(tree instanceof ArrayBinaryTree))
            throw new RuntimeException("The tree has a different implementation");
        ArrayBinaryTree<E> newTree = (ArrayBinaryTree<E>) tree;
        insertNewTree(node,newTree.tree[0],newTree,false);
        size += newTree.size;
        newTree.tree = new BTNode[newTree.capacity];
        newTree.size = 0;
    }

    @Override
    public ArrayBinaryTree<E> subTree(Position<E> h) {//TODO
        BTNode<E> newRoot = checkPosition(h);
        ArrayBinaryTree<E> newTree = new ArrayBinaryTree<>(capacity);
        Iterator<Position<E>> it = new InOrderIterator<E>(this,newRoot);
        int cont = 0;
        //delete from this tree, add to new tree, and count elements
        while (it.hasNext()){
            Position<E> p = it.next();
            BTNode<E> node = checkPosition(p);
            newTree.tree[node.getRank()] = node;
            this.tree[node.getRank()] = null;
            cont++;
        }
        //actualize node positions in the array to match the implementation
        changeSubtreeIndex(newTree,newRoot,0);

        newTree.size = cont;
        return newTree;
    }

    private BTNode<E> checkPosition(Position<E> p){
        if(!(p instanceof BTNode)){ //p==null no haria falta xq ya se comprueba en el instanceof
            throw new RuntimeException("The position is invalid");
        }
        return (BTNode<E>) p;
    }

    private void resize(boolean condition){
        if(condition){
            capacity = capacity*2;
            BTNode<E>[] aux = new BTNode[this.capacity];
            System.arraycopy(tree,0,aux,0,capacity/2);
            tree = aux;
        }
    }

    private void changeSubtreeIndex(ArrayBinaryTree<E> tree, Position<E> pos, int newIndex){
        BTNode<E> n = tree.checkPosition(pos);
        int oldIndex = n.getRank();
        tree.tree[newIndex] = n;
        tree.tree[oldIndex] = null;
        n.setRank(newIndex);
        if((tree.tree[oldIndex*2+1]) != null)
            changeSubtreeIndex(tree,tree.tree[oldIndex*2+1],newIndex*2+1);
        if((tree.tree[oldIndex*2+2]) != null)
            changeSubtreeIndex(tree,tree.tree[oldIndex*2+2],newIndex*2+2);
    }

    private void insertNewTree(BTNode<E> parent, BTNode<E> newNode, ArrayBinaryTree<E> newTree, boolean isLeft){
        int r = newNode.getRank()*2+2;
        int l = newNode.getRank()*2+1;
        //newNode.setRank(null);
        int newNodeI;
        if(isLeft){
            newNodeI = parent.getRank()*2+1;
        }
        else{
            newNodeI = parent.getRank()*2+2;
        }
        newNode.setRank(newNodeI);
        if(newTree.tree[l] != null)
            insertNewTree(newNode,newTree.tree[l],newTree,true);
        if(newTree.tree[r] != null)
            insertNewTree(newNode,newTree.tree[r],newTree,false);
        resize(capacity<=newNodeI);
        tree[newNodeI] = newNode;
    }

    //Extra methods

    public boolean isComplete(){
        for(Position<E> p: this){
            BTNode<E> node = checkPosition(p);
            //if(!((hasLeft(node) && hasRight(node)) || isLeaf(node))){
            //if((!(hasLeft(node) && hasRight(node)) && !isLeaf(node))){
            if(((!hasLeft(node) || !hasRight(node)) && isInternal(node))){
                return false;
            }
        }
        return true;
    }

    public int size(){
        return this.size;
    }


}