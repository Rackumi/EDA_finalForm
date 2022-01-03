package structures.tree.iterators;

import structures.Position;
import structures.tree.Tree;

import java.util.*;

/**
 * LeafIterator
 *
 * @author Rackumi
 */
public class LeafIterator<E> implements Iterator<Position<E>> {

//    private final Tree<E> tree;
//    private final List<Position<E>> l = new LinkedList<>();
//    private final Iterator<Position<E>> it;
//
//    public LeafIterator(Tree<E> tree, Position<E> root){
//        this.tree = tree;
//        it = new PreOrderIterator<>(this.tree, root);
//        while(it.hasNext()){
//            Position<E> node = it.next();
//            if(this.tree.isLeaf(node)) {
//                l.add(node);
//            }
//        }
//    }
//
//    public LeafIterator(Tree<E> tree){
//        this.tree = tree;
//        it = new PreOrderIterator<>(this.tree, this.tree.root());
//        while(it.hasNext()){
//            Position<E> node = it.next();
//            if(this.tree.isLeaf(node)) {
//                l.add(node);
//            }
//        }
//
//    }
//
//    @Override
//    public boolean hasNext() {
//         return !l.isEmpty();
//    }
//
//    /**
//     * This method only visits the leaf nodes
//     */
//    @Override
//    public Position<E> next() {
//         return l.remove(0);
//    }

    private final Tree<E> tree;
    private final Deque<Position<E>> s;
    private final List<Position<E>> l;

    public LeafIterator(Tree<E> t){
        this.tree = t;
        s = new LinkedList<>();
        l = new LinkedList<>();
        if(!tree.isEmpty()){
            s.push(tree.root());
        }
    }

    public LeafIterator(Tree<E> t, Position<E> root){
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
        if(tree.isLeaf(node))
            return node;
        else
            return next();
    }
}