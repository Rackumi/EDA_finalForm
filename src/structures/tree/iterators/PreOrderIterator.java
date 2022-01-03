package structures.tree.iterators;

import structures.Position;
import structures.tree.Tree;
import java.util.*;

/**
 * PreOrderIterator
 *
 * @author Rackumi
 */
public class PreOrderIterator<E> implements Iterator<Position<E>> {

    private final Tree<E> tree;
    private final Deque<Position<E>> s;
    private final List<Position<E>> l;

    public PreOrderIterator(Tree<E> t){
        this.tree = t;
        s = new LinkedList<>();
        l = new LinkedList<>();
        if(!tree.isEmpty()){
            s.push(tree.root());
        }
    }

    public PreOrderIterator(Tree<E> t, Position<E> root){
        this.tree = t;
        s = new LinkedList<>();
        l = new LinkedList<>();
        if(!tree.isEmpty()){
            s.push(root);
        }
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

        Position<E> node = s.pop();
        for(Position<E> p: tree.children(node)){
            l.add(p);
        }
        Collections.reverse(l);
        for(Position<E> p: l){
            s.push(p);
        }
        l.clear();
        return node;
    }

//    private Deque<Position<E>> nodeQueue = new LinkedList<>();
//    private final Tree<E> tree;
//
//    public PreOrderIterator(Tree<E> tree){
//        this.tree = tree;
//        nodeQueue.add(tree.root());
//    }
//
//    public PreOrderIterator(Tree<E> tree, Position<E> root) {
//        this.tree = tree;
//        nodeQueue.add(root);
//    }
//
//    @Override
//    public boolean hasNext() {
//        return (!nodeQueue.isEmpty());
//    }
//
//    @Override
//    public Position<E> next() {
//        Position<E> aux = nodeQueue.pollFirst();
//
//        Deque<Position<E>> reverseList = new LinkedList<>();
//        for (Position<E> node : tree.children(aux)) {
//            reverseList.addFirst(node);
//        }
//        for (Position<E> node : reverseList) {
//            nodeQueue.addFirst(node);
//        }
//        return aux;
//    }

}