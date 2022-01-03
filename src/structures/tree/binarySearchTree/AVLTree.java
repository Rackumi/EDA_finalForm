package structures.tree.binarySearchTree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import structures.Position;
import structures.tree.binarySearchTree.LinkedBinarySearchTree.ReestructurableBinaryTree;

/**
 * AVLTree class - implements an AVL Tree by extending a binary search tree.
 *
 * @author Rackumi
 * https://ccia.ugr.es/~jfv/ed1/tedi/cdrom/docs/Ejer_Avl.htm -> unos ejercicios de avl asi pa practicar
 */
public class AVLTree<E> implements BinarySearchTree<E> {

    //We need this class to store the height of each BTNode
    private class AVLInfo<T> implements Comparable<AVLInfo<T>>, Position<T> {

        private int height;
        private T element;
        private Position<AVLInfo<T>> pos;

        AVLInfo(T element) {
            this.element = element;
            this.pos = null;
            this.height = 1;
        }

        public void setTreePosition(Position<AVLInfo<T>> pos) {
            this.pos = pos;
        }

        public Position<AVLInfo<T>> getTreePosition() {
            return this.pos;
        }


        public void setHeight(int height) {
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public T getElement() {
            return element;
        }

        @Override
        public int compareTo(AVLInfo<T> o) {
            if (element instanceof Comparable && o.element instanceof Comparable) {
                Comparable<T> c1 = (Comparable<T>) element;
                return c1.compareTo(o.element);

            } else {
                throw new ClassCastException("Element is not comparable");
            }
        }

        @Override
        public String toString() {
            return this.getElement().toString();
        }
    }

    private class AVLTreeIterator<T> implements Iterator<Position<T>>{

        private Iterator<Position<AVLInfo<T>>> it;

        public AVLTreeIterator(Iterator<Position<AVLInfo<T>>> iterator){
            this.it = iterator;
        }

        @Override
        public boolean hasNext() {
            return this.it.hasNext();
        }

        @Override
        public Position<T> next() {
            Position<AVLInfo<T>> aux = it.next();
            return aux.getElement();
        }

    }

    private final LinkedBinarySearchTree<AVLInfo<E>> bst = new LinkedBinarySearchTree<>();
    private final Reestructurator reestructurator = new Reestructurator();
    private ReestructurableBinaryTree resBT;

//    public AVLTree() {
//        this(new DefaultComparator<>());
//    }
//
//    /**
//     * Creates a BinarySearchTree with the given comparator.
//     *
//     * @param c the comparator used to sort the nodes in the tree
//     */
//    public AVLTree(Comparator<E> c) {
//        Comparator<AVLInfo<E>> avlComparator = (o1, o2) -> c.compare(o1.getElement(), o2.getElement());
//        bst = new LinkedBinarySearchTree<>(avlComparator);
//        resBT = new ReestructurableBinaryTree();
//        bst.binTree = resBT;
//    }

    @Override
    public Position<E> find(E value) {
        AVLInfo<E> searchedValue = new AVLInfo<>(value);
        Position<AVLInfo<E>> output = bst.find(searchedValue);
        if(output != null) {
            return output.getElement();
        }
        else{
            return null;
        }
    }

    @Override
    public Iterable<? extends Position<E>> findAll(E value) {
        AVLInfo<E> searchedValue = new AVLInfo<>(value);
        List<Position<E>> l = new LinkedList<>();
        for(Position<AVLInfo<E>> p: bst.findAll(searchedValue)){
            l.add(p.getElement());
        }
        return l;
    }

    @Override
    public Position<E> insert(E value) {
        AVLInfo<E> node = new AVLInfo<>(value);
        Position<AVLInfo<E>> internalNode = this.bst.insert(node);
        node.setTreePosition(internalNode);
//        rebalance(internalNode); //por algun motivo no me deja reestructurar :/
        return node;
    }

    @Override
    public boolean isEmpty() {
        return this.bst.size()==0;
    }

