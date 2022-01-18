package structures.tree.binarySearchTree;

import java.util.*;

import structures.Position;
import structures.tree.binarytree.LinkedBinaryTree;
import structures.tree.iterators.InOrderIterator;

/**
 * Realization of a dictionary by means of a binary search tree.
 *
 * @author Rackumi
 */
public class LinkedBinarySearchTree<E> implements BinarySearchTree<E> {

    public LinkedBinaryTree<E> binTree;
    protected Comparator<E> comparator;
    protected int size = 0;

    public LinkedBinarySearchTree() {
        this(null);
    }

    public LinkedBinarySearchTree(Comparator<E> c) {
        if (c == null) {
            this.comparator = new DefaultComparator<>();
        } else {
            this.comparator = c;
        }
        this.binTree = new LinkedBinaryTree<>();
    }

    /**
     * Auxiliary method used by find, insert, and remove.
     *
     * @param value the value searched
     * @param pos   the position to start the search
     * @return the position where value is stored
     */
    protected Position<E> treeSearch(E value, Position<E> pos) throws IllegalStateException, IndexOutOfBoundsException {
        if (!this.binTree.isLeaf(pos)) {
            E posValue = pos.getElement();
            int comp = comparator.compare(value, posValue);
            if (comp < 0) {
                if (this.binTree.hasLeft(pos)) {
                    return treeSearch(value, this.binTree.left(pos)); // search left
                } else {
                    return pos;
                }
            } else if (comp > 0) {
                if (this.binTree.hasRight(pos)) {
                    return treeSearch(value, this.binTree.right(pos)); // search right
                } else {
                    return pos;
                }
            } else {
                return pos;
            }
        } else {
            return pos;
        }
    }

    /**
     * Adds to L all entries in the subtree rooted at v having keys equal to k.
     */
    protected void addAll(List<Position<E>> l, Position<E> pos, E value) {
        if (this.binTree.isLeaf(pos)) {
            return;
        }
        Position<E> p = treeSearch(value, pos);
        if (!this.binTree.isLeaf(p)) { // we found an entry with key equal to k
            addAll(l, this.binTree.left(p), value);
            l.add(p); // add entries in inorder
            addAll(l, this.binTree.right(p), value);
        } // this recursive algorithm is simple, but it's not the fastest
    }

    @Override
    public Position<E> find(E value) {
        if (isEmpty()) {
            return null;
        }

        Position<E> pos = treeSearch(value, this.binTree.root());
        if (comparator.compare(pos.getElement(), value) == 0) {
            return pos;
        } else {
            return null;
        }
    }

    @Override
    public Iterable<? extends Position<E>> findAll(E value) {
        List<Position<E>> l = new LinkedList<>();
//        addAll(l, this.binTree.root(), value);
        Position<E> node = treeSearch(value, this.binTree.root());
        if (comparator.compare(node.getElement(), value) == 0) {
            l.add(node);
        }
        while (successor(node) != null && comparator.compare(successor(node).getElement(), node.getElement()) == 0) {
            l.add(node);
            node = successor(node);
        }

        return l;
    }

