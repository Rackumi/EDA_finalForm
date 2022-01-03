package structures.tree.iterators;

import structures.Position;
import structures.tree.Tree;
import java.util.*;

/**
 * PostOrderIterator
 *
 * @author Rackumi
 */
public class PostOrderIterator<E> implements Iterator<Position<E>> {

    private class Pair<X,Y>{

        private X elem1;
        private Y elem2;

        public Pair(X elem1, Y elem2) {
            this.elem1 = elem1;
            this.elem2 = elem2;
        }

        public X getElem1() {
            return elem1;
        }

        public void setElem1(X elem1) {
            this.elem1 = elem1;
        }

        public Y getElem2() {
            return elem2;
        }

        public void setElem2(Y elem2) {
            this.elem2 = elem2;
        }

    }

    private final Tree<E> tree;
    private final Deque<Pair<Position<E>, Iterator<Position<E>>>> s;

    public PostOrderIterator(Tree<E> t){
        this.tree = t;
        Pair<Position<E>, Iterator<Position<E>>> pair = new Pair(tree.root(), tree.children(tree.root()).iterator());
        s = new LinkedList<>();
        s.push(pair);
    }

    public PostOrderIterator(Tree<E> t, Position<E> root){
        this.tree = t;
        Pair<Position<E>, Iterator<Position<E>>> pair = new Pair(root, tree.children(root).iterator());
        s = new LinkedList<>();
        s.push(pair);
    }

    @Override
    public boolean hasNext() {
        return !s.isEmpty();
    }

    @Override
    public Position<E> next() {
        if(s.isEmpty()){
            throw new NoSuchElementException();
        }

        Iterator<Position<E>> peekIt = s.peek().getElem2();

        while (peekIt.hasNext()){
            Position<E> n = peekIt.next();
            Iterator<Position<E>> nIt = (Iterator<Position<E>>) tree.children(n).iterator();
            Pair<Position<E>, Iterator<Position<E>>> newPair = new Pair(n, nIt);
            s.push(newPair);
            peekIt = nIt;
        }

        Pair<Position<E>, Iterator<Position<E>>> pair = s.pop();

        return pair.getElem1();
    }

}

//public class PosOrderTreeIterator<T> implements Iterator<Position<T>> {
//
//    private final Deque< Pair<Position<T>,Iterator >> nodeStack = new LinkedList<>();
//    private final Tree<T> tree;
//
//    public PosOrderTreeIterator(Tree<T> tree) {
//        this(tree, tree.root());
//    }
//
//    public PosOrderTreeIterator(Tree<T> tree, Position<T> root) {
//        this.tree = tree;
//        Iterator p = tree.children(root).iterator();
//        nodeStack.add(new Pair <>(root,p));
//    }
//
//    @Override
//    public boolean hasNext() {
//        return (!nodeStack.isEmpty());
//    }
//
//    /**
//     * This method visits the nodes of a tree by following a pos-order
//     */
//    @Override
//    public Position<T> next() {
//        if (nodeStack.isEmpty())
//            throw new RuntimeException("No next element");
//
//        Pair<Position<T>,Iterator> element = nodeStack.getLast();
//        Position<T> node = element.getFirst();
//        Iterator iterator = element.getSecond();
//
//        while (tree.isInternal(node) && iterator.hasNext()) {
//            node = (Position<T>) iterator.next();
//            iterator = tree.children(node).iterator();
//            nodeStack.addLast(new Pair <>(node,iterator));
//        }
//
//        nodeStack.removeLast();
//        return node;
//
//    }
//
//}