    @Override
    public void remove(Position<E> pos) {
        AVLInfo<E> avlInfo = (AVLInfo<E>) pos;
        Position<AVLInfo<E>> treePos = avlInfo.getTreePosition();
        Position<AVLInfo<E>> parent = null;

        if (bst.binTree.isLeaf(treePos) || !bst.binTree.hasLeft(treePos) || !bst.binTree.hasRight(treePos)) {
            if (bst.binTree.root() != treePos)
                parent = bst.binTree.parent(treePos);
            bst.binTree.remove(treePos);
        } else {
            Position<AVLInfo<E>> sucessor = bst.successor(treePos);
            bst.binTree.swap(sucessor,treePos);
            if (bst.binTree.root() != treePos)
                parent = bst.binTree.parent(treePos);
            bst.binTree.remove(treePos);
        }
        bst.size--;
        if (parent != null) {
            rebalance(parent);
        }
    }

    @Override
    public int removeReturn(Position<E> pos) throws IllegalStateException {
        AVLInfo<E> avlInfo = (AVLInfo<E>) pos;
        Position<AVLInfo<E>> treePos = avlInfo.getTreePosition();
        Position<AVLInfo<E>> parent = null;

        AVLInfo<E> aux = null;
        if (bst.binTree.isLeaf(treePos) || !bst.binTree.hasLeft(treePos) || !bst.binTree.hasRight(treePos)) {
            if (bst.binTree.root() != treePos)
                parent = bst.binTree.parent(treePos);
            aux = bst.binTree.remove(treePos);
        } else {
            Position<AVLInfo<E>> sucessor = bst.successor(treePos);
            bst.binTree.swap(sucessor,treePos);
            if (bst.binTree.root() != treePos)
                parent = bst.binTree.parent(treePos);
            aux = bst.binTree.remove(treePos);
        }
        bst.size--;
        if (parent != null) {
            rebalance(parent);
        }
        return (int)aux.getElement();
    }

    @Override
    public int size() {
        return this.bst.size();
    }

    @Override
    public Iterable<? extends Position<E>> rangeIterator(E m, E M) {
        AVLInfo<E> node1 = new AVLInfo<>(m);
        AVLInfo<E> node2 = new AVLInfo<>(M);
        return (Iterable<? extends Position<E>>) this.bst.rangeIterator(node1.pos.getElement(), node2.pos.getElement());
    }

    @Override
    public Position<E> successor(Position<E> pos) {
        AVLInfo<E> avlInfo = (AVLInfo<E>) pos;
        Position<AVLInfo<E>> treePos = avlInfo.getTreePosition();
        Position<E> nodo = bst.successor(treePos).getElement();
        return nodo;
    }

    @Override
    public Position<E> predecessor(Position<E> pos) {
        AVLInfo<E> avlInfo = (AVLInfo<E>) pos;
        Position<AVLInfo<E>> treePos = avlInfo.getTreePosition();
        Position<E> nodo = bst.predecessor(treePos).getElement();
        return nodo;
    }

    @Override
    public Iterable<Position<E>> successors(Position<E> pos) {
        AVLInfo<E> avlInfo = checkPosition(pos);
        Position<AVLInfo<E>> treePos = avlInfo.getTreePosition();
        List<Position<E>> l = new LinkedList<>();
        for(Position<AVLInfo<E>> p: this.bst.successors(treePos)){
            l.add(p.getElement());
        }
        return l;
    }

    @Override
    public Iterable<Position<E>> predecessors(Position<E> pos) {
        AVLInfo<E> avlInfo = checkPosition(pos);
        Position<AVLInfo<E>> treePos = avlInfo.getTreePosition();
        List<Position<E>> l = new LinkedList<>();
        for(Position<AVLInfo<E>> p: this.bst.predecessors(treePos)){
            l.add(p.getElement());
        }
        return l;
    }

    @Override
    public Position<E> first() {
        Position<E> nodo = bst.first().getElement();
        return nodo;
    }

    @Override
    public Position<E> last() {
        Position<E> nodo = bst.last().getElement();
        return nodo;
    }

