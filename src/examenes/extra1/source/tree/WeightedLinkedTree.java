package examenes.extra1.source.tree;

import structures.tree.*;
import java.util.*;
import structures.Position;
import structures.tree.iterators.BFSIterator;

/**
 * A linked class for a tree where nodes havpre an arbitrary number of children.
 *
 * @author Rackumi
 */
public class WeightedLinkedTree<E> implements Tree<E> {

    public int getWeight(Position<E> parent, Position<E> child) {
        int cont = 0;
        while(child != parent && !isRoot(child)){
            TreeNode<E> node = checkPosition(child);
            cont += node.getValue();
            child = parent(child);
        }
        return cont;
    }

    private class TreeNode<T> implements Position<T> {

        private T element;
        private TreeNode<T> parent;
        private List<TreeNode<T>> children;
        private WeightedLinkedTree<T> myTree;
        private int value;

        /**
         * Main constructor
         */
        public TreeNode(WeightedLinkedTree<T> t, T e, TreeNode<T> p, List<TreeNode<T>> c, int value) {
            this.myTree = t;
            this.element = e;
            this.parent = p;
            this.children = c;
            this.value = value;
        }

        /**
         * Returns the element stored at this position
         */
        @Override
        public T getElement() {
            return element;
        }

        /**
         * Sets the element stored at this position
         */
        public final void setElement(T o) {
            element = o;
        }

        /**
         * Returns the children of this position
         */
        public List<TreeNode<T>> getChildren() {
            return children;
        }

        /**
         * Sets the right child of this position
         */
        public final void setChildren(List<TreeNode<T>> c) {
            children = c;
        }

        /**
         * Returns the parent of this position
         */
        public TreeNode<T> getParent() {
            return parent;
        }

        /**
         * Sets the parent of this position
         */
        public final void setParent(TreeNode<T> v) {
            parent = v;
        }

        /**
         * @return the myTree
         */
        public WeightedLinkedTree<T> getMyTree() {
            return myTree;
        }

        /**
         * @param myTree the myTree to set
         */
        public void setMyTree(WeightedLinkedTree<T> myTree) {
            this.myTree = myTree;
        }

        public int getValue() {
            return value;
        }
    }
    
    private TreeNode<E> root;
    private int size;

    /**
     * Creates an empty tree.
     */
    public WeightedLinkedTree() {
        root = null;
        size = 0;
    }

    /**
     * Returns the number of nodes in the tree.
     *
     * @return The size.
     *
     */
    //@Override
    public int size() {
        return size;
    }

    /**
     * Returns whether the tree is empty.
     *
     * @return True if is empty.
     *
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns whether a node is internal.
     * @param v
     * @return 
     */
    @Override
    public boolean isInternal(Position<E> v) {
        return !isLeaf(v);
    }

    /**
     * Returns whether a node is external.
     * @param p
     * @return 
     */
    @Override
    public boolean isLeaf(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        return (node.getChildren() == null) || (node.getChildren().isEmpty());
    }

    /**
     * Returns whether a node is the root.
     * @param p
     * @return 
     */
    @Override
    public boolean isRoot(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        return (node == this.root());
    }

    /**
     * Returns the root of the tree.
     * @return 
     */
    @Override
    public Position<E> root() {
        if (root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return root;
    }

    /**
     * Returns the parent of a node.
     * @param p
     * @return 
     */
    @Override
    public Position<E> parent(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        Position<E> parentPos = (Position<E>) node.getParent();
        if (parentPos == null) {
            throw new RuntimeException("No parent");
        }
        return parentPos;
    }

    /**
     * Returns an iterable collection of the children of a node.
     */
    @Override
    public Iterable<? extends Position<E>> children(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        return node.getChildren();
    }

    /**
     * Returns an iterator of the elements stored at the nodes. The nodes are
     * visited according to a breath-first search
     */
    @Override
    public Iterator<Position<E>> iterator() {
        return new BFSIterator<>(this); // An iterator of elements
    }

 
    /**
     * Replaces the element at a node.
     */
    public E replace(Position<E> p, E e) {
        TreeNode<E> node = checkPosition(p);
        E temp = p.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * Adds a root node to an empty tree
     */
    public Position<E> addRoot(E e) {
        if (!isEmpty()) {
            throw new RuntimeException("Tree already has a root");
        }
        size = 1;
        root = new TreeNode<>(this, e, null, new ArrayList<>(), 0);
        return root;
    }

    /**
     * Swap the elements at two nodes
     */
    public void swapElements(Position<E> p1, Position<E> p2) {
        TreeNode<E> node1 = checkPosition(p1);
        TreeNode<E> node2 = checkPosition(p2);
        E temp = p2.getElement();
        node2.setElement(p1.getElement());
        node1.setElement(temp);
    }

    /**
     * If v is a good tree node, cast to TreePosition, else throw exception
     */
    private TreeNode<E> checkPosition(Position<E> p) {
        if (p == null || !(p instanceof TreeNode)) {
            throw new RuntimeException("The position is invalid");
        }
        TreeNode<E> aux = (TreeNode<E>) p;

        if (aux.getMyTree() != this) {
            throw new RuntimeException("The node is not from this tree");
        }
        return aux;
    }

    /**
     * Add a new node whose parent is pointed by a given position.
     *
     * @param p The position of the parent, e the element stored in the new
     * created node.
     */
    public Position<E> add(E element, Position<E> p, final int weight) {
        TreeNode<E> parent = checkPosition(p);
        TreeNode<E> newNode = new TreeNode<>(this, element, parent, new ArrayList<>(), weight);
        List<WeightedLinkedTree<E>.TreeNode<E>> l = parent.getChildren();
        l.add(newNode);
        size++;
        return newNode;
    }

    /**
     * Remove a node and its corresponding subtree rooted at node.
     *
     * @param p The position of the node to be removed.
     */
    public void remove(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        if (node.getParent() != null) {
            Iterator<Position<E>> it = new BFSIterator<>(this,node);
            int cont = 0;
            while (it.hasNext()) {
                it.next();
                cont++;
            }
            size = size - cont;

            TreeNode<E> parent = node.getParent();
            parent.getChildren().remove(node);
        } else {
            this.root = null;
            this.size = 0;
        }
        node.setMyTree(null);
    }
    
    public Position<E> moveSubtree(Position<E> pOrig, Position<E> pDest) {
        return null;
    }

}