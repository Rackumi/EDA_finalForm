package structures.tree.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import structures.Position;
import structures.tree.iterators.InOrderIterator;

/**
 * Implementation for LinkedBinaryTree
 *
 * @author Rackumi
 */
public class LinkedBinaryTree<E> implements BinaryTree<E>{

    public class BTNode<T> implements Position<T>{

        private T element;
        private BTNode<T> left;
        private BTNode<T> right;
        private BTNode<T> parent;

        public BTNode(T element, BTNode<T> parent){
            this.element = element;
            this.parent = parent;
            this.left = null;
            this.right = null;
        }

        public BTNode(T element, BTNode<T> parent, BTNode<T> left, BTNode<T> right){
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public T getElement() {
            return this.element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public BTNode<T> getLeft() {
            return this.left;
        }

        public void setLeft(BTNode<T> left) {
            this.left = left;
        }

        public BTNode<T> getRight() {
            return this.right;
        }

        public void setRight(BTNode<T> right) {
            this.right = right;
        }

        public BTNode<T> getParent() {
            return this.parent;
        }

        public void setParent(BTNode<T> parent) {
            this.parent = parent;
        }

    }

    private BTNode<E> root;

    public LinkedBinaryTree(){
        this.root = null;
    }

    public LinkedBinaryTree(BTNode<E> root){
        this.root = root;
    }

    @Override
    public Position<E> left(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        BTNode<E> leftNode = node.getLeft();
        if(leftNode == null){
            throw new RuntimeException("No left child");
        }
        return leftNode;
    }

    @Override
    public Position<E> right(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        BTNode<E> rightNode = node.getRight();
        if(rightNode == null){
            throw new RuntimeException("No right child");
        }
        return rightNode;
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        return (node.getLeft() != null);
    }

    @Override
    public boolean hasRight(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        return (node.getRight() != null);
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
        return node.getParent() == null;
    }

    @Override
    public Position<E> root() {
        if (root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root;
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
        BTNode<E> parentNode = node.getParent();
        BTNode<E> sibling = null;
        if(parentNode.left==node){
            sibling = parentNode.right;
        }
        else if(parentNode.right==node){
            sibling = parentNode.left;
        }
        return sibling;
    }

    @Override
    public Position<E> addRoot(E e) {
        if(isEmpty()) {
            this.root = new BTNode<>(e, null);
            return root;
        }
        throw new RuntimeException("Tree already has a root");
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
        BTNode<E> parent = checkPosition(p);
        if(!hasLeft(parent)) {
            BTNode<E> node = new BTNode<>(e, parent);
            parent.setLeft(node);
            return node;
        }
        throw new RuntimeException("Node already has a left child");
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        BTNode<E> parent = checkPosition(p);
        if(!hasRight(parent)) {
            BTNode<E> node = new BTNode<>(e, parent);
            parent.setRight(node);
            return node;
        }
        throw new RuntimeException("Node already has a right child");
    }

    @Override
    public E remove(Position<E> p) {
        BTNode<E> node = checkPosition(p);
        BTNode<E> parent = node.getParent();
        BTNode<E> leftPos = node.getLeft();
        BTNode<E> rightPos = node.getRight();
        if(hasLeft(node) && hasRight(node)){
            throw new RuntimeException("Cannot remove node with two children");
        }
        BTNode<E> child = leftPos != null ? leftPos : rightPos;
        if (node == root) { // v is the root
            if (child != null) {
                child.setParent(null);
            }
            root = child;
        } else { // v is not the root
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
            if (child != null) {
                child.setParent(parent);
            }
        }
        return p.getElement();
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
        BTNode<E> node1 = checkPosition(p1);
        BTNode<E> node2 = checkPosition(p2);

//        E aux = p1.getElement(); //version sencilla sin cambiar nodos
//        node1.setElement(p2.getElement());
//        node2.setElement(aux);

        BTNode<E> copyNode1 = new BTNode<>(node1.element, node1.parent, node1.left, node1.right);

        node1.parent = node2.parent == node1 ? node2 : node2.parent;
        node1.left = node2.left == node1 ? node2 : node2.left;
        node1.right = node2.right == node1 ? node2 : node2.right;

        node2.parent = copyNode1.parent == node2 ? node1 : copyNode1.parent;
        node2.left = copyNode1.left == node2 ? node1 : copyNode1.left;
        node2.right = copyNode1.right == node2 ? node1 : copyNode1.right;

        if (node1.parent != null) {
            if (node1.parent.left == node2) {
                node1.parent.left = node1;
            } else {
                node1.parent.right = node1;
            }
        } else {
            this.root = node1;
        }

        if (node2.parent != null) {
            if (node2.parent.left == node1) {
                node2.parent.left = node2;
            } else {
                node2.parent.right = node2;
            }
        } else {
            root = node2;
        }

        if (this.hasLeft(node1)) {
            node1.left.parent = node1;
        }
        if (this.hasRight(node1)) {
            node1.right.parent = node1;
        }
        if (this.hasLeft(node2)) {
            node2.left.parent = node2;
        }
        if (this.hasRight(node2)) {
            node2.right.parent = node2;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.root==null;
    }

    @Override
    public Position<E> parent(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        if(isRoot(node)){
            throw new RuntimeException("No parent");
        }
        return node.getParent();
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        List<Position<E>> l = new LinkedList<>();
        BTNode<E> node = checkPosition(v);
        if(hasLeft(node)){
            l.add(node.getLeft());
        }
        if(hasRight(node)){
            l.add(node.getRight());
        }
        return l;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new InOrderIterator<>(this);
    }

    @Override
    public void attachLeft(Position<E> h, BinaryTree<E> t1) {
        if (t1 == this) {
            throw new RuntimeException("Cannot attach a tree over himself");
        }
        BTNode<E> node = checkPosition(h);
        BTNode<E> root = checkPosition(t1.root());
        if(node.getLeft() == null){
            node.setLeft(root);
            root.setParent(node);
        }
        else {
            throw new RuntimeException("The node already has a left child");
        }
    }
    
    @Override
    public void attachRight(Position<E> h, BinaryTree<E> t1) {
        if (t1 == this) {
            throw new RuntimeException("Cannot attach a tree over himself");
        }
        BTNode<E> node = checkPosition(h);
        BTNode<E> root = checkPosition(t1.root());
        if(node.getRight() == null){
            node.setRight(root);
            root.setParent(node);
        }
        else {
            throw new RuntimeException("The node already has a right child");
        }
    }

    @Override
    public LinkedBinaryTree<E> subTree(Position<E> h) {
        BTNode<E> node = checkPosition(h);
        BTNode<E> parent = node.getParent();
        LinkedBinaryTree<E> t = new LinkedBinaryTree<>(node);
        if(parent.getLeft() == node){
            parent.setLeft(null);
        }
        else{
            parent.setRight(null);
        }
        return t;
    }

    private BTNode<E> checkPosition(Position<E> p){
        if(!(p instanceof BTNode)){ //p==null no haria falta xq ya se comprueba en el instanceof
            throw new RuntimeException("The position is invalid");
        }
        return (BTNode<E>) p;
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
        int cont = 0;
        for(Position<E> ignored : this){
            cont++;
        }
        return cont;
    }

    public void padresNoAbuelosPre(Position<E> p, List<Position<E>> l){
        BTNode<E> node = checkPosition(p);
        if(isLeaf(node.getLeft()) && isLeaf(node.getRight())){
            l.add(node);
        }
        padresNoAbuelosPre(node.getLeft(), l);
        padresNoAbuelosPre(node.getRight(), l);
    }

    public void padresNoAbuelosIn(Position<E> p, List<Position<E>> l){
        BTNode<E> node = checkPosition(p);
        padresNoAbuelosIn(node.getLeft(), l);
        if(isLeaf(node.getLeft()) && isLeaf(node.getRight())){
            l.add(node);
        }
        padresNoAbuelosIn(node.getRight(), l);
    }

    public void padresNoAbuelosPost(Position<E> p, List<Position<E>> l){
        BTNode<E> node = checkPosition(p);
        padresNoAbuelosPost(node.getLeft(), l);
        padresNoAbuelosPost(node.getRight(), l);
        if(isLeaf(node.getLeft()) && isLeaf(node.getRight())){
            l.add(node);
        }
    }

    /**
     * Creates a list storing the the nodes in the subtree of a node, ordered
     * according to the preorder traversal of the subtree.
     *
     * @param p
     * @param pos
     */
    protected void preorderPositions(Position<E> p, List<Position<E>> pos) {
        pos.add(p);
        if (hasLeft(p)) {
            preorderPositions(left(p), pos); // recurse on left child
        }
        if (hasRight(p)) {
            preorderPositions(right(p), pos); // recurse on right child
        }
    }

    /**
     * Creates a list storing the the nodes in the subtree of a node, ordered
     * according to the inorder traversal of the subtree.
     *
     * @param v
     * @param pos
     */
    protected void inorderPositions(Position<E> v, List<Position<E>> pos) {
        if (hasLeft(v)) {
            inorderPositions(left(v), pos); // recurse on left child
        }
        pos.add(v);
        if (hasRight(v)) {
            inorderPositions(right(v), pos); // recurse on right child
        }
    }

    public void addRight(Position<E> node, E newNode){
        BTNode<E> pos = checkPosition(node);
        BTNode<E> newPos = new BTNode<>(newNode, pos);
        BTNode<E> newNewPos = pos.getRight();
        pos.setRight(newPos);
        newPos.setRight(newNewPos);
    }
    
    public void insertRightNode(Position<E> parent, Position<E> node){
        BTNode<E> posParent = checkPosition(parent);
        BTNode<E> posNode = checkPosition(node);
        posParent.setRight(posNode);
    }

    public void insertLeftNode(Position<E> parent, Position<E> node){
        BTNode<E> posParent = checkPosition(parent);
        BTNode<E> posNode = checkPosition(node);
        posParent.setLeft(posNode);
    }

}