    @Override
    public Iterable<Position<E>> findRange(E minValue, E maxValue) throws RuntimeException {
        AVLInfo<E> min = new AVLInfo<>(minValue);
        AVLInfo<E> max = new AVLInfo<>(maxValue);
        List<Position<E>> l = new LinkedList<>();
        for(Position<AVLInfo<E>> p: this.bst.findRange(min, max)){
            l.add(p.getElement());
        }
        return l;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        Iterator<Position<AVLInfo<E>>> bstIt = bst.iterator();
        AVLTreeIterator<E> it = new AVLTreeIterator<E>(bstIt);
        return it;
    }

    //Private methods

    /**
     * If v is a good tree node, cast to TreePosition, else throw exception
     */
    private AVLInfo<E> checkPosition(Position<E> p) throws RuntimeException {
        if (p == null) {
            throw new RuntimeException("The position of the AVL node is null");
        } else if (!(p instanceof AVLInfo)) {
            throw new RuntimeException("The position of the AVL node is not AVL");
        } else {
            AVLInfo<E> aux = (AVLInfo<E>) p;
            return aux;
        }
    }

    /**
     * Returns whether a node has balance factor between -1 and 1.
     */
    private boolean isBalanced(Position<AVLInfo<E>> p){
        int leftHeight;
        if(bst.binTree.hasLeft(p)){
            leftHeight = bst.binTree.left(p).getElement().getHeight();
        }
        else{
            leftHeight = 0;
        }
        int rightHeight = (bst.binTree.hasRight(p)) ? bst.binTree.right(p).getElement().getHeight() : 0; //lo mismo que arriba
//        final int bf = leftHeight - rightHeight;
//        return ((-1 <= bf) && (bf <= 1));
        return Math.abs(rightHeight-leftHeight)<=1;
    }

    /**
     * Return a child of p with height no smaller than that of the other child.
     */
    private Position<AVLInfo<E>> tallerChild(Position<AVLInfo<E>> p) {
        int leftHeight = this.bst.binTree.hasLeft(p) ? this.bst.binTree.left(p).getElement().height : 0;
        int rightHeight = this.bst.binTree.hasRight(p) ? this.bst.binTree.right(p).getElement().height : 0;
        if(leftHeight > rightHeight){
            return this.bst.binTree.left(p);
        }
        else if(leftHeight < rightHeight){
            return this.bst.binTree.right(p);
        }
        else{
            // equal height children - break tie using parent's type
            if (bst.binTree.isRoot(p)) {
                return bst.binTree.left(p);
            }

            if (p == bst.binTree.left(bst.binTree.parent(p))) {
                return bst.binTree.left(p);
            } else {
                return bst.binTree.right(p);
            }
        }
    }

    private void calculateHeight(Position<AVLInfo<E>> p){
        int leftHeight = this.bst.binTree.hasLeft(p) ? this.bst.binTree.left(p).getElement().getHeight() : 0;
        int rightHeight = this.bst.binTree.hasRight(p) ? this.bst.binTree.right(p).getElement().height : 0;
        p.getElement().setHeight(1+Math.max(rightHeight, leftHeight));
    }

    /**
     * Rebalance method called by insert and remove. Traverses the path from p
     * to the root. For each node encountered, we recompute its height and
     * perform a trinode restructuring if it's unbalanced.
     */
    private void rebalance(Position<AVLInfo<E>> zPos) {
        if (bst.binTree.isInternal(zPos)) {
            calculateHeight(zPos);
        }
        while (!bst.binTree.isRoot(zPos)) { // traverse up the tree towards the
            // root
            zPos = bst.binTree.parent(zPos);
            calculateHeight(zPos);
            if (!isBalanced(zPos)) {
                // perform a trinode restructuring at zPos's tallest grandchild
                Position<AVLInfo<E>> xPos = tallerChild(tallerChild(zPos));
                zPos = this.resBT.restructure(xPos, bst);
                calculateHeight(bst.binTree.left(zPos));
                calculateHeight(bst.binTree.right(zPos));
                calculateHeight(zPos);
            }
        }
    }

}