    @Override
    public Position<E> insert(E value) {

        if (this.binTree.isEmpty()) {
            size++;
            return this.binTree.addRoot(value);
        } else {
            Position<E> node = treeSearch(value, this.binTree.root());
            int c = this.comparator.compare(value, node.getElement());
            Position<E> returnPos;
            if (c == 0) {
                this.binTree.addRight(node, value);
                size++;
                return this.binTree.right(node);
            }
            if (c < 0) {
                returnPos = this.binTree.insertLeft(node, value);
            } else { //c > 0
                returnPos = this.binTree.insertRight(node, value);
            }
            size++;
            return returnPos;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(Position<E> pos) {

//        if(this.binTree.isLeaf(pos)){
//            this.binTree.remove(pos);
//        }
//        else if(!this.binTree.hasLeft(pos)){
//            Position<E> rSon = this.binTree.right(pos);
//            Position<E> parent = this.binTree.parent(pos);
//            this.binTree.remove(pos);
//            this.binTree.insertRightNode(parent, rSon);
//        }
//        else if(!this.binTree.hasRight(pos)){
//            Position<E> lSon = this.binTree.left(pos);
//            Position<E> parent = this.binTree.parent(pos);
//            this.binTree.remove(pos);
//            this.binTree.insertLeftNode(parent, lSon);
//        }
//        else{
//            Position<E> succ = successor(pos);
//            this.binTree.swap(succ, pos);
////            remove(pos);
//            this.binTree.remove(pos);
//        }

        if (this.binTree.isLeaf(pos) || !this.binTree.hasRight(pos) || !this.binTree.hasLeft(pos)) {
            this.binTree.remove(pos);
        } else {
            Position<E> succ = successor(pos);
            this.binTree.swap(succ, pos);
//            remove(pos);
            this.binTree.remove(pos);
        }
        size--;
    }

    @Override
    public int removeReturn(Position<E> pos) throws IllegalStateException {
        E remReturn;
        if (this.binTree.isLeaf(pos) || !this.binTree.hasRight(pos) || !this.binTree.hasLeft(pos)) {
            remReturn = this.binTree.remove(pos);
        } else {
            Position<E> succ = successor(pos);
            this.binTree.swap(succ, pos);
//            remove(pos);
            remReturn = this.binTree.remove(pos);
        }
        size--;
        return (int) remReturn;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterable<? extends Position<E>> rangeIterator(E m, E M) {
        List<Position<E>> l = new LinkedList<>();
        Position<E> first = treeSearch(m, this.binTree.root());
        l.add(first);
        while (first.getElement() != M) {
            first = successor(first);
            l.add(first);
        }
        return l;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new InOrderIterator<>(this.binTree);
    }

    public Position<E> successor(Position<E> pos) {
        if (this.binTree.hasRight(pos)) {
            return this.binTree.right(pos);
        } else {
            Position<E> parent = this.binTree.parent(pos);
            while (comparator.compare(parent.getElement(), pos.getElement()) <= 0) {
                if (this.binTree.isRoot(parent)) {
                    return null;
                }
                parent = this.binTree.parent(parent);
            }
            return parent;
        }
    }

    public Position<E> predecessor(Position<E> pos) {
        if (this.binTree.hasLeft(pos)) {
            return this.binTree.left(pos);
        } else {
            Position<E> parent = this.binTree.parent(pos);
            while (comparator.compare(parent.getElement(), pos.getElement()) > 0) {
                if (this.binTree.isRoot(parent)) {
                    return null;
                }
                parent = this.binTree.parent(parent);
            }
            return parent;
        }
    }

    public Iterable<Position<E>> successors(Position<E> pos) {
        List<Position<E>> l = new LinkedList<>();
        Iterator<Position<E>> it = this.iterator();
        while (it.hasNext()) {
            Position<E> next = it.next();
            if (this.comparator.compare(next.getElement(), pos.getElement()) >= 0) {
                l.add(next);
            }

        }
        return l;
    }

    public Iterable<Position<E>> predecessors(Position<E> pos) {
        List<Position<E>> l = new LinkedList<>();
        Iterator<Position<E>> it = this.iterator();
        while (it.hasNext()) {
            Position<E> next = it.next();
            if (this.comparator.compare(next.getElement(), pos.getElement()) <= 0) {
                l.add(next);
            }

        }
        Collections.reverse(l);
        return l;
    }

    public Position<E> first() {
        if (this.binTree.isEmpty()) {
            throw new RuntimeException("No first element.");
        }
        Position<E> node = this.binTree.root();
        while (this.binTree.hasLeft(node)) {
            node = this.binTree.left(node);
        }
        return node;
    }

    public Position<E> last() {
        if (this.binTree.isEmpty()) {
            throw new RuntimeException("No last element.");
        }
        Position<E> node = this.binTree.root();
        while (this.binTree.hasRight(node)) {
            node = this.binTree.right(node);
        }
        return node;
    }

    @Override
    public Iterable<Position<E>> findRange(E minValue, E maxValue) throws RuntimeException {
        if (isEmpty()) {
            return null;
        }
        if (comparator.compare(minValue, maxValue) > 0) {
            throw new RuntimeException("Invalid range. (min>max)");
        }
        List<Position<E>> l = new LinkedList<>();

        Position<E> nodeMin = treeSearch(minValue, this.binTree.root());
        Position<E> nodeMax = treeSearch(maxValue, this.binTree.root());

        if (comparator.compare(nodeMin.getElement(), maxValue) > 0 || comparator.compare(nodeMax.getElement(), minValue) < 0) {
            return l;
        }
        if (comparator.compare(nodeMin.getElement(), nodeMax.getElement()) <= 0) {
            l.add(nodeMin);
        }
        while ((successor(nodeMin) != null) && (comparator.compare(successor(nodeMin).getElement(), nodeMax.getElement()) <= 0)) {
            nodeMin = successor(nodeMin);
            l.add(nodeMin);
        }

        return l;
    }

    protected Position<E> getLeafToRemove(Position<E> pos) {
        Position<E> remPos = pos;

        if (this.binTree.isLeaf(this.binTree.left(remPos))) {
            remPos = this.binTree.left(remPos); // left easy case
        } else if (this.binTree.isLeaf(this.binTree.right(remPos))) {
            remPos = this.binTree.right(remPos); // right easy case
        } else { // entry is at a node with internal children
            Position<E> swapPos = remPos; // find node for moving
            // entry
            remPos = this.binTree.right(swapPos);
            do {
                remPos = this.binTree.left(remPos);
            } while (this.binTree.isInternal(remPos));
                /* Deprecated. Doesn't update AVLInfo.getTreePosition...
                //replacecValue(swapPos, this.binTree.parent(remPos).getElement());
                */
            this.binTree.swap(swapPos, this.binTree.parent(remPos));
        }
        return remPos;
    }

    /**
     * Auxiliary method for removing an external node and its parent
     */
    protected void removeLeaf(Position<E> v) {
        removeAboveLeaf(v);
        size--;
    }

    /**
     * Remove an external node v and replace its parent with v's sibling
     */
    protected void removeAboveLeaf(Position<E> p)
            throws RuntimeException {

        Position<E> u = this.binTree.parent(p);
        this.binTree.remove(p);
        this.binTree.remove(u);

    }

}

class ReestructurableBinaryTree<T> extends LinkedBinaryTree<T> {

    public ReestructurableBinaryTree() {
        this.addRoot(null);
    }

    /**
     * Performs a tri-node restructuring. Assumes the nodes are in one of
     * following configurations:
     *
     * <pre>
     *          z=c       z=c        z=a         z=a
     *         /  \      /  \       /  \        /  \
     *       y=b  t4   y=a  t4    t1  y=c     t1  y=b
     *      /  \      /  \           /  \         /  \
     *    x=a  t3    t1 x=b        x=b  t4       t2 x=c
     *   /  \          /  \       /  \             /  \
     *  t1  t2        t2  t3     t2  t3           t3  t4
     * </pre>
     *
     * @return the new root of the restructured subtree
     */
    public Position<T> restructure(Position<T> posNode, LinkedBinarySearchTree<T> bst) {
        BTNode<T> lowKey, midKey, highKey, t1, t2, t3, t4;
        Position<T> posParent = bst.binTree.parent(posNode); // assumes x has a parent
        Position<T> posGrandParent = bst.binTree.parent(posParent); // assumes y has a parent
        boolean nodeLeft = (posNode == bst.binTree.left(posParent));
        boolean parentLeft = (posParent == bst.binTree.left(posGrandParent));
        BTNode<T> node = (BTNode<T>) posNode, parent = (BTNode<T>) posParent, grandParent = (BTNode<T>) posGrandParent;
        if (nodeLeft && parentLeft) {// Desequilibrio izda-izda
            lowKey = node;
            midKey = parent;
            highKey = grandParent;
            t1 = lowKey.getLeft();
            t2 = lowKey.getRight();
            t3 = midKey.getRight();
            t4 = highKey.getRight();
        } else if (!nodeLeft && parentLeft) {// Desequilibrio izda-dcha
            lowKey = parent;
            midKey = node;
            highKey = grandParent;
            t1 = lowKey.getLeft();
            t2 = midKey.getLeft();
            t3 = midKey.getRight();
            t4 = highKey.getRight();
        } else if (nodeLeft && !parentLeft) {// Desequilibrio dcha-izda
            lowKey = grandParent;
            midKey = node;
            highKey = parent;
            t1 = lowKey.getLeft();
            t2 = midKey.getLeft();
            t3 = midKey.getRight();
            t4 = highKey.getRight();
        } else { // Desequilibrio dcha-dcha
            lowKey = grandParent;
            midKey = parent;
            highKey = node;
            t1 = lowKey.getLeft();
            t2 = midKey.getLeft();
            t3 = highKey.getLeft();
            t4 = highKey.getRight();
        }

        // put b at z's place
        if (bst.binTree.isRoot(posGrandParent)) {
            bst.binTree = (LinkedBinaryTree<T>) bst.binTree.subTree(midKey);//FIXED: bad practice...
        } else {
            BTNode<T> zParent = (BTNode<T>) bst.binTree.parent(posGrandParent);
            if (posGrandParent == bst.binTree.left(zParent)) {
                midKey.setParent(zParent);
                zParent.setLeft(midKey);
            } else { // z was a right child
                midKey.setParent(zParent);
                zParent.setRight(midKey);
            }
        }
        // place the rest of the nodes and their children
        midKey.setLeft(lowKey);
        lowKey.setParent(midKey);
        midKey.setRight(highKey);
        highKey.setParent(midKey);
        lowKey.setLeft(t1);
        t1.setParent(lowKey);
        lowKey.setRight(t2);
        t2.setParent(lowKey);
        highKey.setLeft(t3);
        t3.setParent(highKey);
        highKey.setRight(t4);
        t4.setParent(highKey);

        return midKey; // the new root of this subtree
    }
}